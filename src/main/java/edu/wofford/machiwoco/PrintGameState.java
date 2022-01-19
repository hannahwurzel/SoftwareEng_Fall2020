package edu.wofford.machiwoco;

import java.util.List;
import java.util.ArrayList;


/**
 * This class represents the strings that will be printed to the screen
 * while the game is being played.  All of these strings are static and 
 * subject to change as the game is played and players make their moves.
 */
public class PrintGameState {

    /**
     * Returns a string of the current game state including the cards available
     * for purchase in the Market and the amount of coins and types of cards 
     * each player has.
     * 
     * @param deck current deck
     * @return a string of the gamestate
     */

    public static String getStringCurrentGameState(Market deck) {
        String gameState = "******************************************\n" +
                           "                  MARKET                  \n" +
                           "------------------------------------------\n";
        for (int i = 0; i < deck.getAvailable().size(); i++) {
                String name = deck.getAvailable().get(i).getName();
                int nameLength = name.length();
                while (nameLength <= 18) {
                    name = name + " ";
                    nameLength++;
                }
                String cost = "(" + Integer.toString(deck.getAvailable().get(i).getCost()) + ")";
                int costLength = cost.length();
                while (costLength <= 4) {
                    cost = cost + " ";
                    costLength++;
                }
                String activationRange = deck.getAvailable().get(i).getActivationRange();
                int activationRangeLength = activationRange.length();
                while (activationRangeLength <= 7) {
                    activationRange = activationRange + " ";
                    activationRangeLength++;
                }
                String colorIcon = deck.getAvailable().get(i).getStringColor() + deck.getAvailable().get(i).getStringIcon();
                String owned = " #" + Integer.toString(deck.getAvailable().get(i).getAvailable());
                gameState = gameState + name + colorIcon + " " + cost + activationRange + owned + "\n";
        }
        return gameState;
    }

    /**
     * Returns a string of the current Player State which includes the amount
     * of coins the current player has, the cards they posses, and whether of 
     * not their landmarks are constructed.
     * 
     * @param player current player
     * @return a string of the current players game state
     */

    public static String getStringPlayerState(Player player) {
        String playerString = "";
        playerString = playerString + "------------------------------------------\n";
        playerString = playerString + "                (" + Integer.toString(player.getNumberOfCoins()) + " coins)                 \n";
        for (int i = 0; i < player.getEstablishments().size(); i++) {
            String name = player.getEstablishments().get(i).getName();
            int nameLength = name.length();
            while (nameLength <= 18) {
                name = name + " ";
                nameLength++;
            }
            String cost = "(" + Integer.toString(player.getEstablishments().get(i).getCost()) + ")";
            int costLength = cost.length();
            while (costLength <= 4) {
                cost = cost + " ";
                costLength++;
            }
            String activationRange = player.getEstablishments().get(i).getActivationRange();
            int activationRangeLength = activationRange.length();
            while (activationRangeLength <= 7) {
                activationRange = activationRange + " ";
                activationRangeLength++;
            }
            String colorIcon = player.getEstablishments().get(i).getStringColor() + player.getEstablishments().get(i).getStringIcon();
            String owned = " #" + Integer.toString(player.getEstablishments().get(i).getAvailable());
            playerString = playerString + name + colorIcon + " " + cost + activationRange + owned + "\n";
        }
        playerString = playerString + "..........................................\n";
        for (int i = 0; i < player.getLandmarks().size(); i++) {
            String name2 = player.getLandmarks().get(i).getName();
            int name2Length = name2.length();
            while (name2Length <= 18) {
                name2 = name2 + " ";
                name2Length++;
            }
            String cost2 = "(" + Integer.toString(player.getLandmarks().get(i).getCost()) + ")";
            int cost2Length = cost2.length();
            while (cost2Length <= 4) {
                cost2 = cost2 + " ";
                cost2Length++;
            }
            String colorIcon2 = player.getLandmarks().get(i).getStringColor() + player.getLandmarks().get(i).getStringIcon();
            String constructed;
            if (player.getLandmarks().get(i).getConstructed() == true) {
                constructed = "X";
            } else {
                constructed = " ";
            }
            playerString = playerString + name2 + colorIcon2 + " " + cost2 + "[" + constructed + "]\n";
        }
        return playerString;
    }

