package test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.machine.Direction;
import app.machine.Snake;

public class testSnake {

    private Snake snake;

    @Before
    public void setup() {
        this.snake = new Snake(3, 3);

    }

    @Test
    public void testgetCoord() {
       assertEquals(3, snake.get(0).getX());
       assertEquals(3, snake.get(0).getY());
    }
    
    @Test
    public void testAddCord() {
        snake.addCord(0, 0);
        snake.addCord(1, 1);
        assertEquals(3, snake.size());
    }

    @Test
    public void testMove() {
        snake.addCord(2, 3);
        snake.addCord(1, 3);
        snake.move();
        assertEquals(4, snake.get(0).getX());
        assertEquals(3, snake.get(0).getY());

        assertEquals(3, snake.get(1).getX());
        assertEquals(3, snake.get(1).getY());
        
        assertEquals(2, snake.get(2).getX());
        assertEquals(3, snake.get(2).getY());
    }



    @Test
    public void testChangeDirection() {
        snake.addCord(2, 3);
        snake.changeDirection(Direction.DOWN);
        snake.move();
        
        assertEquals(3, snake.get(0).getX());
        assertEquals(4, snake.get(0).getY());

        assertEquals(3, snake.get(1).getX());
        assertEquals(3, snake.get(1).getY());

        snake.changeDirection(Direction.LEFT);
        snake.move();

        assertEquals(2, snake.get(0).getX());
        assertEquals(4, snake.get(0).getY());

        assertEquals(3, snake.get(1).getX());
        assertEquals(4, snake.get(1).getY());

        snake.changeDirection(Direction.UP);
        snake.move();

        assertEquals(2, snake.get(0).getX());
        assertEquals(3, snake.get(0).getY());

        assertEquals(2, snake.get(1).getX());
        assertEquals(4, snake.get(1).getY());

    }

  


}