public class Pawn extends Piece{

    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public boolean moveValid(Board board, Spot start, Spot end) {
        if(end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }

        int x = end.getX() - start.getX();
        int y = Math.abs(end.getY() - start.getY());

        if(y > 1) return false;
        
        // if moving diagonally, it must kill
        // if moving straight, spot must be free
        if(this.isWhite() && x == -1) {
            if(y != 0) {
                return end.getPiece() != null && !end.getPiece().isWhite();
            }
            else {
                return end.getPiece() == null;
            }
        }
        else if(x == 1) {
            if(y != 0) {
                return end.getPiece() != null && end.getPiece().isWhite();
            }
            else {
                return end.getPiece() == null;
            }

        }
        
        return false;
    }

    @Override
    public String getPieceString() {
        String result = "";
       if(this.isWhite()) {
        result += "W";
       }
       else {
        result += "B";
       }

       return result += "Pw";
    }
    
}
