package game;

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

            }
        });

        cardMap.put("CardName 2", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database

            }
        });

        cardMap.put("CardName 3", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database

            }
        });

        cardMap.put("CardName 4", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database

            }
        });




    }

    @Override
    public void onUse(String cardName) {
        cardMap.get(cardName).cardAction();
    }

    @Override
    public void isOccupied(boolean occupied, String user) {

    }
}
