package edu.wofford.machiwoco;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.*;


public class TestPlayer {

    @Test
    public void testPlayerConstructor() {
        Player player = new Player(1, false, "phase1");
        List <Landmark> landmarks = new ArrayList<> ();
        List <Establishment> establishments = new ArrayList<> ();
        establishments.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 1));
        landmarks.add(new Landmark(Card.Color.NONE, Card.Icon.NONE, 7, "City Hall"));
        assertThat(player.getPlayerNumber(), is(1));
        for (int i = 0; i < establishments.size(); i++) {
            assertThat(player.getEstablishments().get(i).getActivationRange(), is(establishments.get(i).getActivationRange()));
            assertThat(player.getEstablishments().get(i).getClass(), is(establishments.get(i).getClass()));
            assertThat(player.getEstablishments().get(i).getCoinChange(), is(establishments.get(i).getCoinChange()));
            assertThat(player.getEstablishments().get(i).getColor(), is(establishments.get(i).getColor()));
            assertThat(player.getEstablishments().get(i).getCost(), is(establishments.get(i).getCost()));
            assertThat(player.getEstablishments().get(i).getIcon(), is(establishments.get(i).getIcon()));
            assertThat(player.getEstablishments().get(i).getName(), is(establishments.get(i).getName()));
            assertThat(player.getEstablishments().get(i).getAvailable(), is(establishments.get(i).getAvailable()));
        }
        for (int i = 0; i < landmarks.size(); i++) {
            assertThat(player.getLandmarks().get(i).getClass(), is(landmarks.get(i).getClass()));
            assertThat(player.getLandmarks().get(i).getColor(), is(landmarks.get(i).getColor()));
            assertThat(player.getLandmarks().get(i).getConstructed(), is(landmarks.get(i).getConstructed()));
            assertThat(player.getLandmarks().get(i).getCost(), is(landmarks.get(i).getCost()));
            assertThat(player.getLandmarks().get(i).getIcon(), is(landmarks.get(i).getIcon()));
            assertThat(player.getLandmarks().get(i).getName(), is(landmarks.get(i).getName()));
        }
        assertThat(player.getNumberOfCoins(), is(3));
        assertThat(player.isAIPlayer(), is(false));
    }

    @Test
    public void testSetPlayerNumber() {
        Player player = new Player(1, false, "phase1");
        player.setPlayerNumber(1);
        assertThat(player.getPlayerNumber(), is(1));
    }

    @Test
    public void testAddCoins() {
        Player player = new Player(1, false, "phase1");
        player.addCoins(2);
        assertThat(player.getNumberOfCoins(), is(5));
    }

    @Test
    public void testSubtractCoins() {
        Player player = new Player(1, false, "phase1");
        player.subtractCoins(1);
        assertThat(player.getNumberOfCoins(), is(2));
    }

    @Test
    public void subtractCoinsWhenCoinTotal0() {
        Player player = new Player(1, false, "phase1");
        player.subtractCoins(100);
        int actual = player.getNumberOfCoins();
        int expected = 0;
        assertThat(actual, is(expected));
    }

    @Test
    public void testAddEstablishment() {
        Player player = new Player(1, false, "phase1");
        Establishment ranch = new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 0, 1);
        Establishment wheatField = new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 1);
        player.addEstablishment(ranch);
        player.addEstablishment(wheatField);
        assertThat(player.getEstablishments().get(player.getEstablishments().size() - 1).getActivationRange(), is("[2]"));
        assertThat(player.getEstablishments().get(player.getEstablishments().size() - 1).getCoinChange(), is(0));
        assertThat(player.getEstablishments().get(player.getEstablishments().size() - 1).getColor(), is(Card.Color.BLUE));
        assertThat(player.getEstablishments().get(player.getEstablishments().size() - 1).getCost(), is(1));
        assertThat(player.getEstablishments().get(player.getEstablishments().size() - 1).getIcon(), is(Card.Icon.COW));
        assertThat(player.getEstablishments().get(player.getEstablishments().size() - 1).getName(), is("Ranch"));
        assertThat(player.getEstablishments().get(player.getEstablishments().size() - 1).getAvailable(), is(1));
        assertThat(player.getEstablishments().get(0).getAvailable(), is(2));
    }

    @Test
    public void testAddEstablishment2() {
        Player player = new Player(1, false, "phase4");
        Establishment farmers_market = new Establishment(Card.Color.GREEN, Card.Icon.FRUIT, 2, "Farmers Market", "[11-12]", 0, 1);
        player.addEstablishment(farmers_market);
        assertThat(player.getEstablishment("Farmers Market").getActivationRange(), is("[11-12]"));
        assertThat(player.getEstablishment("Farmers Market").getCoinChange(), is(0));
        assertThat(player.getEstablishment("Farmers Market").getColor(), is(Card.Color.GREEN));
        assertThat(player.getEstablishment("Farmers Market").getCost(), is(2));
        assertThat(player.getEstablishment("Farmers Market").getIcon(), is(Card.Icon.FRUIT));
        assertThat(player.getEstablishment("Farmers Market").getName(), is("Farmers Market"));
        assertThat(player.getEstablishment("Farmers Market").getAvailable(), is(1));
    }

    @Test
    public void testAddEstablishment3() {
        Player player = new Player(1, false, "phase5");
        Establishment bakery = new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 0, 1);
        player.addEstablishment(bakery);
        assertThat(player.getEstablishment("Bakery").getAvailable(), is(2));
    }

    @Test
    public void testAddEstablishment4() {
        Player player = new Player(1, false, "phase1");
        Establishment bakery = new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 0, 1);
        player.addEstablishment(bakery);
        assertThat(player.getEstablishment("Bakery").getActivationRange(), is("[2-3]"));
        assertThat(player.getEstablishment("Bakery").getCoinChange(), is(0));
        assertThat(player.getEstablishment("Bakery").getColor(), is(Card.Color.GREEN));
        assertThat(player.getEstablishment("Bakery").getCost(), is(1));
        assertThat(player.getEstablishment("Bakery").getIcon(), is(Card.Icon.BREAD));
        assertThat(player.getEstablishment("Bakery").getName(), is("Bakery"));
        assertThat(player.getEstablishment("Bakery").getAvailable(), is(1));
    }

    @Test
    public void testAddEstablishment5() {
        Player player = new Player(1, false, "phase4");
        Establishment appleOrchid = new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 3, "Apple Orchard", "[10]", 0, 1);
        Establishment family = new Establishment(Card.Color.RED, Card.Icon.CUP, 3, "Family Restaurant", "[9-10]", 0, 1);
        player.addEstablishment(appleOrchid);
        player.addEstablishment(family);
        assertThat(player.getEstablishment("Apple Orchard").getActivationRange(), is("[10]"));
        assertThat(player.getEstablishment("Apple Orchard").getCoinChange(), is(0));
        assertThat(player.getEstablishment("Apple Orchard").getColor(), is(Card.Color.BLUE));
        assertThat(player.getEstablishment("Apple Orchard").getCost(), is(3));
        assertThat(player.getEstablishment("Apple Orchard").getIcon(), is(Card.Icon.WHEAT));
        assertThat(player.getEstablishment("Apple Orchard").getName(), is("Apple Orchard"));
        assertThat(player.getEstablishment("Apple Orchard").getAvailable(), is(1));
    }

    @Test
    public void testWins() {
        Player player = new Player(1, false, "phase1");
        assertThat(player.winner(), is(false));
    }

    @Test
    public void testWins2() {
        Player player = new Player(1, false, "phase1");
        player.addCoins(7);
        player.construct("City Hall");
        assertThat(player.winner(), is(true));
    }


    @Test
    public void testIsConstructed() {
        Player player = new Player(1, false, "phase1");
        player.construct("City Hall");
        boolean actual = player.isConstructed("City Hall");
        boolean expected = true;
        assertThat(actual, is(expected));
    }

    @Test
    public void testOwns() {
        Player player = new Player(1, false, "phase1");
        assertThat(player.owns("Wheat Field"), is(true));
        assertThat(player.owns("Bakery"), is(false));
    }

    @Test
    public void testGetEstablishment() {
        Player player = new Player(1, false, "phase1");
        Establishment wheatFeild = new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 1);
        assertThat(player.getEstablishment("Wheat Field").getActivationRange(), is(wheatFeild.getActivationRange()));
        assertThat(player.getEstablishment("Wheat Field").getClass(), is(wheatFeild.getClass()));
        assertThat(player.getEstablishment("Wheat Field").getCoinChange(), is(wheatFeild.getCoinChange()));
        assertThat(player.getEstablishment("Wheat Field").getColor(), is(wheatFeild.getColor()));
        assertThat(player.getEstablishment("Wheat Field").getCost(), is(wheatFeild.getCost()));
        assertThat(player.getEstablishment("Wheat Field").getIcon(), is(wheatFeild.getIcon()));
        assertThat(player.getEstablishment("Wheat Field").getName(), is(wheatFeild.getName()));
        assertThat(player.getEstablishment("Wheat Field").getAvailable(), is(wheatFeild.getAvailable()));
    }

    @Test
    public void testGetEstablishment2() {
        Player player = new Player(1, false, "phase1");
        Establishment error = new Establishment(Card.Color.NONE, Card.Icon.NONE, 0, "None", "[0]", 0, 0);
        assertThat(player.getEstablishment("Bakery").getActivationRange(), is(error.getActivationRange()));
        assertThat(player.getEstablishment("Bakery").getClass(), is(error.getClass()));
        assertThat(player.getEstablishment("Bakery").getCoinChange(), is(error.getCoinChange()));
        assertThat(player.getEstablishment("Bakery").getColor(), is(error.getColor()));
        assertThat(player.getEstablishment("Bakery").getCost(), is(error.getCost()));
        assertThat(player.getEstablishment("Bakery").getIcon(), is(error.getIcon()));
        assertThat(player.getEstablishment("Bakery").getName(), is(error.getName()));
        assertThat(player.getEstablishment("Bakery").getAvailable(), is(error.getAvailable()));
    }

    @Test
    public void testTakeEstablishmnet() {
        Player player = new Player(1, false, "phase5");
        Establishment take = player.takeEstablishment("Wheat Field");
        Establishment wheatFeild = new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 1);
        assertThat(player.owns("Wheat Field"), is(false));
        assertThat(take.getActivationRange(), is(wheatFeild.getActivationRange()));
        assertThat(take.getClass(), is(wheatFeild.getClass()));
        assertThat(take.getCoinChange(), is(wheatFeild.getCoinChange()));
        assertThat(take.getColor(), is(wheatFeild.getColor()));
        assertThat(take.getCost(), is(wheatFeild.getCost()));
        assertThat(take.getIcon(), is(wheatFeild.getIcon()));
        assertThat(take.getName(), is(wheatFeild.getName()));
        assertThat(take.getAvailable(), is(wheatFeild.getAvailable()));

    }

    @Test
    public void testTakeEstablishmnet2() {
        Player player = new Player(1, false, "phase5");
        assertThat(player.owns("Wheat Field"), is(true));
        Establishment wheatFeild = new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 1);
        player.addEstablishment(wheatFeild);
        assertThat(player.getEstablishment("Wheat Field").getAvailable(), is(2));
        Establishment take = player.takeEstablishment("Wheat Field");
        assertThat(player.getEstablishment("Wheat Field").getAvailable(), is(1));
        assertThat(player.owns("Wheat Field"), is(true));
        assertThat(take.getActivationRange(), is(wheatFeild.getActivationRange()));
        assertThat(take.getClass(), is(wheatFeild.getClass()));
        assertThat(take.getCoinChange(), is(wheatFeild.getCoinChange()));
        assertThat(take.getColor(), is(wheatFeild.getColor()));
        assertThat(take.getCost(), is(wheatFeild.getCost()));
        assertThat(take.getIcon(), is(wheatFeild.getIcon()));
        assertThat(take.getName(), is(wheatFeild.getName()));
        assertThat(take.getAvailable(), is(wheatFeild.getAvailable()));

    }

    @Test
    public void testEstablishmentCanTrade() {
        Player player = new Player(1, false, "phase5");
        player.addEstablishment(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 1));
        player.addEstablishment(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 1, 1));
        player.addEstablishment(new Establishment(Card.Color.PURPLE, Card.Icon.TOWER, 7, "TV Station", "[6]", 0, 1));
        List<Establishment> actual = player.establishmentCanTrade();
        List<Establishment> expected = new ArrayList<> ();
        expected.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 2));
        expected.add(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 1, 1));
        assertThat(actual.size(), is(expected.size()));
        for (int i = 0; i < expected.size(); i++) {
            assertThat(actual.get(i).getActivationRange(), is(expected.get(i).getActivationRange()));
            assertThat(actual.get(i).getClass(), is(expected.get(i).getClass()));
            assertThat(actual.get(i).getCoinChange(), is(expected.get(i).getCoinChange()));
            assertThat(actual.get(i).getColor(), is(expected.get(i).getColor()));
            assertThat(actual.get(i).getCost(), is(expected.get(i).getCost()));
            assertThat(actual.get(i).getIcon(), is(expected.get(i).getIcon()));
            assertThat(actual.get(i).getName(), is(expected.get(i).getName()));
            assertThat(actual.get(i).getAvailable(), is(expected.get(i).getAvailable()));
        }

    }

    @Test
    public void testRandomDecision() {
        Player player = new Player(1, true, "phase5");
        List<Integer> options = new ArrayList<> ();
        options.add(1);
        options.add(2);
        options.add(3);
        options.add(4);
        int rand = player.randomDecision(options);
        Boolean isIn = options.contains(rand);
        assertThat(isIn, is(true));

    }
}