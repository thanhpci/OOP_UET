public class Bishop extends Piece {
    public Bishop(int x, int y) {
        super(x, y);
    }

    public Bishop(int x, int y, String color) {
        super(x, y, color);
    }

    public String getSymbol() {
        return "B";
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

        if (Math.abs(x - curX) != Math.abs(y - curY)) {
            return false;
        }

        int vectorX;
        int vectorY;

        if (curX < x) {
            vectorX = 1;
        } else {
            vectorX = -1;
        }

        if (curY < y) {
            vectorY = 1;
        } else {
            vectorY = -1;
        }

        for (int i = 1; i <= Math.abs(x - curX); i++) {
            int checkX = curX + vectorX * i;
            int checkY = curY + vectorY * i;
            
            if (board.getAt(checkX, checkY) != null && checkX != x && checkY != y) {
                return false;
            }
            if (board.getAt(checkX, checkY) != null && checkX == x && checkY == y) {
                Piece p = board.getAt(checkX, checkY);
                if (p.getColor().equals(this.getColor())) {
                    return false;
                }
            }
        }
        return true;


    }
}
