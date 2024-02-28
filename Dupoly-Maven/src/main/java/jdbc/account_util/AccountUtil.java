package jdbc.account_util;

import jdbc.jdbc_util.DataTransferObject;

public class AccountUtil implements DataTransferObject
{
    @Override
    public int getId() {
        return userId;
    }

    public int userId, numWins, numLosses, duoPoints;
    public String eloRating, userName;
    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNumWins() {
        return numWins;
    }

    public void setNumWins(int numWins) {
        this.numWins = numWins;
    }

    public int getNumLosses() {
        return numLosses;
    }

    public void setNumLosses(int numLosses) {
        this.numLosses = numLosses;
    }

    public String getEloRating() {
        return eloRating;
    }

    public void setEloRating(String eloRating) {
        this.eloRating = eloRating;
    }

    public int getDuoPoints() {
        return duoPoints;
    }

    public void setDuoPoints(int duoPoints) {
        this.duoPoints = duoPoints;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}