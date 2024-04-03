import student.TestCase;

/**
 * Class responsible for testing
 * the BinTree and its various functions.
 * It tests the print, delete, and insert. 
 * @author Connor Marks (connorm20)
 * @version 10.13.2023
 */
public class BinTreeTest extends TestCase {
    /**
     * This sets up anything
     * that is used inside of
     * the test class.
     */
    public void setUp() {
        // nothing goes here
    }


    /**
     * This tests the insertRecord method.
     */
    public void testInsertRecord() {
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        BinTree bin = new BinTree(128);
        bin.insertRecord(sem1, 0);
        assertEquals(bin.getRoot().getList().get(0), sem1);
        assertEquals(systemOut().getHistory(), "");

        BinTreeLeaf leaf = new BinTreeLeaf(new LinkedList<>());

    }


    /**
     * This tests the print tree method.
     */
    public void testPrint() {
        BinTree bin = new BinTree(128);
        bin.printLocation();
        assertEquals(systemOut().getHistory(), "Location Tree:\r\n" + "E\n");
    }


    /**
     * testing print for single insert
     * for 2 inserts of same x y
     * for isLeaf() condition
     */
    public void testPrintAgain() {
        BinTree bin = new BinTree(128);
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");

        bin.insertRecord(sem1, 0);
        bin.printLocation();
        assertEquals(systemOut().getHistory(), "Location Tree:\r\n"
            + "Leaf with 1 objects: 1\r\n" + "");
        systemOut().clearHistory();
        bin.insertRecord(sem1, 0);
        bin.printLocation();
        assertEquals(systemOut().getHistory(), "Location Tree:\r\n"
            + "Leaf with 2 objects: 1 1\n");
        assertTrue(bin.getRoot().getList().getListSize() == 2);
        assertTrue(bin.getRoot().isLeaf());

    }


    /**
     * This tests the print method.
     */
    public void testPrint2() {
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        Seminar sem2 = new Seminar(2, "Overview of HCI Research at VT",
            "0610051600", 90, (short)5, (short)5, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        Seminar sem3 = new Seminar(3, "Overview of HCI Research at VT",
            "0610051600", 90, (short)2, (short)2, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        BinTree bin = new BinTree(128);
        bin.insertRecord(sem1, 0);
        bin.insertRecord(sem2, 1);
        bin.insertRecord(sem3, 2);
        bin.printLocation();
        assertEquals(systemOut().getHistory(), "Location Tree:\r\n" + "I\r\n"
            + "  I\r\n" + "    I\r\n" + "      I\r\n" + "        I\r\n"
            + "          I\r\n" + "            I\r\n" + "              I\r\n"
            + "                I\r\n"
            + "                  Leaf with 1 objects: 3\r\n"
            + "                  Leaf with 1 objects: 2\r\n"
            + "                E\r\n"
            + "              Leaf with 1 objects: 1\r\n" + "            E\r\n"
            + "          E\r\n" + "        E\r\n" + "      E\r\n" + "    E\r\n"
            + "  E\n");
    }


    /**
     * tests the delete method.
     */
    public void testDelete() {
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        Seminar sem2 = new Seminar(2, "Overview of HCI Research at VT",
            "0610051600", 90, (short)45, (short)32, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        Seminar sem3 = new Seminar(3, "Overview of HCI Research at VT",
            "0610051600", 90, (short)15, (short)10, 15, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        Seminar sem4 = new Seminar(4, "Overview of HCI Research at VT",
            "0610051600", 90, (short)109, (short)100, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");

        BinTree bin = new BinTree(128);
        WorldDataBase dataBase = new WorldDataBase(128);
        bin.insertRecord(sem4, 0);
        assertTrue(bin.getRoot().isLeaf());
        bin.insertRecord(sem2, 0);
        assertTrue(bin.getRoot().isInternal());
        assertTrue(bin.getRoot().getLeft().isLeaf());
        assertTrue(bin.getRoot().getRight().isLeaf());
        bin.insertRecord(sem1, 0);
        bin.printLocation();
        bin.binTreeDelete(1);
        bin.binTreeDelete(5);
        bin.binTreeDelete(-1);
        bin.binTreeDelete(4);
        bin.binTreeDelete(2);
        assertTrue(bin.getRoot().isEmpty());
        bin.binTreeDelete(3);
        assertTrue(bin.getRoot().isEmpty());
    }
    
    
    
    public void testInsertMore() 
    {
        Seminar sem1 = new Seminar(1, "", "", 90, (short)10, (short)10, 15, new String[] {""}, "");
        BinTree bin = new BinTree(4);
        
        assertTrue(bin.getRoot().isEmpty());
        
        bin.insertRecord(sem1, 0);
        
        
    }
}
