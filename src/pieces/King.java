package pieces;

import board.Board;
import board.Spot;

public class King extends Piece{

    public King(boolean white) {
        super(white);
    }

    @Override
    public boolean moveValid(Board board, Spot start, Spot end) {
        
        if(end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }

        int x = Math.abs(end.getX() - start.getX());
        int y = Math.abs(end.getY() - start.getY());

        if(x < 2 && y < 2 && x+y > 0) {
            return true;
        }

        return false;
    }

    @Override
    public String getPieceString() {
        String result = "";
        if(isWhite()) {
         result += "W";
        }
        else {
         result += "B";
        }
 
        return result += "Ki";
    }
    
    
}
