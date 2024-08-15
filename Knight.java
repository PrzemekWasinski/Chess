public class Knight {
    private String icon;
    private String enemy;
    private int value;
    private int positionRow;
    private int positionColumn;

    Knight(String icon, String enemy, int value, int positionRow, int positionColumn) {
        this.icon = icon;
        this.enemy = enemy;
        this.value = value;
        this.positionRow = positionRow;
        this.positionColumn = positionColumn;
    }

    void move(String[][] board, int destinationRow, int destinationColumn) {
        destinationRow -= 1;
        destinationColumn -= 1;
        if (destinationRow > 7 || destinationRow < 0 || destinationColumn > 7 || destinationColumn < 0 ||
            board[destinationRow][destinationColumn].charAt(0) == this.icon.charAt(0) ||
            board[destinationRow][destinationColumn].charAt(1) == 'K') {
            System.out.println("Invalid move");
        } else {
            int[][] availableMoves = new int[8][2];

            availableMoves[0][0] = this.positionRow + 1;
            availableMoves[0][1] = this.positionColumn + 2;

            availableMoves[1][0] = this.positionRow + 1;
            availableMoves[1][1] = this.positionColumn - 2;

            availableMoves[2][0] = this.positionRow - 1;
            availableMoves[2][1] = this.positionColumn + 2;

            availableMoves[3][0] = this.positionRow - 1;
            availableMoves[3][1] = this.positionColumn - 2;

            availableMoves[4][0] = this.positionRow + 2;
            availableMoves[4][1] = this.positionColumn + 1;

            availableMoves[5][0] = this.positionRow + 2;
            availableMoves[5][1] = this.positionColumn - 1;

            availableMoves[6][0] = this.positionRow - 2;
            availableMoves[6][1] = this.positionColumn + 1;

            availableMoves[7][0] = this.positionRow - 2;
            availableMoves[7][1] = this.positionColumn - 1;

            boolean legalMove = false;
            for (int i = 0; i < availableMoves.length; i++) {
                if (availableMoves[i][0] == destinationRow) {
                    if (availableMoves[i][1] == destinationColumn) {
                        legalMove = true;
                        break;
                    }
                }
            }
            if (legalMove) {
                board[this.positionRow][this.positionColumn] = "000";
                this.positionRow = destinationRow;
                this.positionColumn = destinationColumn;
                board[destinationRow][destinationColumn] = this.icon;
            } else {
                System.out.println("Invalid move");
            }
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