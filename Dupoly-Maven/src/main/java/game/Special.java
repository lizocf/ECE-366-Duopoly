package game;


import java.util.Scanner;
class Special implements Space
{
    public String spaceName;
    public Special(String name) { spaceName = name; }

    private void startSpace()
    {
            // put 300 dollars in the users account for landing directly on jail
            System.out.println("You've received 300 dollars for passing START");
    }
    private  void debtSpace()
    {
        //pull from the revoir in the database
        // change that to zero

        System.out.println("BANGPOTT!!! You received all the debt money");
    }

    private void vactionSpace()
    {
        System.out.println("Welcome to paradise");
        // literally does nothing
    }

    private void reverseSpace()
    {
        System.out.println("Turn Around");
        // modify direction in the player database
    }
    private  void evictionSpace()
    {
        System.out.println("Sorry Bud you loosing a random house");
        // modify number of hotels. Decrement it by 1.
    }

    private void jailSpace()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Would you like to pay bail[Yes/No]: ");
        String s = scanner.nextLine();

        if (s.equals("Yes"))
        {
            // take 50 dollars from the user
        }
    }

    @Override
    public void isOccupied(boolean occupied, String user)
    {
        //Switch case that executes member functions
        switch (spaceName)
        {

            case "Start":
                startSpace();
                break;

            case "Debt":
                debtSpace();
                break;

            case "Vacation":
                vactionSpace();
                break;

            case "Reverse":
                reverseSpace();
                break;

            case "Eviction":
                evictionSpace();
                break;

            case "Jail":
                jailSpace();
                break;
        }
    }
}




