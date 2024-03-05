import static org.junit.Assert.*;

import layer_area.Layer;
import org.junit.Test;
import shape.Line;
import shape.Point;
import shape.Square;

import java.awt.*;
import java.lang.reflect.Array;
public class LayerTest {
    @Test
    public final void testCreateLayer() {
        Layer layer = new Layer(1,"Layer 1");
        assertEquals(1, layer.getId());
        assertEquals("Layer 1", layer.getName());
    }

    @Test
    public final void testAddShapeLayerlist() {
        Layer layer = new Layer(1,"Layer 1");
        Square shape = new Square(1, 5, 2, 3);
        layer.add_shape_to_list(shape);
        assertEquals(true, layer.getShapeExist(1));
    }

    @Test
    public final void testDeleteShapeLayer() {
        Layer layer = new Layer(1,"Layer 1");
        Square shape = new Square(1, 5, 2, 3);
        layer.add_shape_to_list(shape);
        assertEquals(true, layer.getShapeExist(1));
        layer.delete_shape_to_list(1);
        assertEquals(false, layer.getShapeExist(1));
    }

    @Test
    public void testSetLayerVisibility() {
        Layer layer = new Layer(1,"Layer 1");
        assertEquals(true, layer.getVisible());
        layer.set_layer_visibility();
        assertEquals(false, layer.getVisible());
    }

    @Test
    public void testSetShapeVisibility() {
        Line line = new Line(1, 4,7, 2,3);
        assertEquals(true, line.getVisible());
        line.set_shape_visibility();
        assertEquals(false, line.getVisible());
    }

//    @Test
//    public final void testDeleteLayer() {
//        Layer layer = new Layer(1,"Layer 1");
//        assertTrue(layer.delete());
//    }

//    @Test
//    public final void testCreateLayerList() {
//        LayerList layerList;
//        assertTrue(new LayerList());
//    }
//
//    @Test
//    public final void testDeleteLayerList() {
//        LayerList layerList = new LayerList();
//        assertTrue(layerList.delete());
//    }

//    @Test
//    public final void testAddLayerLayerList() {
//        LayerList layerList = new LayerList();
//        Layer layer = new Layer("a","Layer 1");
//        layerList.addLayer(layer);
//        assertNotNull(layerList.getLayer(layer.getId()));
//    }
//
//    @Test
//    public final void testDeleteLayerLayerList() {
//        LayerList layerList = new LayerList();
//        Layer layer = new Layer("a","Layer 1");
//        layerList.addLayer(layer);
//        assertNotNull(layerList.getLayer(layer.getId()));
//        layerList.deleteLayer(layer);
//        assertNull(layerList.getLayer(layer.getId()));
//    }

//    @Test
//    public void testSetLayerVisible() {
//        Layer layer = new Layer("a","Layer 1");
//        layer.setLayerVisible();
//        assertTrue(layer.isVisible());
//    }
//
//    @Test
//    public void testSetLayerUnvisible() {
//        Layer layer = new Layer("a", "Layer 1");
//        layer.setLayerVisible();
//        assertFalse(layer.isVisible());
//    }

//    @Test
//    public final void testAddShapeLayer() {
//        Layer layer = new Layer("a","Layer 1");
//        Square shape = new square(new Point(5,7), 5);
//        layer.addShape(shape);
//        assertEquals(1, layer.getShape().getNumberOfShapes());
//    }
//
//    @Test
//    public final void testDeleteShapeLayer() {
//        Layer layer = new Layer("a","Layer 1");
//        Square shape = new square(new Point(5,7), 5);
//        layer.addShape(shape);
//        assertEquals(1, layer.getShape().getNumberOfShapes());
//        layer.deleteShape(shape);
//        assertEquals(0, layer.getShape().getNumberOfShapes());
//    }
}
