import java.util.ArrayList;
import java.util.Queue;

public class Tournament {
    // variables
    public static ArrayList<Game> repository = new ArrayList<>();
    public int tourneyID;
    // array of arrays that stores student number, wins, losses, ties
    public int[] roster;
    public int size;
    public int winner;

    // constructor !
    public Tournament(int[] roster, int size) {
        this.tourneyID = ++Tournaments.tourneyCounter;
        this.roster = roster;
        this.size = size;
        this.winner = -1;
    }

    // overwritten method
    public Queue<Integer> createGames(){
        return null;
    }

}
