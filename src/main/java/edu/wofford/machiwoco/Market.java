package edu.wofford.machiwoco;

import java.util.List;
import java.util.ArrayList;


/**
 * This class represents the Market of Machi Koro. It is the 
 * class where players can see if they are able to afford a new establishment.
 * Futher, there is also a purchase function which allows players to buy
 * the establishment if they have enough coins.
 */
public class Market {

    protected Deck deck;
    protected String phase;
    
    /**
     * This constructor creates the market that is particular for each phase. Depending
     * on the phase, the deck will be created to satisfy said phase.
     * 
     * @param phase a string representing the phase of the game that is being played
     */
    public Market(String phase) {
        this.phase = phase;
        deck = new Deck(phase);
        //should it be Deck deck = new Deck(phase);
    }

    /** 
      * This is a method that returns the phase in which the market is activated
      * 
      * @return a string, phase, that represents the phase
      */

    public String getPhase() {
        return phase;
    }

    /** 
      * This is a method that returns a list of establishments in the
      * market.
      * 
      * @return a list of establishments, representing the market
      */

    public List<Establishment> getMarket() {
        return deck.getDeckEstablishments();
    }

    /** 
      * This is a method that returns a list of only establishments
      * that are available in the market
      * 
      * @return a list of establishments, available, that is those available
      */

    public List<Establishment> getAvailable() {
        List<Establishment> available = new ArrayList<> ();
        for(int i = 0; i < deck.getDeckEstablishments().size(); i++) {
            if (deck.getDeckEstablishments().get(i).isAvailable() == true) {
                available.add(deck.getDeckEstablishments().get(i));
            }
        }
        return available;
    }

    /** 
      * This is a method that returns what establishments a player can purchase
      * with a given number of coins that are also available.
      * 
      * @param player the current player
      * @return a list of establishments, canBuy that the player can purchase
      */

    public List<Establishment> canBuy(Player player) {
        List<Establishment> canBuy = new ArrayList<> ();
        int coins = player.getNumberOfCoins();
        for(int i = 0; i < deck.getDeckEstablishments().size(); i++) {
            if (deck.getDeckEstablishments().get(i).isAvailable() == true && coins >= deck.getDeckEstablishments().get(i).getCost()) {
                if (deck.getDeckEstablishments().get(i).getColor().equals(Card.Color.PURPLE)) {
                    if(player.owns(deck.getDeckEstablishments().get(i).getName()) == false) {
                        canBuy.add(deck.getDeckEstablishments().get(i));
                    }
                } else {
                    canBuy.add(deck.getDeckEstablishments().get(i));
                }
            }
        }     
        return canBuy;
    }

    /** 
      * This is a method that allows a player to purchase an establishment.
      * 
      * @param establishment a string representation of the name of the establishment
      * @return establishment purchased
      */

    public Establishment purchase(String establishment) {
        for(int i = 0; i < deck.getDeckEstablishments().size(); i++) {
            if(deck.getDeckEstablishments().get(i).getName().equals(establishment)) {
                deck.getDeckEstablishments().get(i).purchase();
                Establishment purchased = new Establishment(deck.getDeckEstablishments().get(i).getColor(), deck.getDeckEstablishments().get(i).getIcon(), deck.getDeckEstablishments().get(i).getCost(), deck.getDeckEstablishments().get(i).getName(), deck.getDeckEstablishments().get(i).getActivationRange(), deck.getDeckEstablishments().get(i).getCoinChange(), 1);
                return purchased;
            }
        }
        Establishment error = new Establishment();
        return error;
    }
}