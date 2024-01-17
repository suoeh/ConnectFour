import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FileHandling {
    public FileHandling() throws IOException {}

    public void readMembers() throws IOException {
        BufferedReader accountReader = new BufferedReader(new FileReader("src/Accounts.csv"));
        String line;
        String[] values;

        while ((line = accountReader.readLine()) != null) {
            values = line.split(",");
            String name = values[0];
            int studentNumber = Integer.parseInt(values[1]);
            String password = values[2];
            int wins = Integer.parseInt(values[3]);
            int losses = Integer.parseInt(values[4]);
            int ties = Integer.parseInt(values[5]);
            int rating = Integer.parseInt(values[6]);

            Account account = new Account(name, studentNumber, password, wins, losses, ties, rating);
            // System.out.println(account.name);
            // System.out.println(account.studentNumber);
            Accounts.accountRepository.put(studentNumber, account);
        }

        accountReader.close();
    }
    public void readGames() throws IOException {
        BufferedReader gameReader = new BufferedReader(new FileReader("src/Games.csv"));
        String line;
        String[] values;

        while ((line = gameReader.readLine()) != null) {
            values = line.split(",");
            int playerOne = Integer.parseInt(values[0]);
            int playerTwo = Integer.parseInt(values[1]);
            int outcome = Integer.parseInt(values[2]);
            String moves = values[3];
            int tourneyID = Integer.parseInt(values[4]);

            Game game = new Game(playerOne, playerTwo, outcome, moves, tourneyID);
            // System.out.println(game);
            Games.repository.add(game);
        }
    }

    public void updateMembers(String number, String replace) throws IOException {
        BufferedReader accountReader2 = new BufferedReader(new FileReader("src/Accounts.csv"));
        BufferedWriter accountWriter2 = new BufferedWriter(new FileWriter("src/Accounts.csv"));
        String line;
        List<String> lines = new ArrayList<>();

        while ((line = accountReader2.readLine()) != null) {
            if (Objects.equals(line.split(",")[1], number)) {
                line = replace;
            }
            lines.add(line);
        }

        for (String modifiedLine : lines) {
            System.out.println(modifiedLine);
            accountWriter2.write(modifiedLine);
            accountWriter2.newLine();
        }

        accountReader2.close();
        accountWriter2.close();
    }


}
