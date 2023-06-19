package move;

import pieces.Piece;
import player.Player;
import board.Spot;

public class Move {

    private Player player;
    public Player getPlayer() {
        return player;
    }

    private Spot start;
    private Spot end;
    private Piece pieceMoved;
    public Piece getPieceMoved() {
        return pieceMoved;
    }

    public Piece getPieceKilled() {
        return pieceKilled;
    }

    private Piece pieceKilled;

    public Move(Player player, Spot start, Spot end) {
        this.player = player;
        this.start = start;
        this.end = end;
        this.pieceMoved = this.start.getPiece();
        this.pieceKilled = this.end.getPiece();
    }
    
}
