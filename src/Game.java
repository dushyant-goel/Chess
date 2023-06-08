import java.util.ArrayList;
import java.util.List;

public class Game {
    
    private Player[] players;
    private Board board;
    
    
    private Player currPlayer;
    private GameStatus status;
    private List<Move> movesPlayed;

    public Game() {
        this.players = new Player[2];
        this.board = new Board();
        this.movesPlayed = new ArrayList<>();
    }
    
    public Board getBoard() {
        return board;
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

        // Gotta move a piece, not empty air
        if(sourcePiece == null) {
            return false;
        }

        // Player may only move their pieces
        if(!this.currPlayer.isWhiteSide() == sourcePiece.isWhite()) {
            return false;
        }
        
        if(!sourcePiece.moveValid(board, start, end)){
            return false;
        }
        
        // If the move is valid, then the other colour's piece is killed.
        Piece destPiece = end.getPiece();
        if(destPiece != null) {
            destPiece.setKilled(true);
        }

        

        end.setPiece(sourcePiece);
        start.setPiece(null);

        Move move = new Move(currPlayer, start, end);
        movesPlayed.add(move);

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
       this.board.printBoard();
    }

}
