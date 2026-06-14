package lab4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Exercise4Test {

    @Test
    void testDistance() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);

        assertEquals(5.0, p1.distance(p2));
    }

    @Test
    void testHashCode() {
        Point p = new Point(1, 2);

        assertEquals(13, p.hashCode());
    }

    @Test
    void testEqualsSelf() {
        Point p = new Point(1, 2);

        assertTrue(p.equals(p));
    }

    @Test
    void testEqualsNull() {
        Point p = new Point(1, 2);

        assertFalse(p.equals(null));
    }

    @Test
    void testEqualsDifferentClass() {
        Point p = new Point(1, 2);

        assertFalse(p.equals("hello"));
    }

    @Test
    void testEqualsDifferentX() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 2);

        assertFalse(p1.equals(p2));
    }

    @Test
    void testEqualsDifferentY() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 3);

        assertFalse(p1.equals(p2));
    }

    @Test
    void testEqualsSameCoordinates() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);

        assertTrue(p1.equals(p2));
    }

    @Test
    void testPerimeter() {
        Triangle t = new Triangle(
                new Point(0, 0),
                new Point(3, 0),
                new Point(0, 4));

        assertEquals(12.0, t.perimeter());
    }

    @Test
    void testIsEquilateralTrue() {
        Triangle t = new Triangle(
                new Point(0, 0),
                new Point(Math.sqrt(5), 0),
                new Point(Math.sqrt(5) / 2,
                        Math.sqrt(15) / 2));

        assertTrue(t.isEquilateral());
    }

    @Test
    void testIsEquilateralFalse() {
        Triangle t = new Triangle(
                new Point(0, 0),
                new Point(1, 0),
                new Point(0, 1));

        assertFalse(t.isEquilateral());
    }
}