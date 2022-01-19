package edu.wofford.machiwoco;

import java.util.List;
import java.util.ArrayList;

/**
 * This class represents the Landmarks.  All landmarks start as not constructed
 * until a player decides to construct them.
 */

public class Landmark extends Card {
    private boolean constructed;

    /**
    * Constructor for Landmark. Establishes that each landmark starts as unconstructed.
    */

    public Landmark() {
        super();
        constructed = false;
    }

    /**
    * Sets the Landmark to match the parameters given.
    * 
    * @param color represents the color of the landmark
    * @param icon represents the icon of the landmark
    * @param cost represents the cost of the landmark
    * @param name represents the name of the landmark
    */

    public Landmark(Color color, Icon icon, int cost, String name) {
        super(color, icon, cost, name);
        constructed = false;
    }

    /**
    * Sets the value of constructed true or false depending on what was passed in. 
    * 
    * @param constructed a boolean representing if a landmark has been constructed or not
    */

    public void setConstructed(boolean constructed) {
        this.constructed = constructed;
    }

    /**
    * Returns a boolean representing if a landmark has been constructed or not.
    * 
    * @return boolean representing if a landmark has been constructed or not
    */

    public boolean getConstructed() {
        return constructed;
    }

    /**
    * Returns a list of the landmarks.
    * 
    * @return a list of all landmarks
    */

    public static List<Landmark> getLandmarkList() {
        List<Landmark> landmarkList = new ArrayList<> ();
        landmarkList.add(new Landmark(Card.Color.NONE, Card.Icon.TOWER, 4, "Train Station"));
        landmarkList.add(new Landmark(Card.Color.NONE, Card.Icon.TOWER, 7, "City Hall"));
        landmarkList.add(new Landmark(Card.Color.NONE, Card.Icon.TOWER, 10, "Shopping Mall"));
        landmarkList.add(new Landmark(Card.Color.NONE, Card.Icon.TOWER, 16, "Amusement Park"));
        landmarkList.add(new Landmark(Card.Color.NONE, Card.Icon.TOWER, 22, "Radio Tower"));
        return landmarkList;
    }
}