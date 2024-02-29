package game;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;



public class SkullCard implements Card,Space {
    // public String cardName;
    Map<String, OnCard> cardMap = new HashMap<>();

    public SkullCard()
    {
        cardMap.put("CardName 1", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database
                System.out.print("Skull Card 1 happens");

            }
        });

        cardMap.put("CardName 2", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database
                System.out.print("Skull Card 2 happens");

            }
        });

        cardMap.put("CardName 3", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database
                System.out.print("Skull Card 3 happens");

            }
        });

        cardMap.put("CardName 4", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database
                System.out.print("Skull Card 4 happens");

            }
        });
    }

    @Override
    public void onUse(String cardName) {
        cardMap.get(cardName).cardAction();
    }

    @Override
    public void isOccupied(boolean occupied, String user, Connection connection) {
        // does nothing ig
    }
}
