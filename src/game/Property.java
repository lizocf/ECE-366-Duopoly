package game;

import java.util.Scanner;

class Property implements Space {
    public int baseCost,buildCost,baseRent,buildRent;
    public boolean purchased;

    public Property(int costPrice, int buildingCostPrice, int rentPrice, int hotelRentPrice)
    {
        baseCost = costPrice;
        buildCost = buildingCostPrice;
        baseRent = rentPrice;
        buildRent = hotelRentPrice;
    }

    @Override
    public void isOccupied(boolean occupied, String user)
    {
        if (occupied & !purchased)
        {
            //ask user if they want to purchase
            Scanner scanner = new Scanner(System.in);
            System.out.print("Would you like to purchase[Yes/No]: ");
            String s = scanner.nextLine();

            if (s.equals("Yes"))
            {
                // update database (user has purchased a valid property)
            }
        }

        if (occupied & purchased)
        {
            // update database (user has lost money)
        }
    }
}

//Logic to determine if they have set?
//Determine if houses are built or not and how many

