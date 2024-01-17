import java.util.*;

public class SingleElim extends Tournament {
    // constructor
    public SingleElim(int[] roster, int size){
        super(roster, size);
    }

    @Override
    public Queue<Integer> createGames(){
        Queue<Integer> playerQueue = new LinkedList<>();
        if (size == 1) {
            return playerQueue;
        }

        Integer[] randomize = new Integer[size];

        for (int i = 0; i < size; i += 1) {
            randomize[i] = i;
        }

        List<Integer> tempList = Arrays.asList(randomize);
        Collections.shuffle(tempList);
        tempList.toArray(randomize);

        for (int i = 0; i < size; i += 1) {
            playerQueue.add(roster[randomize[i]]);
        }

        return playerQueue;
    }
}
