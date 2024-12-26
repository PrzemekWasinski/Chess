public class Bishop extends Square {

    Bishop(int rank, int file, String icon, boolean moved) {
        super(rank, file, icon, moved);
    }

    public boolean move(Square[][] board, int newRank, int newFile) {
        board[newRank][newFile] = new Bishop(newRank, newFile, icon, false);
        return false;
    }
}
