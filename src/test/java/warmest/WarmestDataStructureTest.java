package warmest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarmestDataStructureTest {

    @Test
    void fullExampleScenario_shouldMatchExpectedOutput() {
        WarmestDataStructureInterface ds = new WarmestDataStructure();

        assertNull(ds.getWarmest());                // null
        assertNull(ds.put("a", 100));               // null
        assertEquals("a", ds.getWarmest());         // a
        assertEquals(100, ds.put("a", 101));        // 100
        assertEquals(101, ds.put("a", 101));        // 101
        assertEquals(101, ds.get("a"));             // 101
        assertEquals("a", ds.getWarmest());         // a
        assertEquals(101, ds.remove("a"));          // 101
        assertNull(ds.remove("a"));                 // null
        assertNull(ds.getWarmest());                // null

        assertNull(ds.put("a", 100));               // null
        assertNull(ds.put("b", 200));               // null
        assertNull(ds.put("c", 300));               // null
        assertEquals("c", ds.getWarmest());         // c
        assertEquals(200, ds.remove("b"));          // 200
        assertEquals("c", ds.getWarmest());         // c
        assertEquals(300, ds.remove("c"));          // 300
        assertEquals("a", ds.getWarmest());         // a
        assertEquals(100, ds.remove("a"));          // 100
        assertNull(ds.getWarmest());                // null
        assertNull(ds.remove("a"));                 // null
    }

    @Test
    void getOnMissingKey_returnsNullAndDoesNotChangeWarmest() {
        WarmestDataStructureInterface ds = new WarmestDataStructure();

        assertNull(ds.put("a", 1));
        assertEquals("a", ds.getWarmest());

        assertNull(ds.get("missing"));
        assertEquals("a", ds.getWarmest()); // warmest stays the same
    }

    @Test
    void getMakesKeyWarmest() {
        WarmestDataStructureInterface ds = new WarmestDataStructure();

        ds.put("a", 1);
        ds.put("b", 2);
        assertEquals("b", ds.getWarmest());

        assertEquals(1, ds.get("a"));      // accessing 'a' makes it warmest
        assertEquals("a", ds.getWarmest());
    }
}