public class Rook extends Piece{

    public Rook(boolean white) {
        super(white);
        
    }

    @Override
    public boolean moveValid(Board board, Spot start, Spot end) {
       
        if(end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }
        
        int x = Math.abs(end.getX() - start.getX());
        int y = Math.abs(end.getY() - start.getY());

        if(x > 0 && y == 0) {
            int startX = start.getX();
            int endX = end.getX();
            int Y = start.getY();    
            
            for(int X = Math.min(startX, endX)+1; X < Math.max(startX, endX); X++) {
                if(board.spots[X][Y].getPiece() != null) {
                    return false;
                }
            }

            return true;
        }
        else if(x == 0 && y > 0) {
            int startY = start.getY();
            int endY = end.getY();
            int X = start.getX();

            for(int Y = Math.min(startY, endY); Y <= Math.max(startY, endY); Y++) {
                if(board.spots[X][Y].getPiece() != null) {
                    return false;
                }
            }
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
