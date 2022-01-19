package edu.wofford.machiwoco;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;

public class TestPrintGameState {

    @Test
    public void testPrintPlayerState() {
        Player player = new Player(1, false, "phase1");
        String actual = PrintGameState.getStringPlayerState(player);
        String expected = "------------------------------------------\n" +
                          "                (3 coins)                 \n" +
                          "Wheat Field        BW (1)  [1]      #1\n" +
                          "..........................................\n" +
                          "City Hall          NT (7)  [ ]\n";
        assertThat(actual, is(expected));
    }

    @Test
    public void testLandmarkConstructed() {
        Player player = new Player(1, false, "phase1");
        player.getLandmarks().get(0).setConstructed(true);
        String actual = PrintGameState.getStringPlayerState(player);
        String expected = "------------------------------------------\n" +
                          "                (3 coins)                 \n" +
                          "Wheat Field        BW (1)  [1]      #1\n" +
                          "..........................................\n" +
                          "City Hall          NT (7)  [X]\n";
        assertThat(actual, is(expected));
    }
    
    @Test
    public void testGetStringCurrentGameState() {
        Deck deck = new Deck("phase1");
        Market market = new Market("phase1");
        String actual = PrintGameState.getStringCurrentGameState(market);
        String expected = "******************************************\n" +
                          "                  MARKET                  \n" +
                          "------------------------------------------\n" +
                          "Wheat Field        BW (1)  [1]      #6\n" +
                          "Ranch              BC (1)  [2]      #6\n" +
                          "Forest             BG (3)  [5]      #6\n";
        assertThat(actual, is(expected));
        assertThat("Forest             BG (3)  [5]      #6".length(), is(38));
    }
    
    
    @Test
    public void whenAvailableIsTrue() {
        Deck deck = new Deck("phase1");
        Market market = new Market("phase1");
        String actual = PrintGameState.getStringCurrentGameState(market);
        String expected = "******************************************\n" +
                          "                  MARKET                  \n" +
                          "------------------------------------------\n" +
                          "Wheat Field        BW (1)  [1]      #6\n" +
                          "Ranch              BC (1)  [2]      #6\n" +
                          "Forest             BG (3)  [5]      #6\n";
        assertThat(actual, is(expected));
    }
    
    
    @Test
    public void whenCoinTotal3() {
        Player player = new Player(1, false, "phase1");
        Market market = new Market("phase1");
        String actual = PrintGameState.printMarketMenu(player, market);
        String expected = "(To view details of an item, type 'view'  \n" +
                                  "followed by the item number. For example, \n" +
                                  "to view item 6, type 'view 6'.)           \n" +
                                  "==========================================\n" +
                                  "---------        PURCHASE        ---------\n" +
                                  " 1. Wheat Field        BW (1)  [1]      #6\n" +
                                  " 2. Ranch              BC (1)  [2]      #6\n" +
                                  " 3. Forest             BG (3)  [5]      #6\n" +
                                  "---------         CANCEL         ---------\n" +
                                  "99. Do nothing                            \n" +
                                  "==========================================\n" +
                                  "Choose a number to purchase or construct:";
        assertThat(actual, is(expected));
    }

    @Test
    public void whenCoinTotal7() {
        Player player = new Player(1, false, "phase1");
        player.addCoins(4);
        Deck deck = new Deck("phase1");
        Market market = new Market("phase1");
        String actual = PrintGameState.printMarketMenu(player, market);
        String expected = "(To view details of an item, type 'view'  \n" +
                            "followed by the item number. For example, \n" +
                            "to view item 6, type 'view 6'.)           \n" +
                            "==========================================\n" +
                            "---------        PURCHASE        ---------\n" +
                            " 1. Wheat Field        BW (1)  [1]      #6\n" +
                            " 2. Ranch              BC (1)  [2]      #6\n" +
                            " 3. Forest             BG (3)  [5]      #6\n" +
                            "---------       CONSTRUCT        ---------\n" +
                            " 4. City Hall          NT (7)  [ ]\n" +
                            "---------         CANCEL         ---------\n" +
                            "99. Do nothing                            \n" +
                            "==========================================\n" +
                            "Choose a number to purchase or construct:";
        assertThat(actual, is(expected));
    }

    @Test
    public void whenCoinTotal7Constructed() {
        Player player = new Player(1, false, "phase1");
        player.addCoins(11);
        player.construct("City Hall");
        Deck deck = new Deck("phase1");
        Market market = new Market("phase1");
        String actual = PrintGameState.printMarketMenu(player, market);
        String expected = "(To view details of an item, type 'view'  \n" +
                            "followed by the item number. For example, \n" +
                            "to view item 6, type 'view 6'.)           \n" +
                            "==========================================\n" +
                            "---------        PURCHASE        ---------\n" +
                            " 1. Wheat Field        BW (1)  [1]      #6\n" +
                            " 2. Ranch              BC (1)  [2]      #6\n" +
                            " 3. Forest             BG (3)  [5]      #6\n" +
                            "---------         CANCEL         ---------\n" +
                            "99. Do nothing                            \n" +
                            "==========================================\n" +
                            "Choose a number to purchase or construct:";
        assertThat(actual, is(expected));
    }

