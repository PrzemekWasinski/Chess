import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Make the board and fill it with empty squares
        Square[][] board = new Square[8][8];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Square(i, j, "00", false);
            }
        }

        //Spawn kings
        board[7][4] = new King(7, 4, "WK", false);
        board[0][4] = new King(0, 4, "BK", false);

        //Spawn queens
        board[7][3] = new Queen(7, 3, "WQ", false);
        board[0][3] = new Queen(0, 3, "BQ", false);

        //Spawn rooks
        board[7][0] = new Rook(7, 0, "WR", false);
        board[7][7] = new Rook(7, 7, "WR", false);
        board[0][0] = new Rook(0, 0, "BR", false);
        board[0][7] = new Rook(0, 7, "BR", false);

        //Spawn bishops
        board[7][2] = new Bishop(7, 2, "WB", false);
        board[7][5] = new Bishop(7, 5, "WB", false);
        board[0][2] = new Bishop(0, 2, "BB", false);
        board[0][5] = new Bishop(0, 5, "BB", false);

        //Spawn knights
        board[7][1] = new Knight(7, 1, "WN", false);
        board[7][6] = new Knight(7, 6, "WN", false);
        board[0][1] = new Knight(0, 1, "BN", false);
        board[0][6] = new Knight(0, 6, "BN", false);

        //Spawn pawns
