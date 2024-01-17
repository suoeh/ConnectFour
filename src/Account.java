public class Account {
    // account data
    public String name;
    public int studentNumber;
    private String password;

    // game data

    public int wins;
    public int losses;
    public int ties;
    public int rating;

    // constructor !
    public Account(String name, int studentNumber, String password) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.password = password;
        this.wins = 0;
        this.losses = 0;
        this.ties = 0;
        this.rating = 1000;
    }

    public Account(String name, int studentNumber, String password, int wins, int losses, int ties, int rating) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.password = password;
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
        this.rating = rating;
    }

    // getter
    public String getPassword() {return password;}

    @Override
    public String toString() {
        return name + "," + studentNumber + "," + password + "," + wins + "," + losses + "," + ties + "," + rating;
    }

    // setters
    public void changeName(String newName) {name = newName;}
    public void changePassword(String newPassword) {password = newPassword;}
    public void addWin() {
        wins += 1;
        changeRating(10 - 5 * ((rating / 100) - 18));
    }
    public void addLoss() {
        losses += 1;
        changeRating(-(10 - 5 * ((-rating / 100) + 2)));
    }
    public void addTie() {ties += 1;}
    public void changeRating(int change) {
        rating += change;
        rating = Math.min(rating, 2000);
        rating = Math.max(rating, 0);
    }

}
