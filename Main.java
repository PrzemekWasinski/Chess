import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] board = new String[8][8];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = "000";
            }
        }

        //Spawn Kings
        King [] whiteKings = new King[2];
        for (int i = 0; i < 2; i++) {
            whiteKings[i] = new King("WK" + Integer.toString(i), 0, 7, 4);
            board[whiteKings[i].getPositionRow()][whiteKings[i].getPositionColumn()] = whiteKings[i].getIcon();
        }

        King [] blackKings = new King[2];
        for (int i = 0; i < 2; i++) {
            blackKings[i] = new King("BK" + Integer.toString(i), 0, 0, 4);
            board[blackKings[i].getPositionRow()][blackKings[i].getPositionColumn()] = blackKings[i].getIcon();
        }

        //Spawn Queens
        Queen [] whiteQueens = new Queen[2];
        for (int i = 0; i < 2; i++) {
            whiteQueens[i] = new Queen("WQ" + Integer.toString(i), "B", 9, 7, 3);
            board[whiteQueens[i].getPositionRow()][whiteQueens[i].getPositionColumn()] = whiteQueens[i].getIcon();
        }

        Queen [] blackQueens = new Queen[2];
        for (int i = 0; i < 2; i++) {
            blackQueens[i] = new Queen("BQ" + Integer.toString(i), "W", 9, 0, 3);
            board[blackQueens[i].getPositionRow()][blackQueens[i].getPositionColumn()] = blackQueens[i].getIcon();
        }

        //Spawn Bishops
        int[] bishopColumns = {2, 5};
        Bishop [] whiteBishops = new Bishop[2];
        for (int i = 0; i < 2; i++) {
            whiteBishops[i] = new Bishop("WB" + Integer.toString(i), "B", 3, 7, bishopColumns[i]);
            board[whiteBishops[i].getPositionRow()][whiteBishops[i].getPositionColumn()] = whiteBishops[i].getIcon();
        }

        Bishop [] blackBishops = new Bishop[2];
        for (int i = 0; i < 2; i++) {
            blackBishops[i] = new Bishop("BB" + Integer.toString(i), "W", 3, 0, bishopColumns[i]);
            board[blackBishops[i].getPositionRow()][blackBishops[i].getPositionColumn()] = blackBishops[i].getIcon();
        }

        //Spawn Knights
        int[] knightColumns = {1, 6};
        Knight [] whiteKnights = new Knight[2];
        for (int i = 0; i < 2; i++) {
            whiteKnights[i] = new Knight("WN" + Integer.toString(i), "B", 3, 7, knightColumns[i]);
            board[whiteKnights[i].getPositionRow()][whiteKnights[i].getPositionColumn()] = whiteKnights[i].getIcon();
        }

        Knight [] blackKnights = new Knight[2];
        for (int i = 0; i < 2; i++) {
            blackKnights[i] = new Knight("BN" + Integer.toString(i), "W", 3, 0, knightColumns[i]);
            board[blackKnights[i].getPositionRow()][blackKnights[i].getPositionColumn()] = blackKnights[i].getIcon();
        }

        //Spawn Rooks
        int[] rookColumns = {0, 7};
        Rook [] whiteRooks = new Rook[2];
        for (int i = 0; i < 2; i++) {
            whiteRooks[i] = new Rook("WR" + Integer.toString(i), "B", 5, 7, rookColumns[i]);
            board[whiteRooks[i].getPositionRow()][whiteRooks[i].getPositionColumn()] = whiteRooks[i].getIcon();
        }

        Rook [] blackRooks = new Rook[2];
        for (int i = 0; i < 2; i++) {
            blackRooks[i] = new Rook("BR" + Integer.toString(i), "W", 5, 0, rookColumns[i]);
            board[blackRooks[i].getPositionRow()][blackRooks[i].getPositionColumn()] = blackRooks[i].getIcon();
        }

        //Spawn pawns
        Pawn [] whitePawns = new Pawn[8];
        for (int i = 0; i < 8; i++) {
            whitePawns[i] = new Pawn("WP" + Integer.toString(i), "B", 1, 6, i, false);
            board[whitePawns[i].getPositionRow()][whitePawns[i].getPositionColumn()] = whitePawns[i].getIcon();
        }

        Pawn [] blackPawns = new Pawn[8];
        for (int i = 0; i < 8; i++) {
            blackPawns[i] = new Pawn("BP" + Integer.toString(i), "W", 1, 1, i, false);
            board[blackPawns[i].getPositionRow()][blackPawns[i].getPositionColumn()] = blackPawns[i].getIcon();
        }

        for (int i = 0; i < board.length; i++) {
            String row = Integer.toString(8 - i);
            System.out.print(row + " ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("   ");
        Character[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        for (int i = 0; i < letters.length; i++) {
            System.out.print(letters[i] + "   ");
        }

        System.out.println();

        int[] rows = {8, 7, 6, 5, 4, 3, 2, 1, 0};
        while (true) {
            int selectedColumn = 0;

            Scanner input1 = new Scanner(System.in);
            Character selectedLetter = input1.next().charAt(0);

            for (int i = 0; i < letters.length; i++) {
                if (letters[i] == selectedLetter) {
                    selectedColumn = i;
                }
            }

            Scanner input2 = new Scanner(System.in);
            int selectedRow = rows[input2.nextInt()];

            System.out.println("Selected Piece - " + board[selectedRow][selectedColumn]);
            int moveColumn = 0;

            Scanner input3 = new Scanner(System.in);
            Character moveLetter = input3.next().charAt(0);

            for (int i = 0; i < letters.length; i++) {
                if (letters[i] == moveLetter) {
                    moveColumn = i + 1;
                }
            }

            Scanner input4 = new Scanner(System.in);
            int moveRow = rows[input4.nextInt() - 1];

            if (board[selectedRow][selectedColumn].charAt(1) == 'K') {
                if (board[selectedRow][selectedColumn].charAt(0) == 'W') {
                    Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                    String piece = String.valueOf(pieceChar);
                    whiteQueens[Integer.parseInt(piece)].move(board, moveRow, moveColumn);
                } else {
                    Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                    String piece = String.valueOf(pieceChar);
                    blackKings[Integer.parseInt(piece)].move(board, moveRow, moveColumn);
                }

            } else if (board[selectedRow][selectedColumn].charAt(1) == 'Q') {
                if (board[selectedRow][selectedColumn].charAt(0) == 'W') {
                    Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                    String piece = String.valueOf(pieceChar);
                    whiteQueens[Integer.parseInt(piece)].move(board, moveRow, moveColumn);
                } else {
                    Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                    String piece = String.valueOf(pieceChar);
                    blackQueens[Integer.parseInt(piece)].move(board, moveRow, moveColumn);
                }

            } else if (board[selectedRow][selectedColumn].charAt(1) == 'B') {
                if (board[selectedRow][selectedColumn].charAt(0) == 'W') {
                    Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                    String piece = String.valueOf(pieceChar);
                    whiteBishops[Integer.parseInt(piece)].move(board, moveRow, moveColumn);
                } else {
                    Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                    String piece = String.valueOf(pieceChar);
                    blackBishops[Integer.parseInt(piece)].move(board, moveRow, moveColumn);
                }

            } else if (board[selectedRow][selectedColumn].charAt(1) == 'N') {
                if (board[selectedRow][selectedColumn].charAt(0) == 'W') {
                    Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                    String piece = String.valueOf(pieceChar);
                    whiteKnights[Integer.parseInt(piece)].move(board, moveRow, moveColumn);
                } else {
                    Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                    String piece = String.valueOf(pieceChar);
                    blackKnights[Integer.parseInt(piece)].move(board, moveRow, moveColumn);
                }

            } else if (board[selectedRow][selectedColumn].charAt(1) == 'R') {
                if (board[selectedRow][selectedColumn].charAt(0) == 'W') {
                    Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                    String piece = String.valueOf(pieceChar);
                    whiteRooks[Integer.parseInt(piece)].move(board, moveRow, moveColumn);
                } else {
                    Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                    String piece = String.valueOf(pieceChar);
                    blackRooks[Integer.parseInt(piece)].move(board, moveRow, moveColumn);
                }

            } else if (board[selectedRow][selectedColumn].charAt(1) == 'P') {
                if (board[selectedRow][selectedColumn].charAt(0) == 'W') {
                    Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                    String piece = String.valueOf(pieceChar);
                    whitePawns[Integer.parseInt(piece)].move(board, moveRow, moveColumn);
                } else {
                    Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                    String piece = String.valueOf(pieceChar);
                    blackPawns[Integer.parseInt(piece)].move(board, moveRow, moveColumn);
                }
            }

            System.out.println();
            for (int i = 0; i < board.length; i++) {
                String row = Integer.toString(8 - i);
                System.out.print(row + " ");
                for (int j = 0; j < board[i].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

            System.out.print("   ");
            for (int i = 0; i < letters.length; i++) {
                System.out.print(letters[i] + "   ");
            }

            System.out.println();
        }
    }
}