public class Pawn extends Square {

    Pawn(int rank, int file, String icon, boolean moved) {
        super(rank, file, icon, moved);
    }

    public boolean move(Square[][] board, int newRank, int newFile) {
        board[newRank][newFile] = new Pawn(newRank, newFile, icon, false);
        return false;
    }
}
