package edu.wofford.machiwoco;

import java.util.List;
import java.util.ArrayList;

/** 
 * This is the Deck class. It contains and creates the list of establishments present in a
 * deck at a given phase in the game. 
 */

public class Deck {

     protected List<Establishment> supplyList = new ArrayList<> ();

     /** 
      * This is the constructor of the Deck class. It uses conditionals to check 
      * which phase of the game the user has chosen to play. This will vary the establishment 
      * cards that are available during game play. It also creates the appropriate cards 
      * and adds them to the list.

      * @param phase a string that repressents which phase of the game the user is in
      */
     public Deck(String phase) {
          if (phase.equals("phase0")) {
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 0, 6));
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 0, 6));
               supplyList.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 0, 6));
               supplyList.add(new Establishment(Card.Color.RED, Card.Icon.CUP, 2, "Cafe", "[3]", 0, 6));
               supplyList.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 2, "Convenience Store", "[4]", 0, 6));
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 3, "Forest", "[5]", 0, 6));
               supplyList.add(new Establishment(Card.Color.PURPLE, Card.Icon.TOWER, 6, "Stadium", "[6]", 0, 4));
               supplyList.add(new Establishment(Card.Color.PURPLE, Card.Icon.TOWER, 7, "TV Station", "[6]", 0, 4));
               supplyList.add(new Establishment(Card.Color.PURPLE, Card.Icon.TOWER, 8, "Business Complex", "[6]", 0, 4));
               supplyList.add(new Establishment(Card.Color.GREEN, Card.Icon.FACTORY, 5, "Cheese Factory", "[7]", 0, 6));
               supplyList.add(new Establishment(Card.Color.GREEN, Card.Icon.FACTORY, 3, "Furniture Factory", "[8]", 0, 6));
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 6, "Mine", "[9]", 0, 6));
               supplyList.add(new Establishment(Card.Color.RED, Card.Icon.CUP, 3, "Family Restaurant", "[9-10]", 0, 6));
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 3, "Apple Orchard", "[10]", 0, 6));
               supplyList.add(new Establishment(Card.Color.GREEN, Card.Icon.FRUIT, 2, "Farmers Market", "[11-12]", 0, 6));
          }
          if (phase.equals("phase1")) {
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 6));
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 1, 6));
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 3, "Forest", "[5]", 1, 6));
          }
          if (phase.equals("phase2")) {
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 6));
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 1, 6));
               supplyList.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 1, 6));
               supplyList.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 2, "Convenience Store", "[4]", 3, 6));
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 3, "Forest", "[5]", 1, 6));
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 6, "Mine", "[9]", 5, 6));
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 3, "Apple Orchard", "[10]", 3, 6));
          }
          if (phase.equals("phase3")) {
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 6));
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 1, 6));
               supplyList.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 1, 6));
               supplyList.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 2, "Convenience Store", "[4]", 3, 6));
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 3, "Forest", "[5]", 1, 6));
               supplyList.add(new Establishment(Card.Color.GREEN, Card.Icon.FACTORY, 5, "Cheese Factory", "[7]", 0, 6));
               supplyList.add(new Establishment(Card.Color.GREEN, Card.Icon.FACTORY, 3, "Furniture Factory", "[8]", 0, 6));
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 6, "Mine", "[9]", 5, 6));
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 3, "Apple Orchard", "[10]", 3, 6));
               supplyList.add(new Establishment(Card.Color.GREEN, Card.Icon.FRUIT, 2, "Farmers Market", "[11-12]", 0, 6));
          }
          if (phase.equals("phase4")) {
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 6));
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 1, 6));
               supplyList.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 1, 6));
               supplyList.add(new Establishment(Card.Color.RED, Card.Icon.CUP, 2, "Cafe", "[3]", 0, 6));
               supplyList.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 2, "Convenience Store", "[4]", 3, 6));
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 3, "Forest", "[5]", 1, 6));
               supplyList.add(new Establishment(Card.Color.GREEN, Card.Icon.FACTORY, 5, "Cheese Factory", "[7]", 0, 6));
               supplyList.add(new Establishment(Card.Color.GREEN, Card.Icon.FACTORY, 3, "Furniture Factory", "[8]", 0, 6));
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 6, "Mine", "[9]", 5, 6));
               supplyList.add(new Establishment(Card.Color.RED, Card.Icon.CUP, 3, "Family Restaurant", "[9-10]", 0, 6));
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 3, "Apple Orchard", "[10]", 3, 6));
               supplyList.add(new Establishment(Card.Color.GREEN, Card.Icon.FRUIT, 2, "Farmers Market", "[11-12]", 0, 6));
          }
          if (phase.equals("phase5")) {
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 6));
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 1, 6));
               supplyList.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 1, 6));
               supplyList.add(new Establishment(Card.Color.RED, Card.Icon.CUP, 2, "Cafe", "[3]", 0, 6));
               supplyList.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 2, "Convenience Store", "[4]", 3, 6));
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 3, "Forest", "[5]", 1, 6));
               supplyList.add(new Establishment(Card.Color.PURPLE, Card.Icon.TOWER, 6, "Stadium", "[6]", 0, 4));
               supplyList.add(new Establishment(Card.Color.PURPLE, Card.Icon.TOWER, 7, "TV Station", "[6]", 0, 4));
               supplyList.add(new Establishment(Card.Color.PURPLE, Card.Icon.TOWER, 8, "Business Complex", "[6]", 0, 4));
               supplyList.add(new Establishment(Card.Color.GREEN, Card.Icon.FACTORY, 5, "Cheese Factory", "[7]", 0, 6));
               supplyList.add(new Establishment(Card.Color.GREEN, Card.Icon.FACTORY, 3, "Furniture Factory", "[8]", 0, 6));
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 6, "Mine", "[9]", 5, 6));
               supplyList.add(new Establishment(Card.Color.RED, Card.Icon.CUP, 3, "Family Restaurant", "[9-10]", 0, 6));
               supplyList.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 3, "Apple Orchard", "[10]", 3, 6));
               supplyList.add(new Establishment(Card.Color.GREEN, Card.Icon.FRUIT, 2, "Farmers Market", "[11-12]", 0, 6));
          }
     }
     /** 
      * This is a method that gets the deck of the establishment cards. It has a type
      * of List. 

      * @return a list, supplyList, of the establishment cards
      */ 
     
     public List<Establishment> getDeckEstablishments() {
          return supplyList;
     }

     /** 
      * This is a method that creates the string representation of the establishment
      * cards. It is of type String. 
      * 
      * @param deck a list representing the deck of cards
      * @return a string, establishments, that is the string representation of a card
      */
     
     public String getEstablishmentString(List<Establishment> deck) {
          String establishments = "";
          for (int i = 0; i < supplyList.size(); i++ ) {
               Establishment card = new Establishment();
               card = deck.get(i);
               establishments = establishments + ".-----------------------.\n";
               if (card.getActivationRange().length()  == 5) {
                    establishments = establishments + "| <" + card.getStringColor() + ">     " + card.getActivationRange() + "     {" + card.getStringIcon() + "} |\n";
               } else if (card.getActivationRange().length() == 3) {
                    establishments = establishments + "| <" + card.getStringColor() + ">      " + card.getActivationRange() + "      {" + card.getStringIcon() +"} |\n";
               } else if (card.getActivationRange().length() == 6) {
                    establishments = establishments + "| <R>    [9-10]     {U} |\n";
               } else if (card.getActivationRange().length() == 4) {
                    establishments = establishments +"| <B>     [10]      {W} |\n";
               } else {
                    establishments = establishments + "| <G>    [11-12]    {O} |\n";
               }
               int x = card.getName().length();
               int extraSpace = 23 - x;
               if (extraSpace % 2 == 0) {
                    String line = card.getName();
                    for (int t = extraSpace/2; t > 0; t = t-1) {
                    line = " " + line + " ";
                    }
                    establishments = establishments + "|" + line + "|\n";
               } else {
                    int t; 
                    String line = card.getName();
                    for (t = (extraSpace - 1)/2; t > 0; t = t-1) {
                         line = " " + line + " ";
                    }
                    line = line + " ";
                    establishments = establishments + "|" + line + "|\n";
               }
               if (card.getName().equals("Wheat Field") || card.getName().equals("Ranch") || card.getName().equals("Bakery") || card.getName().equals("Forest")) {
                    establishments = establishments + "|                       |\n";
                    establishments = establishments + "|  Get 1 coin from the  |\n";
                    establishments = establishments + "|         bank.         |\n";
               } else if (card.getName().equals("Cafe")) {
                    establishments = establishments + "|                       |\n";
                    establishments = establishments + "| Take 1 coin from the  |\n";
                    establishments = establishments + "|    active player.     |\n";
               } else if (card.getName().equals("Convenience Store") || card.getName().equals("Apple Orchard")) {
                    establishments = establishments + "|                       |\n";
                    establishments = establishments + "| Get 3 coins from the  |\n";
                    establishments = establishments + "|         bank.         |\n";
               } else if (card.getName().equals("Stadium")) {
                    establishments = establishments + "|                       |\n";
                    establishments = establishments + "|   Take 2 coins from   |\n";
                    establishments = establishments + "|    each opponent.     |\n";
               } else if (card.getName().equals("TV Station")) {
                    establishments = establishments + "|                       |\n";
                    establishments = establishments + "| Take 5 coins from an  |\n";
                    establishments = establishments + "|       opponent.       |\n";
               } else if (card.getName().equals("Business Complex")) {
                    establishments = establishments + "|                       |\n";
                    establishments = establishments + "| Exchange one of your  |\n";
                    establishments = establishments + "|       non-tower       |\n";
                    establishments = establishments + "| establishments for 1  |\n";
                    establishments = establishments + "|   an opponent owns.   |\n";
               } else if (card.getName().equals("Cheese Factory")) {
                    establishments = establishments + "|                       |\n";
                    establishments = establishments + "| Get 3 coins from the  |\n";
                    establishments = establishments + "|   bank for each {C}   |\n";
                    establishments = establishments + "|   establishment you   |\n";
                    establishments = establishments + "|         own.          |\n";
               } else if (card.getName().equals("Furniture Factory")) {
                    establishments = establishments + "|                       |\n";
                    establishments = establishments + "| Get 3 coins from the  |\n";
                    establishments = establishments + "|   bank for each {G}   |\n";
                    establishments = establishments + "|   establishment you   |\n";
                    establishments = establishments + "|         own.          |\n";
               } else if (card.getName().equals("Mine")) {
                    establishments = establishments + "|                       |\n";
                    establishments = establishments + "| Get 5 coins from the  |\n";
                    establishments = establishments + "|         bank.         |\n";
               } else if (card.getName().equals("Family Restaurant")) {
                    establishments = establishments + "|                       |\n";
                    establishments = establishments + "| Take 2 coins from the |\n";
                    establishments = establishments + "|    active player.     |\n";
               } else {
                    establishments = establishments + "|                       |\n";
                    establishments = establishments + "| Get 2 coins from the  |\n";
                    establishments = establishments + "|   bank for each {W}   |\n";
                    establishments = establishments + "|   establishment you   |\n";
                    establishments = establishments + "|         own.          |\n";
               }
               if (card.getColor() == Card.Color.BLUE) {
                    establishments = establishments + "|    (anyone's turn)    |\n";
               } else if (card.getColor() == Card.Color.GREEN || card.getColor() == Card.Color.PURPLE) {
                    establishments = establishments + "|   (your turn only)    |\n";
               } else {
                    establishments = establishments + "|   (opponent's turn)   |\n";
               }
               establishments = establishments + "|                       |\n";
               establishments = establishments + "| (" + card.getCost().toString() + ")                   |\n";
               establishments = establishments + "|_______________________|\n";
          }
          return establishments;
     }
}