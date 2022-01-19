package edu.wofford.machiwoco;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;



public class TestDice {
    
    @Test
    public void testDiceConstructor() {
        Dice dice = new Dice();
        assertThat(dice.getValue(), is(0));
    }

    @Test
    public void testRollDice() {
        Dice dice = new Dice();
        assert(dice.roll() > 0 && dice.roll() <= 6);
    }
}