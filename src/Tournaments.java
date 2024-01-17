import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// big class to store tournament objects
public class Tournaments {
    // arraylist to store tourneys
    public static ArrayList<Tournament> repository = new ArrayList<>();
    // tournament counter to ensure smooth id checking
    static int tourneyCounter = 0;

    // constructor!!!
    public Tournaments(){
        repository = new ArrayList<>();
    }

}
