import java.util.ArrayList;

public class King extends Square {
    public King(int rank, int file, String icon, boolean moved) {
        super(rank, file, icon, moved);
    }

    public boolean move(Square[][] board, int rankChoice, int fileChoice) {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        moves.add(new int[] {rank + 1, file});
        moves.add(new int[] {rank - 1, file});
        moves.add(new int[] {rank, file + 1});
        moves.add(new int[] {rank, file - 1});
        moves.add(new int[] {rank + 1, file + 1});
        moves.add(new int[] {rank - 1, file - 1});
        moves.add(new int[] {rank + 1, file - 1});
        moves.add(new int[] {rank - 1, file + 1});

        for (int i = 0; i < moves.size(); i++) {
            if (moves.get(i)[0] == rankChoice && moves.get(i)[1] == fileChoice) {
                if (board[rankChoice][fileChoice].checkIfCheck(board, String.valueOf(icon.charAt(0)))) {
                    return false;
                } else {
                    board[rankChoice][fileChoice] = new King(rankChoice, fileChoice, icon, true);
                    return true;
                }
            }
        }

        return false;
    }
}
