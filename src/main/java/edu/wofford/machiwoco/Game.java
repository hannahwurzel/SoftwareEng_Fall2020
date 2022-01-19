package edu.wofford.machiwoco;

import java.util.List;

import java.util.ArrayList;

/**
 * This class represents the actual game play of Mochi Koro. Our main function
 * will call to this class often to proceed with various game play moves.
 */
public class Game {
    protected List<Player> players = new ArrayList<> ();
    protected Market market;
    protected String phase;
    private boolean gameOver;
    private String winner;
    private int currentRoll;
    private boolean doubles;

    /**
     * A constructor for the game class. Establishes the phase, number of players,
     * a new market, an empty string representing the winner, the current dice roll
     * to zero and setting the game has won to zero.
     * 
     * @param phase a string representing the phase of the game
     * @param market represents the market of the game
     * @param players a list of the players playing the game
     */
    public Game(String phase, Market market, List<Player> players) {
        this.phase = phase;
        this.players = players;
        this.market = market;
        winner = "";
        currentRoll = 0;
        gameOver = false;
        doubles = false;
    }

    /**
     * Returns a boolean representing if the game has won or not.
     * 
     * @return a boolean representing if the game has won or not.
     */

    public boolean getGameOver() {
        return gameOver;
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    /**
     * Represents a string containing the player who has won the game.
     * 
     * @return a string containing the player who won
     */

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
        gameOver = true;
    }

    /**
     * This method is responsible for returning a number that represents
     * the current dice roll.
     * 
     * @return an integer representing the dice roll that has been rolled
     */

    public int getCurrentRoll() {
        return currentRoll;
    }

    /**
     * This method is responsible for indicating if doubles
     * have been rolled.
     * 
     * @return an Boolean representing if doubles were rolled
     */


    public Boolean getDoubles() {
        return doubles;
    }

    /**
     * Takes in a number of dice to roll and a player number, rolls the dice, and returns the output string.
     * Then sets the Games curent roll to roll
     * 
     * @param numberOfDie an integer representing the number of dice to roll
     * @param playerNumber the Player Number of the Player rolling
     * @return a string outputing the roll
     */

    public String rollDice(int numberOfDie, int playerNumber) {
        String output = "";
        Dice dice = new Dice();
        int roll = dice.roll();
        if (numberOfDie == 1) {
            output = output + "Player " + Integer.toString(playerNumber) + " rolled [" + Integer.toString(roll) + "] = " + Integer.toString(roll) + ".";
            doubles = false;
        } else if (numberOfDie == 2) {
            int roll2 = dice.roll();
            if (roll == roll2) {
                doubles = true;
            } else {
                doubles = false;
            }
            output = output + "Player " + Integer.toString(playerNumber) + " rolled [" + Integer.toString(roll) + "]" + "["+ Integer.toString(roll2) +  "] = " + Integer.toString(roll + roll2) + ".";
            roll = roll + roll2;
        }
        currentRoll = roll;
        return output;
    }

    /**
     * Takes in a player and their response of what to execute on their turn.
     * 
     * @param currentPlayer a Player who is the current player.
     * @param response the integer response of the Player's selection.
     * @return a string outputing the act of the turn. 
     */

    public String build(Player currentPlayer, int response) {
        String output = "";
        List<Landmark> landmarkOption = currentPlayer.canConstruct();
        List<Establishment> establishmentOption = market.canBuy(currentPlayer);
        if (response <= establishmentOption.size() && response > 0) {
            String purchasing = establishmentOption.get(response - 1).getName();
            Establishment purchased = market.purchase(purchasing);
            currentPlayer.addEstablishment(purchased);
            currentPlayer.subtractCoins(purchased.getCost());
            output = output + "Player " + Integer.toString(currentPlayer.getPlayerNumber()) + " purchased the " + purchasing + ".\n";
        } else if (response > establishmentOption.size() && response <= landmarkOption.size() + establishmentOption.size()) {
            response = response - (establishmentOption.size() + 1);
            String constructing = landmarkOption.get(response).getName();
            currentPlayer.construct(constructing);
            output = output + "Player " + Integer.toString(currentPlayer.getPlayerNumber()) + " constructed the " + constructing + ".\n";
        } else if (response == 99) {
            output = output + "Player " + Integer.toString(currentPlayer.getPlayerNumber()) + " chose not to make improvements.\n";
        }
        output = output + "Turn ended for Player " + Integer.toString(currentPlayer.getPlayerNumber()) +".\n";
        return output;
    }

    /**
     * Takes in the current player and their roll of the dice. It then loops through and adjust income
     * of all players accordingly, returning the string output.
     * 
     * @param currentPlayer the current player.
     * @param currentPlayer the player whose current turn it is
     * @param sum the roll of the die.
     * @param deck the deck of cards
     * @return a string outputing the earned income
     */

