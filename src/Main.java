import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Accounts accounts = new Accounts();
        Games games = new Games();
        Tournaments tourneys = new Tournaments();
        FileHandling file = new FileHandling();
        file.readMembers();
        file.readGames();
        file.readTourneys();
        GUI gui = new GUI();
    }
}
