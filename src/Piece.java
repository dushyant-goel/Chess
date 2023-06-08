public abstract class Piece {
    private boolean killed = false;
    private boolean white = false;

    public Piece(boolean white) {
        this.setWhite(white);
    }
    
    public boolean isWhite() {
        return this.white == true;
    }
    
    private void setWhite(boolean white) {
        this.white = white;
    }


    public boolean isKilled() {
        return this.killed == true;
    }

    public void setKilled(boolean killStatus) {
        this.killed = killStatus;
    }

    public abstract boolean moveValid(Board board, Spot start, Spot end);
    public abstract String getPieceString();
}
