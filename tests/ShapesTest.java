import static org.junit.Assert.*;

import org.junit.Test;

import java.awt.*;
import java.lang.reflect.Array;

public class ShapesTest {

    @Test
    public final void testCreatePoint() {
        Point point = new Point(16,5);
        assertEquals(16, point.getX());
        assertEquals(5, point.getY());
    }

    @Test
    public final void testDeletePoint() {
        Point point = new Point(16,5);
        assertTrue(point.delete());
    }

    @Test
    public final void testCreateLine() {
        Line line = new Line(new Point(2,7), new Point(6,3));
        assertEquals(new Tuple(2,7), line.getP1());
        assertEquals(new Tuple(6,3), line.getP2());
    }

    @Test
    public final void testDeleteLine() {
        Line line = new Line(new Point(2,7), new Point(6,3));
        assertTrue(line.delete());
    }

    @Test
    public final void testCreateSquare() {
        Square square = new Square(new Point(0,0), 4);
        assertEquals(new Tuple(0,0), square.getP());
        assertEquals(4, square.getLenght());
    }

    @Test
    public final void testDeleteSquare() {
        Square square = new Square(new Point(0,0), 4);
        assertTrue(square.delete());
    }

    @Test
    public final void testCreateRectangle() {
        Rect rectangle = new Rect(new Point(0,0), 4, 5);
        assertEquals(new Tuple(0,0), rectangle.getP());
        assertEquals(4, rectangle.getWidht());
        assertEquals(5, rectangle.getHeight());
    }

    @Test
    public final void testDeleteRectangle() {
        Rect rectangle = new Rect(new Point(0,0), 4);
        assertTrue(rectangle.delete());
    }

    @Test
    public final void testCreatePolygon() {
        Polyg polygon = new Polyg(5);
        assertEquals(5, polygon.getNbPoints());
    }

    @Test
    public final void testDeletePolygon() {
        Polyg polygon = new Polyg(5);
        assertTrue(polygon.delete());
    }

    @Test
    public final void testCreateCircle() {
        Circle circle = new Circle (new Point(0, 0), 4);
        assertEquals(new Tuple(0, 0), circle.getP());
        assertEquals(4, circle.getRadius());
    }

    @Test
    public final void testDeleteCircle() {
        Circle circle = new Circle(new Point(0, 0), 4);
        assertTrue(circle.delete());
    }

    @Test
    public final void testCreateCurve() {
        Curve curve = new Curve (new Point(0, 0),new Point(10, 0),new Point(20, 0),new Point(30, 0));

        assertEquals(new Tuple(0, 0), curve.getP1());
        assertEquals(new Tuple(10, 0), curve.getP2());
        assertEquals(new Tuple(20, 0), curve.getP3());
        assertEquals(new Tuple(30, 0), curve.getP4());
    }

    @Test
    public final void testDeleteCurve() {
        Curve curve = new Curve (new Point(0, 0),new Point(10, 0),new Point(20, 0),new Point(30, 0));
        assertTrue(curve.delete());
    }

}