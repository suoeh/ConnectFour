public class HomeScreen {
    // variables
    int studentNumber;
    boolean admin;

    // constructor
    public HomeScreen(int studentNumber) {
        this.studentNumber = studentNumber;
        this.admin = studentNumber == 0;
    }

    public void homeScreen() {
        if (admin) {
            // add extra functionality
        }
    }

}
