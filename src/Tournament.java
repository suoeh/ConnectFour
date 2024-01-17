import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Tournament {
    // variables
    public static ArrayList<Game> repository = new ArrayList<>();
    public int tourneyID;
    // array of arrays that stores student number, wins, losses, ties
    public int[] roster;
    public int size;
    public int[] games;

    // constructor !
    public Tournament(int[] roster, int size) {
        this.tourneyID = ++Tournaments.tourneyCounter;
        this.roster = roster;
        this.size = size;
    }

    public Tournament(int[] roster, int size, int[] games) {
        this.tourneyID = ++Tournaments.tourneyCounter;
        this.roster = roster;
        this.size = size;
        this.games = games;
    }

    // overwritten method
    public Queue<Integer> createGames(){
        return null;
    }

    public String toString() {
        String tempString = Arrays.toString(roster);
        String tempString2 = Arrays.toString(games);
        tempString = tempString.replace("[", ""); // removes the opening bracket
        tempString = tempString.replace("]", ""); // removes the closing bracket
        tempString = tempString.replace(",", "");

        tempString2 = tempString2.replace("[", ""); // removes the opening bracket
        tempString2 = tempString2.replace("]", ""); // removes the closing bracket
        tempString2 = tempString2.replace(",", "");
        return tempString + "," + tempString2;
    }

}
