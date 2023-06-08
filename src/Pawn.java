public class Pawn extends Piece{

    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public boolean moveValid(Board board, Spot start, Spot end) {
        if(end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }

        int x = Math.abs(end.getX() - start.getX());
        int y = end.getY() - start.getY();
        
        if(x == 1) {
            if(this.isWhite() && y == -1) {
                return true;
            }
            else if(y == 1) {
                return true;
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
