public class King {
    private String icon;
    private String enemy;
    private int value;
    private int positionRow;
    private int positionColumn;
    private boolean moved;
    private boolean check;

    King(String icon, String enemy, int value, int positionRow, int positionColumn, boolean moved, boolean check) {
        this.icon = icon;
        this.enemy = enemy;
        this.value = value;
        this.positionRow = positionRow;
        this.positionColumn = positionColumn;
        this.moved = moved;
        this.check = check;
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
            board[this.positionRow][this.positionColumn] = "000";
            this.positionRow = destinationRow;
            this.positionColumn = destinationColumn;
            board[destinationRow][destinationColumn] = this.icon;
            this.moved = true;
        }
    }

    void castle(String[][] board, boolean kingSideCastle, Rook[] whiteRooks, Rook[] blackRooks) {
        if (kingSideCastle && !whiteRooks[0].hasMoved() && this.icon.charAt(0) == 'W' &&
            board[this.positionRow][this.positionColumn + 1] == "000" &&
            board[this.positionRow][this.positionColumn + 2] == "000") {
            board[this.positionRow][this.positionColumn] = "000";
            board[7][6] = this.icon;
            board[7][7] = "000";
            board[7][5] = "WR1";
        } else if (!kingSideCastle && !whiteRooks[1].hasMoved() && this.icon.charAt(0) == 'W' &&
            board[this.positionRow][this.positionColumn - 1] == "000" &&
            board[this.positionRow][this.positionColumn - 2] == "000" &&
            board[this.positionRow][this.positionColumn - 3] == "000") {
            board[this.positionRow][this.positionColumn] = "000";
            board[7][2] = this.icon;
            board[7][0] = "000";
            board[7][3] = "WR0";
        } else if (kingSideCastle && !blackRooks[0].hasMoved() && this.icon.charAt(0) == 'B' &&
            board[this.positionRow][this.positionColumn + 1] == "000" &&
            board[this.positionRow][this.positionColumn + 2] == "000") {
            board[this.positionRow][this.positionColumn] = "000";
            board[0][6] = this.icon;
            board[0][7] = "000";
            board[0][5] = "BR1";
        } else if (!kingSideCastle && !blackRooks[1].hasMoved() && this.icon.charAt(0) == 'B' &&
            board[this.positionRow][this.positionColumn - 1] == "000" &&
            board[this.positionRow][this.positionColumn - 2] == "000" &&
            board[this.positionRow][this.positionColumn - 3] == "000") {
            board[this.positionRow][this.positionColumn] = "000";
            board[0][2] = this.icon;
            board[0][0] = "000";
            board[0][3] = "BR0";
        } else {
            System.out.println("Invalid move");
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

    public boolean getCheck() {
        return check;
    }

    public String getEnemy() {
        return enemy;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setCheck(boolean check) {this.check = check;}

    public boolean hasMoved() {
        return moved;
    }
}