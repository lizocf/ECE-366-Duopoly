package game;

class Property extends Space {
    int rent;
    int price;

    boolean purchased;
    
    @Override
    void isOccupied(boolean occupied) {
        if (occupied & !purchased)
        {
            //ask user if they want to purschase
        }

        if(occupied & purchased)
        {
            //take money from the user.
        }

    }
}
