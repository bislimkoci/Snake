package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.machine.Direction;

public class testDirection {

    private Direction dir;

    @Before
    public void setup() {
        dir = Direction.RIGHT;
    }

    @Test
    public void testMoveCoordX() {
        assertEquals(1, dir.moveCoordX(dir));
        dir = Direction.LEFT;
        assertEquals(-1, dir.moveCoordX(dir));
        dir = Direction.DOWN;
        assertEquals(0, dir.moveCoordX(dir));
    }

    @Test
    public void testMoveCoordY() {
        dir.printDir(dir);
        assertEquals(0, dir.moveCoordY(dir));
        dir = Direction.UP;
        assertEquals(-1, dir.moveCoordY(dir));
        dir = Direction.DOWN;
        assertEquals(1, dir.moveCoordY(dir));
    }

}
