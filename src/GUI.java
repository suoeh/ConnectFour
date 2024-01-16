import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Objects;

public class GUI {

    public GUI() {
        int mode = -1;

        JFrame accountMenu = new JFrame("Connect 4!");
        JFrame signIn = new JFrame("Sign in");
        JFrame mainMenu = new JFrame("Welcome :D");

        accountMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton accountMenuSignInButton = new JButton("Sign in");
        JTextField signInText1 = new JTextField("Name", 20);
        JTextField signInText2 = new JTextField("Student number", 20);
        JTextField signInText3 = new JTextField("Password", 20);
        JButton signInBackButton = new JButton("Back");
        JButton signInLogInButton = new JButton("Log in");
        JButton signInSignUpButton = new JButton("Sign up");
        JLabel signInErrorLabel = new JLabel("");

        accountMenuSignInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                accountMenu.setVisible(false);
                signIn.setVisible(true);
                signInErrorLabel.setText("");
            }
        });

        signInBackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signIn.setVisible(false);
                accountMenu.setVisible(true);
                signInErrorLabel.setText("");
                signInText1.setText("Name");
                signInText2.setText("Student number");
                signInText3.setText("Password");
            }
        });
        signInLogInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
                if (menu.validateNumber(signInText2.getText()) || menu.validateString(signInText3.getText())) {
                    signInErrorLabel.setText("Invalid password/student number");
                } else if (!Objects.equals(signInText3.getText(), Accounts.accountRepository.get(Integer.parseInt(signInText2.getText())).getPassword())) {
                    signInErrorLabel.setText("Wrong password!");
                } else if (Accounts.accountRepository.get(Integer.parseInt(signInText2.getText())) == null) {
                    signInErrorLabel.setText("Student ID doesn't exist");
                } else {
                    try {
                        menu.createAccount(signInText1.getText(),signInText2.getText(),signInText3.getText());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    signIn.setVisible(false);
                    mainMenu.setTitle("Welcome " + signInText1.getText());
                    mainMenu.setVisible(true);
                    signInErrorLabel.setText("");
                    signInText1.setText("Name");
                    signInText2.setText("Student number");
                    signInText3.setText("Password");
                };
            }
        });
        signInSignUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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

                    signIn.setVisible(false);
                    mainMenu.setTitle("Welcome " + signInText1.getText());
                    mainMenu.setVisible(true);
                    signInErrorLabel.setText("");
                    signInText1.setText("Name");
                    signInText2.setText("Student number");
                    signInText3.setText("Password");
                };
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

        JFrame changePassword = new JFrame("Change password");
        changePassword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        changePassword.setSize(800, 600);
        changePassword.setLocationRelativeTo(null);

        JFrame logOut = new JFrame("Log out");
        logOut.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logOut.setSize(800, 600);
        logOut.setLocationRelativeTo(null);

        JButton mainMenuHowToPlayButton = new JButton("How to Play");
        JButton mainMenuPlayAgainstOpponentButton = new JButton("Play Against Opponent");
        JButton mainMenuViewStatsButton = new JButton("View Stats");
        JButton mainMenuCreateTournamentButton = new JButton("Create Tournament");
        JButton mainMenuEditUserDataButton = new JButton("Edit User Data");
        JButton mainMenuChangePasswordButton = new JButton("Change Password");
        JButton mainMenuLogOutButton = new JButton("Log Out");

        mainMenuPanel.add(mainMenuHowToPlayButton);
        mainMenuPanel.add(mainMenuPlayAgainstOpponentButton);
        mainMenuPanel.add(mainMenuViewStatsButton);
        mainMenuPanel.add(mainMenuCreateTournamentButton);
        mainMenuPanel.add(mainMenuEditUserDataButton);
        mainMenuPanel.add(mainMenuChangePasswordButton);
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
            mainMenu.setVisible(false);
            createTournament.setVisible(true);
        });

        mainMenuEditUserDataButton.addActionListener(e -> {
            mainMenu.setVisible(false);
            editUserData.setVisible(true);
        });

        mainMenuChangePasswordButton.addActionListener(e -> {
            mainMenu.setVisible(false);
            changePassword.setVisible(true);
        });

        mainMenuLogOutButton.addActionListener(e -> {
            mainMenu.setVisible(false);
            accountMenu.setVisible(true);
        });

        JPanel howToPlayPanel = new JPanel();
        JPanel playAgainstOpponentPanel = new JPanel();
        JPanel viewStatsPanel = new JPanel();
        JPanel createTournamentPanel = new JPanel();
        JPanel editUserDataPanel = new JPanel();
        JPanel changePasswordPanel = new JPanel();
        JPanel logOutPanel = new JPanel();

        howToPlay.add(howToPlayPanel);
        playAgainstOpponent.add(playAgainstOpponentPanel);
        viewStats.add(viewStatsPanel);
        createTournament.add(createTournamentPanel);
        editUserData.add(editUserDataPanel);
        changePassword.add(changePasswordPanel);
        logOut.add(logOutPanel);

        accountMenu.setVisible(true);
    }

}