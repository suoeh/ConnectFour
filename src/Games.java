import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// big class to store game objects
public class Games {
    // object that stores all games, initialized game repository
    public static ArrayList<Game> repository;
    // total amoutn of game objects
    static int gameCounter = 0;

    // constructor !
    public Games() {
        repository = new ArrayList<>();
    }

    // uploading game function
    public static void uploadGame(Game game) throws IOException {
        // initiates writer to create newline
        repository.add(game);
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/Games.csv", true));
        writer.newLine();
        writer.write(game.toString());
        writer.flush();
        writer.close();

        // uploads player stats
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

        // initializes formatted strings from account data to update into csv
        String tempStringOne = Accounts.accountRepository.get(game.playerOne).toString();
        String tempStringTwo = Accounts.accountRepository.get(game.playerTwo).toString();

        try {
            //updates account changes to file
            FileHandling file = new FileHandling();
            file.updateMembers(String.valueOf(game.playerOne), tempStringOne);
            file.updateMembers(String.valueOf(game.playerTwo), tempStringTwo);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

}
