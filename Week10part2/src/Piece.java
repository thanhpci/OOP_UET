public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color = "white";

    /**
     * Method.
     */
    public Piece(int x, int y) {
        this.coordinatesX = x;
        this.coordinatesY = y;
    }

    /**
     * Method.
     */
    public Piece(int x, int y, String color) {
        this.coordinatesX = x;
        this.coordinatesY = y;
        this.color = color;
    }

    public int getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract String getSymbol();

    public abstract boolean canMove(Board board, int x, int y);

    /**
     * Method.
     */
    public boolean checkPosition(Piece other) {
        return  (this.getCoordinatesX() == other.getCoordinatesX()
                    && this.getCoordinatesY() == other.getCoordinatesY());
    }

}
