import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces;


    public Board() {
        this.pieces = new ArrayList<Piece>();
    }


    /**
     * Method.
     */
    public boolean validate(int x, int y) {
        if (x >= 1 && x <= 8 && y >= 1 && y <= 8) {
            return true;
        }
        return false;
    }


    /**
     * Method.
     */
    public void addPiece(Piece piece) {
        int x = piece.getCoordinatesX();
        int y = piece.getCoordinatesY();

        if (validate(x, y) && getAt(x, y) == null) {
            pieces.add(piece);
        }
    }

    /**
     * Method.
     */
    public Piece getAt(int x, int y) {
        if (!pieces.isEmpty()) {
            for (Piece p : pieces) {
                if (p.getCoordinatesX() == x && p.getCoordinatesY() == y) {
                    return p;
                }
            }
        }
        return null;
    }


    /**
     * Method.
     */
    public void removeAt(int x, int y) {
        Piece piece = getAt(x, y);
        if (piece != null) {
            pieces.remove(piece);
        }
    }


    /**
     * Method.
     */
    public ArrayList<Piece> getPieces() {
        return this.pieces;
    }

    /**
     * Method.
     */
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }


}
