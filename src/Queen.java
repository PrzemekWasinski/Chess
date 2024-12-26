public class Queen extends Square {

    Queen(int rank, int file, String icon, boolean moved) {
        super(rank, file, icon, moved);
    }

    public boolean move(Square[][] board, int newRank, int newFile) {
        board[newRank][newFile] = new Queen(newRank, newFile, icon, false);
        return false;
    }
}
