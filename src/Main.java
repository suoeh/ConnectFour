import java.io.File;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        FileHandling file = new FileHandling();
        file.readMembers();
        file.readGames();
    }
}
