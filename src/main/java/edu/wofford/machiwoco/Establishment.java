package edu.wofford.machiwoco;

import java.util.List;
import java.util.ArrayList;

/**
 * This class represents the Establishments.  All establishments contain an activation
 * range, the number that must be rolled on the die for the card to be activated, and 
 * a coin change, determines whether a player gains or loses coins.  
 * 
 */

public class Establishment extends Card {
    private String activationRange;
    private int coinChange;
    private int available;

    /**
    * Constructor for Establishments.  Sets Activation Range to an empty string and coin change
    * to zero.
    */

    public Establishment() {
        super();
        activationRange = "";
        coinChange = 0;
        available = 0;
    }

    /**
    * Sets the Establishment to match the parameters given.
    * 
    * @param color represents the color of the establishment
    * @param icon represents the icon on the eslablishment
    * @param cost an integer representing the cost of the establishment
    * @param name a string representing the name of the establishment
    * @param activationRange a string representing the activation range of the establishment
    * @param coinChange an integer representing the coin change
    * @param available an integer representing the amount of available cards left of that 
    * certain establishment
    */

    public Establishment(Color color, Icon icon, int cost, String name, String activationRange, int coinChange, int available) {
        super(color, icon, cost, name);
        this.activationRange = activationRange;
        this.coinChange = coinChange;
        this.available = available;

    }

    /**
    * Returns an integer representing the coin change.
    * 
    * @return an integer describing the coin change
    */

    public int getCoinChange() {
        return coinChange;
    }

    /**
    * Returns a string representing the activation range.
    * 
    * @return a string describing the activation range
    */

    public String getActivationRange() {
        return activationRange;
    }

    /**
    * Returns a string representing the activation of an establihsment.
    * 
    * @param playerNum integer representing player number.
    * @return a string describing the activation
    */

    public String activateString(int playerNum) {
        String activate = getName() + " activated for Player " + Integer.toString(playerNum) + ".";
        return activate;
    }

    /**
    * Returns a Boolean respresting if the card is activated on a 
    * given roll for a player.
    *
    * @param roll integer representing the current dice roll
    * @param currentPlayer Boolean represnting if the player is the current player
    * @return a Boolean representing if the establishment is activated.
    */

    public Boolean isActivated(int roll, Boolean currentPlayer) {
        List<Integer> activationRange = new ArrayList<> ();
        if (getName().equals("None")) {
            return false;
        }
        for(int k = 0; k < getActivationRange().length(); k++) {
            if (Character.isDigit(getActivationRange().charAt(k))) {
                if(Character.isDigit(getActivationRange().charAt(k + 1))) {
                    int n = Character.getNumericValue(getActivationRange().charAt(k)) * 10 + Character.getNumericValue(getActivationRange().charAt(k + 1));
                    activationRange.add(n);
                    k = k + 1;
                } else {
                    activationRange.add(Character.getNumericValue(getActivationRange().charAt(k)));
                }
            }
        }
        if (activationRange.contains(roll)) {
            if (getColor() == Card.Color.BLUE) {
                return true;
            } else if (getColor() == Card.Color.GREEN && currentPlayer) {
                return true;
            } else if (getColor() == Card.Color.PURPLE && currentPlayer) {
                return true;
            } else if (getColor() == Card.Color.RED && !currentPlayer) {
                return true;
            }
        }
        return false;
    }

    /** 
    * This is a method that gets the integer value which represents whether a given
    * card is available or not. It is of type integer. 
    * 
    * @return an integer greater than or equal to 0.
    */

    public int getAvailable() {
        return available;
    }

    /** 
    * This is a method that checks whether a card is available or not. It is of type Boolean.
    * If the value is greater or equal to 1 the card is available, if less than 1 or 
    * 0 the card is not available.
    * 
    * @return a boolean, true if card is available, false if card is not 
    */

    public boolean isAvailable() {
        if (available >= 1) {
            return true;
        } else {
            return false;
        }
    }

    /** 
    * This is a method that tracks the availabilty of the cards when a card is purchased.
    * It does not return a value. 
    */

    public void purchase() {
        available = available - 1;
    }

    /** 
    * This is a method that adds an available card to the set of available cards.
    * It does not return a value.
    */

    public void addAvailable() {
        available = available + 1;
    }
}