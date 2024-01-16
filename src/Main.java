import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Accounts accounts = new Accounts();
        Games game = new Games();
        FileHandling file = new FileHandling();
        file.readMembers();
        file.readGames();
        GUI gui = new GUI();
    }
}
