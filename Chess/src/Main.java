import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Make the board and fill it with empty squares
        Squares[][] board = new Squares[8][8];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Squares(i, j, "00");
            }
        }

        Map<String, String> ranks = new HashMap<String, String>();
        ranks.put("1", "7");
        ranks.put("2", "6");
        ranks.put("3", "5");
        ranks.put("4", "4");
        ranks.put("5", "3");
        ranks.put("6", "2");
        ranks.put("7", "1");
        ranks.put("8", "0");

        Map<String, String> files = new HashMap<String, String>();
        files.put("A", "0");
        files.put("B", "1");
        files.put("C", "2");
        files.put("D", "3");
        files.put("E", "4");
        files.put("F", "5");
        files.put("G", "6");
        files.put("H", "7");

        //Spawn pawns
        for (int i = 0; i < 16; i++) {
            if (i < 8) {
                board[6][i] = new Pawn(6, i, "WP");
            } else {
                board[1][i - 8] = new Pawn(1, i - 8, "BP");
            }
        }
        int moveCounter = 0;

        displayBoard(board, moveCounter);

        while (true) {
            //Get user's selected piece
            System.out.print("Select a piece to move: ");

            Scanner sc = new Scanner(System.in);
            String input = sc.next();

            char fileChar = input.charAt(0);
            String fileString = files.get(String.valueOf(fileChar));
            int fileChoice = Integer.parseInt(fileString);

            char rankChar = input.charAt(1);
            String rankString = ranks.get(String.valueOf(rankChar));
            int rankChoice = Integer.parseInt(rankString);

            //Move users selected piece
            if (board[rankChoice][fileChoice].getIcon().charAt(0) == 'W' && moveCounter % 2 == 0) {
                board[rankChoice][fileChoice].move(board);
                board[rankChoice][fileChoice] = new Squares(rankChoice, fileChoice, "00");
                moveCounter++;
            } else if (board[rankChoice][fileChoice].getIcon().charAt(0) == 'B' && moveCounter % 2 != 0) {
                board[rankChoice][fileChoice].move(board); //Make new piece in new position
                board[rankChoice][fileChoice] = new Squares(rankChoice, fileChoice, "00"); //Delete piece from old position
                moveCounter++;
            } else if (board[rankChoice][fileChoice].getIcon().charAt(0) == '0') {
                System.out.println("This square is empty!");
            } else {
                System.out.println("Invalid input!");
            }

            displayBoard(board, moveCounter);
        }

    }

    //Function to display chess board
    public static void displayBoard(Squares[][] board, int moveCounter) {
        System.out.println("Move: " + (moveCounter + 1));

        Map<String, String> ranks = new HashMap<String, String>();
        ranks.put("0", "8");
        ranks.put("1", "7");
        ranks.put("2", "6");
        ranks.put("3", "5");
        ranks.put("4", "4");
        ranks.put("5", "3");
        ranks.put("6", "2");
        ranks.put("7", "1");

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

        Map<String, String> files = new HashMap<String, String>();
        files.put("0", "A");
        files.put("1", "B");
        files.put("2", "C");
        files.put("3", "D");
        files.put("4", "E");
        files.put("5", "F");
        files.put("6", "G");
        files.put("7", "H");

        System.out.print("| X | ");
        for (int i = 0; i < files.size(); i++) {
            String file = files.get(String.valueOf(i));
            System.out.print(file + "  ");
        }
        System.out.print("|");
        System.out.println();
        System.out.println("+-----------------------------+");
    }
}