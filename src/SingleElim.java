import java.util.ArrayList;
import java.util.Collections;

public class SingleElim extends Tournament {
    // constructor
    public SingleElim(int[][] roster, int size){
        super(roster, size);
    }

    @Override
    public ArrayList<Pair> createGames(int[][] roster, int size){
        if (size == 1) {
            return null;
        }

        ArrayList<Pair> games = new ArrayList<>();
        double amount = Math.log(size)/Math.log(2);
        int pairings = (int) Math.ceil(amount);
        for (int i = 0; i < amount; i += 2) {
            int playerOne;
            int playerTwo;

            if (i >= size) {
                playerOne = -1;
            } else {
                playerOne = roster[i][0];
            }

            if ((i + 1) >= size) {
                playerTwo = -1;
            } else {
                playerTwo = roster[i + 1][0];
            }

            Pair pair = new Pair(playerOne, playerTwo);
            games.add(pair);
        }
        Collections.shuffle(games);
        return games;
    }
}
