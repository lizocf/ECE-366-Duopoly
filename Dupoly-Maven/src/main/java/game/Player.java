package game;

public class Player extends Account { // Should this interface extend Account..?
    public int game_id, cash, currSpace;
    public boolean afk, current_direction;

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash)
    {
        this.cash = cash;
    }

    public int getCurrSpace() {
        return currSpace;
    }

    public void setCurrSpace(int currSpace) {
        this.currSpace = currSpace;
    }

    public boolean isAfk() {
        return afk;
    }

    public void setAfk(boolean afk) {
        this.afk = afk;
    }

    public boolean isCurrent_direction() {
        return current_direction;
    }

    public void setCurrent_direction(boolean current_direction) {
        this.current_direction = current_direction;
    }




    //    public Player(int user_id, int num_wins, int num_losses, int elo_rating, int duo_points, String[] user_name, String[] password) {
//        super(user_id, num_wins, num_losses, elo_rating, duo_points, user_name, password);
//    }

    // setters and getters
}