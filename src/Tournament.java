import java.util.ArrayList;

public class Tournament {
    // variables
    public static ArrayList<Game> repository = new ArrayList<>();
    public int tourneyID;
    // array of arrays that stores student number, wins, losses, ties
    public int[][] roster;
    public int size;

    // constructor !
    public Tournament(int[][] roster, int size) {
        this.tourneyID = ++Tournaments.tourneyCounter;
        this.roster = roster;
        this.size = size;
    }

    // overwritten method
    public ArrayList<Pair> createGames(int[][] roster, int size){
        return null;
    }

}
