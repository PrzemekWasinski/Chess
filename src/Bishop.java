import java.util.ArrayList;

public class Bishop extends Square {

    Bishop(int rank, int file, String icon, boolean moved) {
        super(rank, file, icon, moved);
    }

    public boolean move(Square[][] board, int newRank, int newFile) {
        ArrayList<int[]> topLdownRmoves = new ArrayList<int[]>();
        ArrayList<int[]> topRdownLmoves = new ArrayList<int[]>();

        boolean atkTopLdownR = false;
        boolean defTopLdownR = false;

        boolean atkTopRdownL = false;
        boolean defTopRdownL = false;

        for (int i = 1; i < 8; i++) {
            try {
                if (board[rank + i][file + i].getIcon().charAt(0) != icon.charAt(0) &&
                    board[rank + i][file + i].getIcon().charAt(0) != '0') {
                    if ((board[rank + i][file + i].getIcon().charAt(1) == 'B') ||
                        (board[rank + i][file + i].getIcon().charAt(1) == 'Q')) {
                        atkTopLdownR = true;
                    }
                } else if (board[rank + i][file + i].getIcon().charAt(0) == icon.charAt(0)) {
                    if (board[rank + i][file + i].getIcon().charAt(1) == 'K') {
                        defTopLdownR = true;
                    } else {
                        break;
                    }
                }

                int[] move = {rank + i,file + i};
                topLdownRmoves.add(move);
            } catch (ArrayIndexOutOfBoundsException error) {
                break;
            }
        }

        //Up left
        for (int i = 1; i < 8; i++) {
            try {
                if (board[rank - i][file - i].getIcon().charAt(0) != icon.charAt(0) &&
                    board[rank - i][file - i].getIcon().charAt(0) != '0') {
                    if ((board[rank - i][file - i].getIcon().charAt(1) == 'B') ||
                        (board[rank - i][file - i].getIcon().charAt(1) == 'Q')) {
                        atkTopLdownR = true;
                    }
                } else if (board[rank - i][file - i].getIcon().charAt(0) == icon.charAt(0)) {
                    if (board[rank - i][file - i].getIcon().charAt(1) == 'K') {
                        defTopLdownR = true;
                    } else {
                        break;
                    }
                }
                int[] move = {rank - i,file - i};
                topLdownRmoves.add(move);
            } catch (ArrayIndexOutOfBoundsException error) {
                break;
            }
        }

        //Down left
        for (int i = 1; i < 8; i++) {
            try {
                if (board[rank + i][file - i].getIcon().charAt(0) != icon.charAt(0) &&
                    board[rank + i][file - i].getIcon().charAt(0) != '0') {
                    if ((board[rank + i][file - i].getIcon().charAt(1) == 'B') ||
                        (board[rank + i][file - i].getIcon().charAt(1) == 'Q')) {
                        atkTopRdownL = true;
                    }
                } else if (board[rank + i][file - i].getIcon().charAt(0) == icon.charAt(0)) {
                    if (board[rank + i][file - i].getIcon().charAt(1) == 'K') {
                        defTopRdownL = true;
                    } else {
                        break;
                    }
                }
                int[] move = {rank + i,file - i};
                topRdownLmoves.add(move);
            } catch (ArrayIndexOutOfBoundsException error) {
                break;
            }
        }

        //Up right
        for (int i = 1; i < 8; i++) {
            try {
                if (board[rank - i][file + i].getIcon().charAt(0) != icon.charAt(0) &&
                    board[rank - i][file + i].getIcon().charAt(0) != '0') {
                    if ((board[rank - i][file + i].getIcon().charAt(1) == 'B') ||
                        (board[rank - i][file + i].getIcon().charAt(1) == 'Q')) {
                        atkTopRdownL = true;
                    }
                } else if (board[rank - i][file + i].getIcon().charAt(0) == icon.charAt(0)) {
                    if (board[rank - i][file + i].getIcon().charAt(1) == 'K') {
                        defTopRdownL = true;
                    } else {
                        break;
                    }
                }
                int[] move = {rank - i,file + i};
                topRdownLmoves.add(move);
            } catch (ArrayIndexOutOfBoundsException error) {
                break;
            }
        }

        int[] newPosition = {newRank, newFile};

        boolean pinnedTopLdownR = atkTopLdownR && defTopLdownR;
        boolean pinnedTopRdownL = atkTopRdownL && defTopRdownL;

        if (!pinnedTopLdownR) {
            for (int i = 0; i < topLdownRmoves.size(); i++) {
                if (topLdownRmoves.get(i)[0] == newPosition[0] && topLdownRmoves.get(i)[1] == newPosition[1]) {
                    board[newRank][newFile] = new Queen(newRank, newFile, icon, true);
                    return true;
                }
            }
        }

        if (!pinnedTopRdownL) {
            for (int i = 0; i < topRdownLmoves.size(); i++) {
                if (topRdownLmoves.get(i)[0] == newPosition[0] && topRdownLmoves.get(i)[1] == newPosition[1]) {
                    board[newRank][newFile] = new Queen(newRank, newFile, icon, true);
                    return true;
                }
            }
        }

        return false;
    }
}
