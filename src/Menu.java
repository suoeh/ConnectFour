import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Menu {
    public Menu() {}

    public boolean validateString(String string) {
        return !Objects.equals(string, string.replaceAll("\\p{Punct}", ""));
    }

    public boolean validateNumber(String string) {
        try {
            Integer.parseInt(string);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public void createAccount(String name, String studentNumber, String password) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/Accounts.csv", true));
        name = name.replaceAll("\\p{Punct}", "");
        int number = Integer.parseInt(studentNumber);
        Account account = new Account(name, number, password);
        Accounts.accountRepository.put(number, account);
        writer.newLine();
        writer.write(name + "," + studentNumber + "," + password + ",0,0,0,1000");
        writer.close();
    }

    public void login(int studentNumber, String password) {
        if (Accounts.accountRepository.get(studentNumber) == null) {return;}
        if (Objects.equals(password, Accounts.accountRepository.get(studentNumber).getPassword())){
            HomeScreen homeScreen = new HomeScreen(studentNumber);
            homeScreen.homeScreen();
        }
    }
}
