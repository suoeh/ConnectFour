import java.util.Arrays;

public class Game {
    // game data
    public int gameID;
    public int playerOne;
    public int playerTwo;
    public int outcome;
    public int tourneyID;

    // constructor !

    public Game(int playerOne, int playerTwo, int tourneyID){
        this.gameID = ++Games.gameCounter;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.outcome = 0;
        this.tourneyID = tourneyID;
    }

    public Game(int playerOne, int playerTwo, int outcome, int tourneyID){
        this.gameID = ++Games.gameCounter;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.outcome = outcome;
        this.tourneyID = tourneyID;
    }

    @Override
    public String toString() {
        return playerOne + "," + playerTwo + "," + outcome + "," + tourneyID;
    }

    public void submit(){

    }
}
