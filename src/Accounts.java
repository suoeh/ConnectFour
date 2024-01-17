import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Accounts {
    // account repository, saves by integer to account hashmap, allows constant time account check/getter
    public static HashMap<Integer, Account> accountRepository;

    // constructor !
    public Accounts(){
        accountRepository = new HashMap<>();
    }
}
