import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Menu {
    public Menu() {}

    public boolean validateString(String string) {
        if (Objects.equals(string, "")) {return true;}
        return !Objects.equals(string, string.replaceAll("[^a-zA-Z\\s]", ""));
    }

    public boolean validateNumber(String string) {
        if (Objects.equals(string, "")) {return true;}
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
        writer.write("\n" + name + "," + studentNumber + "," + password + ",0,0,0,1000");
        writer.flush();
        writer.close();
    }
}
