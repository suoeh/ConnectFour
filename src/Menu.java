import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Menu {
    public Menu() {}

    // checks for whether a string is good or not for inputting user data, returns true for when a string is bad
    public boolean validateString(String string) {
        if (Objects.equals(string, "")) {return true;}
        return !Objects.equals(string, string.replaceAll("[^a-zA-Z\\s]", ""));
    }

    // returns whether a string can be parsed as an int/vice versa
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
        // process for writing new account from signup page, initializes writer
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/Accounts.csv", true));
        // cleans up name of punctuation
        name = name.replaceAll("\\p{Punct}", "");
        // parses data into text, uploads into csv as a line
        int number = Integer.parseInt(studentNumber);
        Account account = new Account(name, number, password);
        Accounts.accountRepository.put(number, account);
        writer.write("\n" + name + "," + studentNumber + "," + password + ",0,0,0,1000");
        writer.flush();
        writer.close();
    }
}
