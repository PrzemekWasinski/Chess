public class Knight extends Square {

    Knight(int rank, int file, String icon, boolean moved) {
        super(rank, file, icon, moved);
    }

    public boolean move(Square[][] board, int newRank, int newFile) {
        if (board[rank][file].isPinned(board).equals("None")) {
            int[][] moves = {
                {rank + 2, file + 1},
                {rank + 2, file - 1},
                {rank - 2, file + 1},
                {rank - 2, file - 1},
                {rank + 1, file + 2},
                {rank - 1, file + 2},
                {rank + 1, file - 2},
                {rank - 1, file - 2}
            };

            for (int i = 0; i < moves.length; i++) {
                if (moves[i][0] == newRank && moves[i][1] == newFile) {
                    try {
                        board[newRank][newFile] = new Knight(newRank, newFile, icon, true);
                        return true;
                    } catch (ArrayIndexOutOfBoundsException error) {
                        continue;
                    }
                }
            }
        }
        return false;
    }
}
