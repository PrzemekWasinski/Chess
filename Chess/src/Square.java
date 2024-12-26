public class Square {
    public int rank;
    public int file;
    public String icon;
    public boolean moved;

    public Square(int rank, int file, String icon, boolean moved) {
        this.rank = rank;
        this.file = file;
        this.icon = icon;
        this.moved = moved;
    }

    public boolean move(Square[][] board, int rankChoice, int fileChoice) {
        return false;
    }

    //Searches for opposite colour!!!
    public boolean checkIfCheck(Square[][] board, String colour) {
        //Vertical and horizontal squares
        for (int i = rank; i < board.length; i++) {
            if (i != rank) {
                if (board[i][file].getIcon().charAt(0) != colour.charAt(0) &&
                    board[i][file].getIcon().charAt(0) != '0') {
                    if ((board[i][file].getIcon().charAt(1) == 'R') ||
                        (board[i][file].getIcon().charAt(1) == 'Q')) {
                        return true;
                    }
                }
            }
        }

        for (int i = rank; i > -1; i--) {
            if (i != rank) {
                if (board[i][file].getIcon().charAt(0) != colour.charAt(0) &&
                    board[i][file].getIcon().charAt(0) != '0') {
                    if ((board[i][file].getIcon().charAt(1) == 'R') ||
                        (board[i][file].getIcon().charAt(1) == 'Q')) {
                        return true;
                    }
                }
            }
        }

        for (int i = file; i < board[rank].length; i++) {
            if (i != file) {
                if (board[rank][i].getIcon().charAt(0) != colour.charAt(0) &&
                    board[rank][i].getIcon().charAt(0) != '0') {
                    if ((board[rank][i].getIcon().charAt(1) == 'R') ||
                        (board[rank][i].getIcon().charAt(1) == 'Q')) {
                        return true;
                    }
                }
            }
        }

        for (int i = file; i > -1; i--) {
            if (i != file) {
                if (board[rank][i].getIcon().charAt(0) != colour.charAt(0) &&
                    board[rank][i].getIcon().charAt(0) != '0') {
                    if ((board[rank][i].getIcon().charAt(1) == 'R') ||
                        (board[rank][i].getIcon().charAt(1) == 'Q')) {
                        return true;
                    }
                }
            }
        }

        //Down and right TRY TO REMOVE TRY CATCH
        for (int i = 1; i < 8; i++) {
            try {
                if (board[rank + i][file + i].getIcon().charAt(0) != colour.charAt(0) &&
                    board[rank + i][file + i].getIcon().charAt(0) != '0') {
                    if ((board[rank + i][file + i].getIcon().charAt(1) == 'B') ||
                        (board[rank + i][file + i].getIcon().charAt(1) == 'Q')) {
                        return true;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException error) {
                break;
            }
        }

        //Down and left
        for (int i = 1; i < 8; i++) {
            try {
                if (board[rank + i][file - i].getIcon().charAt(0) != colour.charAt(0) &&
                    board[rank + i][file - i].getIcon().charAt(0) != '0') {
                    if ((board[rank + i][file - i].getIcon().charAt(1) == 'B') ||
                        (board[rank + i][file - i].getIcon().charAt(1) == 'Q')) {
                        return true;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException error) {
                break;
            }
        }

        //Up and right
        for (int i = 1; i < 8; i++) {
            try {
                if (board[rank - i][file + i].getIcon().charAt(0) != colour.charAt(0) &&
                    board[rank - i][file + i].getIcon().charAt(0) != '0') {
                    if ((board[rank - i][file + i].getIcon().charAt(1) == 'B') ||
                        (board[rank - i][file + i].getIcon().charAt(1) == 'Q')) {
                        return true;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException error) {
                break;
            }
        }

        //Up and left
        for (int i = 1; i < 8; i++) {
            try {
                if (board[rank - i][file - i].getIcon().charAt(0) != colour.charAt(0) &&
                    board[rank - i][file - i].getIcon().charAt(0) != '0') {
                    if ((board[rank - i][file - i].getIcon().charAt(1) == 'B') ||
                        (board[rank - i][file - i].getIcon().charAt(1) == 'Q')) {
                        return true;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException error) {
                break;
            }
        }

        return false;
    }

    public boolean checkIfCheckmate(Square[][] board, String colour) {
        if (board[rank][file].checkIfCheck(board, colour)) {
            int[][] squares = {
                {rank + 1, file},
                {rank - 1, file},
                {rank, file + 1},
                {rank, file - 1},
                {rank + 1, file + 1},
                {rank - 1, file - 1},
                {rank + 1, file - 1},
                {rank - 1, file + 1}
            };

            for (int i = 0; i < squares.length; i++) {
                try {
                    if (!board[squares[i][0]][squares[i][1]].checkIfCheck(board, colour)) {
                        return false;
                    }
                } catch (ArrayIndexOutOfBoundsException error) {
                    continue;
                }
            }

            return true;
        }

        return false;
    }

    //SETTERS
    void setRank(int newRank) {
        this.rank = newRank;
    }

    void setFile(int newFile) {
        this.file = newFile;
    }

    void setIcon(String newIcon) {
        this.icon = newIcon;
    }

    //GETTERS
    int getRank() {
        return rank;
    }

    int getFile() {
        return file;
    }

    String getIcon() {
        return icon;
    }

    boolean hasMoved() {
        return moved;
    }
}
