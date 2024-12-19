public class Squares {
    public int rank;
    public int file;
    public String icon;

    Squares(int rank, int file, String icon) {
        this.rank = rank;
        this.file = file;
        this.icon = icon;
    }

    public void move(Squares[][] board) {}

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
}
