package edu.wofford.machiwoco;

import java.util.List;
import java.util.NoSuchElementException;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Queries {

    public static int answer() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        return a;
    }

    public static String marketPurchase(Player currentPlayer) {
        String c = Integer.toString(currentPlayer.getPlayerNumber());
        String question = "Player " + c + ", would you like to purchase an\n" +
                          "establishment or construct a landmark? (" + Integer.toString(currentPlayer.getNumberOfCoins()) +
                          "\ncoins) ";
        return question;
    }

    public static String purchase() {
        String question = "Choose a number to purchase or construct: ";
        return question;
    }

    public static String trainStation(Player currentPlayer) {
        String c = Integer.toString(currentPlayer.getPlayerNumber());
        String question = "Player " + c + ", would you like to roll 1 or 2 dice?";
        return question;
    }

    public static String radioTower(Player currentPlayer) {
        String c = Integer.toString(currentPlayer.getPlayerNumber());
        String question = "Player " + c + ", would you like to reroll the dice? (y/n):";
        return question;
    }

    public static String targetPlayer(Player currentPlayer) {
        String c = Integer.toString(currentPlayer.getPlayerNumber());
        String question = "Player " + c + ", who would you like to target?\n";
        return question;
    }

    public static String businessComplex(Player currentPlayer) {
        String c = Integer.toString(currentPlayer.getPlayerNumber());
        String question = "Player " + c + ", select an establishment:\n";
        return question;
    }
}