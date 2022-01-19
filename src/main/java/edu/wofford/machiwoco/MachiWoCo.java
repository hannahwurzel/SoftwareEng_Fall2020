package edu.wofford.machiwoco;

import java.util.List;
import java.util.NoSuchElementException;
import java.io.*;
import java.util.Scanner;

import java.util.ArrayList;

/**
 * This class holds the bulk of the actual game play.
 */
public class MachiWoCo {

    /**
     * This function represents the actual gameplay. This funciton is responsible for printing
     * out the functions from PrintGameState when necessary. It also calls a dice roll, adds
     * or subtracts coins from players, and prompts players to purchase or construct new cards
     * when applicable.
     * 
     * @param numberOfPlayers an integer representing the number of players playing the game
     * @param deck the current deck of the game
     * @param players the list of the current players
     * @param phase the phase that is being played
     */
    public static void playGame(int numberOfPlayers, Deck deck, List<Player> players, String phase) {
        Market market = new Market(phase);
        Game game = new Game(phase, market, players);
        while (game.getGameOver() != true) {
            for (int i = 0; i < numberOfPlayers; i++) {
                Player currentPlayer = game.getPlayer(i);
                System.out.println("Turn started for Player " + Integer.toString(currentPlayer.getPlayerNumber()) + ".");
                System.out.println(PrintGameState.getStringCurrentGameState(market));
                String output = "";
                for(int j = 0; j < numberOfPlayers; j++) {
                    if (currentPlayer.getPlayerNumber() - 1 == j) {
                        output = "Player " + Integer.toString(currentPlayer.getPlayerNumber()) + "*"; 
                    } else {
                        output = "Player " + Integer.toString(j + 1);
                    }
                    while (output.length() < 42) {
                        output = " " + output + " ";
                    }
                    System.out.println(output);
                    System.out.println(PrintGameState.getStringPlayerState(game.getPlayer(j)));
                }
                System.out.println("******************************************");

            //Roll Dice 
                int numberOfDie = 1;
                if(currentPlayer.isConstructed("Train Station")) {
                    //int response;
                    if (currentPlayer.isAIPlayer() == true) {
                        List<Integer> option = new ArrayList<> ();
                        option.add(1);
                        option.add(2);
                        numberOfDie = currentPlayer.randomDecision(option);
                    } else {
                          do {
                            System.out.println(Queries.trainStation(currentPlayer));
                            numberOfDie = Queries.answer();
                        } while (numberOfDie != 1 && numberOfDie != 2);
                    }
                }
                System.out.println(game.rollDice(numberOfDie, currentPlayer.getPlayerNumber()));
                int sum = game.getCurrentRoll();

            //Earn Income Phase 
                 System.out.println(game.earnIncome(currentPlayer, sum, deck));
 
                if (phase.equals("phase5")) {
                    String purpleIncome = "";
                    if (currentPlayer.getEstablishment("Stadium").isActivated(sum, true)) {
                        purpleIncome = purpleIncome + game.earnIncomePurple(currentPlayer, currentPlayer.getEstablishment("Stadium")) + "\n";
                    } 
                    if (currentPlayer.getEstablishment("TV Station").isActivated(sum, true)) {
                        int numberOptions = game.playerTargetsTV(currentPlayer).size();
                        if (numberOptions > 0) {
                            System.out.println(PrintGameState.printChoosePlayerMenu(game.playerTargetsTV(currentPlayer)));
                            int response = 0;
                            if (currentPlayer.isAIPlayer()) {
                                List<Integer> responses = new ArrayList<> ();
                                for (int k = 0; k < numberOptions; k++) {
                                    responses.add(k + 1);
                                }
                                response = currentPlayer.randomDecision(responses);
                            } else {
                                do {
                                    System.out.println(Queries.targetPlayer(currentPlayer));
                                    response = Queries.answer();
                                } while (response < 1 && response > numberOptions);
                            }
                            Player target = game.playerTargetsTV(currentPlayer).get(response - 1);
                            purpleIncome = purpleIncome + game.earnIncomePurple(currentPlayer, target, currentPlayer.getEstablishment("TV Station")) + "\n";
                        }
                    } 
                    if (currentPlayer.getEstablishment("Buisness Center").isActivated(sum, true)) {
                        System.out.println(PrintGameState.printChoosePlayerMenu(game.playerTargetsBuisness(currentPlayer)));
                        String owned = "";
                        String exchange = "";

                        int response = 0;
                        int numberOptions = game.playerTargetsBuisness(currentPlayer).size();
                        if (currentPlayer.isAIPlayer()) {
                            List<Integer> responses = new ArrayList<> ();
                            for (int k = 0; k < numberOptions; k++) {
                                responses.add(k + 1);
                            }
                            response = currentPlayer.randomDecision(responses);
                        } else {
                            do {
                                System.out.println(Queries.targetPlayer(currentPlayer));
                                response = Queries.answer();
                            } while (response < 1 && response > numberOptions);
                        }

                        Player target = game.playerTargetsBuisness(currentPlayer).get(response - 1);

                        for (int l = 0; i < 2; i++) {
                            Player currentPrint = new Player(0, false, "phase5");
                            if (l == 0) {
                                currentPrint = target;
                            } else {
                                currentPrint = currentPlayer;
                            }

                            int choose = 0;
                            int numberOptions2 = currentPrint.establishmentCanTrade().size();
                            if (currentPrint.isAIPlayer()) {
                                List<Integer> responses = new ArrayList<> ();
                                for (int k = 0; k < numberOptions2; k++) {
                                    responses.add(k + 1);
                                }
                                choose = currentPlayer.randomDecision(responses);
                            } else {
                                do {
                                    System.out.println(Queries.businessComplex(currentPrint));
                                    choose = Queries.answer();
                                } while (choose < 1 && choose > numberOptions2);
                            }
                            if (l == 0) {
                                exchange = currentPrint.establishmentCanTrade().get(choose - 1).getName();
                            }
                            else {
                                owned = currentPrint.establishmentCanTrade().get(choose - 1).getName();
                            }
                        }
                        purpleIncome = purpleIncome + game.earnIncomePurple(currentPlayer, target, owned, exchange, currentPlayer.getEstablishment("Buisness Center")) + "\n";
                    }
                    System.out.println(purpleIncome);
                } 

            //Build Phase 
                if (currentPlayer.getNumberOfCoins() > 0) {
                    if (currentPlayer.isAIPlayer() == false) {
                        System.out.println(Queries.marketPurchase(currentPlayer));
                        System.out.println(PrintGameState.printMarketMenu(currentPlayer, market));
                    }
                    boolean responded = false;
                    while (responded == false) {
                        int response; 
                        if (currentPlayer.isAIPlayer() == true) {
                            List<Integer> integers = new ArrayList<> ();
                            int canBuyNum = market.canBuy(currentPlayer).size();
                            canBuyNum = canBuyNum + currentPlayer.canConstruct().size();
                            for(int j = 0; j < canBuyNum; j++) { 
                                integers.add(j + 1);
                            }
                            integers.add(99);
                            response = currentPlayer.randomDecision(integers); 
                        } else {
                            response = Queries.answer();
                        }

                        List<Landmark> landmarkOptions = currentPlayer.canConstruct();
                        List<Establishment> establishmentOptions = market.canBuy(currentPlayer);
                        int landmarkNumberRange = landmarkOptions.size() + establishmentOptions.size();

                        if (response <= establishmentOptions.size() && response > 0) {
                            System.out.println(game.build(currentPlayer, response));
                            responded = true;
                        } else if (response > establishmentOptions.size() && response <= landmarkNumberRange) {
                            System.out.println(game.build(currentPlayer, response));
                            responded = true;
                        } else if (response == 99) {
                            System.out.println(game.build(currentPlayer, response));
                            responded = true;
                        } else {
                            System.out.println(Queries.purchase());
                        }
                    }  
                } else {
                    System.out.println("Player " + Integer.toString(currentPlayer.getPlayerNumber()) + " did not have enough money to make");
                    System.out.println("improvements.");
                    System.out.println("Turn ended for Player " + Integer.toString(currentPlayer.getPlayerNumber()) + ".");
                }   
                if(currentPlayer.winner()) {
                    game.setWinner("Player " + Integer.toString(currentPlayer.getPlayerNumber()));
                    break;
                } 
                if (currentPlayer.isConstructed("Amusement Park") == true && game.getDoubles()) {
                    i = i - 1; 
                }
            }
        }
        //Print End of Game
        System.out.println(PrintGameState.getStringCurrentGameState(market));
        for (int i = 0; i < numberOfPlayers; i++) {
            String output = "";
            if (i == (game.getWinner().charAt(7))) {
                output = "Player " + Integer.toString(i + 1) + "*"; 
            } else {
                output = "Player " + Integer.toString(i + 1);
            }
            while (output.length() < 42) {
                output = " " + output + " ";
            }
            System.out.println(output);
            System.out.println(PrintGameState.getStringPlayerState(game.getPlayer(i)));
        }
        System.out.println("******************************************");
        System.out.println("The game is over. " + game.getWinner() + " is the winner.");
    }

