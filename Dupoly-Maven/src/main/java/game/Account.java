package game;


// For player we might have to call the util functions intself or something


// ISSUE: YOU ARE TRYING TO USE AN INTERFACE AS A CLASS. THIS IS NOT
// HOW AN ABSTRACT CLASS IS IMPLEMENTED.
public class Account{
    public int user_id, num_wins, num_losses, elo_rating, duo_points;
    public String user_name;
    private
    String password;
//    public Account(int user_id, int num_wins, int num_losses, int elo_rating, int duo_points, String[] user_name, String[] password) {
//        this.user_id = user_id;
//        this.num_wins = num_wins;
//        this.num_losses = num_losses;
//        this.elo_rating = elo_rating;
//        this.duo_points = duo_points;
//        this.user_name = user_name;
//        this.password = password;
//    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getNum_wins() {
        return num_wins;
    }

    public void setNum_wins(int num_wins) {
        this.num_wins = num_wins;
    }

    public int getNum_losses() {
        return num_losses;
    }

    public void setNum_losses(int num_losses) {
        this.num_losses = num_losses;
    }

    public int getElo_rating() {
        return elo_rating;
    }

    public void setElo_rating(int elo_rating) {
        this.elo_rating = elo_rating;
    }

    public int getDuo_points() {
        return duo_points;
    }

    public void setDuo_points(int duo_points) {
        this.duo_points = duo_points;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}