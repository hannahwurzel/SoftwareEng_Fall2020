package edu.wofford.machiwoco;

import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;

import java.util.List;
import java.util.ArrayList;


public class TestGame {

    @Test
    public void testConstructor() {
        Market market = new Market("phase1");
        Player player = new Player(1, true, "phase1");
        List<Player> players = new ArrayList<> ();
        players.add(player);
        Game game = new Game("phase1", market, players);
        assertThat(game.getGameOver(), is(false));
        assertThat(game.getWinner(), is(""));
        assertThat(game.getCurrentRoll(), is(0));
    }

    @Test 
    public void testSetWinner() {
        Market market = new Market("phase1");
        Player player = new Player(1, true, "phase1");
        List<Player> players = new ArrayList<> ();
        players.add(player);
        Game game = new Game("phase1", market, players);
        game.setWinner("Player 1");
        assertThat(game.getWinner(), is("Player 1"));
        assertThat(game.getGameOver(), is(true));
    }

    @Test
    public void testRollDice() {
        Market market = new Market("phase1");
        Player player = new Player(1, true, "phase1");
        List<Player> players = new ArrayList<> ();
        players.add(player);
        Game game = new Game("phase1", market, players);
        String actual = game.rollDice(1, 1);
        String expected = "Player 1 rolled [" + Integer.toString(game.getCurrentRoll()) + "] = " + Integer.toString(game.getCurrentRoll()) + ".";
        assertThat(actual, is(expected));
    }

     @Test
     public void testEarnIncome() {
         Market market = new Market("phase1");
         Player player1 = new Player(1, true, "phase1");
         Player player2 = new Player(2, true, "phase1");
         List<Player> players = new ArrayList<> ();
         players.add(player1);
         players.add(player2);
         Deck deck = new Deck("phase1");
         Game game = new Game("phase1", market, players);
         String actual = game.earnIncome(player1, 1, deck);
         String expected = "Wheat Field activated for Player 2.\nWheat Field activated for Player 1.\n";
         assertThat(actual, is(expected));
         assertThat(player1.getNumberOfCoins(), is(4));
         assertThat(player2.getNumberOfCoins(), is(4));
     }

