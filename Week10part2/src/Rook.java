public class Rook extends Piece {
    public Rook(int x, int y) {
        super(x, y);
    }

    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    public String getSymbol() {
        return "R";
    }

    /**
     * Method.
     */
    public boolean canMove(Board board, int x, int y) {
        if (!board.validate(x, y)) {
            return false;
        }

        int curX = this.getCoordinatesX();
        int curY = this.getCoordinatesY();

        if (curX == x && curY != y) {       //Di chuyen theo truc x
            int maxY = Math.max(curY, y);
            int minY = Math.min(curY, y);

            for (int i = minY; i <= maxY; i++) {
                if (i == curY) {
                    continue;
                }
                if (board.getAt(x, i) != null && i != y) {
                    return false;
                }
                if (board.getAt(x, i) != null && i == y) {
                    Piece pieceHere = board.getAt(x, i);
                    if (pieceHere.getColor().equals(this.getColor())) {
                        return false;
                    }
                }
            }
            return true;

        } else if (curX != x && curY == y) {        //Di chuyen theo truc y
            int maxX = Math.max(curX, x);
            int minX = Math.min(curX, x);

            for (int i = minX; i <= maxX; i++) {
                if (i == curX) {
                    continue;
                }
                if (board.getAt(i, y) != null && i != x) {
                    return false;
                }
                if (board.getAt(i, y) != null && i == x) {
                    Piece pieceHere = board.getAt(i, y);
                    if (pieceHere.getColor().equals(this.getColor())) {
                        return false;
                    }
                }
            }
            return true;


        } else {
            return false;
        }
    }
}
