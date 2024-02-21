package game;

import static java.lang.Math.abs;

public class Board {
    // insert stuff here

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

    // 59 spaces
     private Space[] gameBoard = new Space[59];
}
