package app.machine;

public class SnakePart extends Entity{


    public SnakePart(int x, int y) {
        super(x, y);
    }

    public void addCoord(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void copyCord(SnakePart other) {
        this.x = other.x;
        this.y = other.y;
    }
    

    public void printCoordniate(){
        System.out.println(x + " " + y);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

}
