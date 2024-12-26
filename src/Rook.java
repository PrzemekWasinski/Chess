import java.util.ArrayList;

public class Rook extends Square {
    Rook(int rank, int file, String icon, boolean moved) {
        super(rank, file, icon, moved);
    }

    public boolean move(Square[][] board, int newRank, int newFile) {
        ArrayList<int[]> verticalMoves = new ArrayList<int[]>();
        ArrayList<int[]> horizontalMoves = new ArrayList<int[]>();

        boolean attackVer = false;
        boolean defendVer = false;

        boolean attackHor = false;
        boolean defendHor = false;

        //Add squares below rook to vertical moves
        for (int i = rank; i < board.length; i++) {
            if (i != rank) {
                if (board[i][file].getIcon().charAt(1) == 'K') {
                    if (board[i][file].getIcon().charAt(0) == icon.charAt(0)) {
                        defendVer = true;
                    }
                    break;
                }

                if (board[i][file].getIcon().charAt(0) == icon.charAt(0)) {
                    break;
                }

                if ((board[i][file].getIcon().charAt(1) == 'R') ||
                    (board[i][file].getIcon().charAt(1) == 'Q')) {
                    attackVer = true;
                }

                int[] move = {i, file};
                verticalMoves.add(move);
            }
        }

        //Add squares above rook to vertical moves
        for (int i = rank; i > -1; i--) {
            if (i != rank) {
                if (board[i][file].getIcon().charAt(1) == 'K') {
                    if (board[i][file].getIcon().charAt(0) == icon.charAt(0)) {
                        defendVer = true;
                    }
                    break;
                }

                if (board[i][file].getIcon().charAt(0) == icon.charAt(0)) {
                    break;
                }

                if ((board[i][file].getIcon().charAt(1) == 'R') ||
                    (board[i][file].getIcon().charAt(1) == 'Q')) {
                    attackVer = true;
                }

                int[] move = {i, file};
                verticalMoves.add(move);
            }
        }

        //Add squares to the right of the rook to horizontal moves
        for (int i = file; i < board[rank].length; i++) {
            if (i != file) {
                if (board[rank][i].getIcon().charAt(1) == 'K') {
                    if (board[rank][i].getIcon().charAt(0) == icon.charAt(0)) {
                        defendHor = true;
                    }
                    break;
                }

                if (board[rank][i].getIcon().charAt(0) == icon.charAt(0)) {
                    break;
                }

                if ((board[rank][i].getIcon().charAt(1) == 'R') ||
                    (board[rank][i].getIcon().charAt(1) == 'Q')) {
                    attackHor = true;
                }

                int[] move = {rank, i};
                horizontalMoves.add(move);
            }
        }

        //Add moves to the left of the rook to horizontal moves
        for (int i = file; i > -1; i--) {
            if (i != file) {
                if (board[rank][i].getIcon().charAt(1) == 'K') {
                    if (board[rank][i].getIcon().charAt(0) == icon.charAt(0)) {
                        defendHor = true;
                    }
                    break;
                }

                if (board[rank][i].getIcon().charAt(0) == icon.charAt(0)) {
                    break;
                }

                if ((board[rank][i].getIcon().charAt(1) == 'R') ||
                    (board[rank][i].getIcon().charAt(1) == 'Q')) {
                    attackHor = true;
                }

                int[] move = {rank, i};
                horizontalMoves.add(move);
            }
        }

        int[] newPosition = {newRank, newFile};

        boolean pinnedVertical = defendVer && attackVer;
        boolean pinnedHorizontal = defendHor && attackHor;

        if (!pinnedHorizontal) {
            for (int i = 0; i < verticalMoves.size(); i++) {
                if (verticalMoves.get(i)[0] == newPosition[0] && verticalMoves.get(i)[1] == newPosition[1]) {
                    board[newRank][newFile] = new Rook(newRank, newFile, icon, true);
                    return true;
                }
            }
        }

        if (!pinnedVertical) {
            for (int i = 0; i < horizontalMoves.size(); i++) {
                if (horizontalMoves.get(i)[0] == newPosition[0] && horizontalMoves.get(i)[1] == newPosition[1]) {
                    board[newRank][newFile] = new Rook(newRank, newFile, icon, true);
                    return true;
                }
            }
        }

        return false;
    }
}
