package edu.wofford.machiwoco;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import java.util.List;
import java.util.ArrayList;



public class TestCard {
    
    @Test
    public void testCardConstructor() {
        Card card = new Card();
        assertThat(card.getColor(), is(Card.Color.NONE));
        assertThat(card.getIcon(), is(Card.Icon.NONE));
        assertThat(card.getCost(), is(0));
        assertThat(card.getName(), is(""));
    }

    @Test
    public void testGetStringColor() {
        Card card = new Card(Card.Color.GREEN, Card.Icon.WHEAT, 1, "testcard");
        assertThat(card.getStringColor(), is("G"));
        Card card2 = new Card(Card.Color.BLUE, Card.Icon.WHEAT, 1, "testcard");
        assertThat(card2.getStringColor(), is("B"));
        Card card3 = new Card(Card.Color.RED, Card.Icon.WHEAT, 1, "testcard");
        assertThat(card3.getStringColor(), is("R"));
        Card card4 = new Card(Card.Color.PURPLE, Card.Icon.WHEAT, 1, "testcard");
        assertThat(card4.getStringColor(), is("P"));
        Card card5 = new Card(Card.Color.NONE, Card.Icon.WHEAT, 1, "testcard");
        assertThat(card5.getStringColor(), is("N"));
    }

    @Test
    public void testGetStringIcon() {
        Card card = new Card(Card.Color.GREEN, Card.Icon.WHEAT, 1, "testcard");
        assertThat(card.getStringIcon(), is("W"));
        Card card2 = new Card(Card.Color.BLUE, Card.Icon.BREAD, 1, "testcard");
        assertThat(card2.getStringIcon(), is("B"));
        Card card3 = new Card(Card.Color.RED, Card.Icon.COW, 1, "testcard");
        assertThat(card3.getStringIcon(), is("C"));
        Card card4 = new Card(Card.Color.PURPLE, Card.Icon.GEAR, 1, "testcard");
        assertThat(card4.getStringIcon(), is("G"));
        Card card5 = new Card(Card.Color.NONE, Card.Icon.FACTORY, 1, "testcard");
        assertThat(card5.getStringIcon(), is("F"));
        Card card6 = new Card(Card.Color.NONE, Card.Icon.FRUIT, 1, "testcard");
        assertThat(card6.getStringIcon(), is("O"));
        Card card7 = new Card(Card.Color.NONE, Card.Icon.CUP, 1, "testcard");
        assertThat(card7.getStringIcon(), is("U"));
        Card card8 = new Card(Card.Color.NONE, Card.Icon.TOWER, 1, "testcard");
        assertThat(card8.getStringIcon(), is("T"));
    } 

    @Test
    public void testEstablishmentConstructor() {
        Establishment establishment = new Establishment();
        assertThat(establishment.getColor(), is(Card.Color.NONE));
        assertThat(establishment.getIcon(), is(Card.Icon.NONE));
        assertThat(establishment.getCost(), is(0));
        assertThat(establishment.getCoinChange(), is(0));
        assertThat(establishment.getActivationRange(), is(""));
        assertThat(establishment.getName(), is(""));
        assertThat(establishment.getAvailable(), is(0));
    }

    @Test
    public void testEstablishmentConstructor2() {
        Establishment establishment = new Establishment(Card.Color.GREEN, Card.Icon.COW, 1, "Bakery", "[1]", 1, 1);
        assertThat(establishment.getColor(), is(Card.Color.GREEN));
        assertThat(establishment.getIcon(), is(Card.Icon.COW));
        assertThat(establishment.getCost(), is(1));
        assertThat(establishment.getName(), is("Bakery"));
        assertThat(establishment.getActivationRange(), is("[1]"));
        assertThat(establishment.getCoinChange(), is(1));
        assertThat(establishment.getAvailable(), is(1));
    }

    @Test
    public void testLandmarkConstructor() {
        Landmark landmark = new Landmark();
        assertThat(landmark.getColor(), is(Card.Color.NONE));
        assertThat(landmark.getIcon(), is(Card.Icon.NONE));
        assertThat(landmark.getCost(), is(0));
        assertThat(landmark.getConstructed(), is(false));
        assertThat(landmark.getName(), is(""));
    }

