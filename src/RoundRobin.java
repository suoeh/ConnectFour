import java.util.LinkedList;
import java.util.Queue;

public class RoundRobin extends Tournament {
    // constructor! extended class from tournament
    public RoundRobin(int[] roster, int size){
        super(roster, size);
    }

    // round-robin game formatting
    // creates a queue with all possible pairings so everyone faces everyone else exactly once
    // gameQueue processes two players at once per game, the first processed player will be player one
    @Override
    public Queue<Integer> createGames(){
        Queue<Integer> gameQueue = new LinkedList<>();
        // 0(n^2) loop to brute force all pairs, randomizes turn order by randomizing order of queue upload
        for (int i = 0;i < size;i++) {
            for (int j = i + 1;j < size; j++) {
                if (Math.random() >= 0.5) {
                    gameQueue.add(roster[j]);
                    gameQueue.add(roster[i]);
                } else {
                    gameQueue.add(roster[i]);
                    gameQueue.add(roster[j]);
                }
            }
        }
        return gameQueue;
    }
}
