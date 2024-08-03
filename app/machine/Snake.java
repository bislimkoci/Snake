package app.machine;

import java.util.ArrayList;

public class Snake{

    private ArrayList<SnakePart> snakeBody;
    private Direction direction; 

    public Snake(int x, int y) {
        this.snakeBody = new ArrayList<SnakePart>();
        this.direction = Direction.RIGHT;
        addCord(x, y);
    }

    

    public void changeDirection(Direction dir) {
        this.direction = dir;
    }

    public SnakePart get(int pos) {
        return snakeBody.get(pos);
    }

    public void addCord(int x, int y) {
        snakeBody.add(new SnakePart(x, y));
    }

    public int size() {
        return snakeBody.size();
    }
    
    public int nextX() {
        return get(0).x + direction.moveCoordX(direction);
    }

    public int nextY() {
        return get(0).y + direction.moveCoordX(direction);
    }
    
    public boolean isOverlapping() {
        SnakePart head = get(0);
        for (int i = 1; i < size(); i++) {
            if (head.x == get(i).x && head.y == get(i).y){
                return true;
            }
        }
        return false;
    }

    public void move() {
        for (int i = snakeBody.size() - 1; i > 0; i--) {
            SnakePart other = get(i - 1);
            get(i).copyCord(other);
        }
        moveHead();
    }

    private void moveHead() {
        get(0).addCoord(direction.moveCoordX(direction), direction.moveCoordY(direction));
    }

}





