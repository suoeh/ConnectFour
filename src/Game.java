public class Game {
    // game data
    public int gameID;
    public int playerOne;
    public int playerTwo;
    public int outcome;
    public int[] field;
    public String moves;
    public int tourneyID;

    // constructor !
    public Game(int playerOne, int playerTwo, int outcome, int[] field, String moves, int tourneyID){
        this.gameID = Games.gameCounter++;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.outcome = outcome;
        this.field = field;
        this.moves = moves;
        this.tourneyID = tourneyID;
    }

}
