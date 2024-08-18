import java.util.Scanner;

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

    void move(String[][] board, int destinationRow, int destinationColumn,
        Queen[] whiteQueens, Rook[] whiteRooks, Bishop[] whiteBishops, Knight[] whiteKnights, Pawn[] whitePawns,
        Queen[] blackQueens, Rook[] blackRooks, Bishop[] blackBishops, Knight[] blackKnights, Pawn[] blackPawns) {
        destinationRow -= 1;
        destinationColumn -= 1;
        boolean promoting = false;
        if (this.icon.charAt(0) == 'W' && this.icon.charAt(1) == 'P' && destinationRow == 0 ||
            this.icon.charAt(0) == 'B' && this.icon.charAt(1) == 'P' && destinationRow == 7) {
            promoting = true;
        }
        if (destinationRow > 7 || destinationRow < 0 || destinationColumn > 7 || destinationColumn < 0 ||
            board[destinationRow][destinationColumn].charAt(0) == this.icon.charAt(0) ||
            board[destinationRow][destinationColumn].charAt(1) == 'K') {
            System.out.println("Invalid move");
        } else {
            int[][] availableMoves = new int[5][2];
            if (this.icon.charAt(0) == 'W') {
                if (!moved) {
                    if (board[this.positionRow - 1][this.positionColumn] == "000") {
                        availableMoves[0][0] = this.positionRow - 1;
                        availableMoves[0][1] = this.positionColumn;
                    }
                    if (board[this.positionRow - 2][this.positionColumn] == "000" &&
                            board[this.positionRow - 1][this.positionColumn] == "000") {
                        availableMoves[1][0] = this.positionRow - 2;
                        availableMoves[1][1] = this.positionColumn;
                    }
                } else {
                    if (board[this.positionRow - 1][this.positionColumn] == "000") {
                        availableMoves[0][0] = this.positionRow - 1;
                        availableMoves[0][1] = this.positionColumn;
                    }
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
                    if (board[this.positionRow + 1][this.positionColumn] == "000") {
                        availableMoves[0][0] = this.positionRow + 1;
                        availableMoves[0][1] = this.positionColumn;
                    }

                    if (board[this.positionRow + 2][this.positionColumn] == "000" &&
                            board[this.positionRow + 1][this.positionColumn] == "000") {
                        availableMoves[1][0] = this.positionRow + 2;
                        availableMoves[1][1] = this.positionColumn;
                    }
                } else {
                    if (board[this.positionRow + 1][this.positionColumn] == "000") {
                        availableMoves[0][0] = this.positionRow + 1;
                        availableMoves[0][1] = this.positionColumn;
                    }
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
                if (promoting) {
                    System.out.println("1 - Queen, 2 - Rook, 3 - Bishop, 4 - Knight");
                    Scanner sc = new Scanner(System.in);
                    int choice = sc.nextInt();

                    if (choice == 1) {
                        if (this.icon.charAt(0) == 'W') {
                            int whiteQueenAmount = 0;
                            for (int i = 0; i < board.length; i++) {
                                for (int j = 0; j < board[i].length; j++) {
                                    if (board[i][j].charAt(0) == 'W' && board[i][j].charAt(1) == 'Q') {
                                        whiteQueenAmount += 1;
                                    }
                                }
                            }
                            Character pawnNumberCharacter = this.icon.charAt(2);
                            String pawnNumberString = String.valueOf(pawnNumberCharacter);
                            whitePawns[Integer.parseInt(pawnNumberString)].icon = "000";
                            whitePawns[Integer.parseInt(pawnNumberString)].value = 0;
                            board[this.positionRow][this.positionColumn] = "000";
                            this.positionRow = destinationRow;
                            this.positionColumn = destinationColumn;
                            whiteQueens[whiteQueenAmount] = new Queen("WQ" + Integer.toString(whiteQueenAmount), this.enemy, 9, this.positionRow, this.positionColumn);
                            board[destinationRow][destinationColumn] = "WQ" + Integer.toString(whiteQueenAmount);
                        } else {
                            int blackQueenAmount = 0;
                            for (int i = 0; i < board.length; i++) {
                                for (int j = 0; j < board[i].length; j++) {
                                    if (board[i][j].charAt(0) == 'B' && board[i][j].charAt(1) == 'Q') {
                                        blackQueenAmount += 1;
                                    }
                                }
                            }
                            Character pawnNumberCharacter = this.icon.charAt(2);
                            String pawnNumberString = String.valueOf(pawnNumberCharacter);
                            blackPawns[Integer.parseInt(pawnNumberString)].icon = "000";
                            blackPawns[Integer.parseInt(pawnNumberString)].value = 0;
                            board[this.positionRow][this.positionColumn] = "000";
                            this.positionRow = destinationRow;
                            this.positionColumn = destinationColumn;
                            blackQueens[blackQueenAmount] = new Queen("BQ" + Integer.toString(blackQueenAmount), this.enemy, 9, this.positionRow, this.positionColumn);
                            board[destinationRow][destinationColumn] = "BQ" + Integer.toString(blackQueenAmount);
                        }

                    } else if (choice == 2) {
                        if (this.icon.charAt(0) == 'W') {
                            int whiteRookAmount = 0;
                            for (int i = 0; i < board.length; i++) {
                                for (int j = 0; j < board[i].length; j++) {
                                    if (board[i][j].charAt(0) == 'W' && board[i][j].charAt(1) == 'R') {
                                        whiteRookAmount += 1;
                                    }
                                }
                            }
                            Character pawnNumberCharacter = this.icon.charAt(2);
                            String pawnNumberString = String.valueOf(pawnNumberCharacter);
                            whitePawns[Integer.parseInt(pawnNumberString)].icon = "000";
                            whitePawns[Integer.parseInt(pawnNumberString)].value = 0;
                            board[this.positionRow][this.positionColumn] = "000";
                            this.positionRow = destinationRow;
                            this.positionColumn = destinationColumn;
                            whiteRooks[whiteRookAmount] = new Rook("WR" + Integer.toString(whiteRookAmount), this.enemy, 5, this.positionRow, this.positionColumn, true);
                            board[destinationRow][destinationColumn] = "WR" + Integer.toString(whiteRookAmount);
                        } else {
                            int blackRookAmount = 0;
                            for (int i = 0; i < board.length; i++) {
                                for (int j = 0; j < board[i].length; j++) {
                                    if (board[i][j].charAt(0) == 'B' && board[i][j].charAt(1) == 'R') {
                                        blackRookAmount += 1;
                                    }
                                }
                            }
                            Character pawnNumberCharacter = this.icon.charAt(2);
                            String pawnNumberString = String.valueOf(pawnNumberCharacter);
                            blackPawns[Integer.parseInt(pawnNumberString)].icon = "000";
                            blackPawns[Integer.parseInt(pawnNumberString)].value = 0;
                            board[this.positionRow][this.positionColumn] = "000";
                            this.positionRow = destinationRow;
                            this.positionColumn = destinationColumn;
                            blackRooks[blackRookAmount] = new Rook("BR" + Integer.toString(blackRookAmount), this.enemy, 5, this.positionRow, this.positionColumn, true);
                            board[destinationRow][destinationColumn] = "BR" + Integer.toString(blackRookAmount);
                        }
                    } else if (choice == 3) {
                        if (this.icon.charAt(0) == 'W') {
                            int whiteBishopAmount = 0;
                            for (int i = 0; i < board.length; i++) {
                                for (int j = 0; j < board[i].length; j++) {
                                    if (board[i][j].charAt(0) == 'W' && board[i][j].charAt(1) == 'B') {
                                        whiteBishopAmount += 1;
                                    }
                                }
                            }
                            Character pawnNumberCharacter = this.icon.charAt(2);
                            String pawnNumberString = String.valueOf(pawnNumberCharacter);
                            whitePawns[Integer.parseInt(pawnNumberString)].icon = "000";
                            whitePawns[Integer.parseInt(pawnNumberString)].value = 0;
                            board[this.positionRow][this.positionColumn] = "000";
                            this.positionRow = destinationRow;
                            this.positionColumn = destinationColumn;
                            whiteBishops[whiteBishopAmount] = new Bishop("WB" + Integer.toString(whiteBishopAmount), this.enemy, 3, this.positionRow, this.positionColumn);
                            board[destinationRow][destinationColumn] = "WB" + Integer.toString(whiteBishopAmount);
                        } else {
                            int blackBishopAmount = 0;
                            for (int i = 0; i < board.length; i++) {
                                for (int j = 0; j < board[i].length; j++) {
                                    if (board[i][j].charAt(0) == 'B' && board[i][j].charAt(1) == 'B') {
                                        blackBishopAmount += 1;
                                    }
                                }
                            }
                            Character pawnNumberCharacter = this.icon.charAt(2);
                            String pawnNumberString = String.valueOf(pawnNumberCharacter);
                            blackPawns[Integer.parseInt(pawnNumberString)].icon = "000";
                            blackPawns[Integer.parseInt(pawnNumberString)].value = 0;
                            board[this.positionRow][this.positionColumn] = "000";
                            this.positionRow = destinationRow;
                            this.positionColumn = destinationColumn;
                            blackBishops[blackBishopAmount] = new Bishop("BB" + Integer.toString(blackBishopAmount), this.enemy, 3, this.positionRow, this.positionColumn);
                            board[destinationRow][destinationColumn] = "BB" + Integer.toString(blackBishopAmount);
                        }
                    } else if (choice == 4) {
                        if (this.icon.charAt(0) == 'W') {
                            int whiteKnightAmount = 0;
                            for (int i = 0; i < board.length; i++) {
                                for (int j = 0; j < board[i].length; j++) {
                                    if (board[i][j].charAt(0) == 'W' && board[i][j].charAt(1) == 'N') {
                                        whiteKnightAmount += 1;
                                    }
                                }
                            }
                            Character pawnNumberCharacter = this.icon.charAt(2);
                            String pawnNumberString = String.valueOf(pawnNumberCharacter);
                            whitePawns[Integer.parseInt(pawnNumberString)].icon = "000";
                            whitePawns[Integer.parseInt(pawnNumberString)].value = 0;
                            board[this.positionRow][this.positionColumn] = "000";
                            this.positionRow = destinationRow;
                            this.positionColumn = destinationColumn;
                            System.out.println(this.positionRow);
                            System.out.println(this.positionColumn);
                            whiteKnights[whiteKnightAmount] = new Knight("WN" + Integer.toString(whiteKnightAmount), this.enemy, 3, this.positionRow, this.positionColumn);
                            board[destinationRow][destinationColumn] = "WN" + Integer.toString(whiteKnightAmount);
                        } else {
                            int blackKnightAmount = 0;
                            for (int i = 0; i < board.length; i++) {
                                for (int j = 0; j < board[i].length; j++) {
                                    if (board[i][j].charAt(0) == 'B' && board[i][j].charAt(1) == 'N') {
                                        blackKnightAmount += 1;
                                    }
                                }
                            }
                            Character pawnNumberCharacter = this.icon.charAt(2);
                            String pawnNumberString = String.valueOf(pawnNumberCharacter);
                            blackPawns[Integer.parseInt(pawnNumberString)].icon = "000";
                            blackPawns[Integer.parseInt(pawnNumberString)].value = 0;
                            this.icon = "BN" + Integer.toString(blackKnightAmount);
                            board[this.positionRow][this.positionColumn] = "000";
                            this.positionRow = destinationRow;
                            this.positionColumn = destinationColumn;
                            blackKnights[blackKnightAmount] = new Knight("BN" + Integer.toString(blackKnightAmount), this.enemy, 3, this.positionRow, this.positionColumn);
                            board[destinationRow][destinationColumn] = "BN" + Integer.toString(blackKnightAmount);
                        }
                    }
                } else {
                    board[this.positionRow][this.positionColumn] = "000";
                    this.positionRow = destinationRow;
                    this.positionColumn = destinationColumn;
                    board[destinationRow][destinationColumn] = this.icon;
                    this.moved = true;
                }
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