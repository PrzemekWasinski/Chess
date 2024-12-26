public class Knight extends Square {

    Knight(int rank, int file, String icon, boolean moved) {
        super(rank, file, icon, moved);
    }

    public boolean move(Square[][] board, int rankChoice, int fileChoice) {
        board[rankChoice][fileChoice] = new Knight(rankChoice, fileChoice, icon, false);
        return false;
    }
}