     @Test
     public void testEarnIncomePhase2() {
        Market market = new Market("phase2");
        Player player1 = new Player(1, true, "phase2");
        Player player2 = new Player(2, true, "phase2");
        List<Player> players = new ArrayList<> ();
        players.add(player1);
        players.add(player2);
        Game game = new Game("phase2", market, players);
        Player currentPlayer = game.getPlayer(0);
        currentPlayer.addEstablishment(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 0, 1));
        Deck deck = new Deck("phase2");
        String actual = game.earnIncome(player1, 2, deck);
        String expected = "Ranch activated for Player 1.\nBakery activated for Player 1.\n";
        assertThat(player1.getNumberOfCoins(), is(5));
        assertThat(actual, is(expected));
    }

    @Test
    public void testEarnIncomePhase3() {
        Market market = new Market("phase3");
        Player player1 = new Player(1, true, "phase3");
        Player player2 = new Player(2, true, "phase3");
        List<Player> players = new ArrayList<> ();
        players.add(player1);
        players.add(player2);
        Game game = new Game("phase3", market, players);
        Player currentPlayer = game.getPlayer(0);
        currentPlayer.addEstablishment(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 0, 1));
        Deck deck = new Deck("phase3");
        String actual = game.earnIncome(player1, 2, deck);
        String expected = "Ranch activated for Player 1.\nBakery activated for Player 1.\n";
        assertThat(player1.getNumberOfCoins(), is(5));
        assertThat(actual, is(expected));
    }

    @Test
    public void testEarnIncomePhase4() {
        Market market = new Market("phase4");
        Player player1 = new Player(1, true, "phase4");
        Player player2 = new Player(2, true, "phase4");
        Player player3 = new Player(3, true, "phase4");
        Establishment cafe = new Establishment(Card.Color.RED, Card.Icon.CUP, 2, "Cafe", "[3]", 0, 1);
        player1.addEstablishment(cafe);
        player2.addEstablishment(cafe);
        List<Player> players = new ArrayList<> ();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        Game game = new Game("phase4", market, players);
        Deck deck = new Deck("phase4");
        String actual = game.earnIncome(player3, 3, deck);
        String expected = "Cafe activated for Player 2.\nCafe activated for Player 1.\nBakery activated for Player 3.\n";
        assertThat(player1.getNumberOfCoins(), is(4));
        assertThat(player2.getNumberOfCoins(), is(4));
        assertThat(player3.getNumberOfCoins(), is(2));
        assertThat(actual, is(expected));
    }

    @Test
    public void testEarnIncomePhase5() {
        Market market = new Market("phase5");
        Player player1 = new Player(0, true, "phase5");
        Player player2 = new Player(2, true, "phase5");
        Player currentPlayer = new Player(1, true, "phase5");
        Establishment stadium = new Establishment(Card.Color.PURPLE, Card.Icon.TOWER, 6, "Stadium", "[6]", 0, 1);
        player1.addEstablishment(stadium);
        player2.addEstablishment(stadium);
        //need to add rest to check if correct number of coins is present when this is added for each players...


    }

    @Test
    public void testBuild() {
        Market market = new Market("phase1");
        Player player1 = new Player(1, true, "phase1");
        Player player2 = new Player(2, true, "phase1");
        List<Player> players = new ArrayList<> ();
        players.add(player1);
        players.add(player2);
        Game game = new Game("phase1", market, players);
        String actual = game.build(player1, 1);
        String expected = "Player 1 purchased the Wheat Field.\nTurn ended for Player 1.\n";
        assertThat(actual, is(expected));
        assertThat(player1.getNumberOfCoins(), is(2));
    }

    @Test
    public void testBuild2() {
        Market market = new Market("phase1");
        Player player1 = new Player(1, true, "phase1");
        Player player2 = new Player(2, true, "phase1");
        List<Player> players = new ArrayList<> ();
        players.add(player1);
        players.add(player2);
        Game game = new Game("phase1", market, players);
        String actual = game.build(player1, 3);
        String expected = "Player 1 purchased the Forest.\nTurn ended for Player 1.\n";
        assertThat(actual, is(expected));
        assertThat(player1.getNumberOfCoins(), is(0));
    }

    @Test
    public void testBuild99() {
        Market market = new Market("phase1");
        Player player1 = new Player(1, true, "phase1");
        Player player2 = new Player(2, true, "phase1");
        List<Player> players = new ArrayList<> ();
        players.add(player1);
        players.add(player2);
        Game game = new Game("phase1", market, players);
        String actual = game.build(player1, 99);
        String expected = "Player 1 chose not to make improvements.\nTurn ended for Player 1.\n";
        assertThat(actual, is(expected));
        assertThat(player1.getNumberOfCoins(), is(3));
    }

    @Test
    public void testBuildLandmark() {
        Market market = new Market("phase1");
        Player player1 = new Player(1, true, "phase1");
        Player player2 = new Player(2, true, "phase1");
        List<Player> players = new ArrayList<> ();
        players.add(player1);
        players.add(player2);
        player1.addCoins(7);
        Game game = new Game("phase1", market, players);
        String actual = game.build(player1, 4);
        String expected = "Player 1 constructed the City Hall.\nTurn ended for Player 1.\n";
        assertThat(actual, is(expected));
        assertThat(player1.getNumberOfCoins(), is(3));
    }

    @Test
    public void testBuildn() {
        Market market = new Market("phase1");
        Player player1 = new Player(1, true, "phase1");
        Player player2 = new Player(2, true, "phase1");
        List<Player> players = new ArrayList<> ();
        players.add(player1);
        players.add(player2);
        Game game = new Game("phase1", market, players);
        String actual = game.build(player1, 100);
        String actual2 = game.build(player1, -1);
        String expected = "Turn ended for Player 1.\n";
        assertThat(actual, is(expected));
        assertThat(actual2, is(expected));
    }

    @Test
    public void testEarnIncomePurple1() {
        Market market = new Market("phase5");
        Player player1 = new Player(1, true, "phase5");
        Player player3 = new Player(3, true, "phase5");
        player3.addEstablishment(new Establishment(Card.Color.PURPLE, Card.Icon.TOWER, 6, "TV Station", "[6]", 0, 1));
        List<Player> players = new ArrayList<> ();
        players.add(player1);
        players.add(player3);
        Game game = new Game("phase5", market, players);
        String actual = game.earnIncomePurple(player3, player1, player3.getEstablishment("TV Station"));
        String expected = "TV Station activated for Player 3.";
        assertThat(actual, is(expected));

    }

    @Test
    public void testEarnIncomePurple2() {
        Market market = new Market("phase5");
        Player player1 = new Player(1, true, "phase5");
        Player player3 = new Player(3, true, "phase5");
        player3.addEstablishment(new Establishment(Card.Color.PURPLE, Card.Icon.TOWER, 6, "Stadium", "[6]", 0, 1));
        List<Player> players = new ArrayList<> ();
        players.add(player1);
        players.add(player3);
        Game game = new Game("phase5", market, players);
        String actual = game.earnIncomePurple(player3, player3.getEstablishment("Stadium"));
        String expected = "Stadium activated for Player 3.";
        assertThat(actual, is(expected));

    }

    @Test
    public void testEarnIncomePurple3() {
        Market market = new Market("phase5");
        Player player1 = new Player(1, true, "phase5");
        Player player3 = new Player(3, true, "phase5");
        player1.addEstablishment(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 0, 1));
        player3.addEstablishment(new Establishment(Card.Color.PURPLE, Card.Icon.TOWER, 6, "Buisness Center", "[6]", 0, 1));
        List<Player> players = new ArrayList<> ();
        players.add(player1);
        players.add(player3);
        Game game = new Game("phase5", market, players);
        String actual = game.earnIncomePurple(player3, player1, "Bakery", "Ranch", player3.getEstablishment("Buisness Center"));
        String expected = "Buisness Center activated for Player 3.";
        assertThat(actual, is(expected));

    }

    @Test
    public void testPlayerTargetTV() {
        Market market = new Market("phase5");
        Player player1 = new Player(1, true, "phase5");
        Player player2 = new Player(2, true, "phase5");
        Player player3 = new Player(3, true, "phase5");
        player1.subtractCoins(3);
        List<Player> players = new ArrayList<> ();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        Game game = new Game("phase5", market, players);
        List<Player> targetTV = game.playerTargetsTV(player3);
        assertThat(targetTV.size(), is(1));
        assertThat(targetTV.get(0).getPlayerNumber(), is(2));

    }

    @Test
    public void testPlayerTargetBuisness() {
        Market market = new Market("phase5");
        Player player1 = new Player(1, true, "phase5");
        Player player2 = new Player(2, true, "phase5");
        Player player3 = new Player(3, true, "phase5");
        player1.addEstablishment(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 0, 1));
        player3.addEstablishment(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 0, 1));
        List<Player> players = new ArrayList<> ();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        Game game = new Game("phase5", market, players);
        List<Player> targetBuisness = game.playerTargetsBuisness(player3);
        assertThat(targetBuisness.size(), is(1));
        assertThat(targetBuisness.get(0).getPlayerNumber(), is(1));

    }

    @Test
    public void testPlayerTargetBuisness2() {
        Market market = new Market("phase5");
        Player player1 = new Player(1, true, "phase5");
        Player player2 = new Player(2, true, "phase5");
        Player player3 = new Player(3, true, "phase5");
        player1.addEstablishment(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 0, 1));
        player2.addEstablishment(new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 1));
        player3.addEstablishment(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 0, 1));
        List<Player> players = new ArrayList<> ();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        Game game = new Game("phase5", market, players);
        List<Player> targetBuisness = game.playerTargetsBuisness(player3);
        assertThat(targetBuisness.size(), is(2));

    }

    @Test
    public void testPlayerTargetBuisness3() {
        Market market = new Market("phase5");
        Player player1 = new Player(1, true, "phase5");
        Player player2 = new Player(2, true, "phase5");
        Player player3 = new Player(3, true, "phase5");
        player1.addEstablishment(new Establishment(Card.Color.PURPLE, Card.Icon.TOWER, 6, "Buisness Center", "[6]", 0, 1));
        player2.addEstablishment(new Establishment(Card.Color.GREEN, Card.Icon.BREAD, 1, "Bakery", "[2-3]", 1, 1));
        player3.addEstablishment(new Establishment(Card.Color.BLUE, Card.Icon.COW, 1, "Ranch", "[2]", 0, 1));
        List<Player> players = new ArrayList<> ();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        Game game = new Game("phase5", market, players);
        List<Player> targetBuisness = game.playerTargetsBuisness(player3);
        assertThat(targetBuisness.size(), is(1));

    }

    @Test
    public void testGetDoubles() {
        Market market = new Market("phase5");
        Player player1 = new Player(1, true, "phase5");
        Player player2 = new Player(2, true, "phase5");
        Player player3 = new Player(3, true, "phase5");
        List<Player> players = new ArrayList<> ();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        Game game = new Game("phase5", market, players);
        assertThat(game.getDoubles(), is(false));

    }

    @Test
    public void testRollDice2() {
        Market market = new Market("phase1");
        Player player = new Player(1, true, "phase1");
        List<Player> players = new ArrayList<> ();
        players.add(player);
        Game game = new Game("phase1", market, players);
        String actual = game.rollDice(5, 1);
        String expected = "";
        assertThat(actual, is(expected));

    }

    @Test
    public void testRollDice3() {
        Market market = new Market("phase4");
        Player player = new Player(1, true, "phase4");
        List<Player> players = new ArrayList<> ();
        players.add(player);
        Game game = new Game("phase4", market, players);
        String retruned = game.rollDice(2, 1);
        int roll1 = Character.getNumericValue(retruned.charAt(17));
        int roll2 = Character.getNumericValue(retruned.charAt(20));
        int sum = 0;
        if (Character.isDigit(retruned.charAt(26))) {
            sum = Character.getNumericValue(retruned.charAt(25)) * 10 + Character.getNumericValue(retruned.charAt(26));
        } else {
            sum = Character.getNumericValue(retruned.charAt(25));
        }
        assertThat(roll1+ roll2, is(sum));
        Boolean doubles = false;
        if(roll1 == roll2) {
            doubles = true;
        }
        if(roll1 != roll2){
            doubles = false;
        }
        assertThat(doubles, is(game.getDoubles()));
    }
}