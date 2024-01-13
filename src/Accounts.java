import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Accounts {
    public static HashMap<Integer, Account> accountRepository; // stored student number
    public Accounts(){}
    public Account getUser(int studentNumber) {
        return accountRepository.get(studentNumber);
    }

    public ArrayList<Account> sortAccounts(int index) {
        // upload accounts to array
        ArrayList<Account> tempList = new ArrayList<>(accountRepository.values());
        // sort
        switch (index) {
            case 1 -> tempList.sort(Comparator.comparing(o -> o.name));
            case 2 -> tempList.sort(Comparator.comparing(o -> o.studentNumber));
            case 3 -> tempList.sort(Comparator.comparing(o -> o.wins));
            case 4 -> tempList.sort(Comparator.comparing(o -> o.losses));
            case 5 -> tempList.sort(Comparator.comparing(o -> o.rating));
        }

        return tempList;
    }

}
