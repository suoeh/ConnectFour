import java.io.*;

public class FileHandling {
    public FileHandling() throws IOException {}

    public void readMembers() throws IOException {
        BufferedReader accountReader = new BufferedReader(new FileReader("Accounts.csv"));
        String line;
        String[] values;

        while ((line = accountReader.readLine()) != null) {
            values = line.split(",");
            String name = values[0];
            int studentNumber = Integer.parseInt(values[1]);
            String password = values[2];
            int wins = Integer.parseInt(values[3]);
            int losses = Integer.parseInt(values[4]);
            int rating = Integer.parseInt(values[5]);

            Account account = new Account(name, studentNumber, password);
            Accounts.accountRepository.put(studentNumber, account);
        }

        accountReader.close();
    }
    public void readGames() throws IOException {
        BufferedReader gameReader = new BufferedReader(new FileReader("Games.csv"));
        String line;
        String[] values;

        while ((line = gameReader.readLine()) != null) {
            values = line.split(",");
            int playerOne = Integer.parseInt(values[0]);
            int playerTwo = Integer.parseInt(values[1]);
            int outcome = Integer.parseInt(values[2]);
            int[] field = new int[7];
            for (int i = 3; i <= 9; i++) {
                field[i - 3] = Integer.parseInt(values[i]);
            }
            String moves = values[10];
            int tourneyID = Integer.parseInt(values[11]);

            Game game = new Game(playerOne, playerTwo, outcome, field, moves, tourneyID);
            Games.repository.add(game);
            Games.gameCounter++;
        }
    }


}
