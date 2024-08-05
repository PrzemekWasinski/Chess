public class King {
    private String icon;
    private int value;
    private int positionRow;
    private int positionColumn;

    King(String icon, int value, int positionRow, int positionColumn) {
        this.icon = icon;
        this.value = value;
        this.positionRow = positionRow;
        this.positionColumn = positionColumn;
    }

    void move(String[][] board, int destinationRow, int destinationColumn) {
        destinationRow -= 1;
        destinationColumn -= 1;
        if (destinationRow > this.positionRow + 1 || destinationColumn > this.positionColumn + 1 ||
            destinationRow < this.positionRow - 1 || destinationColumn < this.positionColumn - 1 ||
            destinationRow > 7 || destinationRow < 0 || destinationColumn > 7 || destinationColumn < 0 ||
            board[destinationRow][destinationColumn].charAt(0) == this.icon.charAt(0) ||
            board[destinationRow][destinationColumn].charAt(1) == 'K') {
            System.out.println("Invalid move");
        } else {
            board[this.positionRow][this.positionColumn] = "00";
            this.positionRow = destinationRow;
            this.positionColumn = destinationColumn;
            board[destinationRow][destinationColumn] = this.icon;
        }
    }

    public String getIcon() {
        return icon;
    }

    public int getValue() {
        return value;
    }

    public int getPositionRow() {
        return positionRow;
    }

    public int getPositionColumn() {
        return positionColumn;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}