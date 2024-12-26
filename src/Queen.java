public class Queen extends Square {

    Queen(int rank, int file, String icon, boolean moved) {
        super(rank, file, icon, moved);
    }

    public boolean move(Square[][] board, int rankChoice, int fileChoice) {
        board[rankChoice][fileChoice] = new Queen(rankChoice, fileChoice, icon, false);
        return false;
    }
}
