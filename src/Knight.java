public class Knight extends Square {

    Knight(int rank, int file, String icon, boolean moved) {
        super(rank, file, icon, moved);
    }

    public boolean move(Square[][] board, int newRank, int newFile) {
        //If the knight isn't pinned
        if (board[rank][file].isPinned(board).equals("None")) {
            //Available moves
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

            //Check if the user's move is in the available moves array
            for (int i = 0; i < moves.length; i++) {
                try {
                    if (moves[i][0] == newRank && moves[i][1] == newFile) {
                        board[newRank][newFile] = new Knight(newRank, newFile, icon, true);
                        return true;
                    }
                } catch (ArrayIndexOutOfBoundsException error) {
                    continue;
                }
            }
        }
        return false;
    }
}
