package app.machine;

import java.util.Random;

public class Apple extends Entity {
    
    private final int width;
    private final int height;
    private Random r;

    public Apple(int width, int height) {
        super(0, 0);
        r = new Random();
        this.width = width;
        this.height = height;
        changeRandomPos();
        
    }

    public void changeRandomPos() {
        this.x = r.nextInt(width);
        this.y = r.nextInt(height);
    }

    public boolean samePosition(Entity entity) {
        return this.x == entity.x && this.y == entity.y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }



}
