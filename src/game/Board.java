package game;

import static java.lang.Math.abs;

public class Board {
    // insert stuff here



    private boolean passedSpace(int prevSpaceNum, int currSpaceNum, int specialSpaceNum)
    {
        return abs(currSpaceNum - prevSpaceNum) > specialSpaceNum;
    }

}
