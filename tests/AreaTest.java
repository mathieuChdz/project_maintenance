import static org.junit.Assert.*;

import org.junit.Test;
import org.testng.AssertJUnit;

import java.awt.*;
import java.lang.reflect.Array;
public class AreaTest {
    @Test
    public final void testCreateArea() {
        Area area = new Area(20, 30, "A","Area 1");
        assertEquals(20, area.getWidth());
        assertEquals(30, area.getHeight());
        assertEquals("A", area.getId());
        assertEquals("Area 1", area.getName());
    }

    @Test
    public final void testDeleteArea() {
        Area area = new Area(20, 30, "A","Area 1");
        assertTrue(area.delete());
    }

    @Test
    public final void testCreateAreaList() {
        AreaList areaList;
        assertTrue(new AreaList());
    }

    @Test
    public final void testDeleteAreaList() {
        AreaList areaList = new AreaList();
        assertTrue(areaList.delete());
    }

    @Test
    public final void testAddAreaAreaList() {
        AreaList areaList = new AreaList();
        Area area = new Area(20, 30, "A","Area 1");
        areaList.addArea(area);
        assertNotNull(areaList.getArea(area.getId()));
    }

    @Test
    public final void testDeleteAreaAreaList() {$
        AreaList areaList = new AreaList();
        Area area = new Area(20, 30, "A","Area 1");
        areaList.addArea(area);
        assertNotNull(areaList.getArea(area.getId()));
        areaList.deleteArea(area);
        assertNull(areaList.getArea(area.getId()));
    }
}
