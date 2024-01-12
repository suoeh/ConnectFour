import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Accounts {
    public HashMap<Integer, Account> Accounts; // stored student number

    public Account getUser(int studentNumber) {
        return Accounts.get(studentNumber);
    }

    public ArrayList<Account> sortAccounts(int index) {
        // upload accounts to array
        ArrayList<Account> repository = new ArrayList<>(Accounts.values());

        // sort
        switch (index) {
            case 1 -> repository.sort(Comparator.comparing(o -> o.name));
            case 2 -> repository.sort(Comparator.comparing(o -> o.studentNumber));
            case 3 -> repository.sort(Comparator.comparing(o -> o.wins));
            case 4 -> repository.sort(Comparator.comparing(o -> o.losses));
            case 5 -> repository.sort(Comparator.comparing(o -> o.rating));
        }

        return repository;
    }

}
