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

        gameBoard[1] = new Special("Start");
        gameBoard[2] = new Special("Debt");
        gameBoard[3] = new Special("Vacation");
        gameBoard[4] = new Special("Reverse");
        gameBoard[5] = new Special("Eviction");
        gameBoard[6] = new Special("Jail");
        gameBoard[7] = new Special("Start");
        gameBoard[8] = new Special("Debt");
        gameBoard[9] = new Special("Vacation");

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