    @Test
    public void testSetConstructed() {
        Landmark landmark = new Landmark();
        landmark.setConstructed(true);
        boolean actual = landmark.getConstructed();
        boolean expected = true;
        assertThat(actual, is(expected));
    }

    @Test 
    public void testIsAvailable() {
        Establishment establishment = new Establishment();
        boolean actual = establishment.isAvailable();
        boolean expected = false;
        assertThat(actual, is(expected));
    }

    @Test 
    public void testIsAvailableAddAvailable() {
        Establishment establishment = new Establishment();
        establishment.addAvailable();
        boolean actual = establishment.isAvailable();
        boolean expected = true;
        assertThat(actual, is(expected));
    }

    @Test
    public void testGetLandmarkList() {
        List<Landmark> cardsl = new ArrayList<> ();
        cardsl.add(new Landmark(Card.Color.NONE, Card.Icon.TOWER, 4, "Train Station"));
        cardsl.add(new Landmark(Card.Color.NONE, Card.Icon.TOWER, 7, "City Hall"));
        cardsl.add(new Landmark(Card.Color.NONE, Card.Icon.TOWER, 10, "Shopping Mall"));
        cardsl.add(new Landmark(Card.Color.NONE, Card.Icon.TOWER, 16, "Amusement Park"));
        cardsl.add(new Landmark(Card.Color.NONE, Card.Icon.TOWER, 22, "Radio Tower"));
        for (int i = 0; i < 4; i++) {
            assertThat(Landmark.getLandmarkList().get(i).getClass(), is(cardsl.get(i).getClass()));
            assertThat(Landmark.getLandmarkList().get(i).getColor(), is(cardsl.get(i).getColor()));
            assertThat(Landmark.getLandmarkList().get(i).getConstructed(), is(cardsl.get(i).getConstructed()));
            assertThat(Landmark.getLandmarkList().get(i).getCost(), is(cardsl.get(i).getCost()));
            assertThat(Landmark.getLandmarkList().get(i).getIcon(), is(cardsl.get(i).getIcon()));
            assertThat(Landmark.getLandmarkList().get(i).getName(), is(cardsl.get(i).getName()));
        }
    }

    @Test
    public void testActivated() {
        Establishment ranch = new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 0, 6);
        Establishment bakery = new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 0, 6);
        assertThat(ranch.isActivated(2, false), is(true));
        assertThat(bakery.isActivated(2, false), is(false));
        assertThat(bakery.isActivated(3, true), is(true));
    }

    @Test
    public void testActivated2() {
        Establishment farmers_market = new Establishment(Card.Color.GREEN, Card.Icon.FRUIT, 2, "Farmers Market", "[11-12]", 0, 1);
        assertThat(farmers_market.isActivated(11, true), is(true));
    }

    @Test
    public void testActivated3() {
        Establishment none = new Establishment(Card.Color.GREEN, Card.Icon.FRUIT, 2, "None", "[11-12]", 0, 1);
        assertThat(none.isActivated(11, true), is(false));
    }

    @Test
    public void testActivatedPurple() {
        Establishment tvStation = new Establishment(Card.Color.PURPLE, Card.Icon.TOWER, 7, "TV Station", "[6]", 0, 1);
        assertThat(tvStation.isActivated(6, true), is(true));
        assertThat(tvStation.isActivated(6, false), is(false));
    }

    @Test
    public void testActivatedRed() {
        Establishment cafe = new Establishment(Card.Color.RED, Card.Icon.CUP, 2, "Cafe", "[3]", 0, 1);
        assertThat(cafe.isActivated(3, true), is(false));
        assertThat(cafe.isActivated(3, false), is(true));
        assertThat(cafe.isActivated(4, false), is(false));

    }


    @Test
    public void testActivateString() {
        Establishment bakery = new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 0, 6);
        String expected = "Bakery activated for Player 1.";
        String actual = bakery.activateString(1);
        assertThat(actual, is(expected));
    }
} 