package game;

import static java.lang.Math.abs;

public class Board {
    // insert stuff here

    // 59 spaces
    private Space[] gameBoard;

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

        gameBoard = new Space[59];


        // Better way to intialize this board using a loop but for now we will hardcode it. 

        // Intialize SPecial Spaces
        gameBoard[0] = new Special("Start");
        gameBoard[10] = new Special("Debt");
        gameBoard[20] = new Special("Vacation");
        gameBoard[30] = new Special("Reverse");
        gameBoard[40] = new Special("Eviction");
        gameBoard[50] = new Special("Jail");

        gameBoard[1] = new Property(100,100,100,100); //need to input property name
        gameBoard[2] = new SpecialCard(); // might need a speicial Card NAme. Also We should have the hashmaps be here not in the classes themselves. Then we pass in the map. IDK
        gameBoard[3] = new Property(100,100,100,100);
        gameBoard[4] = new Property(100,100,100,100);
        gameBoard[5] = new Property(100,100,100,100);
        gameBoard[6] = new Property(100,100,100,100);
        gameBoard[7] = new Property(100,100,100,100);
        gameBoard[8] = new SkullCard();
        gameBoard[9] = new Property(100,100,100,100);

        gameBoard[11] = new Property(100,100,100,100); //need to input property name
        gameBoard[12] = new Property(100,100,100,100); // might need a speicial Card NAme. Also We should have the hashmaps be here not in the classes themselves. Then we pass in the map. IDK
        gameBoard[13] = new Property(100,100,100,100);
        gameBoard[14] = new Property(100,100,100,100);
        gameBoard[15] = new Property(100,100,100,100);
        gameBoard[16] = new SpecialCard();
        gameBoard[17] = new Property(100,100,100,100);
        gameBoard[18] = new SkullCard();
        gameBoard[19] = new Property(100,100,100,100);

        gameBoard[21] = new Property(100,100,100,100); //need to input property name
        gameBoard[22] = new Property(100,100,100,100); // might need a speicial Card NAme. Also We should have the hashmaps be here not in the classes themselves. Then we pass in the map. IDK
        gameBoard[23] = new Property(100,100,100,100);
        gameBoard[24] = new Property(100,100,100,100);
        gameBoard[25] = new Property(100,100,100,100);
        gameBoard[26] = new SpecialCard();
        gameBoard[27] = new Property(100,100,100,100);
        gameBoard[28] = new SkullCard();
        gameBoard[29] = new Property(100,100,100,100);

        gameBoard[31] = new Property(100,100,100,100);
        gameBoard[32] = new SpecialCard(); // might need
        gameBoard[33] = new Property(100,100,100,100);
        gameBoard[34] = new Property(100,100,100,100);
        gameBoard[35] = new Property(100,100,100,100);
        gameBoard[36] = new Property(100,100,100,100);
        gameBoard[37] = new Property(100,100,100,100);
        gameBoard[38] = new Property(100,100,100,100);
        gameBoard[39] = new Property(100,100,100,100);

        gameBoard[41] = new Property(100,100,100,100);
        gameBoard[42] = new Property(100,100,100,100);
        gameBoard[43] = new Property(100,100,100,100);
        gameBoard[44] = new SkullCard();
        gameBoard[45] = new Property(100,100,100,100);
        gameBoard[46] = new Property(100,100,100,100);
        gameBoard[47] = new Property(100,100,100,100);
        gameBoard[48] = new Property(100,100,100,100);
        gameBoard[49] = new Property(100,100,100,100);

        gameBoard[51] = new Property(100,100,100,100); //need to input property name
        gameBoard[52] = new SpecialCard();
        gameBoard[53] = new Property(100,100,100,100);
        gameBoard[54] = new Property(100,100,100,100);
        gameBoard[55] = new Property(100,100,100,100);
        gameBoard[56] = new Property(100,100,100,100);
        gameBoard[57] = new Property(100,100,100,100);
        gameBoard[58] = new SkullCard();
        gameBoard[59] = new Property(100,100,100,100);
















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
