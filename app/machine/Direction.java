package app.machine;

public enum Direction {
    UP,
    DOWN,
    RIGHT,
    LEFT;

    public int moveCoordX(Direction dir) {
        if (dir == RIGHT) {
            return 1;
        } else if (dir == LEFT) {
            return -1;
        }
        return 0;
    }

    public int moveCoordY(Direction dir) {
        if (dir == DOWN) {
            return 1;
        } else if (dir == UP) {
            return -1;
        }
        return 0;
    }

    public void printDir(Direction dir){
        if (dir == RIGHT) {
            System.out.println("RIGHT");

        }
        if (dir == LEFT) {
            System.out.println("LEFT");
        
        }

        if (dir == DOWN) {
            System.out.println("DOWN");

        }
        if (dir == UP) {
            System.out.println("UP");
    
        }
    }
}
