package game;

public interface Card{
    public boolean stay_in_hand;
    public string description;

    void onDraw(Player player);
    void onUse(Player player);
}