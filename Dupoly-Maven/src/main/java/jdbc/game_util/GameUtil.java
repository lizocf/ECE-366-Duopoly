package jdbc.game_util;

import jdbc.jdbc_util.DataTransferObject;

public class GameUtil implements DataTransferObject
{
    private int gameId;

    private String gameCode;
    private int playerTurn;
    private int debtPot;
    private int numOfPlayers;
    private boolean joinable;

    public int getId() {
        return gameId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameCode() {
        return gameCode;
    }

    public void setGameCode(String gameCode) {
        this.gameCode = gameCode;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }

    public int getDebtPot() {
        return debtPot;
    }

    public void setDebtPot(int debtPot) {
        this.debtPot = debtPot;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    public boolean isJoinable() {
        return joinable;
    }

    public void setJoinable(boolean joinable) {
        this.joinable = joinable;
    }

    @Override
    public String toString() {
        return "GameUtil{" +
                "gameId=" + gameId +
                ", gameCode='" + gameCode + '\'' +
                ", playerTurn=" + playerTurn +
                ", debtPot=" + debtPot +
                ", numOfPlayers=" + numOfPlayers +
                '}';
    }
}
