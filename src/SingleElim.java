import java.util.*;

public class SingleElim extends Tournament {
    // constructor
    public SingleElim(int[] roster, int size){
        super(roster, size);
    }

    // overwritten create game functions, pairs all players with each other and randomizes turn order
    // supposed plan was to recursively complete process by making a new list using the winners/tied players of the preivous list for bracket formatting
    @Override
    public Queue<Integer> createGames(){
        // initializes new list
        Queue<Integer> playerQueue = new LinkedList<>();
        // base case
        if (size == 1) {
            return playerQueue;
        }

        // array of integers to randomize to determine roster upload order
        Integer[] randomize = new Integer[size];
        for (int i = 0; i < size; i += 1) {
            randomize[i] = i;
        }

        // converts array to list to shuffle, reconverted
        List<Integer> tempList = Arrays.asList(randomize);
        Collections.shuffle(tempList);
        tempList.toArray(randomize);

        // picks player to upload to queue based off of random order
        for (int i = 0; i < size; i += 1) {
            playerQueue.add(roster[randomize[i]]);
        }

        return playerQueue;
    }
}
