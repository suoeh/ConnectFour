import java.util.ArrayList;
import java.util.Collections;

public class RoundRobin extends Tournament {
    // constructor
    public RoundRobin(int[][] roster, int size){
        super(roster, size);
    }

    @Override
    public ArrayList<Pair> createGames(int[][] roster, int size){
        ArrayList<Pair> games = new ArrayList<>();
        for (int i = 0;i < size;i++) {
            for (int j = i + 1;j < size; j++) {
                Pair pair = new Pair(roster[i][0], roster[j][0]);
                games.add(pair);
            }
        }
        Collections.shuffle(games);
        return games;
    }
}
