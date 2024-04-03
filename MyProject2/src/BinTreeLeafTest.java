import student.TestCase;

/**
 * Class responsible for testing the
 * BinTreeLeaf functionality.
 * 
 * @author Connor Marks (connorm20)
 * @version 10.13.2023
 */
public class BinTreeLeafTest extends TestCase {

    /**
     * This sets up anything that helps
     * out with testing.
     */
    public void setUp() {
        // Nothing needs to go here
    }


    /**
     * This tests the isEmpty method.
     * Zero inserts.
     */
    public void testIsEmpty() {
        LinkedList<Seminar> lList = new LinkedList<>();
        BinTreeLeaf leaf = new BinTreeLeaf(lList);
        assertFalse(leaf.isEmpty());
    }


    /**
     * This tests the isLeaf method.
     * One insert.
     */
    public void testIsLeaf() {
        LinkedList<Seminar> lList = new LinkedList<>();
        BinTreeLeaf leaf = new BinTreeLeaf(lList);
        assertTrue(leaf.isLeaf());
    }


    /**
     * This tests the insert method.
     * Inserting the same element twice.
     */
    public void testInsert() {
        LinkedList<Seminar> lList = new LinkedList<>();
        BinTreeLeaf leaf = new BinTreeLeaf(lList);
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        leaf.insert(sem1, 0, 0, 128, 0, 128);
        leaf.getList().insertSeminar(sem1);
        assertEquals(lList.getListSize(), 1);
        leaf.getList().insertSeminar(sem1);
        assertEquals(lList.getListSize(), 2);
    }


    /**
     * 
     */
    public void testRemove() {
        LinkedList<Seminar> lList = new LinkedList<>();
        BinTreeLeaf leaf = new BinTreeLeaf(lList);
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        FlyWeight fly = new FlyWeight();
        leaf.remove(sem1);
        assertTrue(leaf.getList().getListSize() == 0);
    }


    /**
     * 
     */
    public void testRemove2() {
        LinkedList<Seminar> lList = new LinkedList<>();
        BinTreeLeaf leaf = new BinTreeLeaf(lList);
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        FlyWeight fly = new FlyWeight();
        assertNotNull(leaf.remove(sem1));
    }


    /**
     * 
     */
    public void testRemove3() {
        LinkedList<Seminar> lList = new LinkedList<>();
        BinTreeLeaf leaf = new BinTreeLeaf(lList);
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        lList.insertSeminar(sem1);
        assertEquals(leaf.remove(sem1), leaf);
    }


    /**
     * This tests the getX method
     */
    public void testGetX() {
        LinkedList<Seminar> lList = new LinkedList<>();
        BinTreeLeaf leaf = new BinTreeLeaf(lList);
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        assertEquals(leaf.getX(sem1), 0);
        lList.insertSeminar(sem1);
        assertEquals(leaf.getX(sem1), 10);
    }


    /**
     * This tests the getY method.
     */
    public void testGetY() {
        LinkedList<Seminar> lList = new LinkedList<>();
        BinTreeLeaf leaf = new BinTreeLeaf(lList);
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        assertEquals(leaf.getY(sem1), 0);
        lList.insertSeminar(sem1);
        assertEquals(leaf.getY(sem1), 10);
    }


    /**
     * This tests the insert method.
     */
    public void testInsert2() {
        LinkedList<Seminar> lList = new LinkedList<>();
        BinTreeLeaf leaf = new BinTreeLeaf(lList);
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        leaf.insert(sem1, 0, 0, 128, 0, 128);
        lList.insertSeminar(sem1);
        assertEquals(leaf.insert(sem1, 0, 0, 128, 0, 128), leaf);
    }


    /**
     * This tests the insert method.
     */
    public void testInsert3() {
        LinkedList<Seminar> lList = new LinkedList<>();
        BinTreeLeaf leaf = new BinTreeLeaf(lList);
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        assertNotNull(leaf.insert(sem1, 0, 0, 128, 0, 128));
    }


    /**
     * This tests the insert method.
     * for a single insert.
     */
    public void testInsert4() {
        LinkedList<Seminar> lList = new LinkedList<>();
        BinTreeLeaf leaf = new BinTreeLeaf(lList);
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        lList.insertSeminar(sem1);
        assertEquals(leaf.insert(sem1, 1, 0, 128, 0, 128), leaf);
    }


    /**
     * This tests the insert method.
     * for multiple inserts.
     */
    public void testInsert5() {
        LinkedList<Seminar> lList = new LinkedList<>();
        BinTreeLeaf leaf = new BinTreeLeaf(lList);
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        Seminar sem2 = new Seminar(2, "Overview of HCI Research at VT",
            "0610051600", 90, (short)15, (short)15, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        lList.insertSeminar(sem1);
        assertNotNull(leaf.insert(sem2, 1, 0, 128, 0, 128));
    }
}
