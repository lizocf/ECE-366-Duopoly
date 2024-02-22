package game;

import static java.lang.Math.abs;

public class Board {
    // insert stuff here

    // 59 spaces
    private Space[] gameBoard;

    public Board()
    {
        gameBoard = new Space[59];
        // populate the gameboard

        for (int i = 0; i < 60; i++)
        {

            //how do I populate this :skull:

            if(i%10 == 0 )
            {
                // the special name should maybe be set somewhere else. We can use a setter or something?
                gameBoard[i] = new Special();
            }
            else if (i%8 == 0)
            {
                gameBoard[i] = // CARD CLASS
            }
            else
            {
                // the values should be set somewhere else
                gameBoard[i] = new Property(500,500,500,500);
            }

            // i mod 10 == 0 --> special

            // i mod 8 == 0 ---> card

            // else --> property




        }





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
