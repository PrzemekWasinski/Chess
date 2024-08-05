public class Pawn {
    private String icon;
    private String enemy;
    private int value;
    private int positionRow;
    private int positionColumn;
    private boolean moved;

    Pawn(String icon, String enemy, int value, int positionRow, int positionColumn, boolean moved) {
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
            int[][] availableMoves = new int[5][2];
            if (this.icon.charAt(0) == 'W') {
                if (!moved) {
                    availableMoves[0][0] = this.positionRow - 1;
                    availableMoves[0][1] = this.positionColumn;
                    availableMoves[1][0] = this.positionRow - 2;
                    availableMoves[1][1] = this.positionColumn;
                } else {
                    availableMoves[0][0] = this.positionRow - 1;
                    availableMoves[0][1] = this.positionColumn;
                }
                if (this.positionColumn != 0) {
                    if (board[this.positionRow - 1][this.positionColumn - 1].charAt(0) != this.icon.charAt(0) &&
                            board[this.positionRow - 1][this.positionColumn - 1].charAt(0) != 'K') {
                        availableMoves[2][0] = this.positionRow - 1;
                        availableMoves[2][1] = this.positionColumn - 1;
                    }
                }

                if (this.positionColumn != 7) {
                    if (board[this.positionRow - 1][this.positionColumn + 1].charAt(0) != this.icon.charAt(0) &&
                            board[this.positionRow - 1][this.positionColumn + 1].charAt(0) != 'K') {
                        availableMoves[3][0] = this.positionRow - 1;
                        availableMoves[3][1] = this.positionColumn + 1;
                    }
                }
            } else {
                if (!moved) {
                    availableMoves[0][0] = this.positionRow + 1;
                    availableMoves[0][1] = this.positionColumn;
                    availableMoves[1][0] = this.positionRow + 2;
                    availableMoves[1][1] = this.positionColumn;
                } else {
                    availableMoves[0][0] = this.positionRow + 1;
                    availableMoves[0][1] = this.positionColumn;
                }
                if (this.positionColumn != 0) {
                    if (board[this.positionRow + 1][this.positionColumn - 1].charAt(0) != this.icon.charAt(0) &&
                            board[this.positionRow + 1][this.positionColumn - 1].charAt(0) != 'K') {
                        availableMoves[2][0] = this.positionRow + 1;
                        availableMoves[2][1] = this.positionColumn - 1;
                    }
                }

                if (this.positionColumn != 7) {
                    if (board[this.positionRow + 1][this.positionColumn + 1].charAt(0) != this.icon.charAt(0) &&
                            board[this.positionRow + 1][this.positionColumn + 1].charAt(0) != 'K') {
                        availableMoves[3][0] = this.positionRow + 1;
                        availableMoves[3][1] = this.positionColumn + 1;
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
                board[this.positionRow][this.positionColumn] = "00";
                this.positionRow = destinationRow;
                this.positionColumn = destinationColumn;
                board[destinationRow][destinationColumn] = this.icon;
                this.moved = true;
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