import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Games {
    // variables
    public static ArrayList<Game> repository;

    public Games() {
        repository = new ArrayList<>();
    }
    static int gameCounter = 0;

    public static void uploadGame(Game game) throws IOException {
        repository.add(game);
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/Games.csv", true));
        writer.newLine();
        writer.write(game.toString());
        writer.flush();
        writer.close();

        // uploads stats
        if (game.outcome == 1) {
            Accounts.accountRepository.get(game.playerOne).addWin();
            Accounts.accountRepository.get(game.playerTwo).addLoss();
        } else if (game.outcome == 2) {
            Accounts.accountRepository.get(game.playerOne).addLoss();
            Accounts.accountRepository.get(game.playerTwo).addWin();
        } else {
            Accounts.accountRepository.get(game.playerOne).addTie();
            Accounts.accountRepository.get(game.playerTwo).addTie();
        }

        String tempStringOne = Accounts.accountRepository.get(game.playerOne).toString();
        String tempStringTwo = Accounts.accountRepository.get(game.playerTwo).toString();

        try {
            FileHandling file = new FileHandling();
            file.updateMembers(String.valueOf(game.playerOne), tempStringOne);
            file.updateMembers(String.valueOf(game.playerTwo), tempStringTwo);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

}
