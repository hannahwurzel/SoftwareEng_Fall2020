package edu.wofford.machiwoco;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class TestDeck {

    @Test
    public void testDeckConstructorPhase0() {
        Deck deck = new Deck("phase0");
        List<Establishment> cardse = new ArrayList<> ();
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 0, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 0, 6));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 0, 6));
        cardse.add(new Establishment(Card.Color.RED, Card.Icon.CUP, 2, "Cafe", "[3]", 0, 6));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 2, "Convenience Store", "[4]", 0, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 3, "Forest", "[5]", 0, 6));
        cardse.add(new Establishment(Card.Color.PURPLE, Card.Icon.TOWER, 6, "Stadium", "[6]", 0, 4));
        cardse.add(new Establishment(Card.Color.PURPLE, Card.Icon.TOWER, 7, "TV Station", "[6]", 0, 4));
        cardse.add(new Establishment(Card.Color.PURPLE, Card.Icon.TOWER, 8, "Business Complex", "[6]", 0, 4));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.FACTORY, 5, "Cheese Factory", "[7]", 0, 6));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.FACTORY, 3, "Furniture Factory", "[8]", 0, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 6, "Mine", "[9]", 0, 6));
        cardse.add(new Establishment(Card.Color.RED, Card.Icon.CUP, 3, "Family Restaurant", "[9-10]", 0, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 3, "Apple Orchard", "[10]", 0, 6));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.FRUIT, 2, "Farmers Market", "[11-12]", 0, 6));
        for (int i = 0; i < cardse.size(); i++) {
            //assertThat(deck.getDeckEstablishments().get(i).getActivationRange(), is(cardse.get(i).getActivationRange()));
            assertThat(deck.getDeckEstablishments().get(i).getClass(), is(cardse.get(i).getClass()));
            //assertThat(deck.getDeckEstablishments().get(i).getCoinChange(), is(cardse.get(i).getCoinChange()));
            assertThat(deck.getDeckEstablishments().get(i).getColor(), is(cardse.get(i).getColor()));
            assertThat(deck.getDeckEstablishments().get(i).getCost(), is(cardse.get(i).getCost()));
            assertThat(deck.getDeckEstablishments().get(i).getIcon(), is(cardse.get(i).getIcon()));
            assertThat(deck.getDeckEstablishments().get(i).getName(), is(cardse.get(i).getName()));
            assertThat(deck.getDeckEstablishments().get(i).getActivationRange(), is(cardse.get(i).getActivationRange()));
            assertThat(deck.getDeckEstablishments().get(i).getCoinChange(), is(cardse.get(i).getCoinChange()));
            assertThat(deck.getDeckEstablishments().get(i).getAvailable(), is(cardse.get(i).getAvailable()));
        }
    }


    @Test
    public void testDeckConstructorPhase1() {
        Deck deck = new Deck("phase1");
        List<Establishment> cardse = new ArrayList<> ();
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 1, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 3, "Forest", "[5]", 1, 6));
        for (int i = 0; i < cardse.size(); i++) {
            assertThat(deck.getDeckEstablishments().get(i).getActivationRange(), is(cardse.get(i).getActivationRange()));
            assertThat(deck.getDeckEstablishments().get(i).getClass(), is(cardse.get(i).getClass()));
            assertThat(deck.getDeckEstablishments().get(i).getCoinChange(), is(cardse.get(i).getCoinChange()));
            assertThat(deck.getDeckEstablishments().get(i).getColor(), is(cardse.get(i).getColor()));
            assertThat(deck.getDeckEstablishments().get(i).getCost(), is(cardse.get(i).getCost()));
            assertThat(deck.getDeckEstablishments().get(i).getIcon(), is(cardse.get(i).getIcon()));
            assertThat(deck.getDeckEstablishments().get(i).getName(), is(cardse.get(i).getName()));
            assertThat(deck.getDeckEstablishments().get(i).getAvailable(), is(cardse.get(i).getAvailable()));
        }
    }

    @Test
    public void testDeckConstructorPhase2() {
        Deck deck = new Deck("phase2");
        List<Establishment> cardse = new ArrayList<> ();
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 1, 6));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 1, 6));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 2, "Convenience Store", "[4]", 3, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 3, "Forest", "[5]", 1, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 6, "Mine", "[9]", 5, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 3, "Apple Orchard", "[10]", 3, 6));
        for (int i = 0; i < cardse.size(); i++) {
            assertThat(deck.getDeckEstablishments().get(i).getActivationRange(), is(cardse.get(i).getActivationRange()));
            assertThat(deck.getDeckEstablishments().get(i).getClass(), is(cardse.get(i).getClass()));
            assertThat(deck.getDeckEstablishments().get(i).getCoinChange(), is(cardse.get(i).getCoinChange()));
            assertThat(deck.getDeckEstablishments().get(i).getColor(), is(cardse.get(i).getColor()));
            assertThat(deck.getDeckEstablishments().get(i).getCost(), is(cardse.get(i).getCost()));
            assertThat(deck.getDeckEstablishments().get(i).getIcon(), is(cardse.get(i).getIcon()));
            assertThat(deck.getDeckEstablishments().get(i).getName(), is(cardse.get(i).getName()));
            assertThat(deck.getDeckEstablishments().get(i).getAvailable(), is(cardse.get(i).getAvailable()));
        }
    }

    @Test 
    public void testDeckConstructorPhase3() {
        Deck deck = new Deck("phase3");
        List<Establishment> cardse = new ArrayList<> ();
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 1, 6));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 1, 6));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 2, "Convenience Store", "[4]", 3, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 3, "Forest", "[5]", 1, 6));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.FACTORY, 5, "Cheese Factory", "[7]", 0, 6));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.FACTORY, 3, "Furniture Factory", "[8]", 0, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 6, "Mine", "[9]", 5, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 3, "Apple Orchard", "[10]", 3, 6));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.FRUIT, 2, "Farmers Market", "[11-12]", 0, 6));
        for (int i = 0; i < cardse.size(); i++) {
            assertThat(deck.getDeckEstablishments().get(i).getActivationRange(), is(cardse.get(i).getActivationRange()));
            assertThat(deck.getDeckEstablishments().get(i).getClass(), is(cardse.get(i).getClass()));
            assertThat(deck.getDeckEstablishments().get(i).getCoinChange(), is(cardse.get(i).getCoinChange()));
            assertThat(deck.getDeckEstablishments().get(i).getColor(), is(cardse.get(i).getColor()));
            assertThat(deck.getDeckEstablishments().get(i).getCost(), is(cardse.get(i).getCost()));
            assertThat(deck.getDeckEstablishments().get(i).getIcon(), is(cardse.get(i).getIcon()));
            assertThat(deck.getDeckEstablishments().get(i).getName(), is(cardse.get(i).getName()));
            assertThat(deck.getDeckEstablishments().get(i).getAvailable(), is(cardse.get(i).getAvailable()));
        }
    }

    @Test
    public void testDeckConstructorPhase4() {
        Deck deck = new Deck("phase4");
        List <Establishment> cardse = new ArrayList<> ();
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 1, 6));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 1, 6));
        cardse.add(new Establishment(Card.Color.RED, Card.Icon.CUP, 2, "Cafe", "[3]", 0, 6));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 2, "Convenience Store", "[4]", 3, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 3, "Forest", "[5]", 1, 6));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.FACTORY, 5, "Cheese Factory", "[7]", 0, 6));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.FACTORY, 3, "Furniture Factory", "[8]", 0, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 6, "Mine", "[9]", 5, 6));
        cardse.add(new Establishment(Card.Color.RED, Card.Icon.CUP, 3, "Family Restaurant", "[9-10]", 0, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 3, "Apple Orchard", "[10]", 3, 6));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.FRUIT, 2, "Farmers Market", "[11-12]", 0, 6));
        for (int i = 0; i < cardse.size(); i++) {
            assertThat(deck.getDeckEstablishments().get(i).getActivationRange(), is(cardse.get(i).getActivationRange()));
            assertThat(deck.getDeckEstablishments().get(i).getClass(), is(cardse.get(i).getClass()));
            assertThat(deck.getDeckEstablishments().get(i).getCoinChange(), is(cardse.get(i).getCoinChange()));
            assertThat(deck.getDeckEstablishments().get(i).getColor(), is(cardse.get(i).getColor()));
            assertThat(deck.getDeckEstablishments().get(i).getCost(), is(cardse.get(i).getCost()));
            assertThat(deck.getDeckEstablishments().get(i).getIcon(), is(cardse.get(i).getIcon()));
            assertThat(deck.getDeckEstablishments().get(i).getName(), is(cardse.get(i).getName()));
            assertThat(deck.getDeckEstablishments().get(i).getAvailable(), is(cardse.get(i).getAvailable()));
        }
    }

    @Test
    public void testDeckConstructorPhase5() {
        Deck deck = new Deck("phase5");
        List <Establishment> cardse = new ArrayList<> ();
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 1, 6));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 1, 6));
        cardse.add(new Establishment(Card.Color.RED, Card.Icon.CUP, 2, "Cafe", "[3]", 0, 6));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 2, "Convenience Store", "[4]", 3, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 3, "Forest", "[5]", 1, 6));
        cardse.add(new Establishment(Card.Color.PURPLE, Card.Icon.TOWER, 6, "Stadium", "[6]", 0, 4));
        cardse.add(new Establishment(Card.Color.PURPLE, Card.Icon.TOWER, 7, "TV Station", "[6]", 0, 4));
        cardse.add(new Establishment(Card.Color.PURPLE, Card.Icon.TOWER, 8, "Business Complex", "[6]", 0, 4));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.FACTORY, 5, "Cheese Factory", "[7]", 0, 6));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.FACTORY, 3, "Furniture Factory", "[8]", 0, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 6, "Mine", "[9]", 5, 6));
        cardse.add(new Establishment(Card.Color.RED, Card.Icon.CUP, 3, "Family Restaurant", "[9-10]", 0, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 3, "Apple Orchard", "[10]", 3, 6));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.FRUIT, 2, "Farmers Market", "[11-12]", 0, 6));
        for (int i = 0; i < cardse.size(); i++) {
            assertThat(deck.getDeckEstablishments().get(i).getActivationRange(), is(cardse.get(i).getActivationRange()));
            assertThat(deck.getDeckEstablishments().get(i).getClass(), is(cardse.get(i).getClass()));
            assertThat(deck.getDeckEstablishments().get(i).getCoinChange(), is(cardse.get(i).getCoinChange()));
            assertThat(deck.getDeckEstablishments().get(i).getColor(), is(cardse.get(i).getColor()));
            assertThat(deck.getDeckEstablishments().get(i).getCost(), is(cardse.get(i).getCost()));
            assertThat(deck.getDeckEstablishments().get(i).getIcon(), is(cardse.get(i).getIcon()));
            assertThat(deck.getDeckEstablishments().get(i).getName(), is(cardse.get(i).getName()));
            assertThat(deck.getDeckEstablishments().get(i).getAvailable(), is(cardse.get(i).getAvailable()));
        }
    }

    @Test
    public void testGetEstablishmentStringPhase0() {
        Deck deck = new Deck("phase0");
        String actual = deck.getEstablishmentString(deck.getDeckEstablishments());
        String expected = ".-----------------------.\n" +
        "| <B>      [1]      {W} |\n" +
        "|      Wheat Field      |\n" +
        "|                       |\n" +
        "|  Get 1 coin from the  |\n" +
        "|         bank.         |\n" +
        "|    (anyone's turn)    |\n" +
        "|                       |\n" +
        "| (1)                   |\n" +
        "|_______________________|\n" +
        ".-----------------------.\n" +
        "| <B>      [2]      {C} |\n" +
        "|         Ranch         |\n" +
        "|                       |\n" +
        "|  Get 1 coin from the  |\n" +
        "|         bank.         |\n" +
        "|    (anyone's turn)    |\n" +
        "|                       |\n" +
        "| (1)                   |\n" +
        "|_______________________|\n" +
        ".-----------------------.\n" +
        "| <G>     [2-3]     {B} |\n" +
        "|        Bakery         |\n" +
        "|                       |\n" +
        "|  Get 1 coin from the  |\n" +
        "|         bank.         |\n" +
        "|   (your turn only)    |\n" +
        "|                       |\n" +
        "| (1)                   |\n" +
        "|_______________________|\n" +
        ".-----------------------.\n" +
        "| <R>      [3]      {U} |\n" +
        "|         Cafe          |\n" +
        "|                       |\n" +
        "| Take 1 coin from the  |\n" +
        "|    active player.     |\n" +
        "|   (opponent's turn)   |\n" +
        "|                       |\n" +
        "| (2)                   |\n" +
        "|_______________________|\n" +
        ".-----------------------.\n" +
        "| <G>      [4]      {B} |\n" +
        "|   Convenience Store   |\n" +
        "|                       |\n" +
        "| Get 3 coins from the  |\n" +
        "|         bank.         |\n" +
        "|   (your turn only)    |\n" +
        "|                       |\n" +
        "| (2)                   |\n" +
        "|_______________________|\n" +
        ".-----------------------.\n" +
        "| <B>      [5]      {G} |\n" +
        "|        Forest         |\n" +
        "|                       |\n" +
        "|  Get 1 coin from the  |\n" +
        "|         bank.         |\n" +
        "|    (anyone's turn)    |\n" +
        "|                       |\n" +
        "| (3)                   |\n" +
        "|_______________________|\n" +
        ".-----------------------.\n" +
        "| <P>      [6]      {T} |\n" + 
        "|        Stadium        |\n" +
        "|                       |\n" +
        "|   Take 2 coins from   |\n" +
        "|    each opponent.     |\n" +
        "|   (your turn only)    |\n" +
        "|                       |\n" +
        "| (6)                   |\n" +
        "|_______________________|\n" +
        ".-----------------------.\n" +
        "| <P>      [6]      {T} |\n" +
        "|      TV Station       |\n" +
        "|                       |\n" +
        "| Take 5 coins from an  |\n" +
        "|       opponent.       |\n" +
        "|   (your turn only)    |\n" +
        "|                       |\n" +
        "| (7)                   |\n" +
        "|_______________________|\n" +
        ".-----------------------.\n" +
        "| <P>      [6]      {T} |\n" +
        "|   Business Complex    |\n" +
        "|                       |\n" +
        "| Exchange one of your  |\n" +
        "|       non-tower       |\n" +
        "| establishments for 1  |\n" +
        "|   an opponent owns.   |\n" +
        "|   (your turn only)    |\n" +
        "|                       |\n" +
        "| (8)                   |\n" +
        "|_______________________|\n" +
        ".-----------------------.\n" +
        "| <G>      [7]      {F} |\n" +
        "|    Cheese Factory     |\n" +
        "|                       |\n" +
        "| Get 3 coins from the  |\n" +
        "|   bank for each {C}   |\n" +
        "|   establishment you   |\n" +
        "|         own.          |\n" +
        "|   (your turn only)    |\n" +
        "|                       |\n" +
        "| (5)                   |\n" +
        "|_______________________|\n" +
        ".-----------------------.\n" +
        "| <G>      [8]      {F} |\n" +
        "|   Furniture Factory   |\n" +
        "|                       |\n" +
        "| Get 3 coins from the  |\n" +
        "|   bank for each {G}   |\n" +
        "|   establishment you   |\n" +
        "|         own.          |\n" +
        "|   (your turn only)    |\n" +
        "|                       |\n" +
        "| (3)                   |\n" +
        "|_______________________|\n" +
        ".-----------------------.\n" +
        "| <B>      [9]      {G} |\n" +
        "|         Mine          |\n" +
        "|                       |\n" +
        "| Get 5 coins from the  |\n" +
        "|         bank.         |\n" +
        "|    (anyone's turn)    |\n" +
        "|                       |\n" +
        "| (6)                   |\n" +
        "|_______________________|\n" +
        ".-----------------------.\n" +
        "| <R>    [9-10]     {U} |\n" +
        "|   Family Restaurant   |\n" +
        "|                       |\n" +
        "| Take 2 coins from the |\n" +
        "|    active player.     |\n" +
        "|   (opponent's turn)   |\n" +
        "|                       |\n" +
        "| (3)                   |\n" +
        "|_______________________|\n" +
        ".-----------------------.\n" +
        "| <B>     [10]      {W} |\n" +
        "|     Apple Orchard     |\n" +
        "|                       |\n" +
        "| Get 3 coins from the  |\n" +
        "|         bank.         |\n" +
        "|    (anyone's turn)    |\n" +
        "|                       |\n" +
        "| (3)                   |\n" +
        "|_______________________|\n" +
        ".-----------------------.\n" +
        "| <G>    [11-12]    {O} |\n" +
        "|    Farmers Market     |\n" +
        "|                       |\n" +
        "| Get 2 coins from the  |\n" +
        "|   bank for each {W}   |\n" +
        "|   establishment you   |\n" +
        "|         own.          |\n" +
        "|   (your turn only)    |\n" +
        "|                       |\n" +
        "| (2)                   |\n" +
        "|_______________________|\n";
        assertThat(actual, is(expected));
    }

    @Test
    public void testGetEstablishmentStringPhase1() {
        Deck deck = new Deck("phase1");
        String actual = deck.getEstablishmentString(deck.getDeckEstablishments());
        String expected = ".-----------------------.\n" +
                          "| <B>      [1]      {W} |\n" +
                          "|      Wheat Field      |\n" +
                          "|                       |\n" +
                          "|  Get 1 coin from the  |\n" +
                          "|         bank.         |\n" +
                          "|    (anyone's turn)    |\n" +
                          "|                       |\n" +
                          "| (1)                   |\n" +
                          "|_______________________|\n" +
                          ".-----------------------.\n" +
                          "| <B>      [2]      {C} |\n" +
                          "|         Ranch         |\n" +
                          "|                       |\n" +
                          "|  Get 1 coin from the  |\n" +
                          "|         bank.         |\n" +
                          "|    (anyone's turn)    |\n" +
                          "|                       |\n" +
                          "| (1)                   |\n" +
                          "|_______________________|\n" +
                          ".-----------------------.\n" +
                          "| <B>      [5]      {G} |\n" +
                          "|        Forest         |\n" +
                          "|                       |\n" +
                          "|  Get 1 coin from the  |\n" +
                          "|         bank.         |\n" +
                          "|    (anyone's turn)    |\n" +
                          "|                       |\n" +
                          "| (3)                   |\n" +
                          "|_______________________|\n";
        assertThat(actual, is(expected));
    }
}