import static org.junit.Assert.*;

import org.junit.Test;

import java.awt.*;
import java.lang.reflect.Array;

import shape.Line;
import shape.Square;
import shape.Rectangle;
import shape.Circle;
import shape.Point;
import shape.Curve;

public class ShapesTest {

    @Test
    public final void testCreatePoint() {
        Point point = new Point(7,16,5);
        assertEquals(7, point.getId());
        assertEquals(16, point.getX());
        assertEquals(5, point.getY());
    }

//    @Test
//    public final void testDeletePoint() {
//        Point point = new Point(16,5);
//        assertTrue(point.delete());
//    }

    @Test
    public final void testCreateLine() {
        Line line = new Line(1, 2,7, 6,3);
        assertEquals(1, line.getId());
        assertEquals(2, line.getX());
        assertEquals(7, line.getY());
        assertEquals(6, line.getP1().getX());
        assertEquals(3, line.getP1().getY());
    }

//    @Test
//    public final void testDeleteLine() {
//        Line line = new Line(1, 2,7, new Point(2,6,3));
//        assertTrue(line.delete());
//    }

    @Test
    public final void testCreateSquare() {
        Square square = new Square(8, 3, 7, 5);
        assertEquals(8, square.getId());
        assertEquals(3, square.getX());
        assertEquals(7, square.getY());
        assertEquals(5, square.getLenght());
    }

//    @Test
//    public final void testDeleteSquare() {
//        Square square = new Square(new Point(0,0), 4);
//        assertTrue(square.delete());
//    }

    @Test
    public final void testCreateRectangle() {
        Rectangle rectangle = new Rectangle(10,8,5,6,2);
        assertEquals(10, rectangle.getId());
        assertEquals(8, rectangle.getX());
        assertEquals(5, rectangle.getY());
        assertEquals(6, rectangle.getWidht());
        assertEquals(2, rectangle.getHeight());
    }

//    @Test
//    public final void testDeleteRectangle() {
//        Rectangle rectangle = new Rectangle(new Point(0,0), 4);
//        assertTrue(rectangle.delete());
//    }

//    @Test
//    public final void testCreatePolygon() {
//        Polyg polygon = new Polyg(5);
//        assertEquals(5, polygon.getNbPoints());
//    }
//
//    @Test
//    public final void testDeletePolygon() {
//        Polyg polygon = new Polyg(5);
//        assertTrue(polygon.delete());
//    }

    @Test
    public final void testCreateCircle() {
        Circle circle = new Circle (84, 6,12,5);
        assertEquals(84, circle.getId());
        assertEquals(6, circle.getX());
        assertEquals(12, circle.getY());
        assertEquals(5, circle.getRadius());
    }

//    @Test
//    public final void testDeleteCircle() {
//        Circle circle = new Circle(new Point(0, 0), 4);
//        assertTrue(circle.delete());
//    }

    @Test
    public final void testCreateCurve() {
        Curve curve = new Curve(1,2,2, 1,4,5,4,9,2);

        assertEquals(1, curve.getId());

        assertEquals(2, curve.getP1().getX());
        assertEquals(2, curve.getP1().getY());

        assertEquals(1, curve.getP2().getX());
        assertEquals(4, curve.getP2().getY());

        assertEquals(5, curve.getP3().getX());
        assertEquals(4, curve.getP3().getY());

        assertEquals(9, curve.getX());
        assertEquals(2, curve.getY());

//        System.out.println(curve.toString());
    }
//
//    @Test
//    public final void testDeleteCurve() {
//        Curve curve = new Curve (new Point(0, 0),new Point(10, 0),new Point(20, 0),new Point(30, 0));
//        assertTrue(curve.delete());
//    }

}