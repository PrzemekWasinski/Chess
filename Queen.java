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
            int[][][] availableMoves = new int[4][8][2];
            // [0] = Moves vertically
            // [1] = Moves horizontally
            // [2] = Moves diagonally from top left to bottom right
            // [3] = Moves diagonally from  top right to bottom left

            for (int i = 0; i < availableMoves.length; i++) {
                for (int j = 0; j < availableMoves[i].length; j++) {
                    for (int k = 0; k < availableMoves[i][j].length; k++) {
                        availableMoves[i][j][k] = -1;
                    }
                }
            }

            boolean defendingVertical = false;
            boolean attackedVertical = false;

            boolean defendingHorizontal = false;
            boolean attackedHorizontal = false;

            boolean defendingTopLeft = false;
            boolean attackedTopLeft = false;

            boolean defendingTopRight = false;
            boolean attackedTopRight = false;

            int verticalCounter = 0;
            int horizontalCounter = 0;
            int diagonalTopLeftCounter = 0;
            int diagonalTopRightCounter = 0;

            for (int i = this.positionRow; i <= 7; i++) {
                if (board[i][this.positionColumn].charAt(0) == this.icon.charAt(0)) {
                    if (i > this.positionRow) {
                        if (board[i][this.positionColumn].charAt(1) == 'K') {
                            defendingVertical = true;
                        }
                        break;
                    }
                } else if (board[i][this.positionColumn].charAt(0) == this.enemy.charAt(0)) {
                    if (board[i][this.positionColumn].charAt(1) == 'Q' || board[i][this.positionColumn].charAt(1) == 'R') {
                        attackedVertical = true;
                    }
                    availableMoves[0][verticalCounter][0] = i;
                    availableMoves[0][verticalCounter][1] = this.positionColumn;
                    verticalCounter++;
                    break;
                } else {
                    availableMoves[0][verticalCounter][0] = i;
                    availableMoves[0][verticalCounter][1] = this.positionColumn;
                    verticalCounter++;
                }
            }
            
            for (int i = this.positionRow; i >= 0; i--) {
                if (board[i][this.positionColumn].charAt(0) == this.icon.charAt(0)) {
                    if (i < this.positionRow) {
                        if (board[i][this.positionColumn].charAt(1) == 'K') {
                            defendingVertical = true;
                        }
                        break;
                    }
                } else if (board[i][this.positionColumn].charAt(0) == this.enemy.charAt(0)) {
                    if (board[i][this.positionColumn].charAt(1) == 'Q' || board[i][this.positionColumn].charAt(1) == 'R') {
                        attackedVertical = true;
                    }
                    availableMoves[0][verticalCounter][0] = i;
                    availableMoves[0][verticalCounter][1] = this.positionColumn;
                    verticalCounter++;
                    break;
                } else {
                    availableMoves[0][verticalCounter][0] = i;
                    availableMoves[0][verticalCounter][1] = this.positionColumn;
                    verticalCounter++;
                }
            }

            for (int i = this.positionColumn; i <= 7; i++) {
                if (board[this.positionRow][i].charAt(0) == this.icon.charAt(0)) {
                    if (i > this.positionColumn) {
                        if (board[this.positionRow][i].charAt(1) == 'K') {
                            defendingHorizontal = true;
                        }
                        break;
                    }
                } else if (board[this.positionRow][i].charAt(0) == this.enemy.charAt(0)) {
                    if (board[this.positionRow][i].charAt(1) == 'Q' || board[this.positionRow][i].charAt(1) == 'R') {
                        attackedHorizontal = true;
                    }
                    availableMoves[1][horizontalCounter][0] = this.positionRow;
                    availableMoves[1][horizontalCounter][1] = i;
                    horizontalCounter++;
                    break;
                } else {
                    availableMoves[1][horizontalCounter][0] = this.positionRow;
                    availableMoves[1][horizontalCounter][1] = i;
                    horizontalCounter++;
                }
            }
            
            for (int i = this.positionColumn; i >= 0; i--) {
                if (board[this.positionRow][i].charAt(0) == this.icon.charAt(0)) {
                    if (i < this.positionColumn) {
                        if (board[this.positionRow][i].charAt(1) == 'K') {
                            defendingHorizontal = true;
                        }
                        break;
                    }
                } else if (board[this.positionRow][i].charAt(0) == this.enemy.charAt(0)) {
                    if (board[this.positionRow][i].charAt(1) == 'Q' || board[this.positionRow][i].charAt(1) == 'R') {
                        attackedHorizontal = true;
                    }
                    availableMoves[1][horizontalCounter][0] = this.positionRow;
                    availableMoves[1][horizontalCounter][1] = i;
                    horizontalCounter++;
                    break;
                } else {
                    availableMoves[1][horizontalCounter][0] = this.positionRow;
                    availableMoves[1][horizontalCounter][1] = i;
                    horizontalCounter++;
                }
            }

            for (int i = 1; i <= 7; i++) {
                if (this.positionRow - i < 0 || this.positionColumn - i < 0) {
                    break;
                } else {
                    if (board[this.positionRow - i][this.positionColumn - i].charAt(0) == this.icon.charAt(0)) {
                        if (board[this.positionRow - i][this.positionColumn - i].charAt(1) == 'K') {
                            defendingTopLeft = true;
                        }
                        break;
                    } else if (board[this.positionRow - i][this.positionColumn - i].charAt(0) == this.enemy.charAt(0)) {
                        if (board[this.positionRow - i][this.positionColumn - i].charAt(1) == 'Q' || board[this.positionRow - i][this.positionColumn - i].charAt(1) == 'B') {
                            attackedTopLeft = true;
                        }
                        availableMoves[2][diagonalTopLeftCounter][0] = this.positionRow - i;
                        availableMoves[2][diagonalTopLeftCounter][1] = this.positionColumn - i;
                        diagonalTopLeftCounter++;
                        break;
                    } else {
                        availableMoves[2][diagonalTopLeftCounter][0] = this.positionRow - i;
                        availableMoves[2][diagonalTopLeftCounter][1] = this.positionColumn - i;
                        diagonalTopLeftCounter++;
                    }
                }
            }

            for (int i = 1; i <= 7; i++) {
                if (this.positionRow + i > 7 || this.positionColumn - i < 0) {
                    break;
                } else {
                    if (board[this.positionRow + i][this.positionColumn - i].charAt(0) == this.icon.charAt(0)) {
                        if (board[this.positionRow + i][this.positionColumn - i].charAt(1) == 'K') {
                            defendingTopRight = true;
                        }
                        break;
                    } else if (board[this.positionRow + i][this.positionColumn - i].charAt(0) == this.enemy.charAt(0)) {
                        if (board[this.positionRow + i][this.positionColumn - i].charAt(1) == 'Q' || board[this.positionRow + i][this.positionColumn - i].charAt(1) == 'B') {
                            attackedTopRight = true;
                        }
                        availableMoves[3][diagonalTopRightCounter][0] = this.positionRow + i;
                        availableMoves[3][diagonalTopRightCounter][1] = this.positionColumn - i;
                        diagonalTopRightCounter++;
                        break;
                    } else {
                        availableMoves[3][diagonalTopRightCounter][0] = this.positionRow + i;
                        availableMoves[3][diagonalTopRightCounter][1] = this.positionColumn - i;
                        diagonalTopRightCounter++;
                    }
                }
            }

            for (int i = 1; i <= 7; i++) {
                if (this.positionRow - i < 0 || this.positionColumn + i > 7) {
                    break;
                } else {
                    if (board[this.positionRow - i][this.positionColumn + i].charAt(0) == this.icon.charAt(0)) {
                        if (board[this.positionRow - i][this.positionColumn + i].charAt(1) == 'K') {
                            defendingTopRight = true;
                        }
                        break;
                    } else if (board[this.positionRow - i][this.positionColumn + i].charAt(0) == this.enemy.charAt(0)) {
                        if (board[this.positionRow - i][this.positionColumn + i].charAt(1) == 'Q' || board[this.positionRow - i][this.positionColumn + i].charAt(1) == 'B') {
                            attackedTopRight = true;
                        }
                        availableMoves[3][diagonalTopRightCounter][0] = this.positionRow - i;
                        availableMoves[3][diagonalTopRightCounter][1] = this.positionColumn + i;
                        diagonalTopRightCounter++;
                        break;
                    } else {
                        availableMoves[3][diagonalTopRightCounter][0] = this.positionRow - i;
                        availableMoves[3][diagonalTopRightCounter][1] = this.positionColumn + i;
                        diagonalTopRightCounter++;
                    }
                }
            }

            for (int i = 1; i <= 7; i++) {
                if (this.positionRow + i > 7 || this.positionColumn + i > 7) {
                    break;
                } else {
                    if (board[this.positionRow + i][this.positionColumn + i].charAt(0) == this.icon.charAt(0)) {
                        if (board[this.positionRow + i][this.positionColumn + i].charAt(1) == 'K') {
                            defendingTopLeft = true;
                        }
                        break;
                    } else if (board[this.positionRow + i][this.positionColumn + i].charAt(0) == this.enemy.charAt(0)) {
                        if (board[this.positionRow + i][this.positionColumn + i].charAt(1) == 'Q' || board[this.positionRow + i][this.positionColumn + i].charAt(1) == 'B') {
                            attackedTopLeft = true;
                        }
                        availableMoves[2][diagonalTopLeftCounter][0] = this.positionRow + i;
                        availableMoves[2][diagonalTopLeftCounter][1] = this.positionColumn + i;
                        diagonalTopLeftCounter++;
                        break;
                    } else {
                        availableMoves[2][diagonalTopLeftCounter][0] = this.positionRow + i;
                        availableMoves[2][diagonalTopLeftCounter][1] = this.positionColumn + i;
                        diagonalTopLeftCounter++;
                    }
                }
            }

            boolean legalMove = false;
            if (defendingVertical && attackedVertical) {
                for (int i = 0; i < availableMoves[0].length; i++) {
                    if (availableMoves[0][i][0] == destinationRow) {
                        if (availableMoves[0][i][1] == destinationColumn) {
                            legalMove = true;
                            break;
                        }
                    }
                }
            } else if (defendingHorizontal && attackedHorizontal) {
                for (int i = 0; i < availableMoves[1].length; i++) {
                    if (availableMoves[1][i][0] == destinationRow) {
                        if (availableMoves[1][i][1] == destinationColumn) {
                            legalMove = true;
                            break;
                        }
                    }
                }
            } else if (defendingTopLeft && attackedTopLeft) {
                for (int i = 0; i < availableMoves[2].length; i++) {
                    if (availableMoves[2][i][0] == destinationRow) {
                        if (availableMoves[2][i][1] == destinationColumn) {
                            legalMove = true;
                            break;
                        }
                    }
                }
            } else if (defendingTopRight && attackedTopRight) {
                for (int i = 0; i < availableMoves[3].length; i++) {
                    if (availableMoves[3][i][0] == destinationRow) {
                        if (availableMoves[3][i][1] == destinationColumn) {
                            legalMove = true;
                            break;
                        }
                    }
                }
            } else {
                for (int i = 0; i < availableMoves.length; i++) {
                    for (int j = 0; j < availableMoves[i].length; j++) {
                        if (availableMoves[i][j][0] == destinationRow) {
                            if (availableMoves[i][j][1] == destinationColumn) {
                                legalMove = true;
                                break;
                            }
                        }
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