public class Move {
    public Cord StartPos;
    public Cord EndPos;
    public PieceTypes PieceType;
    Move(){
        this.StartPos = new Cord();
        this.EndPos = new Cord();
        this.PieceType = PieceTypes.nul;
    }
    Move(Cord StartPos, Cord EndPos, PieceTypes PieceType){
        this.StartPos = new Cord(StartPos);
        this.EndPos = new Cord(EndPos);
        this.PieceType = PieceType;
    }
    public static boolean IsLegalIndex(int index){
        return index > 0 && index < 64;
    }
    public static final int[] KingMoves = {-9,-8,-7,-1,1,7,8,9};
    public static final int[] QueenMoves = {-9,-8,-7,-1,1,7,8,9};
    public static final int[] BishopMoves = {-9,-7,7,9};
    public static final int[] KnightMoves = {-17,-15,-10,-6,6,10,15,17};
    public static final int[] RookMoves = {8,1,-8,-1};
    public static final int[] PawnMoves = {8,16};
}
