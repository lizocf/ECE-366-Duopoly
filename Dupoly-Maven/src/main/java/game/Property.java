package game;

import java.sql.Connection;
import java.util.Scanner;
import jdbc.property_util.*;
import jdbc.player_util.*;


class Property implements Space {
    public int baseCost,buildCost,baseRent,buildRent;
    public boolean purchased;

    public String propertyName, setName;
    // OwnedPropertyDAO propertyDAO;




    public Property(int costPrice, int buildingCostPrice, int rentPrice, int hotelRentPrice,String propname,String setname)
    {
        baseCost = costPrice;
        buildCost = buildingCostPrice;
        baseRent = rentPrice;
        buildRent = hotelRentPrice;
        propertyName = propname;
        setName = setname;
        // everything should get the same collection so its all in the database
        // OwnedPropertyDAO propertyDAO = new OwnedPropertyDAO(connection);
    }

//    public void setPropertyDAO(Connection connection) {
//
//        propertyDAO = new OwnedPropertyDAO(connection);
//    }

    // need to pass in the gameId.
    // How are we passing in propery and set names. Do we change the function?
    // connection needs to be passed.


    @Override
    public void isOccupied(boolean occupied, int userId, int gameId, Connection connection)
    {
        OwnedPropertyDAO propertyDAO = new OwnedPropertyDAO(connection);
        if (occupied & !purchased)
        {
            //ask user if they want to purchase
            Scanner scanner = new Scanner(System.in);
            System.out.print("Would you like to purchase[Yes/No]:  Yes");
            // String s = scanner.nextLine();

            if (true)
            {

                // update database (user has purchased a valid property)
                System.out.print("Property Purchased");
                OwnedPropertyUtil property = new OwnedPropertyUtil();
                // set the other stuff
                property.setPropertyName(propertyName);
                property.setNumOfHotels(0);
                property.setSetName(setName);
                property.setUserId(userId);
                property.setGameId(gameId);
                property = propertyDAO.createInstance(property);

            }
        }


        if (occupied & purchased)
        {
            // update database (user has lost money)
            System.out.print("You have payed rent");
            // we need to get a player by the id finder
            // call the update for that player

            // PlayerDAO playerDAO = new PlayerDAO(connection);
            // PlayerUtil player = playerDAO.findById();
            // these need to be actual values
            // playerDAO.updateCash(player,baseCost,1); // we need to return a player I guess.

            // how do I link the util to the other things?

            // we pass this into a player update cash function? whcih leads us to

        }

    }
}

//Logic to determine if they have set?
//Determine if houses are built or not and how many(how many is in the database)

// For each property I want to make a new DAO?