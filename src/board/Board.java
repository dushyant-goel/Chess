package board;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class Board {
    public Spot[][] spots;

    public Board() {
        this.startBoard();
    }

    public void startBoard() {
        this.spots = new Spot[8][8];

        //Setting up white pieces
        spots[0][0] = new Spot(0, 0, new Rook(false));
        spots[0][1] = new Spot(0, 1, new Knight(false));
        spots[0][2] = new Spot(0, 2, new Bishop(false));
        spots[0][3] = new Spot(0, 3, new Queen(false));
        spots[0][4] = new Spot(0, 4, new King(false));
        spots[0][5] = new Spot(0, 5, new Bishop(false));
        spots[0][6] = new Spot(0, 6, new Knight(false));
        spots[0][7] = new Spot(0, 7, new Rook(false));

        for(int i = 0; i < 8; i++) {
            spots[1][i] = new Spot(1, i, new Pawn(false));
        }        

        //Setting up black pieces
        spots[7][0] = new Spot(7, 0, new Rook(true));
        spots[7][1] = new Spot(7, 1, new Knight(true));
        spots[7][2] = new Spot(7, 2, new Bishop(true));
        spots[7][3] = new Spot(7, 3, new Queen(true));
        spots[7][4] = new Spot(7, 4, new King(true));
        spots[7][5] = new Spot(7, 5, new Bishop(true));
        spots[7][6] = new Spot(7, 6, new Knight(true));
        spots[7][7] = new Spot(7, 7, new Rook(true));

        for(int i = 0; i < 8; i++) {
            spots[6][i] = new Spot(6, i, new Pawn(true));
        }

        // Setting up other pieces
        for(int i = 2; i <= 5; i++) {
            for(int j = 0; j < 8; j++) {
                spots[i][j] = new Spot(i, j, null);
            }
        }
    }

    public void printBoard() {
        System.out.print("   ");
        for(int j = 0; j < 8; j++) {
            System.out.print("" + j + "   ");
        }
        System.out.println();
        
        for(int i = 0; i < 8; i++) {
            System.out.print("" + i + ": ");
            for(int j = 0; j < 8; j++) {
                Piece piece = this.spots[i][j].getPiece();

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
