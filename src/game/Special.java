package game;

class Special extends Space
{
    public String spaceName;
    public Special(String name) { spaceName = name; }

    private void startSpace()
    {

    }
    private  void debtSpace()
    {

    }

    private void vactionSpace()
    {

    }

    private void reverseSpace()
    {

    }
    private  void evictionSpace()
    {

    }

    private void jailSpace()
    {

    }

    @Override
    void isOccupied(boolean occupied, String user)
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