//        for (int i = 0; i < 16; i++) {
//            if (i < 8) {
//                board[6][i] = new Pawn(6, i, "WP", false);
//            } else {
//                board[1][i - 8] = new Pawn(1, i - 8, "BP", false);
//            }
//        }

        //Hashmap to convert rank input to array index
        Map<String, String> ranks = new HashMap<String, String>();
        ranks.put("1", "7");
        ranks.put("2", "6");
        ranks.put("3", "5");
        ranks.put("4", "4");
        ranks.put("5", "3");
        ranks.put("6", "2");
        ranks.put("7", "1");
        ranks.put("8", "0");

        //Hashmap to convert file input to array index
        Map<String, String> files = new HashMap<String, String>();
        files.put("A", "0");
        files.put("B", "1");
        files.put("C", "2");
        files.put("D", "3");
        files.put("E", "4");
        files.put("F", "5");
        files.put("G", "6");
        files.put("H", "7");

        //Print welcome message
        System.out.println("+--------------------------------------------------------------------+");
        System.out.println("|                         Welcome to Chess!                          |");
        System.out.println("|          Select and move pieces by entering their position.        |");
        System.out.println("| For example the input (E2) will select the piece on the E2 square! |");
        System.out.println("+--------------------------------------------------------------------+");

        int moveCounter = 0;

        displayBoard(board, moveCounter);

        //Start game loop
        while (true) {
            boolean checkmate = false;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j].getIcon().equals("WK")) {
                        if (board[i][j].checkIfCheckmate(board, "W")) {
                            System.out.println("Black Wins by Checkmate!");
                            checkmate = true;
                            break;
                        }
                    }
                    if (board[i][j].getIcon().equals("BK")) {
                        if (board[i][j].checkIfCheckmate(board, "B")) {
                            System.out.println("White Wins by Checkmate!");
                            checkmate = true;
                            break;
                        }
                    }
                }
            }

            if (checkmate) {
                break;
            }

            //Get user's selected piece
            System.out.print("Select a piece to move: ");

            Scanner sc = new Scanner(System.in);
            String input = sc.next();

            //Convert user's selected piece to array index
            char fileChar = input.charAt(0);
            String fileString = files.get(String.valueOf(fileChar));
            int file = Integer.parseInt(fileString);

            char rankChar = input.charAt(1);
            String rankString = ranks.get(String.valueOf(rankChar));
            int rank = Integer.parseInt(rankString);

            if ((board[rank][file].getIcon().charAt(0) == 'W' && moveCounter % 2 == 0) ||
                (board[rank][file].getIcon().charAt(0) == 'B' && moveCounter % 2 != 0)) {

                System.out.print("Select where to move your " + board[rank][file].getIcon() + ": ");

                Scanner sc2 = new Scanner(System.in);
                String moveInput = sc2.next();

                char newFileChar = moveInput.charAt(0);
                String newFileString = files.get(String.valueOf(newFileChar));
                int newFile = Integer.parseInt(newFileString);

                char newRankChar = moveInput.charAt(1);
                String newRankString = ranks.get(String.valueOf(newRankChar));
                int newRank = Integer.parseInt(newRankString);

                if ((board[rank][file].getIcon().charAt(1) == 'K' && !board[rank][file].hasMoved()) && (newRank == rank && newFile == file + 2)) {
                    if (board[rank][file + 3].getIcon().charAt(1) == 'R' &&
                        !board[rank][file + 3].hasMoved() &&
                        board[rank][file + 1].getIcon().equals("00") &&
                        board[rank][file + 2].getIcon().equals("00")) {

                        if (!board[rank][file].checkIfCheck(board, String.valueOf(board[rank][file].getIcon().charAt(0))) &&
                            !board[rank][file + 1].checkIfCheck(board, String.valueOf(board[rank][file].getIcon().charAt(0))) &&
                            !board[rank][file + 2].checkIfCheck(board, String.valueOf(board[rank][file].getIcon().charAt(0)))) {

                            board[rank][file + 2] = new King(newRank, newFile, board[rank][file].getIcon(), true);
                            board[rank][file] = new Square(rank, file, "00", false);
                            board[rank][file + 1] = new Rook(rank, file + 1, board[rank][file + 3].getIcon(), true);
                            board[rank][file + 3] = new Square(rank, file, "00", false);
                            moveCounter++;
                        } else {
                            System.out.println("Invalid Move!");
                        }
                    } else {
                        System.out.println("Invalid Move!");
                    }

                } else if ((board[rank][file].getIcon().charAt(1) == 'K' && !board[rank][file].hasMoved()) && (newRank == rank && newFile == file + 2)) {
                    if (board[rank][file - 4].getIcon().charAt(1) == 'R' &&
                        !board[rank][file - 4].hasMoved() &&
                        board[rank][file - 1].getIcon().equals("00") &&
                        board[rank][file - 2].getIcon().equals("00") &&
                        board[rank][file - 2].getIcon().equals("00") ) {

                        if (!board[rank][file].checkIfCheck(board, String.valueOf(board[rank][file].getIcon().charAt(0))) &&
                            !board[rank][file - 1].checkIfCheck(board, String.valueOf(board[rank][file].getIcon().charAt(0))) &&
                            !board[rank][file - 2].checkIfCheck(board, String.valueOf(board[rank][file].getIcon().charAt(0))) &&
                            !board[rank][file - 3].checkIfCheck(board, String.valueOf(board[rank][file].getIcon().charAt(0)))) {

                            board[rank][file - 2] = new King(newRank, newFile, board[rank][file].getIcon(), true);
                            board[rank][file] = new Square(rank, file, "00", false);
                            board[rank][file - 1] = new Rook(rank, file + 1, board[rank][file + 3].getIcon(), true);
                            board[rank][file - 3] = new Square(rank, file, "00", false);
                            board[rank][file - 4] = new Square(rank, file, "00", false);
                            moveCounter++;
                        } else {
                            System.out.println("Invalid Move!");
                        }
                    } else {
                        System.out.println("Invalid Move!");
                    }
                }

                else if (board[rank][file].move(board, newRank, newFile)) { //If piece was moved successfully
                    board[rank][file] = new Square(rank, file, "00", false); //Clear the old position
                    moveCounter++; //Increment move counter

                } else {
                    System.out.println("Invalid move!");
                }

            } else if (board[rank][file].getIcon().charAt(0) == 'W' && moveCounter % 2 != 0) {
                System.out.println("Its Black's turn!");
            } else if (board[rank][file].getIcon().charAt(0) == 'B' && moveCounter % 2 == 0) {
                System.out.println("Its White's turn!");
            } else {
                System.out.println("Invalid input");
            }

            displayBoard(board, moveCounter);
        }
    }

    //Function to display chess board
    public static void displayBoard(Square[][] board, int moveCounter) {
        //Hashmap for printing ranks
        Map<String, String> ranks = new HashMap<String, String>();
        ranks.put("0", "8");
        ranks.put("1", "7");
        ranks.put("2", "6");
        ranks.put("3", "5");
        ranks.put("4", "4");
        ranks.put("5", "3");
        ranks.put("6", "2");
        ranks.put("7", "1");

        //Print board and pieces
        System.out.println("+-----------------------------+");
        for (int i = 0; i < board.length; i++) {
            System.out.print("| " + (ranks.get(String.valueOf(i))) + " ");
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j].getIcon() + " ");
            }
            System.out.println("|");
        }
        System.out.println("|---|-------------------------|");

        //Print the move counter
        if (moveCounter < 10) {
            System.out.print("|00" + moveCounter + "| ");
        } else if (moveCounter < 100) {
            System.out.print("|0" + moveCounter + "| ");
        } else if (moveCounter < 1000) {
            System.out.print("|" + moveCounter + "| ");
        }

        //Hashtable for files
        Map<String, String> files = new HashMap<String, String>();
        files.put("0", "A");
        files.put("1", "B");
        files.put("2", "C");
        files.put("3", "D");
        files.put("4", "E");
        files.put("5", "F");
        files.put("6", "G");
        files.put("7", "H");

        //Print files
        for (int i = 0; i < files.size(); i++) {
            String file = files.get(String.valueOf(i));
            System.out.print(file + "  ");
        }

        System.out.print("|");
        System.out.println();
        System.out.println("+-----------------------------+");
    }
}