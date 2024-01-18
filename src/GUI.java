import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;

// gui class controls all menu navigation
public class GUI {
    // user session, used to determine admin status
    int mode = -1;
    // constructor
    public GUI() {
        // initialized menu jframe
        JFrame accountMenu = new JFrame("Connect 4!");
        JFrame signIn = new JFrame("Sign in");
        JFrame mainMenu = new JFrame("Welcome :D");

        // closing window stops entire app, prevents errors/crashing
        accountMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // buttons and fields
        JButton accountMenuSignInButton = new JButton("Sign in");
        JTextField signInText1 = new JTextField("Name", 20);
        JTextField signInText2 = new JTextField("Student number", 20);
        JTextField signInText3 = new JTextField("Password (characters only)", 20);
        JButton signInBackButton = new JButton("Back");
        JButton signInLogInButton = new JButton("Log in");
        JButton signInSignUpButton = new JButton("Sign up");
        JLabel signInErrorLabel = new JLabel("");

        // button actions, resets text labels and changes menu screens
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

        // log in function
        signInLogInButton.addActionListener(e -> {
            // creates menu class to instantiate account validator functions
            Menu menu = new Menu();
            // invalid number/password, checks for commas that would break the csv
            if (menu.validateNumber(signInText2.getText()) || menu.validateString(signInText3.getText())) {
                signInErrorLabel.setText("Invalid password/student number");
                // checks for invalid student id using hashmap call
            } else if (Accounts.accountRepository.get(Integer.parseInt(signInText2.getText())) == null) {
                signInErrorLabel.setText("Student ID doesn't exist");
                // checks for whether passwords match using getter
            } else if (!Objects.equals(signInText3.getText(), Accounts.accountRepository.get(Integer.parseInt(signInText2.getText())).getPassword())) {
                signInErrorLabel.setText("Wrong password!");
            } else {
                // sets mode/session to current user ID
                mode = Integer.parseInt(signInText2.getText());
                signIn.setVisible(false);
                // custom main menu name :D
                mainMenu.setTitle("Welcome " + Accounts.accountRepository.get(Integer.parseInt(signInText2.getText())).name);
                mainMenu.setVisible(true);
                // resets signin text
                signInErrorLabel.setText("");
                signInText1.setText("Name");
                signInText2.setText("Student number");
                signInText3.setText("Password (characters only)");
            }
        });
        // signup button
        signInSignUpButton.addActionListener(e -> {
            // initialized menu functions
            Menu menu = new Menu();
            // checks for valid string/numbers in textboxes
            if (menu.validateString(signInText1.getText()) || menu.validateNumber(signInText2.getText()) || menu.validateString(signInText3.getText())) {
                signInErrorLabel.setText("Invalid name/password/student number");
                // checks for whether wanted student id is occupied
            } else if (Accounts.accountRepository.get(Integer.parseInt(signInText2.getText())) != null) {
                signInErrorLabel.setText("Student ID is already taken");
            } else {
                try {
                    // creates new account using generated data, method writes data to csv
                    menu.createAccount(signInText1.getText(),signInText2.getText(),signInText3.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                // sets session, custom title
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

        // panel for every frame to add objects
        JPanel accountMenuPanel = new JPanel();
        JPanel signInPanel = new JPanel();
        JPanel mainMenuPanel = new JPanel();

        // required objects per frame within first three menus
        accountMenuPanel.add(accountMenuSignInButton);
        signInPanel.add(signInText1);
        signInPanel.add(signInText2);
        signInPanel.add(signInText3);
        signInPanel.add(signInBackButton);
        signInPanel.add(signInLogInButton);
        signInPanel.add(signInSignUpButton);
        signInPanel.add(signInErrorLabel);

        // adding objects
        accountMenu.add(accountMenuPanel);
        signIn.add(signInPanel);
        mainMenu.add(mainMenuPanel);

        // initialized frame size
        accountMenu.setSize(800, 600);
        signIn.setSize(800, 600);
        mainMenu.setSize(800, 600);

        accountMenu.setLocationRelativeTo(null);
        signIn.setLocationRelativeTo(null);
        mainMenu.setLocationRelativeTo(null);

        // at this point, the initialization of new frames will be done all at once for cleaner formatting
        // initializing every needed frame to move to from menu
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

        // sets all buttons for mainmenu
        JButton mainMenuHowToPlayButton = new JButton("How to Play");
        JButton mainMenuPlayAgainstOpponentButton = new JButton("Play Against Opponent");
        JButton mainMenuViewStatsButton = new JButton("View Stats");
        JButton mainMenuCreateTournamentButton = new JButton("Create Tournament");
        JButton mainMenuEditUserDataButton = new JButton("Edit User Data");
        JButton mainMenuChangeOwnPasswordButton = new JButton("Change Password");
        JButton mainMenuLogOutButton = new JButton("Log Out");

        // adds all buttons
        mainMenuPanel.add(mainMenuHowToPlayButton);
        mainMenuPanel.add(mainMenuPlayAgainstOpponentButton);
        mainMenuPanel.add(mainMenuViewStatsButton);
        mainMenuPanel.add(mainMenuCreateTournamentButton);
        mainMenuPanel.add(mainMenuEditUserDataButton);
        mainMenuPanel.add(mainMenuChangeOwnPasswordButton);
        mainMenuPanel.add(mainMenuLogOutButton);

        // Adding button functionality by changing frames
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
                mainMenu.setVisible(false);
                createTournament.setVisible(true);
        });

        mainMenuEditUserDataButton.addActionListener(e -> {
            // only works on admin session
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
            // resets session
            mode = -1;
            mainMenu.setVisible(false);
            accountMenu.setVisible(true);
        });

        // all panels succeeding menu page
        JPanel howToPlayPanel = new JPanel();
        JPanel playAgainstOpponentPanel = new JPanel();
        JPanel viewStatsPanel = new JPanel();
        JPanel createTournamentPanel = new JPanel();
        JPanel editUserDataPanel = new JPanel();
        JPanel changeOwnPasswordPanel = new JPanel();
        JPanel logOutPanel = new JPanel();

        // adding panels to frames
        howToPlay.add(howToPlayPanel);
        playAgainstOpponent.add(playAgainstOpponentPanel);
        viewStats.add(viewStatsPanel);
        createTournament.add(createTournamentPanel);
        editUserData.add(editUserDataPanel);
        changeOwnPassword.add(changeOwnPasswordPanel);
        logOut.add(logOutPanel);




        // how to play menu
        // rules textbox in menu
        JTextArea rulesArea = new JTextArea(
                "Connect Four is played with two people. In turns, each player (red and green) places a block in the grid. " +
                        "When one player gets four blocks in a row, either vertically or diagonally, they win. " + "The red player always goes first, and the user signed in is red.");
        rulesArea.setLineWrap(true);
        rulesArea.setWrapStyleWord(true);
        rulesArea.setEditable(false);

        // used to wrap text into box
        JScrollPane rulesScrollPane = new JScrollPane(rulesArea);
        rulesScrollPane.setPreferredSize(new Dimension(600, 200));
        howToPlayPanel.add(rulesScrollPane);

        // back button from rules
        JButton howToPlayBackButton = new JButton("back");
        howToPlayBackButton.addActionListener(e -> {
            howToPlay.setVisible(false);
            mainMenu.setVisible(true);
        });
        howToPlayPanel.add(howToPlayBackButton);




        // play against opponent menu
        // Text for typing up opponent ID
        JTextField playAgainstOpponentID = new JTextField("Opponent ID: ", 20);
        playAgainstOpponentPanel.add(playAgainstOpponentID);

        // Back button for play against opponent panel
        JButton playAgainstOpponentBackButton = new JButton("back");
        playAgainstOpponentBackButton.addActionListener(e -> {
            playAgainstOpponent.setVisible(false);
            mainMenu.setVisible(true);
        });
        playAgainstOpponentPanel.add(playAgainstOpponentBackButton);

        // button for starting game with given opponent id
        JButton playAgainstOpponentStartButton = new JButton("Start game");
        playAgainstOpponentStartButton.addActionListener(e -> {
            // takes text from edited textbox as input
            String input = playAgainstOpponentID.getText();
            try {
                // tries to parse textbox as integer
                int number = Integer.parseInt(input);
                // checks if the parsed studentID is in the repository and not same as the current user session
                if (Accounts.accountRepository.get(number) != null && number != mode) {
                    // Create an instance of connectFour and set it visible
                    // sets user as player one and inputted studentID as player two
                    ConnectFour game = new ConnectFour(mode, number, -1);
                    game.frame.setVisible(true);
                    // changes current frame back to menu
                    playAgainstOpponent.setVisible(false);
                    mainMenu.setVisible(true);
                }
            } catch (NumberFormatException ignored) {}

        });
        playAgainstOpponentPanel.add(playAgainstOpponentStartButton);




        // view stats menu
        // relevant buttons to view players, games, tourneys
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

        // initializes and adds panels to frames
        JPanel viewPlayersPanel = new JPanel();
        JPanel viewGamesPanel = new JPanel();
        JPanel viewTourneysPanel = new JPanel();

        viewPlayers.add(viewPlayersPanel);
        viewGames.add(viewGamesPanel);
        viewTourneys.add(viewTourneysPanel);




        // view players menu, view stats menu integrated too
        // initialized 2d array to store players
        String[] playerColumns = {"Name", "Student ID", "Wins", "Losses", "Ties","Win/Loss ratio", "Rating"};
        Object[][] playerData = new Object[Accounts.accountRepository.size() + 50][7];
        // View players button, writes player data into 2d array
        // initial upload so I can directly modify array
        JButton viewPlayersButton = new JButton("View players");
        viewPlayersButton.addActionListener(e -> {
            // creates templist using account repository
            ArrayList<Account> tempList = new ArrayList<>(Accounts.accountRepository.values());
            // sorts by name, does weird formatting as this function makes the alphabetically first name go last
            tempList.sort(Comparator.comparing(o -> o.name));
            // variables used for uplaoding info, uploads first player to first column
            int size = Accounts.accountRepository.size();
            float winLoss = (float) tempList.get(size - 1).wins / tempList.get(size - 1).losses;
            float ratio = (float) Math.round(100 * winLoss) / 100;
            playerData[0][0] = tempList.get(size - 1).name;
            playerData[0][1] = tempList.get(size - 1).studentNumber;
            playerData[0][2] = tempList.get(size - 1).wins;
            playerData[0][3] = tempList.get(size - 1).losses;
            playerData[0][4] = tempList.get(size - 1).ties;
            playerData[0][5] = ratio;
            playerData[0][6] = tempList.get(size - 1).rating;
            // backwards for loop to upload remaining players in alphabetical order, i is the current index of the account from the arraylist values
            for (int i = size - 2; i >= 0; i--) {
                // reinstates win/loss stat
                winLoss = (float) tempList.get(i).wins / tempList.get(i).losses;
                ratio = (float) Math.round(100 * winLoss) / 100;
                playerData[i + 1][0] = tempList.get(i).name;
                playerData[i + 1][1] = tempList.get(i).studentNumber;
                playerData[i + 1][2] = tempList.get(i).wins;
                playerData[i + 1][3] = tempList.get(i).losses;
                playerData[i + 1][4] = tempList.get(i).ties;
                playerData[i + 1][5] = ratio;
                playerData[i + 1][6] = tempList.get(i).rating;
            }

            viewStats.setVisible(false);
            viewPlayers.setVisible(true);
        });
        viewStatsPanel.add(viewPlayersButton);

        // initialized table using player data, playerColumns creates titles
        JTable playerTable = new JTable(playerData, playerColumns);
        JScrollPane playerScrollPane = new JScrollPane(playerTable);
        viewPlayersPanel.add(playerScrollPane);

        // sort by name, follow sort buttons are identical other than the comparator used to sort tempList with
        JButton sortByNameButton = new JButton("Sort Alphabetically");
        sortByNameButton.addActionListener(e -> {
            // creates and sorts list by alphabetical order
            ArrayList<Account> tempList = new ArrayList<>(Accounts.accountRepository.values());
            tempList.sort(Comparator.comparing(o -> o.name));
            // variables
            int size = Accounts.accountRepository.size();
            float winLoss = (float) tempList.get(size - 1).wins / tempList.get(size - 1).losses;
            float ratio = (float) Math.round(100 * winLoss) / 100;
            // initializes first player, function updates data gotten from sorted account repo with coordinates
            playerTable.getModel().setValueAt(tempList.get(size - 1).name, 0, 0);
            playerTable.getModel().setValueAt(tempList.get(size - 1).studentNumber, 0, 1);
            playerTable.getModel().setValueAt(tempList.get(size - 1).wins, 0, 2);
            playerTable.getModel().setValueAt(tempList.get(size - 1).losses, 0, 3);
            playerTable.getModel().setValueAt(tempList.get(size - 1).ties, 0, 4);
            playerTable.getModel().setValueAt(ratio, 0, 5);
            playerTable.getModel().setValueAt(tempList.get(size - 1).rating, 0, 6);
            // backwards for loop
            for (int i = Accounts.accountRepository.size() - 2; i >= 0; i--) {
                // reinstates win/loss stat
                winLoss = (float) tempList.get(i).wins / tempList.get(i).losses;
                ratio = (float) Math.round(100 * winLoss) / 100;
                playerTable.getModel().setValueAt(tempList.get(i).name,i + 1, 0);
                playerTable.getModel().setValueAt(tempList.get(i).studentNumber, i + 1, 1);
                playerTable.getModel().setValueAt(tempList.get(i).wins, i + 1, 2);
                playerTable.getModel().setValueAt(tempList.get(i).losses,i + 1, 3);
                playerTable.getModel().setValueAt(tempList.get(i).ties, i + 1, 4);
                playerTable.getModel().setValueAt(ratio, i + 1, 5);
                playerTable.getModel().setValueAt(tempList.get(size - 1).rating, i + 1, 6);
            }
        });
        viewPlayersPanel.add(sortByNameButton);

        // sort by wins
        JButton sortByWinsButton = new JButton("Sort by Wins");
        sortByWinsButton.addActionListener(e -> {
            // variables
            ArrayList<Account> tempList = new ArrayList<>(Accounts.accountRepository.values());
            int size = Accounts.accountRepository.size();
            float winLoss;
            float ratio;
            // sort list
            tempList.sort(Comparator.comparing(o -> o.wins));
            for (int i = 0; i < Accounts.accountRepository.size(); i++) {
                // gets winloss of current account, rounds
                winLoss = (float) tempList.get(size - i - 1).wins / tempList.get(size - i - 1).losses;
                ratio = (float) Math.round(100 * winLoss) / 100;
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).name,i, 0);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).studentNumber, i, 1);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).wins, i, 2);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).losses,i, 3);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).ties, i, 4);
                playerTable.getModel().setValueAt(ratio, i, 5);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).rating, i, 6);
            }
        });
        viewPlayersPanel.add(sortByWinsButton);

        // sort by losses
        JButton sortByLossesButton = new JButton("Sort by Losses");
        sortByLossesButton.addActionListener(e -> {
            // variables
            ArrayList<Account> tempList = new ArrayList<>(Accounts.accountRepository.values());
            int size = Accounts.accountRepository.size();
            float winLoss;
            float ratio;
            // sort list
            tempList.sort(Comparator.comparing(o -> o.losses));
            for (int i = 0; i < Accounts.accountRepository.size(); i++) {
                winLoss = (float) tempList.get(size - i - 1).wins / tempList.get(size - i - 1).losses;
                ratio = (float) Math.round(100 * winLoss) / 100;
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).name,i, 0);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).studentNumber, i, 1);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).wins, i, 2);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).losses,i, 3);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).ties, i, 4);
                playerTable.getModel().setValueAt(ratio, i, 5);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).rating, i, 6);
            }
        });
        viewPlayersPanel.add(sortByLossesButton);

        // sort by ties
        JButton sortByTiesButton = new JButton("Sort by Ties");
        sortByTiesButton.addActionListener(e -> {
            // variables
            ArrayList<Account> tempList = new ArrayList<>(Accounts.accountRepository.values());
            int size = Accounts.accountRepository.size();
            float winLoss;
            float ratio;
            // sort list
            tempList.sort(Comparator.comparing(o -> o.ties));
            for (int i = 0; i < Accounts.accountRepository.size(); i++) {
                winLoss = (float) tempList.get(size - i - 1).wins / tempList.get(size - i - 1).losses;
                ratio = (float) Math.round(100 * winLoss) / 100;
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).name,i, 0);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).studentNumber, i, 1);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).wins, i, 2);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).losses,i, 3);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).ties, i, 4);
                playerTable.getModel().setValueAt(ratio, i, 5);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).rating, i, 6);
            }
        });
        viewPlayersPanel.add(sortByTiesButton);

        // sort by rating
        JButton sortByRatingButton = new JButton("Sort by Rating");
        sortByRatingButton.addActionListener(e -> {
            // variables
            ArrayList<Account> tempList = new ArrayList<>(Accounts.accountRepository.values());
            int size = Accounts.accountRepository.size();
            float winLoss;
            float ratio;
            // sort list
            tempList.sort(Comparator.comparing(o -> o.rating));
            for (int i = 0; i < Accounts.accountRepository.size(); i++) {
                winLoss = (float) tempList.get(size - i - 1).wins / tempList.get(size - i - 1).losses;
                ratio = (float) Math.round(100 * winLoss) / 100;
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).name,i, 0);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).studentNumber, i, 1);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).wins, i, 2);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).losses,i, 3);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).ties, i, 4);
                playerTable.getModel().setValueAt(ratio, i, 5);
                playerTable.getModel().setValueAt(tempList.get(size - i - 1).rating, i, 6);
            }
        });
        viewPlayersPanel.add(sortByRatingButton);




        // view games panel, same basis as view players but w/o sorting
        String[] gameColumns = {"Game ID", "Player 1", "Player 2", "Result", "Tourney ID"};
        Object[][] gameData = new Object[Games.gameCounter + 100][5];

        // initialized table to view 2d array
        JTable gameTable = new JTable(gameData, gameColumns);
        JScrollPane gameScrollPane = new JScrollPane(gameTable);
        viewGamesPanel.add(gameScrollPane);

        // View games button
        JButton viewGamesButton = new JButton("View games");
        viewGamesButton.addActionListener(e -> {
            // brute forces through all the games to upload game information, same basis
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





        // view tournaments screen
        String[] tourneyColumns = {"ID","Roster", "Game IDs"};
        Object[][] tourneyData = new Object[Tournaments.tourneyCounter + 100][3];

        // initialized 2d array
        JTable tourneyTable = new JTable(tourneyData, tourneyColumns);
        JScrollPane tourneyScrollPane = new JScrollPane(tourneyTable);
        viewTourneysPanel.add(tourneyScrollPane);

        // View Tournaments Button
        JButton viewTournamentsButton = new JButton("View tournaments");
        viewTournamentsButton.addActionListener(e -> {
            ArrayList<Tournament> tempList = Tournaments.repository;
            int size = tempList.size();
            // brute force adding all parsed tournament data
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

        // Back buttons for stats, tourney, user data
        JButton viewStatsBackButton = new JButton("Back");
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




        // Change password panel
        // Change password text box
        JTextField changingOwnPasswordField = new JTextField("New Password:", 20);
        changeOwnPasswordPanel.add(changingOwnPasswordField);
        // back button, resets password text
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
            // makes sure password passes character check
            if (!Objects.equals(changingOwnPasswordField.getText(), "") && Objects.equals(changingOwnPasswordField.getText(), changingOwnPasswordField.getText().replaceAll("[^a-zA-Z\\s]", ""))) {
                // changes password of account using mode session, resets password text
                Accounts.accountRepository.get(mode).changePassword(changingOwnPasswordField.getText());
                changingOwnPasswordField.setText("New Password");
                String tempString = Accounts.accountRepository.get(mode).toString();

                try {
                    // parses new account data to rewrite into csv
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
        JTextField listOfPlayers = new JTextField("List of players, seperated only by spaces", 50);
        createTournamentPanel.add(listOfPlayers);

        // Round Robin Button
        JButton roundRobinButton = new JButton("Round Robin");
        roundRobinButton.addActionListener(e -> {
            // parses playerlist from string to int
            String[] roster = listOfPlayers.getText().split(" ");
            int[] rosterID = new int[roster.length];
            int counter = 0;
            boolean valid = true;
            int tempID;
            // does checks to see if parsed string is valid, makes valid boolean equal false if not
            if (roster.length < 2) {valid = false;} // too small tournament size
            for (String s : roster) {
                try {
                    // attempts to parse every entry in array into integer, does hashmap call to determine valid player id
                    // uploads valid information into int array
                    tempID = Integer.parseInt(s);
                    if (Accounts.accountRepository.get(tempID) == null) {
                        valid = false;
                    }
                    rosterID[counter++] = tempID;
                } catch (Exception ex) {
                    valid = false;
                }
            }

            // creates hashtable to check for unique student ids
            Hashtable<Integer, Integer> set = new Hashtable<>();
            for (int num : rosterID) {
                if (set.containsKey(num)) { // if duplicate is found, constant time operation
                    valid = false;
                }
                set.put(num, 0); // puts data into hashtable
            }

            if (valid) { // roundrobin initialized when checks pass
                // creates new tourney object, makes a queue using tourney function
                RoundRobin rr = new RoundRobin(rosterID, roster.length);
                Queue<Integer> queueOfPlayers = rr.createGames();
                // System.out.println(queueOfPlayers); DEBUG CODE!!
                createTournament.setVisible(false);
                mainMenu.setVisible(true);
                listOfPlayers.setText("List of players, seperated only by spaces");

                int playerOne;
                int playerTwo;
                // list of game ids
                int[] games = new int[queueOfPlayers.size() / 2];
                counter = 0;

                while (queueOfPlayers.size() > 1) {
                    // pulls first two entries of queue to put in game, uploads new game id into list
                    playerOne = queueOfPlayers.poll();
                    playerTwo = queueOfPlayers.poll();
                    ConnectFour game = new ConnectFour(playerOne, playerTwo, rr.tourneyID);
                    games[counter++] = Games.gameCounter + counter;
                    game.frame.setVisible(true);
                }

                try {
                    // uploads tournament data, users/games are put into csv
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

        // single elimination tournament function
        // has not been physically implemented
        JButton elimButton = new JButton("Single Elimination");
        elimButton.addActionListener(e -> {
            // same process of obtaining valid roster from roundrobin tournament
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
                // creates queue to be recursively processed
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

                    // reuploads surviving players back to queue until single player queue is reached
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
                    // uploads tourney data to csv
                    FileHandling file = new FileHandling();
                    file.updateTourneys(se);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                Tournaments.repository.add(se);


            }
        });
        // createTournamentPanel.add(elimButton);
        // back button
        JButton createTournamentBackButton = new JButton("back");
        createTournamentBackButton.addActionListener(e -> {
            createTournament.setVisible(false);
            mainMenu.setVisible(true);
        });
        createTournamentPanel.add(createTournamentBackButton);




        // admin panel to edit user data !
        JFrame modifyUser = new JFrame("Pick student ID");
        modifyUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        modifyUser.setSize(800, 600);
        modifyUser.setLocationRelativeTo(null);
        // panel
        JPanel modifyUserPanel = new JPanel();
        modifyUser.add(modifyUserPanel);
        // Edit user data selection
        JTextField pickStudentField = new JTextField("Which student ID would you like to edit?", 30);
        editUserDataPanel.add(pickStudentField);
        // back button
        JButton editUserDataBackButton = new JButton("back");
        editUserDataBackButton.addActionListener(e -> {
            editUserData.setVisible(false);
            // resets field text
            pickStudentField.setText("Which student ID would you like to edit?");
            mainMenu.setVisible(true);
        });
        editUserDataPanel.add(editUserDataBackButton);

        // text fields to modify user data
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
            // checks if studentID input is valid student number
            String input = pickStudentField.getText();
            try {
                int number = Integer.parseInt(input);
                if (Accounts.accountRepository.get(number) != null) {
                    // loads temporary account data in object, sets textBox name as current userID details
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

        // confirm account changes
        JButton modifyUserConfirmButton = new JButton("Confirm account changes");
        modifyUserConfirmButton.addActionListener(e -> {
            try {
                // checks if all entries are valid and can parse without breaking
                Account tempAccount = Accounts.accountRepository.get(Integer.parseInt(pickStudentField.getText()));
                int wins = Integer.parseInt(newWins.getText());
                int losses = Integer.parseInt(newLosses.getText());
                int ties = Integer.parseInt(newTies.getText());
                int rating = Integer.parseInt(newRating.getText());
                // if new name has no symbols or numbers, modify data
                if (Objects.equals(newName.getText(), newName.getText().replaceAll("[^a-zA-Z\\s]", ""))) {
                    tempAccount.changeName(newName.getText());
                }
                // if new password has any symbols or numbers, modify data
                if (Objects.equals(newPassword.getText(), newPassword.getText().replaceAll("[^a-zA-Z\\s]", ""))) {
                    tempAccount.changePassword(newPassword.getText());
                }

                // updates account data
                tempAccount.wins = wins;
                tempAccount.losses = losses;
                tempAccount.ties = ties;
                tempAccount.rating = rating;


                String tempString = tempAccount.toString();

                try {
                    // writes new account data to csv
                    FileHandling file = new FileHandling();
                    file.updateMembers(pickStudentField.getText(), tempString);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                // resets pickstudentfield text and visible menus
                modifyUser.setVisible(false);
                pickStudentField.setText("Which student ID would you like to edit?");
                mainMenu.setVisible(true);

            } catch (NumberFormatException ignored) {}

        });
        modifyUserPanel.add(modifyUserConfirmButton);

        // text to show order of account details
        JLabel newUserContext = new JLabel("The details are as follows: Name, password, wins, losses, ties, elo.");
        modifyUserPanel.add(newUserContext);

        accountMenu.setVisible(true);
    }
}
