import java.util.Arrays;

public class Game {
    // game data
    public int gameID;
    public int playerOne;
    public int playerTwo;
    public int outcome;
    public int tourneyID;

    // constructor ! default constructor for initializing new game

    public Game(int playerOne, int playerTwo, int tourneyID){
        this.gameID = ++Games.gameCounter;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.outcome = 0;
        this.tourneyID = tourneyID;
    }

    // overridden constructor for storing games from a csv

    public Game(int playerOne, int playerTwo, int outcome, int tourneyID){
        // manually sets game counter for current object by moving static variable to smallest unoccupied gameID
        this.gameID = ++Games.gameCounter;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.outcome = outcome;
        this.tourneyID = tourneyID;
    }

    // cool and awesome toString function :D
    @Override
    public String toString() {
        return playerOne + "," + playerTwo + "," + outcome + "," + tourneyID;
    }

}
