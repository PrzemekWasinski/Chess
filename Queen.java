package Chess;

public class Queen {
    private String icon;
    private String enemy;
    private int value;
    private int positionRow;
    private int positionColumn;

    Queen(String icon, String enemy, int value, int positionRow, int positionColumn) {
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
            int[][] availableMoves = new int[32][2];

            for (int i = 0; i < availableMoves.length; i++) {
                for (int j = 0; j < availableMoves[i].length; j++) {
                    availableMoves[i][j] = -1;
                }
            }

            int counter = 0;
            for (int i = this.positionRow; i <= 7; i++) {
                if (board[i][this.positionColumn].charAt(0) == this.icon.charAt(0)) {
                    if (i > this.positionRow) {
                        break;
                    }
                } else if (board[i][this.positionColumn].charAt(0) == this.enemy.charAt(0)) {
                    availableMoves[counter][0] = i;
                    availableMoves[counter][1] = this.positionColumn;
                    counter++;
                    break;
                } else {
                    availableMoves[counter][0] = i;
                    availableMoves[counter][1] = this.positionColumn;
                    counter++;
                }
            }
            for (int i = this.positionRow; i >= 0; i--) {
                if (board[i][this.positionColumn].charAt(0) == this.icon.charAt(0)) {
                    if (i < this.positionRow) {
                        break;
                    }
                } else if (board[i][this.positionColumn].charAt(0) == this.enemy.charAt(0)) {
                    availableMoves[counter][0] = i;
                    availableMoves[counter][1] = this.positionColumn;
                    counter++;
                    break;
                } else {
                    availableMoves[counter][0] = i;
                    availableMoves[counter][1] = this.positionColumn;
                    counter++;
                }
            }

            for (int i = this.positionColumn; i <= 7; i++) {
                if (board[this.positionRow][i].charAt(0) == this.icon.charAt(0)) {
                    if (i > this.positionColumn) {
                        break;
                    }
                } else if (board[this.positionRow][i].charAt(0) == this.enemy.charAt(0)) {
                    availableMoves[counter][0] = this.positionRow;
                    availableMoves[counter][1] = i;
                    counter++;
                    break;
                } else {
                    availableMoves[counter][0] = this.positionRow;
                    availableMoves[counter][1] = i;
                    counter++;
                }
            }
            for (int i = this.positionColumn; i >= 0; i--) {
                if (board[this.positionRow][i].charAt(0) == this.icon.charAt(0)) {
                    if (i < this.positionColumn) {
                        break;
                    }
                } else if (board[this.positionRow][i].charAt(0) == this.enemy.charAt(0)) {
                    availableMoves[counter][0] = this.positionRow;
                    availableMoves[counter][1] = i;
                    counter++;
                    break;
                } else {
                    availableMoves[counter][0] = this.positionRow;
                    availableMoves[counter][1] = i;
                    counter++;
                }
            }

            for (int i = 1; i <= 7; i++) {
                if (this.positionRow - i < 0 || this.positionColumn - i < 0) {
                    break;
                } else {
                    if (board[this.positionRow - i][this.positionColumn - i].charAt(0) == this.icon.charAt(0)) {
                        if (i > 1) {
                            break;
                        }
                    } else if (board[this.positionRow - i][this.positionColumn - i].charAt(0) == this.enemy.charAt(0)) {
                        availableMoves[counter][0] = this.positionRow - i;
                        availableMoves[counter][1] = this.positionColumn - i;
                        counter++;
                        break;
                    } else {
                        availableMoves[counter][0] = this.positionRow - i;
                        availableMoves[counter][1] = this.positionColumn - i;
                        counter++;
                    }
                }
            }
            for (int i = 1; i <= 7; i++) {
                if (this.positionRow + i > 7 || this.positionColumn - i < 0) {
                    break;
                } else {
                    if (board[this.positionRow + i][this.positionColumn - i].charAt(0) == this.icon.charAt(0)) {
                        if (i > 1) {
                            break;
                        }
                    } else if (board[this.positionRow + i][this.positionColumn - i].charAt(0) == this.enemy.charAt(0)) {
                        availableMoves[counter][0] = this.positionRow + i;
                        availableMoves[counter][1] = this.positionColumn - i;
                        counter++;
                        break;
                    } else {
                        availableMoves[counter][0] = this.positionRow + i;
                        availableMoves[counter][1] = this.positionColumn - i;
                        counter++;
                    }
                }
            }
            for (int i = 1; i <= 7; i++) {
                if (this.positionRow - i < 0 || this.positionColumn + i > 7) {
                    break;
                } else {
                    if (board[this.positionRow - i][this.positionColumn + i].charAt(0) == this.icon.charAt(0)) {
                        if (i > 1) {
                            break;
                        }
                    } else if (board[this.positionRow - i][this.positionColumn + i].charAt(0) == this.enemy.charAt(0)) {
                        availableMoves[counter][0] = this.positionRow - i;
                        availableMoves[counter][1] = this.positionColumn + i;
                        counter++;
                        break;
                    } else {
                        availableMoves[counter][0] = this.positionRow - i;
                        availableMoves[counter][1] = this.positionColumn + i;
                        counter++;
                    }
                }
            }
            for (int i = 1; i <= 7; i++) {
                if (this.positionRow + i > 7 || this.positionColumn + i > 7) {
                    break;
                } else {
                    if (board[this.positionRow + i][this.positionColumn + i].charAt(0) == this.icon.charAt(0)) {
                        if (i > 1) {
                            break;
                        }
                    } else if (board[this.positionRow + i][this.positionColumn + i].charAt(0) == this.enemy.charAt(0)) {
                        availableMoves[counter][0] = this.positionRow + i;
                        availableMoves[counter][1] = this.positionColumn + i;
                        break;
                    } else {
                        availableMoves[counter][0] = this.positionRow + i;
                        availableMoves[counter][1] = this.positionColumn + i;
                        counter++;
                    }
                }
            }
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