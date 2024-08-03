package test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.machine.SnakePart;

public class testSnakePart {
    private SnakePart cod;

    @Before
    public void setup() {
        cod = new SnakePart(0, 0);
    }

    @Test
    public void createCod() {
        assertEquals(0, cod.getX());
    }

    @Test
    public void testAddCoord() {
        cod.addCoord(1, -1);
        assertEquals(1, cod.getX());
        assertEquals(-1, cod.getY());
    }

    @Test
    public void testCopyCord() {
        SnakePart other = new SnakePart(-2, 3);
        cod.copyCord(other);
        assertEquals(-2, cod.getX());
        assertEquals(3, cod.getY());
    }

}
