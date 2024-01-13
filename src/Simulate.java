public class Simulate {
    public int playerOne;
    public int playerTwo;
    public int outcome = 0;
    public int[] field = new int[7];
    public String moves;
    public int tourneyID;

    // constructor !
    public Simulate(int playerOne, int playerTwo, int tourneyID){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.outcome = 0;
        this.field = new int[7];
        this.moves = "";
        this.tourneyID = tourneyID;
    }
}
