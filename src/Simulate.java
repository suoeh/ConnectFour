public class Simulate {
    public int playerOne;
    public int playerTwo;
    public int outcome;
    public int[][] field;
    public String moves;
    public int tourneyID;

    // constructor !
    public Simulate(int playerOne, int playerTwo, int tourneyID){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.outcome = 0;
        this.field = new int[7][6];
        this.moves = "";
        this.tourneyID = tourneyID;
    }

    public void endGame(){
        Game game = new Game(playerOne, playerTwo, outcome, moves, tourneyID);
        Games.repository.add(game);
    }
}
