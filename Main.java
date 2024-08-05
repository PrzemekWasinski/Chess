public class Main {
    public static void main(String[] args) {
        String[][] board = new String[8][8];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = "00";
            }
        }

        King whiteKing = new King("WK", 0, 7, 4);
        King blackKing = new King("BK", 0, 0, 4);
        board[whiteKing.getPositionRow()][whiteKing.getPositionColumn()] = whiteKing.getIcon();
        board[blackKing.getPositionRow()][blackKing.getPositionColumn()] = blackKing.getIcon();

        Queen whiteQueen = new Queen("WQ", "B", 9, 7, 3);
        Queen blackQueen = new Queen("BQ", "W", 9, 0, 3);
        board[whiteQueen.getPositionRow()][whiteQueen.getPositionColumn()] = whiteQueen.getIcon();
        board[blackQueen.getPositionRow()][blackQueen.getPositionColumn()] = blackQueen.getIcon();

        Bishop whiteBishop1 = new Bishop("WB", "B", 3, 7, 2);
        Bishop whiteBishop2 = new Bishop("WB", "B", 3, 7, 5);
        Bishop blackBishop1 = new Bishop("BB", "W", 3, 0, 2);
        Bishop blackBishop2 = new Bishop("BB", "W", 3, 0, 5);
        board[whiteBishop1.getPositionRow()][whiteBishop1.getPositionColumn()] = whiteBishop1.getIcon();
        board[whiteBishop2.getPositionRow()][whiteBishop2.getPositionColumn()] = whiteBishop2.getIcon();
        board[blackBishop1.getPositionRow()][blackBishop1.getPositionColumn()] = blackBishop1.getIcon();
        board[blackBishop2.getPositionRow()][blackBishop2.getPositionColumn()] = blackBishop2.getIcon();

        Knight whiteKnight1 = new Knight("WN", "B",3, 7, 1);
        Knight whiteKnight2 = new Knight("WN", "B",3, 7, 6);
        Knight blackKnight1 = new Knight("BN", "W",3, 0, 1);
        Knight blackKnight2 = new Knight("BN", "W",3, 0, 6);
        board[whiteKnight1.getPositionRow()][whiteKnight1.getPositionColumn()] = whiteKnight1.getIcon();
        board[whiteKnight2.getPositionRow()][whiteKnight2.getPositionColumn()] = whiteKnight2.getIcon();
        board[blackKnight1.getPositionRow()][blackKnight1.getPositionColumn()] = blackKnight1.getIcon();
        board[blackKnight2.getPositionRow()][blackKnight2.getPositionColumn()] = blackKnight2.getIcon();

        Rook whiteRook1 = new Rook("WR", "B", 5, 7, 0);
        Rook whiteRook2 = new Rook("WR", "B", 5, 7, 7);
        Rook blackRook1 = new Rook("BR", "W", 5, 0, 0);
        Rook blackRook2 = new Rook("BR", "W", 5, 0, 7);
        board[whiteRook1.getPositionRow()][whiteRook1.getPositionColumn()] = whiteRook1.getIcon();
        board[whiteRook2.getPositionRow()][whiteRook2.getPositionColumn()] = whiteRook2.getIcon();
        board[blackRook1.getPositionRow()][blackRook1.getPositionColumn()] = blackRook1.getIcon();
        board[blackRook2.getPositionRow()][blackRook2.getPositionColumn()] = blackRook2.getIcon();

        Pawn whitePawn1 = new Pawn("WP", "B", 1, 6, 0, false);
        Pawn whitePawn2 = new Pawn("WP", "B", 1, 6, 1, false);
        Pawn whitePawn3 = new Pawn("WP", "B", 1, 6, 2, false);
        Pawn whitePawn4 = new Pawn("WP", "B", 1, 6, 3, false);
        Pawn whitePawn5 = new Pawn("WP", "B", 1, 6, 4, false);
        Pawn whitePawn6 = new Pawn("WP", "B", 1, 6, 5, false);
        Pawn whitePawn7 = new Pawn("WP", "B", 1, 6, 6, false);
        Pawn whitePawn8 = new Pawn("WP", "B", 1, 6, 7, false);
        board[whitePawn1.getPositionRow()][whitePawn1.getPositionColumn()] = whitePawn1.getIcon();
        board[whitePawn2.getPositionRow()][whitePawn2.getPositionColumn()] = whitePawn2.getIcon();
        board[whitePawn3.getPositionRow()][whitePawn3.getPositionColumn()] = whitePawn3.getIcon();
        board[whitePawn4.getPositionRow()][whitePawn4.getPositionColumn()] = whitePawn4.getIcon();
        board[whitePawn5.getPositionRow()][whitePawn5.getPositionColumn()] = whitePawn5.getIcon();
        board[whitePawn6.getPositionRow()][whitePawn6.getPositionColumn()] = whitePawn6.getIcon();
        board[whitePawn7.getPositionRow()][whitePawn7.getPositionColumn()] = whitePawn7.getIcon();
        board[whitePawn8.getPositionRow()][whitePawn8.getPositionColumn()] = whitePawn8.getIcon();

        Pawn blackPawn1 = new Pawn("BP", "W", 1, 1, 0, false);
        Pawn blackPawn2 = new Pawn("BP", "W", 1, 1, 1, false);
        Pawn blackPawn3 = new Pawn("BP", "W", 1, 1, 2, false);
        Pawn blackPawn4 = new Pawn("BP", "W", 1, 1, 3, false);
        Pawn blackPawn5 = new Pawn("BP", "W", 1, 1, 4, false);
        Pawn blackPawn6 = new Pawn("BP", "W", 1, 1, 5, false);
        Pawn blackPawn7 = new Pawn("BP", "W", 1, 1, 6, false);
        Pawn blackPawn8 = new Pawn("BP", "W", 1, 1, 7, false);

        board[blackPawn1.getPositionRow()][blackPawn1.getPositionColumn()] = blackPawn1.getIcon();
        board[blackPawn2.getPositionRow()][blackPawn2.getPositionColumn()] = blackPawn2.getIcon();
        board[blackPawn3.getPositionRow()][blackPawn3.getPositionColumn()] = blackPawn3.getIcon();
        board[blackPawn4.getPositionRow()][blackPawn4.getPositionColumn()] = blackPawn4.getIcon();
        board[blackPawn5.getPositionRow()][blackPawn5.getPositionColumn()] = blackPawn5.getIcon();
        board[blackPawn6.getPositionRow()][blackPawn6.getPositionColumn()] = blackPawn6.getIcon();
        board[blackPawn7.getPositionRow()][blackPawn7.getPositionColumn()] = blackPawn7.getIcon();
        board[blackPawn8.getPositionRow()][blackPawn8.getPositionColumn()] = blackPawn8.getIcon();

        //Example usage of showing the Italian Opening:
        whitePawn5.move(board, 5, 5);
        blackPawn5.move(board, 4, 5);
        whiteKnight2.move(board, 6, 6);
        blackKnight1.move(board, 3, 3);
        whiteBishop2.move(board, 5, 3);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}