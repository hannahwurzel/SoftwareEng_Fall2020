package edu.wofford.machiwoco;

import java.lang.Math;
import java.util.Random;

/** 
 * This is the Dice class. It represents a dice that can be rolled.
 */

public class Dice {

    /** 
     * This is the constructor for the dice class. It sets the value, of type integer, to 0. 
     * The value represents the result of a dice roll.
     */

    private int value;
    
    public Dice() {
        value = 0;
    }
    /** 
     * This is a method that gets the value of a dice roll. It is of type integer.
     * 
     * @return // and integer value (1-6) representing the result of a dice roll
     */

    public int getValue() {
        return value;
    }
    
    /** 
     * This is a method that rolls a die. It is of type integer. It uses the 
     * function Random() to generate a random number. We also ensure that this
     * number will be 1-6.
     * 
     * @return an integer value, 1-6
     */

    public int roll() {
        Random roll =  new Random();
        value = roll.nextInt(6) + 1;
        return value;
    }
}

