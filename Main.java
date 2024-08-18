package Chess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Make the board and fill all squares with "000"
        String[][] board = new String[8][8];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = "000";
            }
        }

        //Spawn Kings
        King [] whiteKings = new King[2];
        for (int i = 0; i < 1; i++) {
            whiteKings[i] = new King("WK" + Integer.toString(i), 0, 7, 4, false);
            board[whiteKings[i].getPositionRow()][whiteKings[i].getPositionColumn()] = whiteKings[i].getIcon();
        }

        King [] blackKings = new King[2];
        for (int i = 0; i < 1; i++) {
            blackKings[i] = new King("BK" + Integer.toString(i), 0, 0, 4, false);
            board[blackKings[i].getPositionRow()][blackKings[i].getPositionColumn()] = blackKings[i].getIcon();
        }

        //Spawn Queens
        Queen [] whiteQueens = new Queen[10];
        for (int i = 0; i < 1; i++) {
            whiteQueens[i] = new Queen("WQ" + Integer.toString(i), "B", 9, 7, 3);
            board[whiteQueens[i].getPositionRow()][whiteQueens[i].getPositionColumn()] = whiteQueens[i].getIcon();
        }

        Queen [] blackQueens = new Queen[10];
        for (int i = 0; i < 1; i++) {
            blackQueens[i] = new Queen("BQ" + Integer.toString(i), "W", 9, 0, 3);
            board[blackQueens[i].getPositionRow()][blackQueens[i].getPositionColumn()] = blackQueens[i].getIcon();
        }

        //Spawn Bishops
        int[] bishopColumns = {2, 5};
        Bishop [] whiteBishops = new Bishop[10];
        for (int i = 0; i < 2; i++) {
            whiteBishops[i] = new Bishop("WB" + Integer.toString(i), "B", 3, 7, bishopColumns[i]);
            board[whiteBishops[i].getPositionRow()][whiteBishops[i].getPositionColumn()] = whiteBishops[i].getIcon();
        }

        Bishop [] blackBishops = new Bishop[10];
        for (int i = 0; i < 2; i++) {
            blackBishops[i] = new Bishop("BB" + Integer.toString(i), "W", 3, 0, bishopColumns[i]);
            board[blackBishops[i].getPositionRow()][blackBishops[i].getPositionColumn()] = blackBishops[i].getIcon();
        }

        //Spawn Knights
        int[] knightColumns = {1, 6};
        Knight [] whiteKnights = new Knight[10];
        for (int i = 0; i < 2; i++) {
            whiteKnights[i] = new Knight("WN" + Integer.toString(i), "B", 3, 7, knightColumns[i]);
            board[whiteKnights[i].getPositionRow()][whiteKnights[i].getPositionColumn()] = whiteKnights[i].getIcon();
        }

        Knight [] blackKnights = new Knight[10];
        for (int i = 0; i < 2; i++) {
            blackKnights[i] = new Knight("BN" + Integer.toString(i), "W", 3, 0, knightColumns[i]);
            board[blackKnights[i].getPositionRow()][blackKnights[i].getPositionColumn()] = blackKnights[i].getIcon();
        }

        //Spawn Rooks
        int[] rookColumns = {0, 7};
        Rook [] whiteRooks = new Rook[10];
        for (int i = 0; i < 2; i++) {
            whiteRooks[i] = new Rook("WR" + Integer.toString(i), "B", 5, 7, rookColumns[i], false);
            board[whiteRooks[i].getPositionRow()][whiteRooks[i].getPositionColumn()] = whiteRooks[i].getIcon();
        }

        Rook [] blackRooks = new Rook[10];
        for (int i = 0; i < 2; i++) {
            blackRooks[i] = new Rook("BR" + Integer.toString(i), "W", 5, 0, rookColumns[i], false);
            board[blackRooks[i].getPositionRow()][blackRooks[i].getPositionColumn()] = blackRooks[i].getIcon();
        }

        //Spawn pawns
        Pawn [] whitePawns = new Pawn[8];
        for (int i = 0; i < board.length; i++) {
            whitePawns[i] = new Pawn("WP" + Integer.toString(i), "B", 1, 6, i, false);
            board[whitePawns[i].getPositionRow()][whitePawns[i].getPositionColumn()] = whitePawns[i].getIcon();
        }

        Pawn [] blackPawns = new Pawn[8];
        for (int i = 0; i < 8; i++) {
            blackPawns[i] = new Pawn("BP" + Integer.toString(i), "W", 1, 1, i, false);
            board[blackPawns[i].getPositionRow()][blackPawns[i].getPositionColumn()] = blackPawns[i].getIcon();
        }

        // Print the board to the terminal
        for (int i = 0; i < board.length; i++) {
            String row = Integer.toString(8 - i);
            System.out.print(row + " ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("   ");
        int[] rows = {8, 7, 6, 5, 4, 3, 2, 1, 0};
        Character[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        for (int i = 0; i < letters.length; i++) {
            System.out.print(letters[i] + "   ");
        }
        System.out.println();

        // Start the game
        int moves = 1;
        while (true) {

            // Check if it's white or black's turn
            boolean whiteTurn = false;
            String turn = "";
            if (moves % 2 == 0) {
                whiteTurn = false;
                turn = "Black's turn";
            } else {
                whiteTurn = true;
                turn = "White's turn";
            }
            System.out.println(turn);

            // Get the user's selected piece column position
            int selectedColumn = 0;
            Scanner input1 = new Scanner(System.in);
            Character selectedLetter = input1.next().charAt(0);
            for (int i = 0; i < letters.length; i++) {
                if (letters[i] == selectedLetter) {
                    selectedColumn = i;
                }
            }

            // Get the user's selected piece row position
            Scanner input2 = new Scanner(System.in);
            int selectedRow = rows[input2.nextInt()];

            // Tell the user which piece they have selected
            System.out.println("Selected Piece - " + board[selectedRow][selectedColumn]);

            // Get the user's move column
            int moveColumn = 0;
            Scanner input3 = new Scanner(System.in);
            Character moveLetter = input3.next().charAt(0);
            for (int i = 0; i < letters.length; i++) {
                if (letters[i] == moveLetter) {
                    moveColumn = i + 1;
                }
            }

            // Get the user's move row
            Scanner input4 = new Scanner(System.in);
            int moveRow = rows[input4.nextInt() - 1];

            // If the king is selected
            if (board[selectedRow][selectedColumn].charAt(1) == 'K') {
                // If the piece is white
                if (board[selectedRow][selectedColumn].charAt(0) == 'W') {
                    // If it is white's turn
                    if (whiteTurn) {
                        // Convert piece number from a Character to an int
                        Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                        String piece = String.valueOf(pieceChar);
                        // If the user is trying to castle on the king side
                        if (!whiteKings[0].hasMoved() && moveColumn == 7) {
                            whiteKings[0].castle(board, true, whiteRooks, blackRooks);
                            moves++;
                        // If the user is trying to castle on the queen side
                        } else if (!whiteKings[0].hasMoved() && moveColumn == 3) {
                            whiteKings[0].castle(board, false, whiteRooks, blackRooks);
                            moves++;
                        // If the user is not trying to castle
                        } else {
                            whiteKings[Integer.parseInt(piece)].move(board, moveRow, moveColumn);
                            moves++;
                        }
                    // If it is not white's turn
                    } else {
                        System.out.println("It's not your turn");
                    }
                // If the piece is black
                } else {
                    // If it is black's turn
                    if (!whiteTurn) {
                        // Convert piece number from a Character to an int
                        Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                        String piece = String.valueOf(pieceChar);
                        // If the user is trying to castle on the king side
                        if (!blackKings[0].hasMoved() && moveColumn == 7) {
                            blackKings[0].castle(board, true, whiteRooks, blackRooks);
                            moves++;
                        // If the user is trying to castle on the queen side
                        } else if (!blackKings[0].hasMoved() && moveColumn == 3) {
                            blackKings[0].castle(board, false, whiteRooks, blackRooks);
                            moves++;
                        // If the user is not trying to castle
                        } else {
                            blackKings[Integer.parseInt(piece)].move(board, moveRow, moveColumn);
                            moves++;
                        }
                    // If it is not black's turn
                    } else {
                        System.out.println("It's not your turn");
                    }
                }

            } else if (board[selectedRow][selectedColumn].charAt(1) == 'Q') {
                if (board[selectedRow][selectedColumn].charAt(0) == 'W') {
                    if (whiteTurn) {
                        Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                        String piece = String.valueOf(pieceChar);
                        whiteQueens[Integer.parseInt(piece)].move(board, moveRow, moveColumn);
                        moves++;
                    } else {
                        System.out.println("It's not your turn");
                    }
                } else {
                    if (!whiteTurn) {
                        Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                        String piece = String.valueOf(pieceChar);
                        blackQueens[Integer.parseInt(piece)].move(board, moveRow, moveColumn);
                        moves++;
                    } else {
                        System.out.println("It's not your turn");
                    }
                }

            } else if (board[selectedRow][selectedColumn].charAt(1) == 'B') {
                if (board[selectedRow][selectedColumn].charAt(0) == 'W') {
                    if (whiteTurn) {
                        Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                        String piece = String.valueOf(pieceChar);
                        whiteBishops[Integer.parseInt(piece)].move(board, moveRow, moveColumn);
                        moves++;
                    } else {
                        System.out.println("It's not your turn");
                    }
                } else {
                    if (!whiteTurn) {
                        Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                        String piece = String.valueOf(pieceChar);
                        blackBishops[Integer.parseInt(piece)].move(board, moveRow, moveColumn);
                        moves++;
                    } else {
                        System.out.println("It's not your turn");
                    }
                }

            } else if (board[selectedRow][selectedColumn].charAt(1) == 'N') {
                if (board[selectedRow][selectedColumn].charAt(0) == 'W') {
                    if (whiteTurn) {
                        Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                        String piece = String.valueOf(pieceChar);
                        whiteKnights[Integer.parseInt(piece)].move(board, moveRow, moveColumn);
                        moves++;
                    } else {
                        System.out.println("It's not your turn");
                    }
                } else {
                    if (!whiteTurn) {
                        Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                        String piece = String.valueOf(pieceChar);
                        blackKnights[Integer.parseInt(piece)].move(board, moveRow, moveColumn);
                        moves++;
                    } else {
                        System.out.println("It's not your turn");
                    }
                }

            } else if (board[selectedRow][selectedColumn].charAt(1) == 'R') {
                if (board[selectedRow][selectedColumn].charAt(0) == 'W') {
                    if (whiteTurn) {
                        Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                        String piece = String.valueOf(pieceChar);
                        whiteRooks[Integer.parseInt(piece)].move(board, moveRow, moveColumn);
                        moves++;
                    } else {
                        System.out.println("It's not your turn");
                    }
                } else {
                    if (!whiteTurn) {
                        Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                        String piece = String.valueOf(pieceChar);
                        blackRooks[Integer.parseInt(piece)].move(board, moveRow, moveColumn);
                        moves++;
                    } else {
                        System.out.println("It's not your turn");
                    }
                }

            } else if (board[selectedRow][selectedColumn].charAt(1) == 'P') {
                if (board[selectedRow][selectedColumn].charAt(0) == 'W') {
                    if (whiteTurn) {
                        Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                        String piece = String.valueOf(pieceChar);
                        whitePawns[Integer.parseInt(piece)].move(board, moveRow, moveColumn,
                        whiteQueens, whiteRooks, whiteBishops, whiteKnights, whitePawns,
                        blackQueens, blackRooks, blackBishops, blackKnights, blackPawns);
                        moves++;
                    } else {
                        System.out.println("It's not your turn");
                    }
                } else {
                    if (!whiteTurn) {
                        Character pieceChar = board[selectedRow][selectedColumn].charAt(2);
                        String piece = String.valueOf(pieceChar);
                        blackPawns[Integer.parseInt(piece)].move(board, moveRow, moveColumn,
                        whiteQueens, whiteRooks, whiteBishops, whiteKnights, whitePawns,
                        blackQueens, blackRooks, blackBishops, blackKnights, blackPawns);
                        moves++;
                    } else {
                        System.out.println("It's not your turn");
                    }
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