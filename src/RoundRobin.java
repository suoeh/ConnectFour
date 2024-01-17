import java.util.LinkedList;
import java.util.Queue;

public class RoundRobin extends Tournament {
    // constructor
    public RoundRobin(int[] roster, int size){
        super(roster, size);
    }

    @Override
    public Queue<Integer> createGames(){
        Queue<Integer> gameQueue = new LinkedList<>();
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
