import java.util.Arrays;

public class Game {
    // game data
    public int gameID;
    public int playerOne;
    public int playerTwo;
    public int outcome;
    public String moves;
    public int tourneyID;

    // constructor !

    public Game(int playerOne, int playerTwo, int tourneyID){
        this.gameID = ++Games.gameCounter;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.outcome = 0;
        this.moves = "";
        this.tourneyID = tourneyID;
    }

    public Game(int playerOne, int playerTwo, int outcome, String moves, int tourneyID){
        this.gameID = ++Games.gameCounter;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.outcome = outcome;
        this.moves = moves;
        this.tourneyID = tourneyID;
    }

    @Override
    public String toString() {
        return playerOne + playerTwo + outcome + moves + tourneyID;
    }

    public void submit(){

    }
}
