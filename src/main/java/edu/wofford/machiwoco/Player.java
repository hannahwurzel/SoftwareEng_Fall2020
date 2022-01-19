package edu.wofford.machiwoco;

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;


/** 
 * This class represents each player that is playing the game.  This class allows programmers
 * to obtain a players number (example: Player 1 or Player 2), the Landmarks and Establishments 
 * each player owns, and the number of coins they possess.
 */

public class Player {
    protected int playerNumber;
    protected List <Establishment> Establishments = new ArrayList<> ();
    protected List<Landmark> Landmarks = new ArrayList<> ();
    protected int coins;
    protected boolean isAIPlayer;

    /**
     * This constructor creates each player when the game begins.  They are each given a player number,
     * their starting establishments and landmarks and three coins.  
     * 
     * @param playerNumber an int representing the number of the current player
     * @param isAIPlayer a boolean establishing if a player is AI or not
     * @param phase a string representing what phase of Machi Koro is being played
     */

    public Player(int playerNumber, boolean isAIPlayer, String phase) {
        this.playerNumber = playerNumber;
        coins = 3;
        this.isAIPlayer = isAIPlayer;
        if (phase.equals("phase1")) {
            Establishments.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 1));
            Landmarks.add(new Landmark(Card.Color.NONE, Card.Icon.NONE, 7, "City Hall"));
        }
        if (phase.equals("phase2")) {
            Establishments.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 1));
            Establishments.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 1, 1));
            Landmarks.add(new Landmark(Card.Color.NONE, Card.Icon.TOWER, 4, "Train Station"));
            Landmarks.add(new Landmark(Card.Color.NONE, Card.Icon.NONE, 7, "City Hall"));
        }
        if (phase.equals("phase3")) {
            Establishments.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 1));
            Establishments.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 1, 1));
            Landmarks.add(new Landmark(Card.Color.NONE, Card.Icon.TOWER, 4, "Train Station"));
            Landmarks.add(new Landmark(Card.Color.NONE, Card.Icon.NONE, 7, "City Hall"));
            Landmarks.add(new Landmark(Card.Color.NONE, Card.Icon.TOWER, 10, "Shopping Mall"));
        }
        if (phase.equals("phase4")) {
            Establishments.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 1));
            Establishments.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 1, 1));
            Landmarks.add(new Landmark(Card.Color.NONE, Card.Icon.TOWER, 4, "Train Station"));
            Landmarks.add(new Landmark(Card.Color.NONE, Card.Icon.TOWER, 10, "Shopping Mall"));
            Landmarks.add(new Landmark(Card.Color.NONE, Card.Icon.TOWER, 16, "Amusement Park"));
        }
        if (phase.equals("phase5") || phase.equals("phase6")) {
            Establishments.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 1));
            Establishments.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 1, 1));
            Landmarks.add(new Landmark(Card.Color.NONE, Card.Icon.TOWER, 4, "Train Station"));
            Landmarks.add(new Landmark(Card.Color.NONE, Card.Icon.TOWER, 10, "Shopping Mall"));
            Landmarks.add(new Landmark(Card.Color.NONE, Card.Icon.TOWER, 16, "Amusement Park"));
            Landmarks.add(new Landmark(Card.Color.NONE, Card.Icon.TOWER, 22, "Radio Tower"));
        }
    }

    /**
     * This function returns the player number.
     * 
     * @return an integer representing the player number
     */

    public int getPlayerNumber() {
        return playerNumber;
    }

    /**
     * This function sets the player number.
     * 
     * @param playerNumber a positive number representing the player
     */

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    /**
     * This function returns a list of the current Establishments.
     * 
     * @return a list of the Establishments 
     */

    public List<Establishment> getEstablishments() {
        return Establishments;
    }

    /**
     * This function returns a list of the current Landmarks.
     * 
     * @return a list of the Landmarks
     */

    public List<Landmark> getLandmarks() {
        return Landmarks;
    }

    /**
     * This function adds an establishment to a players deck.
     * 
     * @param establishment the establishment being added
     */

    public void addEstablishment(Establishment establishment) {
        boolean alreadyOwns = false;
        for (int i = 0; i < Establishments.size(); i++ ) {
            if (establishment.getName().equals(Establishments.get(i).getName())) {
                Establishments.get(i).addAvailable();
                alreadyOwns = true;
            }
        }
        if (alreadyOwns == false) {
            int a = 0;
            int activation;
            if (Character.isDigit(establishment.getActivationRange().charAt(2))) {
                activation = Character.getNumericValue(establishment.getActivationRange().charAt(1)) * 10 + Character.getNumericValue(establishment.getActivationRange().charAt(2));
            } else {
                activation = Character.getNumericValue(establishment.getActivationRange().charAt(1));
            }
            for (int i = 0; i < Establishments.size(); i++) {
                int activation1;
                if (Character.isDigit(Establishments.get(i).getActivationRange().charAt(2))) {
                    activation1 = Character.getNumericValue(Establishments.get(i).getActivationRange().charAt(1)) * 10 + Character.getNumericValue(Establishments.get(i).getActivationRange().charAt(2));
                } else {
                    activation1 = Character.getNumericValue(Establishments.get(i).getActivationRange().charAt(1));
                }
                if (activation > activation1) {
                    a++;
                } else if (establishment.getActivationRange().length() > Establishments.get(i).getActivationRange().length()) {
                    a++;
                }
            }
            Establishments.add(a, establishment);
        }
    } 

    /**
     * This function that takes the name of an establihsment to be taken.
     * and removes one from the players list of establishments
     * 
     * @param establishment the name of the establishment being taken
     * @return an establishment representing the establihsment taken.
     */

    public Establishment takeEstablishment(String establishment) {
        Card.Color color = getEstablishment(establishment).getColor();
        Card.Icon icon = getEstablishment(establishment).getIcon();
        String name = getEstablishment(establishment).getName();
        String activation_range = getEstablishment(establishment).getActivationRange();
        int cost = getEstablishment(establishment).getCost();
        int coinChange = getEstablishment(establishment).getCoinChange();

        Establishment take = new Establishment(color, icon, cost, name, activation_range, coinChange, 1);
        if (getEstablishment(establishment).getAvailable() > 1) {
            getEstablishment(establishment).purchase();
        } else {
            Establishments.remove(getEstablishment(establishment));
        }
        return take;

    }

    /**
     * This function returns the establishments the Player can
     * trade.
     * 
     * @return a list of establihsments that can be traded.
     */

    public List<Establishment> establishmentCanTrade() {
        List<Establishment> can_take = new ArrayList<> ();
        for(int i = 0; i < Establishments.size(); i++) {
            Establishment check = Establishments.get(i);
            if(check.getName().equals("Wheat Field") || check.getName().equals("Bakery")) {
                if (check.getAvailable() > 1) {
                    can_take.add(check);
                }
            } else if(!check.getColor().equals(Card.Color.PURPLE)) {
                can_take.add(check);
            }
        }
        return can_take;
    }

    /**
     * This function returns the number of coins a player has.
     * 
     * @return an integer representing the number of coins a player has
     */

    public int getNumberOfCoins() {
        return coins;
    }

    /**
     * This function adds coins to a players bank.  The amount of coins added
     * depends on what card was pulled.
     * 
     * @param i represents the number of coins a player will obtain
     */

    public void addCoins(int i) {
        coins = coins + i;
    }
    
    /** 
     * This function deducts coins from a players bank.  The amount of the coins 
     * deducted depends on what card was pulled or what consequences another 
     * player gave them.
     * This number can never fall below zero.
     * 
     * @param i represents the number of coins a player will lose
     */

    public void subtractCoins(int i) {
        coins = coins - i;
        if (coins < 0) {
            coins = 0;
        }
    }

    /** 
    * This is a method which creates the random game play behavior of the AI Player
    * we have created. 
    * 
    * @param options a list of integers which represents the possible options for the AI Player
    * @return a list of integers that represents the options that the AI Player will choose
    */

    public Integer randomDecision(List<Integer> options) {
        Random random = new Random();
        return options.get(random.nextInt(options.size()));
    }

    /** 
    * This is a method which returns if the Player is an AI Player
    * 
    * @return a boolean true if the Player is an AIPlayer and false if not.
    */

    public boolean isAIPlayer() {
        return isAIPlayer;
    }
    
    /** This is a method that loops through the list of landmarks, 
     * checks if landmarks can be afforded by the player and the returns 
     *the appropriate list of landmarks a player can contruct.
     * 
     * @return a list of landmarks the player can construct
     */

    public List<Landmark> canConstruct() {
        List<Landmark> landmarks = new ArrayList<> ();
        for (int i = 0; i < Landmarks.size(); i++) {
            if (Landmarks.get(i).getConstructed() == false) {
                if (Landmarks.get(i).getCost() <= coins) {
                    landmarks.add(Landmarks.get(i));
                }
            }
        }
        return landmarks;
    }

    /**
     * This function is responsible for constructing a landmark.
     * 
     * @param landmark a string representing which landmark is being
     * constructed
     */

    public void construct(String landmark) {
        for (int i = 0; i < Landmarks.size(); i++) {
            if (Landmarks.get(i).getName().equals(landmark)) {
                Landmarks.get(i).setConstructed(true);
                coins = coins - Landmarks.get(i).getCost();
            }
        }
    }

    /** 
     * This method represents if someone has won the game or not. 
     * 
     * @return a boolean representing if a player has won (true) or 
     * not (false)
     */

    public boolean winner() {
        for(int i = 0; i < Landmarks.size(); i++) {
            if (Landmarks.get(i).getConstructed() == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method determines if a function is constructed or not.
     * 
     * @param landmark a string representing the name of a landmark
     * @return a boolean representing whether or not the landmark has 
     * been constructed
     */

    public boolean isConstructed(String landmark) {
        for (int i = 0; i < Landmarks.size(); i++) {
            if (Landmarks.get(i).getName().equals(landmark)) {
                if (Landmarks.get(i).getConstructed() == true) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * This method determines if a player owns an establishment or not.
     * 
     * @param establishment a string representing the name of a establishment
     * @return a boolean representing whether or not the player owns
     * the establishment
     */


    public boolean owns(String establishment) {
        for (int i = 0; i < Establishments.size(); i++) {
            if (Establishments.get(i).getName().equals(establishment)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method returns a specific establishment of the player.
     * 
     * @param establishment a string representing the name of a establishment
     * @return an establishment that the player owns
     * 
     */

    public Establishment getEstablishment(String establishment) {
        Establishment error = new Establishment(Card.Color.NONE, Card.Icon.NONE, 0, "None", "[0]", 0, 0);
        for (int i = 0; i < Establishments.size(); i++) {
            if (Establishments.get(i).getName().equals(establishment)) {
                return Establishments.get(i);
            }
        }
        return error;
    }
}