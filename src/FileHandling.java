import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileHandling {
    // constructor !
    public FileHandling() throws IOException {}

    // reads members csv list and stores as arraylist
    // csv in format name, student-number, password, wins, losses, ties, rating
    public void readMembers() throws IOException {
        // reader and temp variables to store ongoing data
        BufferedReader accountReader = new BufferedReader(new FileReader("src/Accounts.csv"));
        String line;
        String[] values;

        // data parsing, reads through entire csv file
        while ((line = accountReader.readLine()) != null) {
            values = line.split(",");
            String name = values[0];
            int studentNumber = Integer.parseInt(values[1]);
            String password = values[2];
            int wins = Integer.parseInt(values[3]);
            int losses = Integer.parseInt(values[4]);
            int ties = Integer.parseInt(values[5]);
            int rating = Integer.parseInt(values[6]);

            // creates new account object using data, uploads
            Account account = new Account(name, studentNumber, password, wins, losses, ties, rating);
            // System.out.println(account.name);
            // System.out.println(account.studentNumber);
            // stores account data into repository
            Accounts.accountRepository.put(studentNumber, account);
        }
        accountReader.close();
    }

    // store games function, same basis as readMembers()
    // csv in format playerOne, playerTwo. outcome, tourneyID
    public void readGames() throws IOException {
        // variables
        BufferedReader gameReader = new BufferedReader(new FileReader("src/Games.csv"));
        String line;
        String[] values;

        // reads and saves whole csv file lien by line
        while ((line = gameReader.readLine()) != null) {
            values = line.split(",");
            int playerOne = Integer.parseInt(values[0]);
            int playerTwo = Integer.parseInt(values[1]);
            int outcome = Integer.parseInt(values[2]);
            int tourneyID = Integer.parseInt(values[3]);

            // creates and uploads object
            Game game = new Game(playerOne, playerTwo, outcome, tourneyID);
            // System.out.println(game);
            Games.repository.add(game);
        }
        gameReader.close();
    }


    // same as previous functions, but for tournaments
    // csv in format roster, games, both of which are space seperated integers
    public void readTourneys() throws IOException {
        BufferedReader gameReader = new BufferedReader(new FileReader("src/Tournaments.csv"));
        String line;
        String[] values;

        while ((line = gameReader.readLine()) != null) {
            // stores spaced integers of players and game ids as arrays to upload
            values = line.split(",");
            String[] roster = values[0].split(" ");
            String[] games = values[1].split(" ");

            int[] rosterID = new int[roster.length];
            int counter = 0;
            int tempID;
            for (String s : roster) {
                tempID = Integer.parseInt(s);
                rosterID[counter++] = tempID;
            }

            int[] gamesID = new int[games.length];
            counter = 0;
            for (String s : games) {
                tempID = Integer.parseInt(s);
                gamesID[counter++] = tempID;
            }

            // created/uploaded tournament object
            Tournament tourney = new Tournament(rosterID, roster.length, gamesID);
            // System.out.println(game);
            Tournaments.repository.add(tourney);
        }

        gameReader.close();
    }

    // uploads newly finished tournament with relevant members and game ids
    public void updateTourneys(Tournament tournament) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/Tournaments.csv", true));
        writer.newLine();
        writer.write(tournament.toString());
        writer.flush();
        writer.close();
    }

    // function used for rewriting user data, saves current csv as arraylist
    public void updateMembers(String number, String replace) throws IOException {
        BufferedReader accountReader = new BufferedReader(new FileReader("src/Accounts.csv"));
        String line;
        List<String> lines = new ArrayList<>();

        // brute forces entire csv until student number is found, since student numbers are unique
        while ((line = accountReader.readLine()) != null) {
            if (Objects.equals(line.split(",")[1], number)) {
                // replaces line with new line
                line = replace;
            }
            lines.add(line);
        }

        accountReader.close();
        BufferedWriter accountWriter = new BufferedWriter(new FileWriter("src/Accounts.csv"));

        // rewrites entire csv from arraylist, flushes to update in real time
        for (int i = 0; i < lines.size(); i++) {
            accountWriter.write(lines.get(i));
            if (i < lines.size() - 1) {
                accountWriter.write("\n"); // makes sure csv doesn't end with a new line for read/writing
            }
        }

        accountWriter.flush();
        accountWriter.close();
    }


}
