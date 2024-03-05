import static org.junit.Assert.*;

import layer_area.Area;
import layer_area.Layer;
import org.junit.Test;
//import org.testng.AssertJUnit;
import shape.Square;

import java.awt.*;
import java.lang.reflect.Array;
public class AreaTest {
    @Test
    public final void testCreateArea() {
        Area area = new Area(20, 30, 1,"Area 1");
        assertEquals(20, area.getWidht());
        assertEquals(30, area.getHeight());
        assertEquals(1, area.getId());
        assertEquals("Area 1", area.getName());
    }

    @Test
    public final void testAddLayerArealist() {
        Area area = new Area(20, 30,1,"Area 1");
        Layer layer = new Layer(1,"Layer 1");
        area.add_layer_to_list(layer);
        assertEquals(true, area.getLayerExist(1));
    }

    @Test
    public final void testDeleteLayerArealist() {
        Area area = new Area(20, 30,1,"Area 1");
        Layer layer = new Layer(1,"Layer 1");
        area.add_layer_to_list(layer);
        assertEquals(true, area.getLayerExist(1));
        area.delete_layer_to_list(1);
        assertEquals(false, area.getLayerExist(1));

    }

//    @Test
//    public final void testDeleteArea() {
//        Area area = new Area(20, 30, 1,"Area 1");
//        assertTrue(area.delete_Area_to_list(area.getId()));
//    }

//    @Test
//    public final void testCreateAreaList() {
//        AreaList areaList;
//        assertTrue(new AreaList());
//    }
//
//    @Test
//    public final void testDeleteAreaList() {
//        AreaList areaList = new AreaList();
//        assertTrue(areaList.delete());
//    }

//    @Test
//    public final void testAddAreaAreaList() {
//        AreaList areaList = new AreaList();
//        Area area = new Area(20, 30, 1,"Area 1");
//        areaList.addArea(area);
//        assertNotNull(areaList.getArea(area.getId()));
//    }
//
//    @Test
//    public final void testDeleteAreaAreaList() {
//        AreaList areaList = new AreaList();
//        Area area = new Area(20, 30, 1,"Area 1");
//        areaList.addArea(area);
//        assertNotNull(areaList.getArea(area.getId()));
//        areaList.deleteArea(area);
//        assertNull(areaList.getArea(area.getId()));
//    }
}
