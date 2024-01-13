import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Menu {
    BufferedWriter writer = new BufferedWriter(new FileWriter("Accounts.csv"));
    public Menu() throws IOException {}

    // implement menu gui

    public boolean validatePassword(String password) {
        if (password.length() < 8) {return false;}
        return Objects.equals(password, password.replaceAll("\\p{Punct}", ""));
    }

    public void createAccount(String name, String password) throws IOException {
        name = name.replaceAll("\\p{Punct}", "");
        int studentNumber = (int) (Math.random() * 1000000);
        while (Accounts.accountRepository.get(studentNumber) == null) {
            studentNumber = (int) (Math.random() * 1000000);
        }
        Account account = new Account(name, studentNumber, password);
        Accounts.accountRepository.put(studentNumber, account);
        writer.newLine();
        writer.write(name + "," + studentNumber + "," + password + ",0,0,1000");
    }

    public void login(int studentNumber, String password) {
        if (Accounts.accountRepository.get(studentNumber) == null) {return;}
        if (Objects.equals(password, Accounts.accountRepository.get(studentNumber).getPassword())){
            HomeScreen homeScreen = new HomeScreen(studentNumber);
            homeScreen.homeScreen();
        }
    }



}
