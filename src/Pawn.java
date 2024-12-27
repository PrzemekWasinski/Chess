import java.util.ArrayList;
import java.util.Scanner;

public class Pawn extends Square {

    Pawn(int rank, int file, String icon, boolean moved) {
        super(rank, file, icon, moved);
    }

    public boolean move(Square[][] board, int newRank, int newFile) {
        ArrayList<int[]> moves = new ArrayList<int[]>();

        String pinResult = board[rank][file].isPinned(board);

        //Moving forwards
        if (icon.charAt(0) == 'W') {
            try {
                if (board[rank - 1][file].getIcon().equals("00") &&
                    !pinResult.equals("Horizontal") &&
                    !pinResult.equals("TopLdownR") &&
                    !pinResult.equals("TopRdownL")) {
                    moves.add(new int[]{rank - 1, file});
                    if (board[rank - 2][file].getIcon().equals("00") && !moved) {
                        moves.add(new int[]{rank - 2, file});
                    }
                }
            } catch (ArrayIndexOutOfBoundsException error) {}

            try {
                if (board[rank - 1][file - 1].getIcon().charAt(0) == 'B' &&
                    !pinResult.equals("Vertical") &&
                    !pinResult.equals("Horizontal") &&
                    !pinResult.equals("TopRdownL")) {
                    moves.add(new int[]{rank - 1, file - 1});
                }
            } catch (ArrayIndexOutOfBoundsException error) {}

            try {
                if (board[rank - 1][file + 1].getIcon().charAt(0) == 'B' &&
                    !pinResult.equals("Vertical") &&
                    !pinResult.equals("Horizontal") &&
                    !pinResult.equals("TopLdownR")) {
                    moves.add(new int[]{rank - 1, file + 1});
                }
            } catch (ArrayIndexOutOfBoundsException error) {}

        } else if (icon.charAt(0) == 'B') {
            try {
                if (board[rank + 1][file].getIcon().equals("00") &&
                    !pinResult.equals("Horizontal") &&
                    !pinResult.equals("TopLdownR") &&
                    !pinResult.equals("TopRdownL")) {
                    moves.add(new int[]{rank + 1, file});
                    if (board[rank + 2][file].getIcon().equals("00") && !moved) {
                        moves.add(new int[]{rank + 2, file});
                    }
                }
            } catch (ArrayIndexOutOfBoundsException error) {}

            try {
                if (board[rank + 1][file - 1].getIcon().charAt(0) == 'W' &&
                    !pinResult.equals("Vertical") &&
                    !pinResult.equals("Horizontal") &&
                    !pinResult.equals("TopLdownR")) {
                    moves.add(new int[]{rank + 1, file - 1});
                }
            } catch (ArrayIndexOutOfBoundsException error) {}

            try {
                if (board[rank + 1][file + 1].getIcon().charAt(0) == 'W' &&
                    !pinResult.equals("Horizontal") &&
                    !pinResult.equals("Vertical") &&
                    !pinResult.equals("TopRdownL")) {
                    moves.add(new int[]{rank + 1, file + 1});
                }
            } catch (ArrayIndexOutOfBoundsException error) {}
        }

        for (int i = 0; i < moves.size(); i++) {
            if (moves.get(i)[0] == newRank && moves.get(i)[1] == newFile) {
                if ((icon.charAt(0) == 'W' && newRank == 0) || (icon.charAt(0) == 'B' && newRank == 7)) {
                    System.out.print("Q - Queen | R - Rook | B - Bishop | N - Knight: ");

                    Scanner sc = new Scanner(System.in);
                    String promotion = sc.next();
                    boolean validInput = false;

                    while (!validInput) {
                        if (promotion.equals("Q") || promotion.equals("R") || promotion.equals("B") || promotion.equals("N")) {
                            validInput = true;
                        } else {
                            System.out.print("Q - Queen | R - Rook | B - Bishop | N - Knight: ");
                            promotion = sc.next();
                        }
                    }

                    if (promotion.equals("Q")) {
                        board[newRank][newFile] = new Queen(newRank, newFile, icon.charAt(0) + promotion, true);
                    } else if (promotion.equals("R")) {
                        board[newRank][newFile] = new Rook(newRank, newFile, icon.charAt(0) + promotion, true);
                    } else if (promotion.equals("B")) {
                        board[newRank][newFile] = new Bishop(newRank, newFile, icon.charAt(0) + promotion, true);
                    } else {
                        board[newRank][newFile] = new Knight(newRank, newFile, icon.charAt(0) + promotion, true);
                    }

                    return true;
                } else {
                    board[newRank][newFile] = new Pawn(newRank, newFile, icon, true);
                    return true;
                }
            }
        }

        return false;
    }
}
