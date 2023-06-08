import java.util.List;


public class Game {
    
    private Player[] players;
    private Board board;
    
    public Board getBoard() {
        return board;
    }

    private Player currPlayer;
    
    private GameStatus status;
    private List<Move> movesPlayed;
    
    public Game() {
        this.players = new Player[2];
        this.board = new Board();
    }

    public void startGame(Player p1, Player p2) {
        players[0] = p1;
        players[1] = p2;
        board.startBoard();
        
        if(p1.isWhiteSide()) {
            this.currPlayer = p1;
        }
        else {
            this.currPlayer = p2;
        }

        this.setStatus(GameStatus.ACTIVE);
    }
    
    public GameStatus getStatus() {
        return status;
    }
    
    public void setStatus(GameStatus status) {
        this.status = status;
    }
    
    public Player getCurrPlayer() {
        return currPlayer;
    }
    
    public boolean playerMove(int startX, int startY, int endX, int endY) {
        
        Spot start = board.spots[startX][startY];
        Spot end = board.spots[endX][endY];
        Piece sourcePiece = start.getPiece();

        if(!this.currPlayer.isWhiteSide() == sourcePiece.isWhite()) {
            return false;
        }
        
        if(!sourcePiece.moveValid(board, start, end)){
            return false;
        }
        
        Piece destPiece = end.getPiece();
        if(destPiece != null) {
            destPiece.setKilled(true);
        }

        end.setPiece(sourcePiece);
        start.setPiece(null);

        if(destPiece instanceof King) {

            if(this.currPlayer.isWhiteSide()) {
                this.setStatus(GameStatus.WHITEWIN);
            }
            else {
                this.setStatus(GameStatus.BLACKWIN);
            }
        }

        if(this.currPlayer == this.players[0]) {
            this.currPlayer = this.players[1];
        }
        else {
            this.currPlayer = this.players[0];
        }

        return true;
    }

    public void printBoard() {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                Piece piece = this.board.spots[i][j].getPiece();

                String out = "";

                if(piece == null) {
                    out += "___";
                }
                else {
                    out += piece.getPieceString();
                }

                System.out.print(out + " ");
            }
            System.out.println("\n");
        }
    }

}
