package game;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;

public class Board {
    // insert stuff here



    // 59 spaces
    public Space[] gameBoard;
    public Map<Integer,String> lookup;

    public Board()
    {
        // Intiliaze the probability and its weights!
        // Hardcoded for now but maybe we eventualy put these in a yaml file
        // the format is .add(probability percentage, "card name")
        // call specialPB.next() to draw a card. This gets passed in to the SkullCard.onUSe function AHHHH THIS MIGHT WORK
        WeightedProbModel<Object> skullPB = new WeightedProbModel<>()
                .add(40, "Card 1")
                .add(35, "Card 2")
                .add(25, "Card 3")
                .add(25, "Card 4");

        WeightedProbModel<Object> specialPB = new WeightedProbModel<>()
                .add(40, "Card 1")
                .add(35, "Card 2")
                .add(25, "Card 3")
                .add(25, "Card 4");

        gameBoard = new Space[60];
        lookup = new HashMap<Integer,String>();


        // Better way to intialize this board using a loop but for now we will hardcode it. 

        // Intialize SPecial Spaces
        gameBoard[0] = new Special("Start");
        gameBoard[10] = new Special("Debt");
        gameBoard[20] = new Special("Vacation");
        gameBoard[30] = new Special("Reverse");
        gameBoard[40] = new Special("Eviction");
        gameBoard[50] = new Special("Jail");

        gameBoard[1] = new Property(100,100,100,100,"New York City", "New York"); //need to input property name
        gameBoard[2] = new SpecialCard(); // might need a speicial Card NAme. Also We should have the hashmaps be here not in the classes themselves. Then we pass in the map. IDK
        gameBoard[3] = new Property(100,100,100,100,"Poughkeepskie", "New York");

        gameBoard[4] = new Property(100,100,100,100,"Miami", "Florida");
        gameBoard[5] = new Property(100,100,100,100,"Tampa", "Florida");
        gameBoard[6] = new Property(100,100,100,100,"Orlando", "Florida");
        
        gameBoard[7] = new Property(100,100,100,100,"Boston", "Massachusetts");
        gameBoard[8] = new SkullCard();
        gameBoard[9] = new Property(100,100,100,100,"Cambridge", "Massachusetts");
        gameBoard[11] = new Property(100,100,100,100,"Salem", "Massachusetts"); //need to input property name

<<<<<<< HEAD
        gameBoard[11] = new Property(100,100,100,100,"Salem", "New York"); //need to input property name
        gameBoard[12] = new Property(100,100,100,100,"Detroit", "New York"); // might need a speicial Card NAme. Also We should have the hashmaps be here not in the classes themselves. Then we pass in the map. IDK
        gameBoard[13] = new Property(100,100,100,100,"Flint", "Michigan");
        gameBoard[14] = new Property(100,100,100,100,"Rochester", "New York");
        gameBoard[15] = new Property(100,100,100,100,"Cleveland", "New York");
=======
        gameBoard[12] = new Property(100,100,100,100,"Detroit", "Michigan"); // might need a speicial Card NAme. Also We should have the hashmaps be here not in the classes themselves. Then we pass in the map. IDK
        gameBoard[13] = new Property(100,100,100,100,"Flint", "Michigan");
        gameBoard[14] = new Property(100,100,100,100,"Rochester", "Michigan");
        
        gameBoard[15] = new Property(100,100,100,100,"Cleveland", "Ohio");
>>>>>>> a41b3315cd5e4173af1ed9d92bee9fafe319364a
        gameBoard[16] = new SpecialCard();
        gameBoard[17] = new Property(100,100,100,100,"Cincinnati", "Ohio");
        gameBoard[18] = new SkullCard();
        gameBoard[19] = new Property(100,100,100,100,"Beavercreek", "Ohio");

        gameBoard[21] = new Property(100,100,100,100,"Stowe", "Vermont"); //need to input property name
        gameBoard[22] = new Property(100,100,100,100,"Burlington", "Vermont"); // might need a speicial Card NAme. Also We should have the hashmaps be here not in the classes themselves. Then we pass in the map. IDK
        
        gameBoard[23] = new Property(100,100,100,100,"Los Angeles", "California");
        gameBoard[24] = new Property(100,100,100,100,"San Francisco", "California");

        gameBoard[25] = new Property(100,100,100,100,"Las Vegas", "Nevada");
        gameBoard[26] = new SpecialCard();
        gameBoard[27] = new Property(100,100,100,100,"Henderson", "Nevada");
        gameBoard[28] = new SkullCard();
        gameBoard[29] = new Property(100,100,100,100,"Boulder City", "Nevada");

        gameBoard[31] = new Property(100,100,100,100,"San Antonio", "Texas");
        gameBoard[32] = new SpecialCard(); // might need
        gameBoard[33] = new Property(100,100,100,100,"Dallas", "Texas");
        gameBoard[34] = new Property(100,100,100,100,"Houston", "Texas");

        gameBoard[35] = new Property(100,100,100,100,"Portland", "Oregon");
        gameBoard[36] = new Property(100,100,100,100,"Eugene", "Oregon");
        gameBoard[37] = new Property(100,100,100,100,"Oregon City", "Oregon");

        gameBoard[38] = new Property(100,100,100,100,"Seattle", "Washington");
        gameBoard[39] = new Property(100,100,100,100,"Olympia", "Washington");
        gameBoard[41] = new Property(100,100,100,100,"Vancouver", "Washington");

        gameBoard[42] = new Property(100,100,100,100,"Albuquerque", "New Mexico");
        gameBoard[43] = new Property(100,100,100,100,"Santa Fe", "New Mexico");
        gameBoard[44] = new SkullCard();

        gameBoard[45] = new Property(100,100,100,100,"Electric Company", "New York");
        gameBoard[46] = new Property(100,100,100,100,"Water Company", "New York");

        gameBoard[47] = new Property(100,100,100,100,"JFK", "Airports");
        gameBoard[48] = new Property(100,100,100,100,"DTW", "Airports");
        gameBoard[49] = new Property(100,100,100,100,"CLE", "Airports");
        gameBoard[51] = new Property(100,100,100,100,"LAX", "Airports"); //need to input property name
        gameBoard[52] = new SpecialCard();
<<<<<<< HEAD
        gameBoard[53] = new Property(100,100,100,100,"DFW", "New York");
        gameBoard[54] = new Property(100,100,100,100,"DCA", "Airport");
=======
        gameBoard[53] = new Property(100,100,100,100,"DFW", "Airports");
        gameBoard[54] = new Property(100,100,100,100,"DCA", "Airports");
>>>>>>> a41b3315cd5e4173af1ed9d92bee9fafe319364a
        gameBoard[55] = new Property(100,100,100,100,"Tax", "New York");
        
        gameBoard[56] = new Property(100,100,100,100,"New York City", "New York");
        gameBoard[57] = new Property(100,100,100,100,"New York City", "New York");
        gameBoard[58] = new SkullCard();
        gameBoard[59] = new Property(100,100,100,100,"New York City", "New York");


//        lookup.put(1,"New York City");
//        lookup.put(9,"Seattle");
    }

    private int doublesCounter = 0;
    // should be reset at the end of every player's turn

    private int rollDice()
    {
        int die1 = (int) (6*Math.random()+1);
        int die2 = (int) (6*Math.random()+1);

        if(die1 == die2) {doublesCounter++;}

        return die1 + die2;
    }
    private boolean passedSpace(int prevSpaceNum, int currSpaceNum, int specialSpaceNum)
    {
        return abs(currSpaceNum - prevSpaceNum) > specialSpaceNum;
    }
}

// playing a game. Hard Code No game loop. Instatiate Player classes
