import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pawn extends Squares {

    Pawn(int rank, int file, String icon) {
        super(rank, file, icon);
    }

    public void move(Squares[][] board) {
        Map<String, String> ranks = new HashMap<String, String>();
        ranks.put("1", "7");
        ranks.put("2", "6");
        ranks.put("3", "5");
        ranks.put("4", "4");
        ranks.put("5", "3");
        ranks.put("6", "2");
        ranks.put("7", "1");
        ranks.put("8", "0");

        Map<String, String> files = new HashMap<String, String>();
        files.put("A", "0");
        files.put("B", "1");
        files.put("C", "2");
        files.put("D", "3");
        files.put("E", "4");
        files.put("F", "5");
        files.put("G", "6");
        files.put("H", "7");

        System.out.print("Select where to move your Pawn: ");

        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        char fileChar = input.charAt(0);
        String fileString = files.get(String.valueOf(fileChar));
        int fileChoice = Integer.parseInt(fileString);

        char rankChar = input.charAt(1);
        String rankString = ranks.get(String.valueOf(rankChar));
        int rankChoice = Integer.parseInt(rankString);

        board[rankChoice][fileChoice] = new Pawn(rankChoice, fileChoice, icon);
    }
}
