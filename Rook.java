package Chess;

public class Rook {
    private String icon;
    private String enemy;
    private int value;
    private int positionRow;
    private int positionColumn;
    private boolean moved;

    Rook(String icon, String enemy, int value, int positionRow, int positionColumn, boolean moved) {
        this.icon = icon;
        this.enemy = enemy;
        this.value = value;
        this.positionRow = positionRow;
        this.positionColumn = positionColumn;
        this.moved = moved;
    }

    void move(String[][] board, int destinationRow, int destinationColumn) {
        destinationRow -= 1;
        destinationColumn -= 1;
        if (destinationRow > 7 || destinationRow < 0 || destinationColumn > 7 || destinationColumn < 0 ||
            board[destinationRow][destinationColumn].charAt(0) == this.icon.charAt(0) ||
            board[destinationRow][destinationColumn].charAt(1) == 'K') {
            System.out.println("Invalid move");
        } else {
            int[][][] availableMoves = new int[2][8][2];
            // [0] = Moves vertically
            // [1] = Moves horizontally

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

            // Add moves vertically
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
            // Add moves horizontally
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

            // Add moves from rook to top left
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
                        diagonalTopLeftCounter++;
                        break;
                    } else {
                        diagonalTopLeftCounter++;
                    }
                }
            }
            // Add moves from rook to bottom left
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
                        diagonalTopRightCounter++;
                        break;
                    } else {
                        diagonalTopRightCounter++;
                    }
                }
            }

            // Add moves from rook to top right
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
                        diagonalTopRightCounter++;
                        break;
                    } else {
                        diagonalTopRightCounter++;
                    }
                }
            }

            // Add moves from rook to bottom right
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
                        diagonalTopLeftCounter++;
                        break;
                    } else {
                        diagonalTopLeftCounter++;
                    }
                }
            }
            boolean pinnedTopLeft = defendingTopLeft && attackedTopLeft;
            boolean pinnedTopRight = defendingTopRight && attackedTopRight;

            boolean legalMove = false;
            if (defendingVertical && attackedVertical) {
                System.out.println("vertical");
                for (int i = 0; i < availableMoves[0].length; i++) {
                    if (availableMoves[0][i][0] == destinationRow) {
                        if (availableMoves[0][i][1] == destinationColumn) {
                            legalMove = true;
                            break;
                        }
                    }
                }
            } else if (defendingHorizontal && attackedHorizontal) {
                System.out.println("horizontal");
                for (int i = 0; i < availableMoves[1].length; i++) {
                    if (availableMoves[1][i][0] == destinationRow) {
                        if (availableMoves[1][i][1] == destinationColumn) {
                            legalMove = true;
                            break;
                        }
                    }
                }
            } else if (!pinnedTopLeft && !pinnedTopRight) {
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
            } else {
                legalMove = false;
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

    public boolean hasMoved() {
        return moved;
    }
}