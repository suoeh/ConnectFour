import java.io.*;
import java.util.ArrayList;
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
            int tourneyID = Integer.parseInt(values[3]);

            Game game = new Game(playerOne, playerTwo, outcome, tourneyID);
            // System.out.println(game);
            Games.repository.add(game);
        }
        gameReader.close();
    }

    public void readTourneys() throws IOException {
        BufferedReader gameReader = new BufferedReader(new FileReader("src/Tournaments.csv"));
        String line;
        String[] values;

        while ((line = gameReader.readLine()) != null) {
            values = line.split(",");
            String[] roster = values[0].split(" ");
            int winner = Integer.parseInt(values[1]);

            int[] rosterID = new int[roster.length];
            int counter = 0;
            int tempID;
            for (String s : roster) {
                tempID = Integer.parseInt(s);
                rosterID[counter++] = tempID;
            }

            Tournament tourney = new Tournament(rosterID, roster.length, winner);
            // System.out.println(game);
            Tournaments.repository.add(tourney);
        }

        gameReader.close();
    }
    public void updateMembers(String number, String replace) throws IOException {
        BufferedReader accountReader = new BufferedReader(new FileReader("src/Accounts.csv"));
        String line;
        List<String> lines = new ArrayList<>();

        while ((line = accountReader.readLine()) != null) {
            if (Objects.equals(line.split(",")[1], number)) {
                line = replace;
            }
            lines.add(line);
        }

        accountReader.close();
        BufferedWriter accountWriter = new BufferedWriter(new FileWriter("src/Accounts.csv"));

        for (String modifiedLine : lines) {
            accountWriter.write(modifiedLine);
            accountWriter.newLine();
        }

        accountWriter.flush();
        accountWriter.close();
    }


}
