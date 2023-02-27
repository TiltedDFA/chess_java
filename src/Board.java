package src;
import java.lang.*;
import java.util.*;
public class Board {
    //taking bottom left to be A1
    private Piece[] m_pieces;
    private boolean m_whites_turn;
    //[White/Black][KingSide/QueenSide]
    private boolean[][] m_casteling;
    //-1 if no target, 0-63 if target
    private int m_en_peseant_target;
    private int m_num_half_moves;
    private int m_num_full_moves;


    Board(){
        m_pieces = new Piece[64];
        m_casteling  = new boolean[2][2];
    }
	public String toString(){
		String ReturnValue = new String();
		for(int row = 0; row < 8; row++){
			for(int col= 0; col < 8; col++){
				if(this.m_pieces[ ToIndex(new Cord(col,row)) ] == null){
					ReturnValue += '_';
				}
			}
		}
	}
    public void Init(){
        LoadFromFEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
    }
	public void Init(String FEN){
		LoadFromFEN(FEN);
	}
    private void MakePieceInstance(char fen,int BoardIndex){
        switch(fen){
            case 'k':
		        m_pieces[BoardIndex] = new Piece(PieceTypes.bk);
		        break;
        	case 'q':
                m_pieces[BoardIndex] = new Piece(PieceTypes.bq);
	    	    break;
	        case 'b':
		        m_pieces[BoardIndex] = new Piece(PieceTypes.bb);
		        break;
	        case 'n':
		        m_pieces[BoardIndex] = new Piece(PieceTypes.bn);
		        break;
	        case 'r':
		        m_pieces[BoardIndex] = new Piece(PieceTypes.br);
		        break;
	        case 'p':
	        	m_pieces[BoardIndex] = new Piece(PieceTypes.bp);
	        	break;
        	case 'K':
	        	m_pieces[BoardIndex] = new Piece(PieceTypes.wk);
	        	break;
	        case 'Q':
		        m_pieces[BoardIndex] = new Piece(PieceTypes.wq);
		        break;
	        case 'B':
		        m_pieces[BoardIndex] = new Piece(PieceTypes.wb);
		        break;
	        case 'N':
		        m_pieces[BoardIndex] = new Piece(PieceTypes.wn);
		        break;
	        case 'R':
		        m_pieces[BoardIndex] = new Piece(PieceTypes.wr);
		        break;
	        case 'P':
	        	m_pieces[BoardIndex] = new Piece(PieceTypes.wp);
		        break;
	        default:
	        	break;
        }
    }
    private void LoadFromFEN(String fen){
        final String[] fenBlocks = fen.split(" ");
        Cord BoardPosition = new Cord(8, 8);
        for(int i = 0; i < fenBlocks[0].length();i++){
            if(Character.isDigit(fenBlocks[0].charAt(i))){
                BoardPosition.XPos -= fenBlocks[0].charAt(i) - '0';
            }
            else if (fenBlocks[0].charAt(i) == '/'){
                BoardPosition.YPos--;
                BoardPosition.XPos = 8;
            }
            else{
                MakePieceInstance(fenBlocks[0].charAt(i), BoardPosition.ToIndex());
                BoardPosition.XPos--;
            }
        }
        m_whites_turn = fenBlocks[1].charAt(0) == 'w';

        m_casteling[0][0] = false;
        m_casteling[0][1] = false;
        m_casteling[1][0] = false;
        m_casteling[1][1] = false;
        for(int i = 0; i < fenBlocks[2].length();i++){
            switch(fenBlocks[2].charAt(i)){
                case 'K':
                    m_casteling[0][0] = true;
			        break;
		        case 'k':
                    m_casteling[1][0] = true;
	    		    break;
		        case 'Q':
                    m_casteling[0][1] = true;
			        break;
		        case 'q':
                    m_casteling[1][1] = true;
			        break;
		        default:
			        break;
            }
        }
        if (fenBlocks[3].charAt(0) == '-'){
	    	m_en_peseant_target = -1;
	    }
	    else{
		    final int colour_index = (fenBlocks[3].charAt(1) == 2) ? 8 : 48;
		    switch (fenBlocks[3].charAt(0))
		    {
		    case 'a':
                m_en_peseant_target = colour_index;
		    	break;
		    case 'b':
		    	m_en_peseant_target = colour_index + 1;
		    	break;
		    case 'c':
		    	m_en_peseant_target = colour_index + 2;
		    	break;
		    case 'd':
		    	m_en_peseant_target = colour_index + 3;
		    	break;
		    case 'e':
		    	m_en_peseant_target = colour_index + 4;
		    	break;
		    case 'f':
		    	m_en_peseant_target = colour_index + 5;
		    	break;
		    case 'g':
		    	m_en_peseant_target = colour_index + 6;
		    	break;
		    case 'h':
		    	m_en_peseant_target = colour_index + 7;
		    	break;
		    default:
		    	m_en_peseant_target = -1;
		    }
	    }
        m_num_half_moves = fenBlocks[4].charAt(0) - '0';
        m_num_full_moves = fenBlocks[5].charAt(0) - '0';
    }
	public List<Move> GenLegalMoves(int index){
		List<Move> ReturnValue = new ArrayList<Move>();

	}
	private List<Move> genBlackKingMoves(int index){
		List<Move> ReturnValue = new ArrayList<Move>();
		for
	}
	public static int ToIndex(Cord pos){
		return pos.ToIndex();
	}
}