    /**
    * Main function for the entirety of the code.
    * 
    * @param args a string representing the keyboard inputs
    */
    public static void main(String[] args) {

    String[] validPhase = {"phase0", "phase1", "phase2", "phase3", "phase4", "phase5"};
        String phaseArg = "";
        for (int i = 0; i < validPhase.length; i++) {
            if (args[0].equals(validPhase[i])) {
                phaseArg = args[0];
            }
        }
        if (phaseArg.equals("phase0")) {
            Deck deck = new Deck(phaseArg);
            System.out.println(deck.getEstablishmentString(deck.getDeckEstablishments()) + PrintGameState.getStringLandmark(Landmark.getLandmarkList()));
        }
        if (phaseArg.equals("phase1") && args.length == 1) {
            Deck deck = new Deck(phaseArg);
            Player player1 = new Player(1, false, phaseArg);
            Player player2 = new Player(2, false, phaseArg);
            List<Player> players = new ArrayList<> ();
            players.add(player1);
            players.add(player2);
            System.out.println("The game has started. Player 1 will go\nfirst.");
            playGame(2, deck, players, phaseArg);
        }
        if (args[1].equals("2") || args[1].equals("--ai")) {
            Deck deck = new Deck(phaseArg);
            Player player1 = new Player(1, false, phaseArg);
            Player player2 = new Player(2, true, phaseArg);
            List<Player> players = new ArrayList<> ();
            players.add(player1);
            players.add(player2);
            System.out.println("The game has started. Player 1 will go\nfirst.");
            playGame(2, deck, players, phaseArg);
        }
        if (args[1].equals("3")) {
            Deck deck = new Deck(phaseArg);
            Player player1 = new Player(1, false, phaseArg);
            Player player2 = new Player(2, true, phaseArg);
            Player player3 = new Player(3, true, phaseArg);
            List<Player> players = new ArrayList<> ();
            players.add(player1);
            players.add(player2);
            players.add(player3);
            System.out.println("The game has started. Player 1 will go first\nfirst.");
            playGame(3, deck, players, phaseArg);
        }
        if (args[1].equals("4")) {
            Deck deck = new Deck(phaseArg);
            Player player1 = new Player(1, false, phaseArg);
            Player player2 = new Player(2, true, phaseArg);
            Player player3 = new Player(3, true, phaseArg);
            Player player4 = new Player(4, true, phaseArg);
            List<Player> players = new ArrayList<> ();
            players.add(player1);
            players.add(player2);
            players.add(player3);
            players.add(player4);
            System.out.println("The game has started. Player 1 will go first\nfirst.");
            playGame(4, deck, players, phaseArg);
        }
    }
}