    /**
     * Returns a string of the current Market Menu which includes the cards that are 
     * available for the current player to purchase or construct.
     * 
     * @param player the current player
     * @param market current available market
     * @return a string of the current market menu
     */

    public static String printMarketMenu(Player player, Market market) {
        String currentMarketMenu = "(To view details of an item, type 'view'  \n" + 
                                   "followed by the item number. For example, \n" +
                                   "to view item 6, type 'view 6'.)           \n" +
                                   "==========================================\n" +
                                   "---------        PURCHASE        ---------\n";
        int count = 1;
        for (int i = 0; i < market.canBuy(player).size(); i++) {
            String number = Integer.toString(count);
            int numberLength = number.length();
            while(numberLength < 2) {
                number = " " + number;
                numberLength++;
            }
            String name = market.canBuy(player).get(i).getName();
            int nameLength = name.length();
            while (nameLength <= 18) {
                name = name + " ";
                nameLength++;
            }
            String cost = "(" + Integer.toString(market.canBuy(player).get(i).getCost()) + ")";
            int costLength = cost.length();
            while (costLength <= 4) {
                cost = cost + " ";
                costLength++;
            }
            String activationRange = market.canBuy(player).get(i).getActivationRange();
            int activationRangeLength = activationRange.length();
            while (activationRangeLength <= 7) {
                activationRange = activationRange + " ";
                activationRangeLength++;
            }
            String colorIcon = market.canBuy(player).get(i).getStringColor() + market.canBuy(player).get(i).getStringIcon();
            String owned = " #" + Integer.toString(market.canBuy(player).get(i).getAvailable());
            currentMarketMenu = currentMarketMenu + number + ". " + name + colorIcon + " " + cost + activationRange + owned + "\n";
            count = count + 1;
        }
        if(player.canConstruct().size() > 0) {
            currentMarketMenu = currentMarketMenu + "---------       CONSTRUCT        ---------\n";
        }
        for(int i = 0; i < player.canConstruct().size(); i++) {
            String number2 = Integer.toString(count);
            int number2Length = number2.length();
            while(number2Length < 2) {
                number2 = " " + number2;
                number2Length++;
            }
            String name2 = player.canConstruct().get(i).getName();
            int name2Length = name2.length();
            while (name2Length <= 18) {
                name2 = name2 + " ";
                name2Length++;
            }
            String cost2 = "(" + Integer.toString(player.getLandmarks().get(i).getCost()) + ")";
            int cost2Length = cost2.length();
            while (cost2Length <= 4) {
                cost2 = cost2 + " ";
                cost2Length++;
            }
            String colorIcon2 = player.getLandmarks().get(i).getStringColor() + player.getLandmarks().get(i).getStringIcon();
            String constructed = "[ ]";
            String newLine = number2 + ". " + name2 + colorIcon2 + " " + cost2 + constructed;
            currentMarketMenu = currentMarketMenu + newLine + "\n";
            count = count + 1;

        }
        currentMarketMenu = currentMarketMenu + 
                            "---------         CANCEL         ---------\n"+
                            "99. Do nothing                            \n" +
                            "==========================================\n" +
                            "Choose a number to purchase or construct:";
        return currentMarketMenu;
    }

    /**
     * Returns a string of the choose payer menue of targetable
     * players.
     * 
     * @param options a list of players who can be targeted.
     * @return a string of the choose player menue.
     */
    
    public static String printChoosePlayerMenu(List<Player> options) {
        String menue = "-------     AVAILABLE PLAYERS      -------\n";
        for (int i = 0; i < options.size(); i++) {
            String num = Integer.toString(i + 1) + ". ";
            String player = "Player " + Integer.toString(options.get(i).getPlayerNumber() + 1);
            while (player.length() < 20) {
                player = player + " ";
            }
            String coins = " (" + Integer.toString(options.get(i).getNumberOfCoins()) + " coins)";
            menue = menue + num +  player + coins + "\n";
        }  
        return menue;         
    } 

    /**
     * Returns a string of the choose establishment menue of player;s
     * tradeable establishemnts.
     * 
     * @param player a Player who's estabihments are being presented.
     * @return a string of the choose establihsment menue.
     */

