package plugin.main;

public class ChunkPrivate {
    private int X;
    private int Y;
    private String ChunkName;
    public int getX() {
        return X;
    }
    public int getY() {
        return Y;
    }
    public ChunkPrivate(int x, int y){
        this.X = x;
        this.Y = y;
        ChunkName = x + " " + y;
    }
}
