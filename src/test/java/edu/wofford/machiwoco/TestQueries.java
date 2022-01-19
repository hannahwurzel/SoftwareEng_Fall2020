package edu.wofford.machiwoco;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;


public class TestQueries {
    @Test
    public void testMarketPurchase() {
        String expected = "Player 1, would you like to purchase an\nestablishment or construct a landmark? (3\ncoins) ";
        Player player = new Player(1, false, "phase1");
        assertThat(Queries.marketPurchase(player), is(expected));
    }

    @Test
    public void testPurchase() {
        String expected = "Choose a number to purchase or construct: ";
        Player player = new Player(1, false, "phase1");
        assertThat(Queries.purchase(), is(expected));
    }

    @Test
    public void testTrainStation() {
        String expected = "Player 1, would you like to roll 1 or 2 dice?";
        Player player = new Player(1, false, "phase1");
        assertThat(Queries.trainStation(player), is(expected));
    }

    @Test
    public void testRadioTower() {
        String expected = "Player 1, would you like to reroll the dice? (y/n):";
        Player player = new Player(1, false, "phase1");
        assertThat(Queries.radioTower(player), is(expected));
    }

    @Test
    public void testTargetPlayer() {
        String expected = "Player 1, who would you like to target?\n";
        Player player = new Player(1, false, "phase1");
        assertThat(Queries.targetPlayer(player), is(expected));
    }

    @Test
    public void testBuisnessComplex() {
        String expected = "Player 1, select an establishment:\n";
        Player player = new Player(1, false, "phase1");
        assertThat(Queries.businessComplex(player), is(expected));
    }

}