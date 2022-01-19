package edu.wofford.machiwoco;

    /** 
    * This is a class that creates the cards that will join the deck. 
    */

public class Card {

    public enum Color {BLUE, GREEN, RED, PURPLE, NONE};
    public enum Icon {WHEAT, BREAD, COW, GEAR, FACTORY, FRUIT, CUP, TOWER, NONE};
    private Color color;
    private Icon icon;
    private int cost;
    private String name;
        
    /** 
    * This is the contructor for the Card class. It sets color to NONE, icon to NONE,
    * cost to 0, name to an empty string and available to 0.
    */

    public Card() {
        color = Color.NONE;
        icon = Icon.NONE;
        cost = 0;
        name = "";
    }

    /** 
    * This brings in the information from the contructor and assigns it appropriately. 
    * 
    * @param color the color of the card
    * @param icon the icon on the card
    * @param cost an integer representing the cost of the card
    * @param name a string representing the name of the card
    */

    public Card(Color color, Icon icon, int cost, String name) {
        this.color = color;
        this.icon = icon;
        this.cost = cost;
        this.name = name;
    }

    /** 
    * This is a method that gets the color of the card. It is of type Card.Color.
    * 
    * @return a value from the Color enum
    */

    public Color getColor() {
        return color;
    }

    /** 
    * This is a method that gets the icon for the card. It is of type Card.Icon.
    * 
    * @return a value from the Icon enum
    */

    public Icon getIcon() {
        return icon;
    }

    /** 
    * This is a method that gets the cost of a card. It is of type Integer.
    * 
    * @return an integer representing the appropriate cost of a card
    */

    public Integer getCost() {
        return cost;
    }

    /** 
    * This is a method that gets the name of a card. It is of type String. 
    * 
    * @return a string that represents the appropriate name of a card
    */

    public String getName() {
        return name;
    }

    /** 
    * This is a Method that gets the string representation of the color of a card.
    * it is of type String.
    *
    * @return a string that represents the appropriate string for a color of a card
    */

    public String getStringColor() {
        Color color = getColor();
        if (color == Color.BLUE) {
            return "B";
        } else if (color == Color.GREEN) {
            return "G";
        } else if (color == Color.RED) {
            return "R";
        } else if (color == Color.PURPLE) {
            return "P";
        } else {
            return "N";
        }
    }

    /** 
    * This is a Method that gets the string representation of the icon of a card.
    * it is of type String.
    *
    * @return a string that represents the appropriate string for a icon of a card
    */

    public String getStringIcon() {
        Icon icon = getIcon();
        if (icon == Icon.WHEAT) {
            return "W";
        } else if (icon == Icon.BREAD) {
            return "B";
        } else if (icon == Icon.COW) {
            return "C";
        } else if (icon == Icon.GEAR) {
            return "G";
        } else if (icon == Icon.FACTORY) {
            return "F";
        } else if (icon == Icon.FRUIT) {
            return "O";
        } else if (icon == Icon.CUP) {
            return "U";
        } else {
            return "T";
        }
    }
}