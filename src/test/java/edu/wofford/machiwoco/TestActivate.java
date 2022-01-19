package edu.wofford.machiwoco;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;


import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;

import java.util.List;


public class TestActivate {
    @Test
    public void testActivateWheatField3() {
        Player player = new Player(1, false, "phase1");
        Establishment wheatField = new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 0, 3);
        Activate.activate(wheatField, player, player);
        assertThat(player.getNumberOfCoins(), is(6));
    }

    @Test
    public void testActivateRanch1() {
        Player player = new Player(1, false, "phase1");
        Establishment ranch = new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 0, 1);
        Activate.activate(ranch, player, player);
        assertThat(player.getNumberOfCoins(), is(4));
    }

    @Test
    public void testActivateCheeseFactory2() {
        Player player = new Player(1, false, "phase3");
        Establishment cheeseFactory = new Establishment(Card.Color.GREEN, Card.Icon.FACTORY, 5, "Cheese Factory", "[7]", 0, 2);
        Establishment ranch = new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 0, 2);
        player.addEstablishment(ranch);
        Activate.activate(cheeseFactory, player, player);
        assertThat(player.getNumberOfCoins(), is(15));
    }

    @Test
    public void testActivateFarmersMarket1() {
        Player player = new Player(1, false, "phase3");
        Establishment farmersMarket = new Establishment(Card.Color.GREEN, Card.Icon.FRUIT, 2, "Farmers Market", "[11-12]", 0, 1);
        Activate.activate(farmersMarket, player, player);
        assertThat(player.getNumberOfCoins(), is(5));
    }

    @Test
    public void testActivateFurnitureFactory2() {
        Player player = new Player(1, false, "phase3");
        Establishment furnitureFactory = new Establishment(Card.Color.GREEN, Card.Icon.FACTORY, 3, "Furniture Factory", "[8]", 0, 2);
        Establishment forest = new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 3, "Forest", "[5]", 0, 1);
        player.addEstablishment(forest);
        Activate.activate(furnitureFactory, player, player);
        assertThat(player.getNumberOfCoins(), is(9));
    }

    @Test
    public void testActivateForest3() {
        Player player = new Player(1, false, "phase1");
        Establishment forest = new Establishment(Card.Color.BLUE, Card.Icon.GEAR, 3, "Forest", "[5]", 0, 3);
        Activate.activate(forest, player, player);
        assertThat(player.getNumberOfCoins(), is(6));
    }

    @Test
    public void testActivateAppleO() {
        Player player = new Player(1, false, "phase4");
        Establishment apppleO = new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 3, "Apple Orchard", "[10]", 3, 1);
        Activate.activate(apppleO, player, player);
        assertThat(player.getNumberOfCoins(), is(6));
    }

    @Test
    public void testActivateBakery4() {
        Player player = new Player(1, false, "phase3");
        Establishment bakery = new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 0, 4);
        Activate.activate(bakery, player, player);
        assertThat(player.getNumberOfCoins(), is(7));
    }

    @Test
    public void testActivateWithShoppingMall() {
        Player player = new Player(1, false, "phase3");
        player.addCoins(10);
        player.construct("Shopping Mall");
        Establishment bakery = new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 0, 4);
        Activate.activate(bakery, player, player);
        assertThat(player.getNumberOfCoins(), is(11));
    }

    @Test
    public void testActivateCafe(){
        Player player = new Player(1, false, "phase3");
        Player curPlayer = new Player(2, false, "phase3");
        Establishment cafe = new Establishment(Card.Color.RED, Card.Icon.CUP, 2, "Cafe", "[3]", 0, 1);
        Activate.activate(cafe, player, curPlayer);
        assertThat(player.getNumberOfCoins(), is(4));
        assertThat(curPlayer.getNumberOfCoins(), is(2));

    }

    @Test
    public void testActivateFamilyRestaurant() {
        Player player = new Player(1, false, "phase3");
        Player curPlayer = new Player(2, false, "phase3");
        Establishment family_restaurant = new Establishment(Card.Color.RED, Card.Icon.CUP, 3, "Family Restaurant", "[9-10]", 0, 1);
        Activate.activate(family_restaurant, player, curPlayer);
        assertThat(player.getNumberOfCoins(), is(5));
        assertThat(curPlayer.getNumberOfCoins(), is(1));

    }

    @Test
    public void testActivateCafeSM(){
        Player player = new Player(1, false, "phase3");
        Player curPlayer = new Player(2, false, "phase3");
        player.addCoins(10);
        player.construct("Shopping Mall");
        Establishment cafe = new Establishment(Card.Color.RED, Card.Icon.CUP, 2, "Cafe", "[3]", 0, 1);
        Activate.activate(cafe, player, curPlayer);
        assertThat(player.getNumberOfCoins(), is(5));
        assertThat(curPlayer.getNumberOfCoins(), is(1));

    }

    @Test
    public void testActivateFamilyRestaurantSM() {
        Player player = new Player(1, false, "phase3");
        Player curPlayer = new Player(2, false, "phase3");
        player.addCoins(10);
        player.construct("Shopping Mall");
        Establishment family_restaurant = new Establishment(Card.Color.RED, Card.Icon.CUP, 3, "Family Restaurant", "[9-10]", 0, 1);
        Activate.activate(family_restaurant, player, curPlayer);
        assertThat(player.getNumberOfCoins(), is(6));
        assertThat(curPlayer.getNumberOfCoins(), is(0));

        
    }

    @Test
    public void testActivateCafeSM2(){
        Player player = new Player(1, false, "phase3");
        Player curPlayer = new Player(2, false, "phase3");
        player.addCoins(10);
        player.construct("Shopping Mall");
        Establishment cafe = new Establishment(Card.Color.RED, Card.Icon.CUP, 2, "Cafe", "[3]", 0, 2);
        Activate.activate(cafe, player, curPlayer);
        assertThat(player.getNumberOfCoins(), is(6));
        assertThat(curPlayer.getNumberOfCoins(), is(0));

    }

    @Test
    public void testActivateFamilyRestaurantSM2() {
        Player player = new Player(1, false, "phase3");
        Player curPlayer = new Player(2, false, "phase3");
        player.addCoins(10);
        player.construct("Shopping Mall");
        curPlayer.addCoins(1);
        Establishment family_restaurant = new Establishment(Card.Color.RED, Card.Icon.CUP, 3, "Family Restaurant", "[9-10]", 0, 2);
        Activate.activate(family_restaurant, player, curPlayer);
        assertThat(player.getNumberOfCoins(), is(7));
        assertThat(curPlayer.getNumberOfCoins(), is(0));

        
    }

    @Test
    public void testActivateFamilyRestaurant2() {
        Player player = new Player(1, false, "phase3");
        Player curPlayer = new Player(2, false, "phase3");
        Establishment family_restaurant = new Establishment(Card.Color.RED, Card.Icon.CUP, 3, "Family Restaurant", "[9-10]", 0, 2);
        Activate.activate(family_restaurant, player, curPlayer);
        assertThat(player.getNumberOfCoins(), is(6));
        assertThat(curPlayer.getNumberOfCoins(), is(0));

    }

    @Test
    public void testActivateFamilyRestaurantSM3() {
        Player player = new Player(1, false, "phase3");
        Player curPlayer = new Player(2, false, "phase3");
        player.addCoins(10);
        player.construct("Shopping Mall");
        curPlayer.addCoins(2);
        Establishment family_restaurant = new Establishment(Card.Color.RED, Card.Icon.CUP, 3, "Family Restaurant", "[9-10]", 0, 2);
        Activate.activate(family_restaurant, player, curPlayer);
        assertThat(player.getNumberOfCoins(), is(8));
        assertThat(curPlayer.getNumberOfCoins(), is(0));

        
    }

    @Test
    public void testActivateStadium() {
        Player player1 = new Player(1, false, "phase5");
        Player player2 = new Player(2, false, "phase5");
        Player player3 = new Player(3, false, "phase5");
        Player player4 = new Player(4, false, "phase5");
        player1.addCoins(2);
        player2.addCoins(3);
        player3.subtractCoins(2);
        List<Player> players = new ArrayList<> ();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        Activate.activatePurple(player4, players);
        assertThat(player1.getNumberOfCoins(), is(3));
        assertThat(player2.getNumberOfCoins(), is(4));
        assertThat(player3.getNumberOfCoins(), is(0));
        assertThat(player4.getNumberOfCoins(), is(8));
    }

    @Test
    public void testActivateTV() {
        Player player1 = new Player(1, false, "phase5");
        Player player2 = new Player(2, false, "phase5");
        Activate.activatePurple(player1, player2);
        assertThat(player1.getNumberOfCoins(), is(6));
        assertThat(player2.getNumberOfCoins(), is(0));
    }

    @Test
    public void testActivateTV2() {
        Player player1 = new Player(1, false, "phase5");
        Player player2 = new Player(2, false, "phase5");
        player2.addCoins(2);
        Activate.activatePurple(player1, player2);
        assertThat(player1.getNumberOfCoins(), is(8));
        assertThat(player2.getNumberOfCoins(), is(0));
    }

    @Test
    public void testActivateTV3() {
        Player player1 = new Player(1, false, "phase5");
        Player player2 = new Player(2, false, "phase5");
        player2.addCoins(3);
        Activate.activatePurple(player1, player2);
        assertThat(player1.getNumberOfCoins(), is(8));
        assertThat(player2.getNumberOfCoins(), is(1));
    }

    @Test
    public void testActivateBuisness() {
        Player player1 = new Player(1, false, "phase5");
        Player player2 = new Player(2, false, "phase5");
        Activate.activatePurple(player1, player2, "Wheat Field", "Bakery");
        assertThat(player1.getEstablishment("Bakery").getAvailable(), is(2));
        assertThat(player2.getEstablishment("Wheat Field").getAvailable(), is(2));
        assertThat(player1.owns("Wheat Field"), is(false));
        assertThat(player2.owns("Bakery"), is(false));


    }


    


}