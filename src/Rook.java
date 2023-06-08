public class Rook extends Piece{

    public Rook(boolean white) {
        super(white);
        
    }

    @Override
    public boolean moveValid(Board board, Spot start, Spot end) {
       
        if(end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }

        int x = Math.abs(end.getX() - start.getX());
        int y = Math.abs(end.getY() - start.getY());

        if((x > 0 && y == 0) || (x == 0 && y > 0)) {
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

       return result += "Rk";
    }
    
}
