import static org.junit.Assert.*;

import org.junit.Test;

import java.awt.*;
import java.lang.reflect.Array;
public class LayerTest {
    @Test
    public final void testCreateLayer() {
        Layer layer = new Layer("a","Layer 1");
        assertEquals("a", layer.getId());
        assertEquals("Layer 1", layer.getName());
    }

    @Test
    public final void testDeleteLayer() {
        Layer layer = new Layer("a","Layer 1");
        assertTrue(layer.delete());
    }

    @Test
    public final void testCreateLayerList() {
        LayerList layerList;
        assertTrue(new LayerList());
    }

    @Test
    public final void testDeleteLayerList() {
        LayerList layerList = new LayerList();
        assertTrue(layerList.delete());
    }

    @Test
    public final void testAddLayerLayerList() {
        LayerList layerList = new LayerList();
        Layer layer = new Layer("a","Layer 1");
        layerList.addLayer(layer);
        assertNotNull(layerList.getLayer(layer.getId()));
    }

    @Test
    public final void testDeleteLayerLayerList() {
        LayerList layerList = new LayerList();
        Layer layer = new Layer("a","Layer 1");
        layerList.addLayer(layer);
        assertNotNull(layerList.getLayer(layer.getId()));
        layerList.deleteLayer(layer);
        assertNull(layerList.getLayer(layer.getId()));
    }

    @Test
    public void testSetLayerVisible() {
        Layer layer = new Layer("a","Layer 1");
        layer.setLayerVisible();
        assertTrue(layer.isVisible());
    }

    @Test
    public void testSetLayerUnvisible() {
        Layer layer = new Layer("a", "Layer 1");
        layer.setLayerVisible();
        assertFalse(layer.isVisible());
    }

    @Test
    public final void testAddShapeLayer() {
        Layer layer = new Layer("a","Layer 1");
        Square shape = new square(new Point(5,7), 5);
        layer.addShape(shape);
        assertEquals(1, layer.getShape().getNumberOfShapes());
    }

    @Test
    public final void testDeleteShapeLayer() {
        Layer layer = new Layer("a","Layer 1");
        Square shape = new square(new Point(5,7), 5);
        layer.addShape(shape);
        assertEquals(1, layer.getShape().getNumberOfShapes());
        layer.deleteShape(shape);
        assertEquals(0, layer.getShape().getNumberOfShapes());
    }
}
