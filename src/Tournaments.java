import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Tournaments {
    public static ArrayList<Tournament> repository = new ArrayList<>();
    static int tourneyCounter = 0;
    public Tournaments(){
        repository = new ArrayList<>();
    }

    public ArrayList<Tournament> returnTourney() {
        return repository;
    }

}
