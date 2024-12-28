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

    public boolean move(Square[][] board, int newRank, int newFile) {
        return false;
    }

    /////////
    //CHECK//
    /////////
    public boolean checkIfCheck(Square[][] board, String colour) { //Searches for opposite colour
        //Vertical and horizontal squares
        for (int i = rank; i < board.length; i++) {
            if (i != rank) {
                if (board[i][file].getIcon().charAt(0) == colour.charAt(0)) {
                    break;
                } else if (board[i][file].getIcon().charAt(0) != colour.charAt(0) &&
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
                if (board[i][file].getIcon().charAt(0) == colour.charAt(0)) {
                    break;
                } else if (board[i][file].getIcon().charAt(0) != colour.charAt(0) &&
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
                if (board[i][file].getIcon().charAt(0) == colour.charAt(0)) {
                    break;
                } else if (board[rank][i].getIcon().charAt(0) != colour.charAt(0) &&
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
                if (board[i][file].getIcon().charAt(0) == colour.charAt(0)) {
                    break;
                } else if (board[rank][i].getIcon().charAt(0) != colour.charAt(0) &&
                    board[rank][i].getIcon().charAt(0) != '0') {
                    if ((board[rank][i].getIcon().charAt(1) == 'R') ||
                        (board[rank][i].getIcon().charAt(1) == 'Q')) {
                        return true;
                    }
                }
            }
        }

        //Down and right
        for (int i = 1; i < 8; i++) {
            try {
                 if (board[i][file].getIcon().charAt(0) == colour.charAt(0)) {
                    break;
                } else if (board[rank + i][file + i].getIcon().charAt(0) != colour.charAt(0) &&
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
                if (board[i][file].getIcon().charAt(0) == colour.charAt(0)) {
                    break;
                } else if (board[rank + i][file - i].getIcon().charAt(0) != colour.charAt(0) &&
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
                if (board[i][file].getIcon().charAt(0) == colour.charAt(0)) {
                    break;
                } else if (board[rank - i][file + i].getIcon().charAt(0) != colour.charAt(0) &&
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
                if (board[i][file].getIcon().charAt(0) == colour.charAt(0)) {
                    break;
                } else if (board[rank - i][file - i].getIcon().charAt(0) != colour.charAt(0) &&
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

        int[][] knightSquares = {
            {rank + 2, file + 1},
            {rank + 2, file - 1},
            {rank - 2, file + 1},
            {rank - 2, file - 1},
            {rank + 1, file + 2},
            {rank - 1, file + 2},
            {rank + 1, file - 2},
            {rank - 1, file - 2}
        };

        for (int i = 0; i < knightSquares.length; i++) {
            try {
                if (board[knightSquares[i][0]][knightSquares[i][1]].getIcon().charAt(0) != icon.charAt(0) &&
                        board[knightSquares[i][0]][knightSquares[i][1]].getIcon().charAt(0) == 'K') {
                    return true;
                }
            } catch (ArrayIndexOutOfBoundsException error) {
                continue;
            }
        }

        int[][] pawnSquares;

        if (icon.charAt(0) == 'W') {
            pawnSquares = new int[][]{
                {rank - 1, file - 1},
                {rank - 1, file + 1}
            };
        } else {
            pawnSquares = new int[][]{
                {rank + 1, file - 1},
                {rank + 1, file + 1}
            };
        }

        try {
            if (board[pawnSquares[0][0]][pawnSquares[0][1]].icon.charAt(0) != icon.charAt(0) &&
                    board[pawnSquares[0][0]][pawnSquares[0][1]].icon.charAt(1) == 'P') {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException error) {}

        try {
            if (board[pawnSquares[1][0]][pawnSquares[1][1]].icon.charAt(0) != icon.charAt(0) &&
                    board[pawnSquares[1][0]][pawnSquares[1][1]].icon.charAt(1) == 'P') {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException error) {}

        return false;
    }

    /////////////
    //CHECKMATE//
    /////////////
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

    /////////////
    //STALEMATE//
    /////////////
    public boolean isStalemate(Square[][] board, String colour) {
        if (!board[rank][file].checkIfCheck(board, colour)) {
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

    ////////
    //PINS//
    ////////
    public String isPinned(Square[][] board) {
        boolean attackVer = false;
        boolean defendVer = false;

        boolean attackHor = false;
        boolean defendHor = false;

        boolean attackTopLdownR = false;
        boolean defendTopLdownR = false;

        boolean attackTopRdownL = false;
        boolean defendTopRdownL = false;

        for (int i = rank; i < board.length; i++) {
            if (i != rank) {
                if (board[i][file].getIcon().charAt(0) == icon.charAt(0)) {
                    if (board[i][file].getIcon().charAt(1) == 'K') {
                        defendVer = true;
                    } else {
                        break;
                    }
                } else if (board[i][file].getIcon().charAt(0) != icon.charAt(0) && board[i][file].getIcon().charAt(0) != '0') {
                    if ((board[i][file].getIcon().charAt(1) == 'R') ||
                        (board[i][file].getIcon().charAt(1) == 'Q')) {
                        attackVer = true;
                    }
                }
            }
        }

        //Add squares above rook to vertical moves
        for (int i = rank; i > -1; i--) {
            if (i != rank) {
                if (board[i][file].getIcon().charAt(0) == icon.charAt(0)) {
                    if (board[i][file].getIcon().charAt(1) == 'K') {
                        defendVer = true;
                    } else {
                        break;
                    }
                } else if (board[i][file].getIcon().charAt(0) != icon.charAt(0) && board[i][file].getIcon().charAt(0) != '0') {
                    if ((board[i][file].getIcon().charAt(1) == 'R') ||
                        (board[i][file].getIcon().charAt(1) == 'Q')) {
                        attackVer = true;
                    }
                }
            }
        }

        //Add squares to the right of the rook to horizontal moves
        for (int i = file; i < board[rank].length; i++) {
            if (i != file) {
                if (board[rank][i].getIcon().charAt(0) == icon.charAt(0)) {
                    if (board[rank][i].getIcon().charAt(1) == 'K') {
                        defendHor = true;
                    } else {
                        break;
                    }
                } else if (board[rank][i].getIcon().charAt(0) != icon.charAt(0) && board[rank][i].getIcon().charAt(0) != '0') {
                    if ((board[rank][i].getIcon().charAt(1) == 'R') ||
                        (board[rank][i].getIcon().charAt(1) == 'Q')) {
                        attackHor = true;
                    }
                }
            }
        }

        //Add moves to the left of the rook to horizontal moves
        for (int i = file; i > -1; i--) {
            if (i != file) {
                if (board[rank][i].getIcon().charAt(0) == icon.charAt(0)) {
                    if (board[rank][i].getIcon().charAt(1) == 'K') {
                        defendHor = true;
                    } else {
                        break;
                    }
                } else if (board[rank][i].getIcon().charAt(0) != icon.charAt(0) && board[rank][i].getIcon().charAt(0) != '0') {
                    if ((board[rank][i].getIcon().charAt(1) == 'R') ||
                        (board[rank][i].getIcon().charAt(1) == 'Q')) {
                        attackHor = true;
                    }
                }
            }
        }
        //Right down
        for (int i = 1; i < 8; i++) {
            try {
                if (board[rank + i][file + i].getIcon().charAt(0) != icon.charAt(0) &&
                    board[rank + i][file + i].getIcon().charAt(0) != '0') {
                    if ((board[rank + i][file + i].getIcon().charAt(1) == 'B') ||
                        (board[rank + i][file + i].getIcon().charAt(1) == 'Q')) {
                        attackTopLdownR = true;
                    }
                } else if (board[rank + i][file + i].getIcon().charAt(0) == icon.charAt(0)) {
                    if (board[rank + i][file + i].getIcon().charAt(1) == 'K') {
                        defendTopLdownR = true;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException error) {
                break;
            }
        }

        //Up left
        for (int i = 1; i < 8; i++) {
            try {
                if (board[rank - i][file - i].getIcon().charAt(0) != icon.charAt(0) &&
                    board[rank - i][file - i].getIcon().charAt(0) != '0') {
                    if ((board[rank - i][file - i].getIcon().charAt(1) == 'B') ||
                        (board[rank - i][file - i].getIcon().charAt(1) == 'Q')) {
                        attackTopLdownR = true;
                    }
                } else if (board[rank - i][file - i].getIcon().charAt(0) == icon.charAt(0)) {
                    if (board[rank - i][file - i].getIcon().charAt(1) == 'K') {
                        defendTopLdownR = true;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException error) {
                break;
            }
        }

        //Down left
        for (int i = 1; i < 8; i++) {
            try {
                if (board[rank + i][file - i].getIcon().charAt(0) != icon.charAt(0) &&
                    board[rank + i][file - i].getIcon().charAt(0) != '0') {
                    if ((board[rank + i][file - i].getIcon().charAt(1) == 'B') ||
                        (board[rank + i][file - i].getIcon().charAt(1) == 'Q')) {
                        attackTopRdownL = true;
                    }
                } else if (board[rank + i][file - i].getIcon().charAt(0) == icon.charAt(0)) {
                    if (board[rank + i][file - i].getIcon().charAt(1) == 'K') {
                        defendTopRdownL = true;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException error) {
                break;
            }
        }

        //Up right
        for (int i = 1; i < 8; i++) {
            try {
                if (board[rank - i][file + i].getIcon().charAt(0) != icon.charAt(0) &&
                    board[rank - i][file + i].getIcon().charAt(0) != '0') {
                    if ((board[rank - i][file + i].getIcon().charAt(1) == 'B') ||
                        (board[rank - i][file + i].getIcon().charAt(1) == 'Q')) {
                        attackTopRdownL = true;
                    }
                } else if (board[rank - i][file + i].getIcon().charAt(0) == icon.charAt(0)) {
                    if (board[rank - i][file + i].getIcon().charAt(1) == 'K') {
                        defendTopRdownL = true;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException error) {
                break;
            }
        }

        if (attackVer && defendVer) {
            return "Vertical";
        } else if (attackHor && defendHor) {
            return "Horizontal";
        } else if (attackTopLdownR && defendTopLdownR) {
            return "TopLdownR";
        } else if (attackTopRdownL && defendTopRdownL) {
            return "TopRdownL";
        }
        return "None";
    }

    String getIcon() {
        return icon;
    }

    boolean hasMoved() {
        return moved;
    }
}
