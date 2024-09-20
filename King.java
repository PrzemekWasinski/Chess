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

    void checkIfCheck(String[][] board) {
            boolean attackedVertical = false;
            boolean attackedHorizontal = false;
            boolean attackedTopLeft = false;
            boolean attackedTopRight = false;

            for (int i = this.positionRow; i <= 7; i++) {
                if (board[i][this.positionColumn].charAt(0) == this.icon.charAt(0)) {
                    if (i > this.positionRow) {
                        break;
                    }
                } else if (board[i][this.positionColumn].charAt(0) == this.enemy.charAt(0)) {
                    if (board[i][this.positionColumn].charAt(1) == 'Q' || board[i][this.positionColumn].charAt(1) == 'R') {
                        attackedVertical = true;
                    }
                    break;
                } 
            }
            
            for (int i = this.positionRow; i >= 0; i--) {
                if (board[i][this.positionColumn].charAt(0) == this.icon.charAt(0)) {
                    if (i < this.positionRow) {
                        break;
                    }
                } else if (board[i][this.positionColumn].charAt(0) == this.enemy.charAt(0)) {
                    if (board[i][this.positionColumn].charAt(1) == 'Q' || board[i][this.positionColumn].charAt(1) == 'R') {
                        attackedVertical = true;
                    }
                    break;
                } 
            }

            for (int i = this.positionColumn; i <= 7; i++) {
                if (board[this.positionRow][i].charAt(0) == this.icon.charAt(0)) {
                    if (i > this.positionColumn) {
                        break;
                    }
                } else if (board[this.positionRow][i].charAt(0) == this.enemy.charAt(0)) {
                    if (board[this.positionRow][i].charAt(1) == 'Q' || board[this.positionRow][i].charAt(1) == 'R') {
                        attackedHorizontal = true;
                    }
                    break;
                }
            }
            
            for (int i = this.positionColumn; i >= 0; i--) {
                if (board[this.positionRow][i].charAt(0) == this.icon.charAt(0)) {
                    if (i < this.positionColumn) {
                        break;
                    }
                } else if (board[this.positionRow][i].charAt(0) == this.enemy.charAt(0)) {
                    if (board[this.positionRow][i].charAt(1) == 'Q' || board[this.positionRow][i].charAt(1) == 'R') {
                        attackedHorizontal = true;
                    }
                    break;
                }
            }

            for (int i = 1; i <= 7; i++) {
                if (this.positionRow - i < 0 || this.positionColumn - i < 0) {
                    break;
                } else {
                    if (board[this.positionRow - i][this.positionColumn - i].charAt(0) == this.icon.charAt(0)) {
                        break;
                    } else if (board[this.positionRow - i][this.positionColumn - i].charAt(0) == this.enemy.charAt(0)) {
                        if (board[this.positionRow - i][this.positionColumn - i].charAt(1) == 'Q' || board[this.positionRow - i][this.positionColumn - i].charAt(1) == 'B') {
                            attackedTopLeft = true;
                        }
                        break;
                    }
                }
            }

            for (int i = 1; i <= 7; i++) {
                if (this.positionRow + i > 7 || this.positionColumn - i < 0) {
                    break;
                } else {
                    if (board[this.positionRow + i][this.positionColumn - i].charAt(0) == this.icon.charAt(0)) {
                        break;
                    } else if (board[this.positionRow + i][this.positionColumn - i].charAt(0) == this.enemy.charAt(0)) {
                        if (board[this.positionRow + i][this.positionColumn - i].charAt(1) == 'Q' || board[this.positionRow + i][this.positionColumn - i].charAt(1) == 'B') {
                            attackedTopRight = true;
                        }
                        break;
                    }
                }
            }

            for (int i = 1; i <= 7; i++) {
                if (this.positionRow - i < 0 || this.positionColumn + i > 7) {
                    break;
                } else {
                    if (board[this.positionRow - i][this.positionColumn + i].charAt(0) == this.icon.charAt(0)) {
                        break;
                    } else if (board[this.positionRow - i][this.positionColumn + i].charAt(0) == this.enemy.charAt(0)) {
                        if (board[this.positionRow - i][this.positionColumn + i].charAt(1) == 'Q' || board[this.positionRow - i][this.positionColumn + i].charAt(1) == 'B') {
                            attackedTopRight = true;
                        }
                        break;
                    } 
                }
            }

            for (int i = 1; i <= 7; i++) {
                if (this.positionRow + i > 7 || this.positionColumn + i > 7) {
                    break;
                } else {
                    if (board[this.positionRow + i][this.positionColumn + i].charAt(0) == this.icon.charAt(0)) {
                        break;
                    } else if (board[this.positionRow + i][this.positionColumn + i].charAt(0) == this.enemy.charAt(0)) {
                        if (board[this.positionRow + i][this.positionColumn + i].charAt(1) == 'Q' || board[this.positionRow + i][this.positionColumn + i].charAt(1) == 'B') {
                            attackedTopLeft = true;
                        }
                        break;
                    }
                }
            }

            try {
                if (board[this.positionRow + 1][this.positionColumn + 2].charAt(1) == 'N' &&
                    board[this.positionRow + 1][this.positionColumn + 2].charAt(0) == this.enemy.charAt(0)) {
                    this.check = true;
                } else if (board[this.positionRow + 1][this.positionColumn - 2].charAt(1) == 'N' &&
                            board[this.positionRow + 1][this.positionColumn - 2].charAt(0) == this.enemy.charAt(0)) {
                    this.check = true;
                } else if (board[this.positionRow - 1][this.positionColumn + 2].charAt(1) == 'N' &&
                            board[this.positionRow - 1][this.positionColumn + 2].charAt(0) == this.enemy.charAt(0)) {
                    this.check = true;
                } else if (board[this.positionRow - 1][this.positionColumn - 2].charAt(1) == 'N' &&
                            board[this.positionRow - 1][this.positionColumn - 2].charAt(0) == this.enemy.charAt(0)) {
                    this.check = true;
                } else if (board[this.positionRow + 2][this.positionColumn + 1].charAt(1) == 'N' &&
                            board[this.positionRow + 2][this.positionColumn + 1].charAt(0) == this.enemy.charAt(0)) {
                    this.check = true;
                } else if (board[this.positionRow + 2][this.positionColumn - 1].charAt(1) == 'N' &&
                            board[this.positionRow + 2][this.positionColumn - 1].charAt(0) == this.enemy.charAt(0)) {
                    this.check = true;
                } else if (board[this.positionRow - 2][this.positionColumn + 1].charAt(1) == 'N' &&
                            board[this.positionRow - 2][this.positionColumn + 1].charAt(0) == this.enemy.charAt(0)) {
                    this.check = true;
                } else if (board[this.positionRow - 2][this.positionColumn - 1].charAt(1) == 'N' &&
                            board[this.positionRow - 2][this.positionColumn - 1].charAt(0) == this.enemy.charAt(0)) {
                    this.check = true;
                } else if (attackedVertical || attackedHorizontal || attackedTopRight || attackedTopLeft) {
                    this.check = true;
                } 
            } catch (ArrayIndexOutOfBoundsException e) {}     

            if (!this.check) {
                try {
                    if (this.icon.charAt(0) == 'W') {
                        if (board[this.positionRow - 1][this.positionColumn + 1].charAt(0) == this.enemy.charAt(0) &&
                            board[this.positionRow - 1][this.positionColumn + 1].charAt(1) == 'P') {    
                            this.check = true;
                        } else if (board[this.positionRow - 1][this.positionColumn - 1].charAt(0) == this.enemy.charAt(0) &&
                                    board[this.positionRow - 1][this.positionColumn - 1].charAt(1) == 'P') {
                            this.check = true;
                        }
                    } else if (this.icon.charAt(0) == 'B') {
                        if (board[this.positionRow + 1][this.positionColumn + 1].charAt(0) == this.enemy.charAt(0) &&
                            board[this.positionRow + 1][this.positionColumn + 1].charAt(1) == 'P') {    
                            this.check = true;
                        } else if (board[this.positionRow + 1][this.positionColumn - 1].charAt(0) == this.enemy.charAt(0) &&
                                    board[this.positionRow + 1][this.positionColumn - 1].charAt(1) == 'P') {
                            this.check = true;
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {}
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

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean hasMoved() {
        return moved;
    }
}