import student.TestCase;

/**
 * @author Connor Marks (connorm20)
 * @version 10.13.2023
 * This class tests all the methods
 * and constructors for the FlyWeight
 * class. It tests the isLeaf method.
 */
public class FlyWeightTest extends TestCase {
    /**
     * This intializes any of
     * the classes or objects
     * we need for testing.
     */
    public void setUp() {
        // Nothing goes here.
    }


    /**
     * This tests the isLeaf method.
     */
    public void testIsLeaf() {
        FlyWeight fly = new FlyWeight();
        assertFalse(fly.isLeaf());
    }


    /**
     * This tests the isEmpty method.
     */
    public void testIsEmpty() {
        FlyWeight fly = new FlyWeight();
        assertTrue(fly.isEmpty());
    }


    /**
     * This tests the insert method.
     */
    public void testInsert() {
        FlyWeight fly = new FlyWeight();
        Seminar sem = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present " + "an overview of HCI research at VT");
        LinkedList list = new LinkedList();
        fly.insert(sem, 1, 0, 128, 0, 128);
        list.insertSeminar(sem);
        assertEquals(list.getListSize(), 1);
        assertFalse(fly.isLeaf());
        assertTrue(fly.isEmpty());
    }


    /**
     * This tests the isInternal method.
     */
    public void testIsInternal() {
        FlyWeight fly = new FlyWeight();
        assertFalse(fly.isInternal());
    }


    /**
     * This tests the getX method.
     */
    public void testGetX() {
        FlyWeight fly = new FlyWeight();
        Seminar sem = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present " + "an overview of HCI research at VT");
        assertEquals(fly.getX(sem), 0);
    }


    /**
     * This tests the getY method.
     */
    public void testGetY() {
        FlyWeight fly = new FlyWeight();
        Seminar sem = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present " + "an overview of HCI research at VT");
        assertEquals(fly.getY(sem), 0);
    }


    /**
     * This tests the getLeft method.
     */
    public void testGetLeft() {
        FlyWeight fly = new FlyWeight();
        assertNull(fly.getLeft());
    }


    /**
     * This tests the getRight method.
     */
    public void testGetRight() {
        FlyWeight fly = new FlyWeight();
        assertNull(fly.getRight());
    }


    /**
     * This tests the getList method.
     */
    public void testGetList() {
        FlyWeight fly = new FlyWeight();
        assertNull(fly.getList());
    }


    /**
     * This tests the remove method.
     */
    public void testRemove() {
        FlyWeight fly = new FlyWeight();
        Seminar sem = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present " + "an overview of HCI research at VT");
        assertNull(fly.remove(sem));
    }


    /**
     * This tests the search method.
     */
    public void testSearch() {
        FlyWeight fly = new FlyWeight();
        Seminar sem = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present " + "an overview of HCI research at VT");
        assertFalse(fly.search(0, 0, 0));
    }


  
}