    @Test
    public void whenCoinTotal1() {
        Player player = new Player(1, false, "phase1");
        player.subtractCoins(2);
        Deck deck = new Deck("phase1");
        Market market = new Market("phase1");
        String actual = PrintGameState.printMarketMenu(player, market);
        String expected = "(To view details of an item, type 'view'  \n" +
                                  "followed by the item number. For example, \n" +
                                  "to view item 6, type 'view 6'.)           \n" +
                                  "==========================================\n" +
                                  "---------        PURCHASE        ---------\n" +
                                  " 1. Wheat Field        BW (1)  [1]      #6\n" +
                                  " 2. Ranch              BC (1)  [2]      #6\n" +
                                  "---------         CANCEL         ---------\n" +
                                  "99. Do nothing                            \n" +
                                  "==========================================\n" +
                                  "Choose a number to purchase or construct:";
        assertThat(actual, is(expected));
    }

    @Test
    public void testPlayerOptions() {
        Player player1 = new Player(0, false, "phase5");
        Player player2 = new Player(1, false, "phase5");
        Player player3 = new Player(2, false, "phase5");
        List<Player> options = new ArrayList<> ();
        options.add(player1);
        options.add(player2);
        options.add(player3);
        String actual = PrintGameState.printChoosePlayerMenu(options);
        String expected = "-------     AVAILABLE PLAYERS      -------\n" +
                          "1. Player 1             (3 coins)\n" +
                          "2. Player 2             (3 coins)\n" +
                          "3. Player 3             (3 coins)\n";
        assertThat(actual, is(expected));
    }

    @Test
    public void testGetStringLandmark() {
        List<Landmark> landmarks = new ArrayList<> ();
        landmarks = Landmark.getLandmarkList();
        String actual = PrintGameState.getStringLandmark(landmarks);
        String expected = ".-----------------------.\n" + 
                          "| <N>   LANDMARK    {T} |\n" +
                          "|     Train Station     |\n" +
                          "|                       |\n" +
                          "|  You may roll 1 or 2  |\n" +
                          "|         dice.         |\n" +
                          "|                       |\n" +
                          "| (4)               [ ] |\n" +
                          "|_______________________|\n" +
                          ".-----------------------.\n" + 
                          "| <N>   LANDMARK    {T} |\n" +
                          "|       City Hall       |\n" +
                          "|                       |\n" +
                          "|                       |\n" +
                          "|                       |\n" +
                          "|                       |\n" +
                          "| (7)               [ ] |\n" +
                          "|_______________________|\n" +
                          ".-----------------------.\n" +
                          "| <N>   LANDMARK    {T} |\n" +
                          "|     Shopping Mall     |\n" +
                          "|                       |\n" +
                          "|   Your {U} and {B}    |\n" +
                          "|  establishments earn  |\n" +
                          "|     +1 coin when      |\n" +
                          "|      activated.       |\n" +
                          "|                       |\n" +
                          "| (10)              [ ] |\n" +
                          "|_______________________|\n" +
                          ".-----------------------.\n" +
                          "| <N>   LANDMARK    {T} |\n" +
                          "|    Amusement Park     |\n" +
                          "|                       |\n" +
                          "| If you roll doubles,  |\n" +
                          "|   take another turn   |\n" +
                          "|    after this one.    |\n" +
                          "|                       |\n" +
                          "| (16)              [ ] |\n" +
                          "|_______________________|\n" +
                          ".-----------------------.\n" +
                          "| <N>   LANDMARK    {T} |\n" +
                          "|      Radio Tower      |\n" +
                          "|                       |\n" +
                          "|  Once per turn, you   |\n" +
                          "| may reroll the dice.  |\n" +
                          "|                       |\n" +
                          "| (22)              [ ] |\n" +
                          "|_______________________|\n";
        assertThat(actual, is(expected));
    }

    @Test
    public void testPrintChooseEStablishmentMenue() {
        Player player1 = new Player(0, false, "phase5");
        Player player2 = new Player(1, false, "phase5");
        Establishment cafe = new Establishment(Card.Color.RED, Card.Icon.CUP, 2, "Cafe", "[3]", 0, 1);
        Establishment wheatField = new Establishment(Card.Color.BLUE, Card.Icon.WHEAT, 1, "Wheat Field", "[1]", 1, 1);
        Establishment buisnessComplex = new Establishment(Card.Color.PURPLE, Card.Icon.TOWER, 8, "Business Complex", "[6]", 0, 1);
        player1.addEstablishment(cafe);
        player1.addEstablishment(wheatField);
        player1.addEstablishment(buisnessComplex);
        player2.addEstablishment(buisnessComplex);
        player2.addEstablishment(cafe);
        String acutal2 = PrintGameState.printChooseEstablishmentMenu(player2);
        String expected2 = "-------  AVAILABLE ESTABLISHMENTS  -------\n" +
                           "                 Player 2                 \n" +
                           "1. Cafe               RU (2)  [3]         \n";
        String actual1 = PrintGameState.printChooseEstablishmentMenu(player1);
        String expected1 = "-------  AVAILABLE ESTABLISHMENTS  -------\n" +
                           "                 Player 1                 \n" +
                           "1. Wheat Field        BW (1)  [1]         \n" +
                           "2. Cafe               RU (2)  [3]         \n";
        assertThat(actual1, is(expected1));
        assertThat(acutal2, is(expected2)); 
    }

} 