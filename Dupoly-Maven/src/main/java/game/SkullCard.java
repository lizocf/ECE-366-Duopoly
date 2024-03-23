package game;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


@SpringBootApplication
@RestController
@CrossOrigin
public class SkullCard implements Card,Space {

    WeightedProbModel<Object> skullPB = new WeightedProbModel<>()
            .add(100, "Bankrupt")
            .add(0, "Market Crash")
            .add(0, "Based")
            .add(0, "f off")
            .add(0, "Squatters Rights")
            .add(0, "Jailed")
            .add(0, "No Go")
            .add(0, "Divorced")
            .add(0, "Swap")
            .add(0, "West Coast Best Coast")
            .add(0, "West Coast Worst Coast")
            .add(0, "Dust Bowl")
            .add(0, "Triple Skull emoji")
            .add(0, "We're So Back")
            .add(0, "Self Sabotage")
            .add(0, "What Do You Bring To The Table")
            .add(0, "Rent Stabilized")
            .add(0, "Eviction")
            .add(0, "Winner Winner Chicken Dinner");

    // public String cardName;
    Map<String, OnCard> cardMap = new HashMap<>();

    public SkullCard()
    {
        cardMap.put("Bankrupt", new OnCard()
        {

            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database
                System.out.println("Skull Card 1 happens");

            }
        });

        cardMap.put("Market Crash", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database
                System.out.print("Skull Card 2 happens");

            }
        });

        cardMap.put("Based", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database
                System.out.print("Skull Card 3 happens");

            }
        });

        cardMap.put("f off", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database
                System.out.print("Skull Card 4 happens");

            }
        });

        cardMap.put("Squatters Rights", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database
                System.out.print("Skull Card 4 happens");

            }
        });

        cardMap.put("Jailed", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database
                System.out.print("Skull Card 4 happens");

            }
        });


        cardMap.put("No Go", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database
                System.out.print("Skull Card 4 happens");

            }
        });

        cardMap.put("Divorced", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database
                System.out.print("Skull Card 1 happens");

            }
        });

        cardMap.put("Swap", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database
                System.out.print("Skull Card 2 happens");

            }
        });

        cardMap.put("West Coast Best Coast", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database
                System.out.print("Skull Card 3 happens");

            }
        });

        cardMap.put("West Coast Worst Coast", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database
                System.out.print("Skull Card 4 happens");

            }
        });

        cardMap.put("Dust Bowl", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database
                System.out.print("Skull Card 4 happens");

            }
        });

        cardMap.put("Triple Skull Emoji", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database
                System.out.print("Skull Card 4 happens");

            }
        });


        cardMap.put("We're So Back", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database
                System.out.print("Skull Card 4 happens");

            }
        });

        cardMap.put("Self Sabotage", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database
                System.out.print("Skull Card 4 happens");

            }
        });

        cardMap.put("What Do You Bring To The Table", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database
                System.out.print("Skull Card 4 happens");

            }
        });

        cardMap.put("Rent Stabilized", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database
                System.out.print("Skull Card 4 happens");

            }
        });


        cardMap.put("Eviction", new OnCard()
        {
            @Override
            public void cardAction()
            {
                // define what needs to happen in the sequel database
                System.out.print("Skull Card 4 happens");

            }
        });

        cardMap.put("Winner Winner Chicken Dinner", new OnCard()
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
    public void onUse()
    {
        String cardName = (String) skullPB.next();
        cardMap.get(cardName).cardAction();
    }

    @Override
    public void isOccupied(boolean occupied, int userId, int gameId, Connection connection)
    {
        onUse();
    }
}
