import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // initializes objects to edit/store csv data as objects
        Accounts accounts = new Accounts();
        Games games = new Games();
        Tournaments tourneys = new Tournaments();
        FileHandling file = new FileHandling();
        // load data
        file.readMembers();
        file.readGames();
        file.readTourneys();
        // loads gui
        GUI gui = new GUI();
    }
}
