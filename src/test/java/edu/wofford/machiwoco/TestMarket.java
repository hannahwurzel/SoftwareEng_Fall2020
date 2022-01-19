package edu.wofford.machiwoco;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import java.util.List;
import java.util.ArrayList;


public class TestMarket {
    @Test
    public void MarketConstructorPhase1() {
        Market market = new Market("phase1");
        assertThat(market.getPhase(), is("phase1"));
        List<Establishment> cardse = new ArrayList<> ();
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 1, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 3, "Forest", "[5]", 1, 6));
        for (int i = 0; i < cardse.size(); i++) {
            assertThat(market.getMarket().get(i).getActivationRange(), is(cardse.get(i).getActivationRange()));
            assertThat(market.getMarket().get(i).getClass(), is(cardse.get(i).getClass()));
            assertThat(market.getMarket().get(i).getCoinChange(), is(cardse.get(i).getCoinChange()));
            assertThat(market.getMarket().get(i).getColor(), is(cardse.get(i).getColor()));
            assertThat(market.getMarket().get(i).getCost(), is(cardse.get(i).getCost()));
            assertThat(market.getMarket().get(i).getIcon(), is(cardse.get(i).getIcon()));
            assertThat(market.getMarket().get(i).getName(), is(cardse.get(i).getName()));
            assertThat(market.getMarket().get(i).getAvailable(), is(cardse.get(i).getAvailable()));
        }    
    }

    @Test
    public void MarketConstructorPhase2() {
        Market market = new Market("phase2");
        assertThat(market.getPhase(), is("phase2"));
        List<Establishment> cardse = new ArrayList<> ();
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 1, 6));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 1, 6));
        cardse.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 2, "Convenience Store", "[4]", 3, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 3, "Forest", "[5]", 1, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 6, "Mine", "[9]", 5, 6));
        cardse.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 3, "Apple Orchard", "[10]", 3, 6));
        for (int i = 0; i < cardse.size(); i++) {
            assertThat(market.getMarket().get(i).getActivationRange(), is(cardse.get(i).getActivationRange()));
            assertThat(market.getMarket().get(i).getClass(), is(cardse.get(i).getClass()));
            assertThat(market.getMarket().get(i).getCoinChange(), is(cardse.get(i).getCoinChange()));
            assertThat(market.getMarket().get(i).getColor(), is(cardse.get(i).getColor()));
            assertThat(market.getMarket().get(i).getCost(), is(cardse.get(i).getCost()));
            assertThat(market.getMarket().get(i).getIcon(), is(cardse.get(i).getIcon()));
            assertThat(market.getMarket().get(i).getName(), is(cardse.get(i).getName()));
            assertThat(market.getMarket().get(i).getAvailable(), is(cardse.get(i).getAvailable()));
        }    
    }


    @Test
    public void testPurchase() {
        Market market = new Market("phase1");
        Establishment actual = market.purchase("Wheat Field");
        Establishment expected = new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 1);
        assertThat(actual.getActivationRange(), is(expected.getActivationRange()));
        assertThat(actual.getClass(), is(expected.getClass()));
        assertThat(actual.getCoinChange(), is(expected.getCoinChange()));
        assertThat(actual.getColor(), is(expected.getColor()));
        assertThat(actual.getCost(), is(expected.getCost()));
        assertThat(actual.getIcon(), is(expected.getIcon()));
        assertThat(actual.getName(), is(expected.getName()));
        assertThat(actual.getAvailable(), is(expected.getAvailable()));

    }

    @Test
    public void testGetAvailable() {
        Market market = new Market("phase1");
        List<Establishment> expected = new ArrayList<> ();
        expected.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 6));
        expected.add(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 1, 6));
        expected.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 3, "Forest", "[5]", 1, 6));
        for (int i = 0; i < expected.size(); i++) {
            assertThat(market.getAvailable().get(i).getActivationRange(), is(expected.get(i).getActivationRange()));
            assertThat(market.getAvailable().get(i).getClass(), is(expected.get(i).getClass()));
            assertThat(market.getAvailable().get(i).getCoinChange(), is(expected.get(i).getCoinChange()));
            assertThat(market.getAvailable().get(i).getColor(), is(expected.get(i).getColor()));
            assertThat(market.getAvailable().get(i).getCost(), is(expected.get(i).getCost()));
            assertThat(market.getAvailable().get(i).getIcon(), is(expected.get(i).getIcon()));
            assertThat(market.getAvailable().get(i).getName(), is(expected.get(i).getName()));
            assertThat(market.getAvailable().get(i).getAvailable(), is(expected.get(i).getAvailable()));
        }  
    }

    @Test
    public void testGetAvailable2() {
        Market market = new Market("phase1");
        market.purchase("Wheat Field");
        market.purchase("Wheat Field");
        market.purchase("Wheat Field");
        market.purchase("Wheat Field");
        market.purchase("Wheat Field");
        market.purchase("Wheat Field");
        List<Establishment> expected = new ArrayList<> ();
        expected.add(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 1, 6));
        expected.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 3, "Forest", "[5]", 1, 6));
        for (int i = 0; i < expected.size(); i++) {
            assertThat(market.getAvailable().get(i).getActivationRange(), is(expected.get(i).getActivationRange()));
            assertThat(market.getAvailable().get(i).getClass(), is(expected.get(i).getClass()));
            assertThat(market.getAvailable().get(i).getCoinChange(), is(expected.get(i).getCoinChange()));
            assertThat(market.getAvailable().get(i).getColor(), is(expected.get(i).getColor()));
            assertThat(market.getAvailable().get(i).getCost(), is(expected.get(i).getCost()));
            assertThat(market.getAvailable().get(i).getIcon(), is(expected.get(i).getIcon()));
            assertThat(market.getAvailable().get(i).getName(), is(expected.get(i).getName()));
            assertThat(market.getAvailable().get(i).getAvailable(), is(expected.get(i).getAvailable()));
        }

    }

    @Test
    public void testCanBuy() {
        Market market = new Market("phase1");
        List<Establishment> expected = new ArrayList<> ();
        Player player = new Player(1, false, "phase1");
        player.subtractCoins(2);
        expected.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 6));
        expected.add(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 1, 6));
        for (int i = 0; i < expected.size(); i++) {
            assertThat(market.canBuy(player).get(i).getActivationRange(), is(expected.get(i).getActivationRange()));
            assertThat(market.canBuy(player).get(i).getClass(), is(expected.get(i).getClass()));
            assertThat(market.canBuy(player).get(i).getCoinChange(), is(expected.get(i).getCoinChange()));
            assertThat(market.canBuy(player).get(i).getColor(), is(expected.get(i).getColor()));
            assertThat(market.canBuy(player).get(i).getCost(), is(expected.get(i).getCost()));
            assertThat(market.canBuy(player).get(i).getIcon(), is(expected.get(i).getIcon()));
            assertThat(market.canBuy(player).get(i).getName(), is(expected.get(i).getName()));
            assertThat(market.canBuy(player).get(i).getAvailable(), is(expected.get(i).getAvailable()));
        }
    }

    @Test
    public void testCanBuy2() {
        Market market = new Market("phase1");
        List<Establishment> expected = new ArrayList<> ();
        Player player = new Player(1, false, "phase1");
        player.subtractCoins(2);
        market.purchase("Wheat Field");
        market.purchase("Wheat Field");
        market.purchase("Wheat Field");
        market.purchase("Wheat Field");
        market.purchase("Wheat Field");
        market.purchase("Wheat Field");
        expected.add(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 1, 6));
        for (int i = 0; i < expected.size(); i++) {
            assertThat(market.canBuy(player).get(i).getActivationRange(), is(expected.get(i).getActivationRange()));
            assertThat(market.canBuy(player).get(i).getClass(), is(expected.get(i).getClass()));
            assertThat(market.canBuy(player).get(i).getCoinChange(), is(expected.get(i).getCoinChange()));
            assertThat(market.canBuy(player).get(i).getColor(), is(expected.get(i).getColor()));
            assertThat(market.canBuy(player).get(i).getCost(), is(expected.get(i).getCost()));
            assertThat(market.canBuy(player).get(i).getIcon(), is(expected.get(i).getIcon()));
            assertThat(market.canBuy(player).get(i).getName(), is(expected.get(i).getName()));
            assertThat(market.canBuy(player).get(i).getAvailable(), is(expected.get(i).getAvailable()));
        }
    }

    @Test
    public void testCanBuy3() {
        Market market = new Market("phase1");
        Player player = new Player(1, false, "phase1");
        player.subtractCoins(3);
        market.purchase("Wheat Field");
        market.purchase("Wheat Field");
        market.purchase("Wheat Field");
        market.purchase("Wheat Field");
        market.purchase("Wheat Field");
        market.purchase("Wheat Field");
        assertThat(market.canBuy(player).size(), is(0));
    }

    @Test
    public void testCanBuyPurple() {
        Market market = new Market("phase5");
        List<Establishment> expected = new ArrayList<> ();
        Player player = new Player(1, false, "phase5");
        player.addCoins(3);
        expected.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 6));
        expected.add(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 1, 6));
        expected.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 1, 6));
        expected.add(new Establishment(Card.Color.RED, Card.Icon.CUP, 2, "Cafe", "[3]", 0, 6));
        expected.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 2, "Convenience Store", "[4]", 3, 6));
        expected.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 3, "Forest", "[5]", 1, 6));
        expected.add(new Establishment(Card.Color.PURPLE, Card.Icon.TOWER, 6, "Stadium", "[6]", 0, 4));
        expected.add(new Establishment(Card.Color.GREEN, Card.Icon.FACTORY, 5, "Cheese Factory", "[7]", 0, 6));
        expected.add(new Establishment(Card.Color.GREEN, Card.Icon.FACTORY, 3, "Furniture Factory", "[8]", 0, 6));
        expected.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 6, "Mine", "[9]", 5, 6));
        expected.add(new Establishment(Card.Color.RED, Card.Icon.CUP, 3, "Family Restaurant", "[9-10]", 0, 6));
        expected.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 3, "Apple Orchard", "[10]", 3, 6));
        expected.add(new Establishment(Card.Color.GREEN, Card.Icon.FRUIT, 2, "Farmers Market", "[11-12]", 0, 6));
        for (int i = 0; i < expected.size(); i++) {
            assertThat(market.canBuy(player).get(i).getActivationRange(), is(expected.get(i).getActivationRange()));
            assertThat(market.canBuy(player).get(i).getClass(), is(expected.get(i).getClass()));
            assertThat(market.canBuy(player).get(i).getCoinChange(), is(expected.get(i).getCoinChange()));
            assertThat(market.canBuy(player).get(i).getColor(), is(expected.get(i).getColor()));
            assertThat(market.canBuy(player).get(i).getCost(), is(expected.get(i).getCost()));
            assertThat(market.canBuy(player).get(i).getIcon(), is(expected.get(i).getIcon()));
            assertThat(market.canBuy(player).get(i).getName(), is(expected.get(i).getName()));
            assertThat(market.canBuy(player).get(i).getAvailable(), is(expected.get(i).getAvailable()));
        }
    }
    
    @Test
    public void testCanBuyPurpleOwned() {
        Market market = new Market("phase5");
        List<Establishment> expected = new ArrayList<> ();
        Player player = new Player(1, false, "phase5");
        player.addCoins(3);
        player.addEstablishment(market.purchase("Stadium"));
        expected.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 6));
        expected.add(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 1, 6));
        expected.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 1, 6));
        expected.add(new Establishment(Card.Color.RED, Card.Icon.CUP, 2, "Cafe", "[3]", 0, 6));
        expected.add(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 2, "Convenience Store", "[4]", 3, 6));
        expected.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 3, "Forest", "[5]", 1, 6));
        expected.add(new Establishment(Card.Color.GREEN, Card.Icon.FACTORY, 5, "Cheese Factory", "[7]", 0, 6));
        expected.add(new Establishment(Card.Color.GREEN, Card.Icon.FACTORY, 3, "Furniture Factory", "[8]", 0, 6));
        expected.add(new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 6, "Mine", "[9]", 5, 6));
        expected.add(new Establishment(Card.Color.RED, Card.Icon.CUP, 3, "Family Restaurant", "[9-10]", 0, 6));
        expected.add(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 3, "Apple Orchard", "[10]", 3, 6));
        expected.add(new Establishment(Card.Color.GREEN, Card.Icon.FRUIT, 2, "Farmers Market", "[11-12]", 0, 6));
        for (int i = 0; i < expected.size(); i++) {
            assertThat(market.canBuy(player).get(i).getActivationRange(), is(expected.get(i).getActivationRange()));
            assertThat(market.canBuy(player).get(i).getClass(), is(expected.get(i).getClass()));
            assertThat(market.canBuy(player).get(i).getCoinChange(), is(expected.get(i).getCoinChange()));
            assertThat(market.canBuy(player).get(i).getColor(), is(expected.get(i).getColor()));
            assertThat(market.canBuy(player).get(i).getCost(), is(expected.get(i).getCost()));
            assertThat(market.canBuy(player).get(i).getIcon(), is(expected.get(i).getIcon()));
            assertThat(market.canBuy(player).get(i).getName(), is(expected.get(i).getName()));
            assertThat(market.canBuy(player).get(i).getAvailable(), is(expected.get(i).getAvailable()));
        }
    }

    @Test
    public void testPurchase2() {
        Market market = new Market("phase1");
        Establishment actual = market.purchase("Bakery");
        Establishment expected = new Establishment();
        assertThat(actual.getActivationRange(), is(expected.getActivationRange()));
        assertThat(actual.getClass(), is(expected.getClass()));
        assertThat(actual.getCoinChange(), is(expected.getCoinChange()));
        assertThat(actual.getColor(), is(expected.getColor()));
        assertThat(actual.getCost(), is(expected.getCost()));
        assertThat(actual.getIcon(), is(expected.getIcon()));
        assertThat(actual.getName(), is(expected.getName()));
        assertThat(actual.getAvailable(), is(expected.getAvailable()));
        
    }
}