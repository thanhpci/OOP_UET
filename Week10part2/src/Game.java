import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory;

    public Game(Board board) {
        this.board = board;
        moveHistory = new ArrayList<Move>();
    }

    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Move> getMoveHistory() {
        return this.moveHistory;
    }

    /**
     * Method.
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece !=  null && piece.canMove(board, x, y)) {
            Move moveP = new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y, piece);
            if (board.getAt(x, y) != null) {
                moveP.setKilledPiece(board.getAt(x, y));
                board.removeAt(x, y);
            }
            moveHistory.add(moveP);
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
        }
    }
}