    public String earnIncome(Player currentPlayer, int sum, Deck deck) {
        String playerIncome = "";

        List<Card.Color> activationOrder = new ArrayList<> ();
        activationOrder.add(Card.Color.RED);
        activationOrder.add(Card.Color.BLUE);
        activationOrder.add(Card.Color.GREEN);

        List<Player> playerOrderClockwise = new ArrayList<> ();
        for (int i = currentPlayer.getPlayerNumber(); i < players.size(); i++) {
            playerOrderClockwise.add(players.get(i));
        }
        for (int i = 0; i < currentPlayer.getPlayerNumber(); i++) {
            playerOrderClockwise.add(players.get(i));
        }

        List<Player> playerOrderCounterClockwise = new ArrayList<> ();
        for (int i = playerOrderClockwise.size() - 1; i >= 0; i--) {
            playerOrderCounterClockwise.add(playerOrderClockwise.get(i));
        }

        for(int i = 0; i < activationOrder.size(); i++) {
            for (int j = 0; j < deck.getDeckEstablishments().size(); j++) {
                Establishment check = deck.getDeckEstablishments().get(j);
                List<Player> playerOrderTemp = new ArrayList<> ();
                if (check.getColor().equals(activationOrder.get(i))) {
                    if (check.getColor().equals(Card.Color.RED)) {
                        playerOrderTemp = playerOrderCounterClockwise;
                    } else {
                        playerOrderTemp = playerOrderClockwise;
                    }
                    for (int k = 0; k < playerOrderTemp.size(); k++) {
                        if (playerOrderTemp.get(k).owns(check.getName())) {
                            Establishment activate = playerOrderTemp.get(k).getEstablishment(check.getName());
                            Boolean curPlayer = false;
                            if (playerOrderTemp.get(k).getPlayerNumber() == currentPlayer.getPlayerNumber()) {
                                curPlayer = true;
                            }
                            if (activate.isActivated(sum, curPlayer)) {
                                Activate.activate(activate, playerOrderTemp.get(k), currentPlayer);
                                playerIncome = playerIncome + activate.activateString(playerOrderTemp.get(k).getPlayerNumber()) + "\n";
                            }
                        }
                    }
                }
            }
        }
        return playerIncome;
    }

    /**
     * Takes in the current player and their purple establishemt to 
     * activate. 
     * 
     * @param currentPlayer the current player.
     * @param establishment the purple establihsment to activte.
     * @return a string outputing the earned income
     */

    public String earnIncomePurple(Player currentPlayer, Establishment establishment) {
        Activate.activatePurple(currentPlayer, players);
        String playerIncome = establishment.activateString(currentPlayer.getPlayerNumber());
        return playerIncome;
    }

    /**
     * Takes in the current player and their purple establishemt to 
     * activate. 
     * 
     * @param currentPlayer the current player.
     * @param targetedPlayer the targeted player.
     * @param establishment the purple establihsment to activte.
     * @return a string outputing the earned income
     */

    public String earnIncomePurple(Player currentPlayer, Player targetedPlayer, Establishment establishment) {
        Activate.activatePurple(currentPlayer, targetedPlayer);
        String playerIncome = establishment.activateString(currentPlayer.getPlayerNumber());
        return playerIncome;
    }

    /**
     * Takes in the current player and their purple establishemt to 
     * activate. 
     * 
     * @param currentPlayer the current player.
     * @param targetedPlayer the targeted player.
     * @param owned the string name of the establihsment owned.
     * @param exchange the string name of the establishment chose to take.
     * @param establishment the purple establihsment to activte.
     * @return a string outputing the earned income
     */

    public String earnIncomePurple(Player currentPlayer, Player targetedPlayer, String owned, String exchange, Establishment establishment) {
        Activate.activatePurple(currentPlayer, targetedPlayer, owned, exchange);
        String playerIncome = establishment.activateString(currentPlayer.getPlayerNumber());
        return playerIncome;
    }

    /**
     * Takes in the current player and determined players subject
     * to be targets of the TV Station.
     * 
     * @param currentPlayer the current player.
     * @return a list of targetable players.
     */

    public List<Player> playerTargetsTV(Player currentPlayer) {
        List<Player> target_player = new ArrayList<> ();
        for(int i = 0; i < players.size(); i++) {
            if (players.get(i).getNumberOfCoins() > 0 && players.get(i).getPlayerNumber() != currentPlayer.getPlayerNumber()) {
                target_player.add(players.get(i));
            }
        }
        return target_player;
    }

    /**
     * Takes in the current player and determined players subject
     * to be targets of the Buisness Center.
     * 
     * @param currentPlayer the current player.
     * @return a list of targetable players.
     */

    public List<Player> playerTargetsBuisness(Player currentPlayer) {
        List<Player> target_player = new ArrayList<> ();
        for(int i = 0; i < players.size(); i++) {
            if (players.get(i).getPlayerNumber() != currentPlayer.getPlayerNumber()) {
                if(players.get(i).getEstablishment("Wheat Field").getAvailable() > 1 || players.get(i).getEstablishment("Bakery").getAvailable() > 1) {
                    target_player.add(players.get(i));
                } else {
                    for(int m = 0; m < players.get(i).getEstablishments().size(); m++) {
                        Establishment check = players.get(i).getEstablishments().get(m);
                        if(!check.getName().equals("Wheat Field") && !check.getName().equals("Bakery") && !check.getColor().equals(Card.Color.PURPLE)) {
                            target_player.add(players.get(i));
                            break;
                        }
                    }
    
                }
            }
            
            
        }
        return target_player;
    }

}