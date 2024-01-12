public class Account {
    // account data
    public String name;
    public int studentNumber;
    private String password;

    // game data

    public int wins;
    public int losses;
    public int rating;

    // constructor !
    public Account(String name, int studentNumber, String password) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.password = password;
        this.wins = 0;
        this.losses = 0;
        this.rating = 1000;
    }

    // getter
    public String getPassword() {return password;}

    // setters
    public void changeName(String newName) {name = newName;}
    public void changePassword(String newPassword) {password = newPassword;}
    public void changeRating(int change) {rating += change;}

}
