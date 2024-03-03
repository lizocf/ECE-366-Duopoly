package jdbc.property_util;

import jdbc.jdbc_util.DataTransferObject;

public class OwnedPropertyUtil implements DataTransferObject
{
    @Override
    public int getId() {
        return userId;
    }

    private int gameId;
    private int userId;
    private String setName;
    private String propertyName;
    private int numOfHotels;

    public int debtPot;

    public int getDebtPot() {
        return debtPot;
    }

    public void setDebtPot(int debtPot) {
        this.debtPot = debtPot;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public int getNumOfHotels() {
        return numOfHotels;
    }

    public void setNumOfHotels(int numOfHotels) {
        this.numOfHotels = numOfHotels;
    }
}
