package game;

public interface Player extends Account { // Should this interface extend Account..?
    public int game_id, cash;
    public boolean afk, current_direction;

 // setters and getters
}