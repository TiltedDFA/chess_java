
public class Piece {
    private PieceTypes m_piece_type;
    public Piece(){
        m_piece_type = null;
    }
    public Piece(PieceTypes pt){
        m_piece_type = pt;
    }
    public PieceTypes GetPieceType(){
        return m_piece_type;
    }
}
