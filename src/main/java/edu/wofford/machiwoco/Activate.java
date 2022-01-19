package edu.wofford.machiwoco;

import java.util.List;
import java.util.ArrayList;

/** 
    * This is a class that activates given establishment. 
    */

public class Activate {

    /**
    * Activates the establishment given, adjusting player coin.
    * 
    * @param establishment an Establishment represents the establishment to activate
    * @param playerOwner a Player representing the owner of the establishment to activate.
    * @param currentPlayer an Player representing the current player of the game.
    */

    public static void activate(Establishment establishment, Player playerOwner, Player currentPlayer) {
        String name = establishment.getName();
        if (name.equals("Wheat Field") || name.equals("Ranch") || name.equals("Forest") || name.equals("Bakery")) {
            playerOwner.addCoins(establishment.getAvailable());
        } else if (name.equals("Farmers Market")) {
            for(int i = 0; i < playerOwner.getEstablishments().size(); i++) {
                if (playerOwner.getEstablishments().get(i).getIcon().equals(Card.Icon.WHEAT)) {
                    playerOwner.addCoins(2 * playerOwner.getEstablishments().get(i).getAvailable() * establishment.getAvailable());
                }
            }
        } else if (name.equals("Furniture Factory")) {
            for(int i = 0; i < playerOwner.getEstablishments().size(); i++) {
                if (playerOwner.getEstablishments().get(i).getIcon().equals(Card.Icon.GEAR)) {
                    playerOwner.addCoins(3 * playerOwner.getEstablishments().get(i).getAvailable() * establishment.getAvailable());
                }
            }
        } else if (name.equals("Cheese Factory")) {
            for(int i = 0; i < playerOwner.getEstablishments().size(); i++) {
                if (playerOwner.getEstablishments().get(i).getIcon().equals(Card.Icon.COW)) {
                    playerOwner.addCoins(3 * playerOwner.getEstablishments().get(i).getAvailable() * establishment.getAvailable());
                }
            } 
        } else if (name.equals("Cafe")) {
            for(int i = 0; i < establishment.getAvailable(); i++) {
                if (playerOwner.isConstructed("Shopping Mall")) {
                    if (currentPlayer.getNumberOfCoins() >= 2) {
                        playerOwner.addCoins(2);
                        currentPlayer.subtractCoins(2);
                    } else if (currentPlayer.getNumberOfCoins() >= 1) {
                        playerOwner.addCoins(1);
                        currentPlayer.subtractCoins(1);
                    }
                } else if (currentPlayer.getNumberOfCoins() >= 1) {
                    playerOwner.addCoins(1);
                    currentPlayer.subtractCoins(1);
                }

            }

        } else if(name.equals("Family Restaurant")) {
            for(int i = 0; i < establishment.getAvailable(); i++) {
                if (playerOwner.isConstructed("Shopping Mall")) {
                    if (currentPlayer.getNumberOfCoins() >= 3) {
                        playerOwner.addCoins(3);
                        currentPlayer.subtractCoins(3);
                    } else if (currentPlayer.getNumberOfCoins() >= 2) {
                        playerOwner.addCoins(2);
                        currentPlayer.subtractCoins(2);
                    } else if (currentPlayer.getNumberOfCoins() >= 1) {
                        playerOwner.addCoins(1);
                        currentPlayer.subtractCoins(1);
                    }
                } else if (currentPlayer.getNumberOfCoins() >= 2) {
                    playerOwner.addCoins(2);
                    currentPlayer.subtractCoins(2);
                } else if (currentPlayer.getNumberOfCoins() >= 1) {
                    playerOwner.addCoins(1);
                    currentPlayer.subtractCoins(1);
                }
            }
        } else {
            playerOwner.addCoins(establishment.getCoinChange() * (establishment.getAvailable()));
        }
        
        if (playerOwner.isConstructed("Shopping Mall") & (establishment.getIcon().equals(Card.Icon.BREAD))) {
            playerOwner.addCoins((establishment.getAvailable()));
        }
    }

    /**
    * Activates the purple establishment given, adjusting player coin.
    * 
    * @param currentPlayer an Player representing the current player.
    * @param players a list of Players who are subject to the activation.
    */

    public static void activatePurple(Player currentPlayer, List<Player> players) {
        for(int i = 0; i < players.size(); i++) {
            if (players.get(i).getPlayerNumber() != currentPlayer.getPlayerNumber()) {
                if (players.get(i).getNumberOfCoins() >= 2) {
                    currentPlayer.addCoins(2);
                    players.get(i).subtractCoins(2);
                } else if (players.get(i).getNumberOfCoins() == 1) {
                    currentPlayer.addCoins(1);
                    players.get(i).subtractCoins(1);
                }
            }
        }

    }

    /**
    * Activates the purple establishment given, adjusting player coin.
    * 
    * @param currentPlayer an Player representing the current player.
    * @param targetedPlayer the Player who are has been targeted.
    */

    public static void activatePurple(Player currentPlayer, Player targetedPlayer) {
        int coins_to_take;
        if (targetedPlayer.getNumberOfCoins() > 5) {
            coins_to_take = 5;

        } else {
            coins_to_take = targetedPlayer.getNumberOfCoins();
        }
        targetedPlayer.subtractCoins(coins_to_take);
        currentPlayer.addCoins(coins_to_take);

    }

     /**
    * Activates the purple establishment given, adjusting player coin.
    * 
    * @param currentPlayer an Player representing the current player.
    * @param targetedPlayer the Player who are has been targeted.
    * @param owned a string representing the name of the establishment the player wants to trade.
    * @param exchange a string representing the name of the establihsment the player wants to take.
    */

    public static void activatePurple(Player currentPlayer, Player targetedPlayer, String owned, String exchange) {
        currentPlayer.addEstablishment(targetedPlayer.takeEstablishment(exchange));
        targetedPlayer.addEstablishment(currentPlayer.takeEstablishment(owned));

    }


}