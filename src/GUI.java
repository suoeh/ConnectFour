import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;

public class GUI {
    int mode = -1;
    public GUI() {
        // main menu
        JFrame accountMenu = new JFrame("Connect 4!");
        JFrame signIn = new JFrame("Sign in");
        JFrame mainMenu = new JFrame("Welcome :D");

        accountMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton accountMenuSignInButton = new JButton("Sign in");
        JTextField signInText1 = new JTextField("Name", 20);
        JTextField signInText2 = new JTextField("Student number", 20);
        JTextField signInText3 = new JTextField("Password (characters only)", 20);
        JButton signInBackButton = new JButton("Back");
        JButton signInLogInButton = new JButton("Log in");
        JButton signInSignUpButton = new JButton("Sign up");
        JLabel signInErrorLabel = new JLabel("");

        accountMenuSignInButton.addActionListener(e -> {
            accountMenu.setVisible(false);
            signIn.setVisible(true);
            signInErrorLabel.setText("");
        });

        signInBackButton.addActionListener(e -> {
            signIn.setVisible(false);
            accountMenu.setVisible(true);
            signInErrorLabel.setText("");
            signInText1.setText("Name");
            signInText2.setText("Student number");
            signInText3.setText("Password (characters only)");
        });
        signInLogInButton.addActionListener(e -> {
            Menu menu = new Menu();
            if (menu.validateNumber(signInText2.getText()) || menu.validateString(signInText3.getText())) {
                signInErrorLabel.setText("Invalid password/student number");
            } else if (Accounts.accountRepository.get(Integer.parseInt(signInText2.getText())) == null) {
                signInErrorLabel.setText("Student ID doesn't exist");
            } else if (!Objects.equals(signInText3.getText(), Accounts.accountRepository.get(Integer.parseInt(signInText2.getText())).getPassword())) {
                signInErrorLabel.setText("Wrong password!");
            } else {
                mode = Integer.parseInt(signInText2.getText());
                signIn.setVisible(false);
                mainMenu.setTitle("Welcome " + Accounts.accountRepository.get(Integer.parseInt(signInText2.getText())).name);
                mainMenu.setVisible(true);
                signInErrorLabel.setText("");
                signInText1.setText("Name");
                signInText2.setText("Student number");
                signInText3.setText("Password (characters only)");
            }
        });
        signInSignUpButton.addActionListener(e -> {
            Menu menu = new Menu();
            if (menu.validateString(signInText1.getText()) || menu.validateNumber(signInText2.getText()) || menu.validateString(signInText3.getText())) {
                signInErrorLabel.setText("Invalid name/password/student number");
            } else if (Accounts.accountRepository.get(Integer.parseInt(signInText2.getText())) != null) {
                signInErrorLabel.setText("Student ID is already taken");
            } else {
                try {
                    menu.createAccount(signInText1.getText(),signInText2.getText(),signInText3.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                mode = Integer.parseInt(signInText2.getText());
                signIn.setVisible(false);
                mainMenu.setTitle("Welcome " + Accounts.accountRepository.get(Integer.parseInt(signInText2.getText())).name);
                mainMenu.setVisible(true);
                signInErrorLabel.setText("");
                signInText1.setText("Name");
                signInText2.setText("Student number");
                signInText3.setText("Password");
            }
        });

        JPanel accountMenuPanel = new JPanel();
        JPanel signInPanel = new JPanel();
        JPanel mainMenuPanel = new JPanel();

        accountMenuPanel.add(accountMenuSignInButton);
        signInPanel.add(signInText1);
        signInPanel.add(signInText2);
        signInPanel.add(signInText3);
        signInPanel.add(signInBackButton);
        signInPanel.add(signInLogInButton);
        signInPanel.add(signInSignUpButton);
        signInPanel.add(signInErrorLabel);

        accountMenu.add(accountMenuPanel);
        signIn.add(signInPanel);
        mainMenu.add(mainMenuPanel);

        accountMenu.setSize(800, 600);
        signIn.setSize(800, 600);
        mainMenu.setSize(800, 600);

        accountMenu.setLocationRelativeTo(null);
        signIn.setLocationRelativeTo(null);
        mainMenu.setLocationRelativeTo(null);


        JFrame howToPlay = new JFrame("How to play");
        howToPlay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        howToPlay.setSize(800, 600);
        howToPlay.setLocationRelativeTo(null);

        JFrame playAgainstOpponent = new JFrame("Play against opponent");
        playAgainstOpponent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        playAgainstOpponent.setSize(800, 600);
        playAgainstOpponent.setLocationRelativeTo(null);

        JFrame viewStats = new JFrame("View stats");
        viewStats.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewStats.setSize(800, 600);
        viewStats.setLocationRelativeTo(null);

        JFrame createTournament = new JFrame("Create tournament");
        createTournament.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createTournament.setSize(800, 600);
        createTournament.setLocationRelativeTo(null);

        JFrame editUserData = new JFrame("Edit user data");
        editUserData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editUserData.setSize(800, 600);
        editUserData.setLocationRelativeTo(null);

        JFrame changeOwnPassword = new JFrame("Change password");
        changeOwnPassword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        changeOwnPassword.setSize(800, 600);
        changeOwnPassword.setLocationRelativeTo(null);

        JFrame logOut = new JFrame("Log out");
        logOut.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logOut.setSize(800, 600);
        logOut.setLocationRelativeTo(null);

        JButton mainMenuHowToPlayButton = new JButton("How to Play");
        JButton mainMenuPlayAgainstOpponentButton = new JButton("Play Against Opponent");
        JButton mainMenuViewStatsButton = new JButton("View Stats");
        JButton mainMenuCreateTournamentButton = new JButton("Create Tournament");
        JButton mainMenuEditUserDataButton = new JButton("Edit User Data");
        JButton mainMenuChangeOwnPasswordButton = new JButton("Change Password");
        JButton mainMenuLogOutButton = new JButton("Log Out");

        mainMenuPanel.add(mainMenuHowToPlayButton);
        mainMenuPanel.add(mainMenuPlayAgainstOpponentButton);
        mainMenuPanel.add(mainMenuViewStatsButton);
        mainMenuPanel.add(mainMenuCreateTournamentButton);
        mainMenuPanel.add(mainMenuEditUserDataButton);
        mainMenuPanel.add(mainMenuChangeOwnPasswordButton);
        mainMenuPanel.add(mainMenuLogOutButton);

        // Adding buttons
        mainMenuHowToPlayButton.addActionListener(e -> {
            mainMenu.setVisible(false);
            howToPlay.setVisible(true);
        });

        mainMenuPlayAgainstOpponentButton.addActionListener(e -> {
            mainMenu.setVisible(false);
            playAgainstOpponent.setVisible(true);
        });

        mainMenuViewStatsButton.addActionListener(e -> {
            mainMenu.setVisible(false);
            viewStats.setVisible(true);
        });

        mainMenuCreateTournamentButton.addActionListener(e -> {
            if (mode == 0) {
                mainMenu.setVisible(false);
                createTournament.setVisible(true);
            }
        });

        mainMenuEditUserDataButton.addActionListener(e -> {
            if (mode == 0) {
                mainMenu.setVisible(false);
                editUserData.setVisible(true);
            }
        });

        mainMenuChangeOwnPasswordButton.addActionListener(e -> {
            mainMenu.setVisible(false);
            changeOwnPassword.setVisible(true);
        });

        mainMenuLogOutButton.addActionListener(e -> {
            mode = -1;
            mainMenu.setVisible(false);
            accountMenu.setVisible(true);
        });

        JPanel howToPlayPanel = new JPanel();
        JPanel playAgainstOpponentPanel = new JPanel();
        JPanel viewStatsPanel = new JPanel();
        JPanel createTournamentPanel = new JPanel();
        JPanel editUserDataPanel = new JPanel();
        JPanel changeOwnPasswordPanel = new JPanel();
        JPanel logOutPanel = new JPanel();

        howToPlay.add(howToPlayPanel);
        playAgainstOpponent.add(playAgainstOpponentPanel);
        viewStats.add(viewStatsPanel);
        createTournament.add(createTournamentPanel);
        editUserData.add(editUserDataPanel);
        changeOwnPassword.add(changeOwnPasswordPanel);
        logOut.add(logOutPanel);

        // Back button in how to play
        JButton howToPlayBackButton = new JButton("back");
        howToPlayBackButton.addActionListener(e -> {
            howToPlay.setVisible(false);
            mainMenu.setVisible(true);
        });
        howToPlayPanel.add(howToPlayBackButton);

        // Text for opponent ID
        JTextField playAgainstOpponentID = new JTextField("Opponent ID: ", 20);
        playAgainstOpponentPanel.add(playAgainstOpponentID);
        // Back button for play against opponent panel
        JButton playAgainstOpponentBackButton = new JButton("back");
        playAgainstOpponentBackButton.addActionListener(e -> {
            playAgainstOpponent.setVisible(false);
            mainMenu.setVisible(true);
        });
        playAgainstOpponentPanel.add(playAgainstOpponentBackButton);
        
        JButton playAgainstOpponentStartButton = new JButton("Start game");
        playAgainstOpponentStartButton.addActionListener(e -> {
            String input = playAgainstOpponentID.getText();
            try {
                int number = Integer.parseInt(input);
                if (Accounts.accountRepository.get(number) != null && number != mode) {
                    // Create an instance of connectFour and set it visible
                    // ConnectFour game = new ConnectFour(mode, number, -1);
                    ConnectFour game = new ConnectFour(mode, number, -1);
                    game.frame.setVisible(true);
                    // Hide the current mainMenu frame
                    playAgainstOpponent.setVisible(false);
                    mainMenu.setVisible(true);
                }
            } catch (NumberFormatException ignored) {}

        });
        playAgainstOpponentPanel.add(playAgainstOpponentStartButton);


        JFrame viewPlayers = new JFrame("View Players");
        viewPlayers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewPlayers.setSize(800, 600);
        viewPlayers.setLocationRelativeTo(null);

        JFrame viewGames = new JFrame("View Games");
        viewGames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewGames.setSize(800, 600);
        viewGames.setLocationRelativeTo(null);

        JFrame viewTourneys = new JFrame("View Tourneys");
        viewTourneys.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewTourneys.setSize(800, 600);
        viewTourneys.setLocationRelativeTo(null);

        JPanel viewPlayersPanel = new JPanel();
        JPanel viewGamesPanel = new JPanel();
        JPanel viewTourneysPanel = new JPanel();

        viewPlayers.add(viewPlayersPanel);
        viewGames.add(viewGamesPanel);
        viewTourneys.add(viewTourneysPanel);

        String[] playerColumns = {"Name", "Student ID", "Wins", "Losses", "Ties", "Rating"};
        Object[][] playerData = new Object[Accounts.accountRepository.size() + 50][6];

        // View players button
        JButton viewPlayersButton = new JButton("View players");
        viewPlayersButton.addActionListener(e -> {
            ArrayList<Account> tempList = new ArrayList<>(Accounts.accountRepository.values());
            tempList.sort(Comparator.comparing(o -> o.name));
            playerData[0][0] = tempList.get(Accounts.accountRepository.size() - 1).name;
            playerData[0][1] = tempList.get(Accounts.accountRepository.size() - 1).studentNumber;
            playerData[0][2] = tempList.get(Accounts.accountRepository.size() - 1).wins;
            playerData[0][3] = tempList.get(Accounts.accountRepository.size() - 1).losses;
            playerData[0][4] = tempList.get(Accounts.accountRepository.size() - 1).ties;
            playerData[0][5] = tempList.get(Accounts.accountRepository.size() - 1).rating;
            for (int i = Accounts.accountRepository.size() - 2; i >= 0; i--) {
                playerData[i + 1][0] = tempList.get(i).name;
                playerData[i + 1][1] = tempList.get(i).studentNumber;
                playerData[i + 1][2] = tempList.get(i).wins;
                playerData[i + 1][3] = tempList.get(i).losses;
                playerData[i + 1][4] = tempList.get(i).ties;
                playerData[i + 1][5] = tempList.get(i).rating;
            }

            viewStats.setVisible(false);
            viewPlayers.setVisible(true);
        });
        viewStatsPanel.add(viewPlayersButton);

        JTable playerTable = new JTable(playerData, playerColumns);
        JScrollPane playerScrollPane = new JScrollPane(playerTable);
        viewPlayersPanel.add(playerScrollPane);

        JButton sortByNameButton = new JButton("Sort Alphabetically");
        sortByNameButton.addActionListener(e -> {
            ArrayList<Account> tempList = new ArrayList<>(Accounts.accountRepository.values());
            tempList.sort(Comparator.comparing(o -> o.name));
            playerTable.getModel().setValueAt(tempList.get(Accounts.accountRepository.size() - 1).name, 0, 0);
            playerTable.getModel().setValueAt(tempList.get(Accounts.accountRepository.size() - 1).studentNumber, 0, 1);
            playerTable.getModel().setValueAt(tempList.get(Accounts.accountRepository.size() - 1).wins, 0, 2);
            playerTable.getModel().setValueAt(tempList.get(Accounts.accountRepository.size() - 1).losses, 0, 3);
            playerTable.getModel().setValueAt(tempList.get(Accounts.accountRepository.size() - 1).ties, 0, 4);
            playerTable.getModel().setValueAt(tempList.get(Accounts.accountRepository.size() - 1).rating, 0, 5);
            for (int i = Accounts.accountRepository.size() - 2; i >= 0; i--) {
                playerTable.getModel().setValueAt(tempList.get(i).name,i + 1, 0);
                playerTable.getModel().setValueAt(tempList.get(i).studentNumber, i + 1, 1);
                playerTable.getModel().setValueAt(tempList.get(i).wins, i + 1, 2);
                playerTable.getModel().setValueAt(tempList.get(i).losses,i + 1, 3);
                playerTable.getModel().setValueAt(tempList.get(i).ties, i + 1, 4);
                playerTable.getModel().setValueAt(tempList.get(i).rating, i + 1, 5);
            }
        });
        viewPlayersPanel.add(sortByNameButton);

        JButton sortByWinsButton = new JButton("Sort by Wins");
        sortByWinsButton.addActionListener(e -> {
            ArrayList<Account> tempList = new ArrayList<>(Accounts.accountRepository.values());
            int size = Accounts.accountRepository.size();
            tempList.sort(Comparator.comparing(o -> o.wins));
            for (int i = 0; i < Accounts.accountRepository.size(); i++) {
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).name,i, 0);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).studentNumber, i, 1);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).wins, i, 2);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).losses,i, 3);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).ties, i, 4);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).rating, i, 5);
            }
        });
        viewPlayersPanel.add(sortByWinsButton);

        JButton sortByLossesButton = new JButton("Sort by Losses");
        sortByLossesButton.addActionListener(e -> {
            ArrayList<Account> tempList = new ArrayList<>(Accounts.accountRepository.values());
            int size = Accounts.accountRepository.size();
            tempList.sort(Comparator.comparing(o -> o.losses));
            for (int i = 0; i < Accounts.accountRepository.size(); i++) {
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).name,i, 0);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).studentNumber, i, 1);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).wins, i, 2);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).losses,i, 3);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).ties, i, 4);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).rating, i, 5);
            }
        });
        viewPlayersPanel.add(sortByLossesButton);

        JButton sortByTiesButton = new JButton("Sort by Ties");
        sortByTiesButton.addActionListener(e -> {
            ArrayList<Account> tempList = new ArrayList<>(Accounts.accountRepository.values());
            int size = Accounts.accountRepository.size();
            tempList.sort(Comparator.comparing(o -> o.ties));
            for (int i = 0; i < Accounts.accountRepository.size(); i++) {
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).name,i, 0);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).studentNumber, i, 1);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).wins, i, 2);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).losses,i, 3);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).ties, i, 4);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).rating, i, 5);
            }
        });
        viewPlayersPanel.add(sortByTiesButton);

        JButton sortByRatingButton = new JButton("Sort by Rating");
        sortByRatingButton.addActionListener(e -> {
            ArrayList<Account> tempList = new ArrayList<>(Accounts.accountRepository.values());
            int size = Accounts.accountRepository.size();
            tempList.sort(Comparator.comparing(o -> o.rating));
            for (int i = 0; i < Accounts.accountRepository.size(); i++) {
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).name,i, 0);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).studentNumber, i, 1);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).wins, i, 2);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).losses,i, 3);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).ties, i, 4);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).rating, i, 5);
            }
        });
        viewPlayersPanel.add(sortByRatingButton);

        String[] gameColumns = {"Game ID", "Player 1", "Player 2", "Result", "Tourney ID"};
        Object[][] gameData = new Object[Games.gameCounter + 100][5];

        JTable gameTable = new JTable(gameData, gameColumns);
        JScrollPane gameScrollPane = new JScrollPane(gameTable);
        viewGamesPanel.add(gameScrollPane);

        // View games button
        JButton viewGamesButton = new JButton("View games");
        viewGamesButton.addActionListener(e -> {
            ArrayList<Game> tempList = Games.repository;
            int size = tempList.size();
            for (int i = 0; i < size; i++) {
                gameTable.getModel().setValueAt(i + 1,i, 0);
                gameTable.getModel().setValueAt(tempList.get(i).playerOne, i, 1);
                gameTable.getModel().setValueAt(tempList.get(i).playerTwo, i, 2);
                gameTable.getModel().setValueAt(tempList.get(i).outcome,i, 3);
                gameTable.getModel().setValueAt(tempList.get(i).tourneyID, i, 4);
            }

            viewStats.setVisible(false);
            viewGames.setVisible(true);
        });
        viewStatsPanel.add(viewGamesButton);

        String[] tourneyColumns = {"ID","Roster", "Game IDs"};
        Object[][] tourneyData = new Object[Tournaments.tourneyCounter + 100][3];

        JTable tourneyTable = new JTable(tourneyData, tourneyColumns);
        JScrollPane tourneyScrollPane = new JScrollPane(tourneyTable);
        viewTourneysPanel.add(tourneyScrollPane);

        // View Tournaments Button
        JButton viewTournamentsButton = new JButton("View tournaments");
        viewTournamentsButton.addActionListener(e -> {
            ArrayList<Tournament> tempList = Tournaments.repository;
            int size = tempList.size();
            for (int i = 0; i < size; i++) {
                int[] tempRoster = tempList.get(i).roster;
                int[] tempGameRoster = tempList.get(i).games;
                String stringedRoster = Arrays.toString(tempRoster).replace(",", "");
                String stringedGameRoster = Arrays.toString(tempGameRoster).replace(",", "");
                tourneyTable.getModel().setValueAt(tempList.get(i).tourneyID,i, 0);
                tourneyTable.getModel().setValueAt(stringedRoster,i, 1);
                tourneyTable.getModel().setValueAt(stringedGameRoster, i, 2);
            }
            viewStats.setVisible(false);
            viewTourneys.setVisible(true);
        });
        viewStatsPanel.add(viewTournamentsButton);

        // Back buttons for stats, tourney, user data & password
        JButton viewStatsBackButton = new JButton("back");
        viewStatsBackButton.addActionListener(e -> {
            viewStats.setVisible(false);
            mainMenu.setVisible(true);
        });
        viewStatsPanel.add(viewStatsBackButton);

        JButton viewPlayersBackButton = new JButton("Back");
        viewPlayersBackButton.addActionListener(e -> {
            viewPlayers.setVisible(false);
            viewStats.setVisible(true);
        });
        viewPlayersPanel.add(viewPlayersBackButton);

        JButton viewGamesBackButton = new JButton("Back");
        viewGamesBackButton.addActionListener(e -> {
            viewGames.setVisible(false);
            viewStats.setVisible(true);
        });
        viewGamesPanel.add(viewGamesBackButton);

        JButton viewTourneysBackButton = new JButton("Back");
        viewTourneysBackButton.addActionListener(e -> {
            viewTourneys.setVisible(false);
            viewStats.setVisible(true);
        });
        viewTourneysPanel.add(viewTourneysBackButton);

        // rules
        JTextArea rulesArea = new JTextArea(
                "Connect Four is played with two people. In turns, each player (red and green) places a block in the grid. " +
                        "When one player gets four blocks in a row, either vertically or diagonally, they win. " + "The red player always goes first, and the user signed in is red.");
        rulesArea.setLineWrap(true);
        rulesArea.setWrapStyleWord(true);
        rulesArea.setEditable(false);

        JScrollPane rulesScrollPane = new JScrollPane(rulesArea);
        rulesScrollPane.setPreferredSize(new Dimension(600, 200));

        howToPlayPanel.add(rulesScrollPane);


        // Change password text box
        JTextField changingOwnPasswordField = new JTextField("New Password:", 20);
        changeOwnPasswordPanel.add(changingOwnPasswordField);

        JButton changeOwnPasswordBackButton = new JButton("back");
        changeOwnPasswordBackButton.addActionListener(e -> {
            changingOwnPasswordField.setText("New Password:");
            changeOwnPassword.setVisible(false);
            mainMenu.setVisible(true);
        });
        changeOwnPasswordPanel.add(changeOwnPasswordBackButton);

        // confirm password change
        JButton changeOwnPasswordConfirmButton = new JButton("Confirm");
        changeOwnPasswordConfirmButton.addActionListener(e -> {
            if (!Objects.equals(changingOwnPasswordField.getText(), "") && Objects.equals(changingOwnPasswordField.getText(), changingOwnPasswordField.getText().replaceAll("[^a-zA-Z\\s]", ""))) {
                Accounts.accountRepository.get(mode).changePassword(changingOwnPasswordField.getText());
                changingOwnPasswordField.setText("New Password");
                String tempString = Accounts.accountRepository.get(mode).toString();

                try {
                    FileHandling file = new FileHandling();
                    file.updateMembers(String.valueOf(mode), tempString);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                changeOwnPassword.setVisible(false);
                mainMenu.setVisible(true);
            }
        });
        changeOwnPasswordPanel.add(changeOwnPasswordConfirmButton);





        // tourney menu

        // Player count button
        JLabel createTournamentRoster = new JLabel("Players:");
        createTournamentPanel.add(createTournamentRoster);

        // List of players
        JTextField listOfPlayers = new JTextField("List of players", 50);
        createTournamentPanel.add(listOfPlayers);

        // Round Robin Button
        JButton roundRobinButton = new JButton("Round Robin");
        roundRobinButton.addActionListener(e -> {
            String[] roster = listOfPlayers.getText().split(" ");
            int[] rosterID = new int[roster.length];
            int counter = 0;
            boolean valid = true;
            int tempID;
            if (roster.length < 2) {valid = false;}
            for (String s : roster) {
                try {
                    tempID = Integer.parseInt(s);
                    if (Accounts.accountRepository.get(tempID) == null) {
                        valid = false;
                    }
                    rosterID[counter++] = tempID;
                } catch (Exception ex) {
                    valid = false;
                }
            }

            Hashtable<Integer, Integer> set = new Hashtable<>();
            for (int num : rosterID) {
                if (set.containsKey(num)) {
                    valid = false;
                }
                set.put(num, 0);
            }

            if (valid) {
                RoundRobin rr = new RoundRobin(rosterID, roster.length);
                Queue<Integer> queueOfPlayers = rr.createGames();
                // System.out.println(queueOfPlayers);
                createTournament.setVisible(false);
                mainMenu.setVisible(true);
                listOfPlayers.setText("List of players");

                int playerOne;
                int playerTwo;
                int[] games = new int[queueOfPlayers.size() / 2];
                counter = 0;

                while (queueOfPlayers.size() > 1) {
                    playerOne = queueOfPlayers.poll();
                    playerTwo = queueOfPlayers.poll();
                    ConnectFour game = new ConnectFour(playerOne, playerTwo, rr.tourneyID);
                    games[counter++] = Games.gameCounter + counter;
                    game.frame.setVisible(true);
                }

                try {
                    FileHandling file = new FileHandling();
                    rr.games = games;
                    file.updateTourneys(rr);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                Tournaments.repository.add(rr);
            }
        });
        createTournamentPanel.add(roundRobinButton);

        JButton elimButton = new JButton("Single Elimination");
        elimButton.addActionListener(e -> {
            String[] roster = listOfPlayers.getText().split(" ");
            int[] rosterID = new int[roster.length];
            int counter = 0;
            boolean valid = true;
            int tempID;
            if (roster.length < 2) {valid = false;}
            for (String s : roster) {
                try {
                    tempID = Integer.parseInt(s);
                    if (Accounts.accountRepository.get(tempID) == null) {
                        valid = false;
                    }
                    rosterID[counter++] = tempID;
                } catch (Exception ex) {
                    valid = false;
                }
            }

            Set<Integer> set = new HashSet<>();
            for (int num : rosterID) {
                if (set.contains(num)) {
                    valid = false;
                }
                set.add(num);
            }

            if (valid) {
                SingleElim se = new SingleElim(rosterID, roster.length);
                Queue<Integer> queueOfPlayers = se.createGames();
                System.out.println(queueOfPlayers);
                int playerOne;
                int playerTwo;

                createTournament.setVisible(false);
                mainMenu.setVisible(true);
                listOfPlayers.setText("List of players");

                while (queueOfPlayers.size() > 1) {
                    playerOne = queueOfPlayers.poll();
                    playerTwo = queueOfPlayers.poll();
                    ConnectFour game = new ConnectFour(playerOne, playerTwo, se.tourneyID);
                    game.frame.setVisible(true);

                    if (game.outcome == 0) {
                        queueOfPlayers.add(playerOne);
                        queueOfPlayers.add(playerTwo);
                    } else if (game.outcome == 2) {
                        queueOfPlayers.add(playerOne);
                    } else {
                        queueOfPlayers.add(playerTwo);
                    }

                }
                // se.winner = queueOfPlayers.poll();

                try {
                    FileHandling file = new FileHandling();
                    file.updateTourneys(se);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                Tournaments.repository.add(se);


            }
        });
        // createTournamentPanel.add(elimButton);

        JButton createTournamentBackButton = new JButton("back");
        createTournamentBackButton.addActionListener(e -> {
            createTournament.setVisible(false);
            mainMenu.setVisible(true);
        });
        createTournamentPanel.add(createTournamentBackButton);




        // edit user data !
        JFrame modifyUser = new JFrame("Pick student ID");
        modifyUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        modifyUser.setSize(800, 600);
        modifyUser.setLocationRelativeTo(null);

        JPanel modifyUserPanel = new JPanel();
        modifyUser.add(modifyUserPanel);

        // Edit user data selection
        JTextField pickStudentField = new JTextField("Which student ID would you like to edit?", 30);
        editUserDataPanel.add(pickStudentField);

        JButton editUserDataBackButton = new JButton("back");
        editUserDataBackButton.addActionListener(e -> {
            editUserData.setVisible(false);
            pickStudentField.setText("Which student ID would you like to edit?");
            mainMenu.setVisible(true);
        });
        editUserDataPanel.add(editUserDataBackButton);


        // place to modify user
        JTextField newName = new JTextField("name", 20);
        modifyUserPanel.add(newName);

        JTextField newPassword = new JTextField("password", 20);
        modifyUserPanel.add(newPassword);

        JTextField newWins = new JTextField("wins");
        modifyUserPanel.add(newWins);

        JTextField newLosses = new JTextField("losses");
        modifyUserPanel.add(newLosses);

        JTextField newTies = new JTextField("ties");
        modifyUserPanel.add(newTies);

        JTextField newRating = new JTextField("elo", 5);
        modifyUserPanel.add(newRating);



        // find user to modify, admin panel
        JButton pickStudentButton = new JButton("Confirm");
        pickStudentButton.addActionListener(e -> {
            String input = pickStudentField.getText();
            try {
                int number = Integer.parseInt(input);
                if (Accounts.accountRepository.get(number) != null) {
                    Account tempAccount = Accounts.accountRepository.get(number);
                    newName.setText(tempAccount.name);
                    newPassword.setText(tempAccount.getPassword());
                    newWins.setText(String.valueOf(tempAccount.wins));
                    newLosses.setText(String.valueOf(tempAccount.losses));
                    newTies.setText(String.valueOf(tempAccount.ties));
                    newRating.setText(String.valueOf(tempAccount.rating));

                    editUserData.setVisible(false);
                    modifyUser.setVisible(true);
                }
            } catch (NumberFormatException ignored) {}
        });
        editUserDataPanel.add(pickStudentButton);

        JButton modifyUserConfirmButton = new JButton("Confirm account changes");
        modifyUserConfirmButton.addActionListener(e -> {
            try {
                Account tempAccount = Accounts.accountRepository.get(Integer.parseInt(pickStudentField.getText()));
                int wins = Integer.parseInt(newWins.getText());
                int losses = Integer.parseInt(newLosses.getText());
                int ties = Integer.parseInt(newTies.getText());
                int rating = Integer.parseInt(newRating.getText());

                if (Objects.equals(newName.getText(), newName.getText().replaceAll("[^a-zA-Z\\s]", ""))) {
                    tempAccount.changeName(newName.getText());
                }

                if (Objects.equals(newPassword.getText(), newPassword.getText().replaceAll("[^a-zA-Z\\s]", ""))) {
                    tempAccount.changePassword(newPassword.getText());
                }

                tempAccount.wins = wins;
                tempAccount.losses = losses;
                tempAccount.ties = ties;
                tempAccount.rating = rating;


                String tempString = tempAccount.toString();

                try {
                    FileHandling file = new FileHandling();
                    file.updateMembers(pickStudentField.getText(), tempString);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                modifyUser.setVisible(false);
                pickStudentField.setText("Which student ID would you like to edit?");
                mainMenu.setVisible(true);

            } catch (NumberFormatException ignored) {}

        });
        modifyUserPanel.add(modifyUserConfirmButton);

        JLabel newUserContext = new JLabel("The details are as follows: Name, password, wins, losses, ties, elo.");
        modifyUserPanel.add(newUserContext);

        accountMenu.setVisible(true);
    }
}