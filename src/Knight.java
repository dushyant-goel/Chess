public class Knight extends Piece{

    public Knight(boolean white) {
        super(white);
    }

    @Override
    public boolean moveValid(Board board, Spot start, Spot end) {
        
        if(end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }

        int x = Math.abs(end.getX() - start.getX());
        int y = Math.abs(end.getY() - start.getY());

        if((x == 1 && y == 2) || (x == 2 && y == 2)) {
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
 
        return result += "Kn";
    }
    
}