    public static String printChooseEstablishmentMenu(Player player) {
        String chooseEstablishmentMenu = "-------  AVAILABLE ESTABLISHMENTS  -------\n";
        String header = "Player " + Integer.toString(player.getPlayerNumber() + 1);
        while(header.length() < 42) {
            header = " " + header + " "; 
        }
        chooseEstablishmentMenu = chooseEstablishmentMenu + header + "\n";
        List<Establishment> establishments = player.establishmentCanTrade();
        for (int m = 0; m < establishments.size(); m++) {
            String name = Integer.toString(m + 1) + ". " + establishments.get(m).getName();
            int nameLength = name.length();
            while (nameLength <= 21) {
                name = name + " ";
                nameLength++;
            }
            String cost = "(" + Integer.toString(establishments.get(m).getCost()) + ")";
            int costLength = cost.length();
            while (costLength <= 4) {
                cost = cost + " ";
                costLength++;
            }
            String activationRange = establishments.get(m).getActivationRange();
            int activationRangeLength = activationRange.length();
            while (activationRangeLength <= 11) {
                activationRange = activationRange + " ";
                activationRangeLength++;
            }
            String colorIcon = establishments.get(m).getStringColor() + establishments.get(m).getStringIcon();
            chooseEstablishmentMenu = chooseEstablishmentMenu +  name + colorIcon + " " + cost + activationRange + "\n";
        }

        return chooseEstablishmentMenu;
    } 

    /**
     * Returns a string representing the Landmarks available for the 
     * current player to purchase.
     * 
     * @param deck current deck
     * @return string of available Landmarks
     */

    public static String getStringLandmark(List<Landmark> deck) {
        String landmarks = "";
        for (int i = 0; i < 5; i++) {
            Landmark card = new Landmark();
            card = deck.get(i);
            landmarks = landmarks + ".-----------------------.\n";
            landmarks = landmarks + "| <N>   LANDMARK    {T} |\n";
            int x = card.getName().length();
            int extraSpace = 23 - x;
            if (extraSpace % 2 == 0) {
                String line = card.getName();
                for (int j = extraSpace/2; j > 0; j = j-1) {
                    line = " " + line + " ";

                }
                landmarks = landmarks + "|" + line + "|\n";
            } else {
                String line = card.getName();
                for (int j = (extraSpace - 1)/2; j > 0; j = j-1) {
                     line = " " + line + " ";
                }
                line = line + " ";
                landmarks = landmarks + "|" + line + "|\n";
            }
            landmarks = landmarks + "|                       |\n";
            if (card.getName().equals("Train Station")) {
                landmarks = landmarks + "|  You may roll 1 or 2  |\n";
                landmarks = landmarks + "|         dice.         |\n";
                landmarks = landmarks + "|                       |\n";
            } else if (card.getName().equals("Shopping Mall")) {
                landmarks = landmarks + "|   Your {U} and {B}    |\n";
                landmarks = landmarks + "|  establishments earn  |\n";
                landmarks = landmarks + "|     +1 coin when      |\n";
                landmarks = landmarks + "|      activated.       |\n";
                landmarks = landmarks + "|                       |\n";
            } else if (card.getName().equals("Amusement Park")) {
                landmarks = landmarks + "| If you roll doubles,  |\n";
                landmarks = landmarks + "|   take another turn   |\n";
                landmarks = landmarks + "|    after this one.    |\n";
                landmarks = landmarks + "|                       |\n";
            } else if (card.getName().equals("Radio Tower")) {
                landmarks = landmarks + "|  Once per turn, you   |\n";
                landmarks = landmarks + "| may reroll the dice.  |\n";
                landmarks = landmarks + "|                       |\n";
            } else {
                landmarks = landmarks + "|                       |\n";
                landmarks = landmarks + "|                       |\n";
                landmarks = landmarks + "|                       |\n";
            }
            if (card.getCost().toString().length() == 2) {
                landmarks = landmarks + "| (" + card.getCost().toString() + ")              [ ] |\n";
            } else {
                landmarks = landmarks + "| (" + card.getCost().toString() + ")               [ ] |\n";
            }
            landmarks = landmarks + "|_______________________|\n";
        }
        return landmarks;
    }
}