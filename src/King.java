public class King extends Square {
    public King(int rank, int file, String icon, boolean moved) {
        super(rank, file, icon, moved);
    }

    public boolean move(Square[][] board, int newRank, int newFile) {
        //Available moves
        int[][] moves = {
            {rank + 1, file},
            {rank - 1, file},
            {rank, file + 1},
            {rank, file - 1},
            {rank + 1, file + 1},
            {rank - 1, file - 1},
            {rank + 1, file - 1},
            {rank - 1, file + 1}
        };

        //Check if user's move is in the array and check if it is safe
        for (int i = 0; i < moves.length; i++) {
            try {
                if (moves[i][0] == newRank && moves[i][1] == newFile) {
                    if (board[newRank][newFile].checkIfCheck(board, String.valueOf(icon.charAt(0)))) {
                        return false;
                    } else {
                        board[newRank][newFile] = new King(newRank, newFile, icon, true);
                        return true;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException error) {
                continue;
            }
        }
        return false;
    }
}
