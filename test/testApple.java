package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import app.machine.Apple;
import app.machine.SnakePart;

public class testApple {
    
    private Apple apple;

    @Before
    public void setUp() {
        apple = new Apple(200, 200);

    }


    @Test
    public void testSamePosition() {
        apple.setPosition(2, 2);
        SnakePart snakeHead = new SnakePart(2, 2);
        assertTrue(apple.samePosition(snakeHead));

        SnakePart snakeHead2 = new SnakePart(3, 2);
        assertFalse(apple.samePosition(snakeHead2));


    }

}
