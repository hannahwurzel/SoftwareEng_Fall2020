# MACHI KORO
    This program allows the user to play Machi Koro. Machi koro is a game composed of a deck of cards, a pair of dice and a set of coins. 

    The cards come in two different varieties, establishments and landmarks. Establishments are cards the user may choose to activate as a result of a die/dice roll. 
    Landmarks, once they are constructed, provide the player with benefits each round and once all active landmarks are contructed the player wins the game.

    The roll of the die/dice is a determining factor in the amount of coins a player could recieve. 

    Each player will begin with specific starting cards, this will vary depending on which phase the player chooses to play. In the typical version of the game the player will begin with the Wheat Field and Bakery establishments, along with the four landmark cards, Train Station (4 coins), Shopping Mall (10 coins), Amusement Park (16 coins), and the Radio Tower (22 coins). 


## DECK
    The deck is comprised of the following (this will vary among game phases):
    Wheat Field (6 + 4 starting)
    Ranch (6)
    Bakery (6 + 4 starting)
    Cafe (6)
    Convenience Store (6)
    Forest (6)
    Stadium (4)
    TV Station (4)
    Business Center (4)
    Cheese Factory (6)
    Furniture Factory (6)
    Mine (6)
    Family Restaurant (6)
    Apple Orchard (6)
    Farmers Market (6)
    Train Station (4)
    Shopping Mall (4)
    Amusement Park (4)
    Radio Tower (4)

## CURRENT GAME STATE
    The current game state is printed for each player during their turn. It is labled at the top "MARKET". It includes the name of the establishments they possess, two characters representing the color and icon, the cost (in parentheses), the activation range (in square brackets) and the number available of each card. The market entries are sorted by activation value (low to high).
    After the establishments are listed, the landmarks are listed. The list includes the name of the landmark, two characters representing the color and icon, the cost in parentheses, and whether is has been constructed or not (reprented by either the presence of an "X" in square brackets or not).

## MARKET MENU
    The Market Menu provides a numbered list of the market establishments and landmark options. The establishments and landmarks in this menu mimic the structure of those in the current game state. The list is numbered, therefore, to purchase or one of the items from the market menu simply enter the number of the item desired. The establishments are sorted by activation value and come before the landmarks. There is also an option for the user to choose "99. do nothing". The establishments and landmarks in this menu are only ones that the user can afford at that time. The user also has an ability to view the full card of an item in this list (ex. to view item 1, enter "view 1").

## USER COMMAND
    To start game play, the user should enter the command:
    "java -jar build/libs/machiwoco.jar" followed by the argument specifying which phase they wish to play (ex. "phase0"). For phase 1 an additional argument is accepted, "--ai", this will determine whether the opponet is another human or an AI player. 


## PHASE 0
    In Phase 0, the user will not be able to play an actual version of the game, but instead will be able to view a printed version of the establishment cards (in order of activation) and the landmark cards. The cards are labled accordingly: The value in the angled brackets is the abbreviation for the color of the card, the value in the curly brackets is the abbreviation for the icon on the card, the value in the parentheses is the cost of the card, the value/range in the square brackets is the activation range of the card (only if it is an establishment), otherwise, the card will be a landmark with square brackets (bottom-right), these brackets will either be empty (unconstructed) or filled with an X (constructed). Each card will also have a prompt for the user in the center. 

## PHASE 1
    This phase of the game requires two human players, or if specified 1 human and 1 AI player. Each player begins the game with three coins, a Wheat Field card, and an unconstructed City Hall card . The goal of the game is to construct the City Hall, acting as the only landmark.  To do so you need seven coins. 
    The game begins with Player One rolling a die.  That player receives the amount of coins that was rolled.  Then, they have to opportunity to either purchase an Establishment (Wheat Field (costs 1 coin), Ranch (costs 1 coin), or Forest (costs 3 coins)) or construct City Hall (costs 7 coins). There are 6 cards available of each of these cards for the players to construct. If one purchases an Establishment they also receive a coin from the bank.  Once this player does so, it is then Player Two's turn.  This process continues until one player purchases City Hall and wins the game. 

## PHASE 2
    This phase is similar to the previous, however, the player now can purchase the Bakery, Convenience Store and the Apple Orchard establishments. Players will start with 1 Wheat Field and 1 Bakery. The Train Station landmark will also need to be contructed along with the City Hall for a player to win the game. The player can choose to play the game with either 1 or 2 AI players. This can be specified in the command argument. 

## PHASE 3
    This phase is similar to phase 2, however, the Cheese Factory, Furniture Factory and the Farmers market are added to the deck. The Shopping Mall is also added to the list of landmarks that need to be constructed in order to win the game.

## PHASE 4
    Phase 4 is again similar to the previous phase. The Cafe and Family restuarant are added to the deck as establisments. The City Hall is removed from the deck and replace with the Amusement Park which will act as the third landmark needed to be constructed in order to win the game. 

## PHASE 5
    Phase 5 adds all major purple establishments to the deck. This includes the Stadium, TV Station and the Business Center. The Radio Tower landmark is also added and will need to be contructed in addition to the 3 other active landmarks in order for a player to win the game. 





