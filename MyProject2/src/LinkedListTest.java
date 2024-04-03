import student.TestCase;

/**
 * @author Connor Marks (connorm20)
 * @version 10.13.2023
 * Test class responsible for ensuring correct
 * behavior of linked list is exhibited. This
 * class has various test cases for inserting,
 * removing, searching, and accessing elements
 * of the linked list. It tests simple cases,
 * like 1 element being inserted, removed,
 * or accessed. It also tests boundary cases
 * for false removal, false search, and false access.
 * Test cases cover all necessary mutations. 
 */
public class LinkedListTest extends TestCase {

    /**
     * Empty setup constructor, not needed for testing.
     * Used so webcat is not angry. 
     */
    public void setUp() {
        // Nothing goes here.
    }


    /**
     * This tests the insertSeminar method,
     * the removeSeminar method, and the
     * searchSeminar method.
     */
    public void testInsertSeminar() {
        LinkedList lList = new LinkedList();
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        lList.insertSeminar(sem1);
        assertEquals(lList.getListSize(), 1);
        assertEquals(lList.searchSeminar(sem1), sem1);
        assertTrue(lList.removeSeminar(sem1));
        assertFalse(lList.removeSeminar(sem1));
        assertEquals(lList.getListSize(), 0);
        assertEquals(lList.searchSeminar(sem1), null);

        lList.insertSeminar(sem1);
        lList.insertSeminar(sem1);
        assertEquals(lList.getListSize(), 2);

    }


    /**
     * tests the remove seminar with null head
     */
    public void testRemove2() {
        // if (head.getSeminar().equals(sem)) return true

        LinkedList<Seminar> lList = new LinkedList<>();
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        lList.insertSeminar(sem1);
        assertEquals(lList.getListSize(), 1);
        assertTrue(lList.removeSeminar(sem1));
        assertEquals(lList.getListSize(), 0);

        assertFalse(lList.removeSeminar(sem1));

    }


    /**
     * Tests that out of range indices returns null.
     */
    public void testGet() {
        LinkedList<Seminar> lList = new LinkedList<>();
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        lList.insertSeminar(sem1);
        assertNull(lList.get(-1));
        assertNull(lList.get(10));
        assertEquals(lList.get(0), sem1);
    }


    /**
     * Tests get for duplicate inserts.
     */
    public void testGet2() {
        LinkedList<Seminar> lList = new LinkedList<>();
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        lList.insertSeminar(sem1);
        lList.insertSeminar(sem1);
        assertEquals(lList.getListSize(), 2);
        assertEquals(lList.get(1), sem1);
        assertEquals(lList.get(0), sem1);

    }


    /**
     * Tests the linkedlist insert when the head is not null
     */
    public void testInsertHeadNotNull() {
        LinkedList<Seminar> lList = new LinkedList<>();
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        lList.insertSeminar(sem1);

    }


    /**
     * Tests inserting the same seminar.
     */
    public void testInsert2() {
        LinkedList<Seminar> lList = new LinkedList<>();
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        lList.insertSeminar(sem1);
        assertEquals(lList.getListSize(), 1);
        lList.insertSeminar(sem1);
        assertEquals(lList.getListSize(), 2);
    }


    /**
     * Tests remove when we insert 2 elements,
     * try to remove a false element, insert that
     * element and tests successful removal.
     */
    public void testRemove() {
        LinkedList<Seminar> lList = new LinkedList<>();
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        Seminar sem2 = new Seminar(2, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        lList.insertSeminar(sem1);
        assertTrue(lList.removeSeminar(sem1));
        assertFalse(lList.removeSeminar(sem2));
        lList.insertSeminar(sem2);
        assertTrue(lList.removeSeminar(sem2));
    }


    /**
     * This tests the search method when 2 items
     * are in the list.
     */
    public void testSearch() {
        LinkedList<Seminar> lList = new LinkedList<>();
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        Seminar sem2 = new Seminar(2, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        lList.insertSeminar(sem1);
        assertEquals(lList.searchSeminar(sem1), sem1);
        lList.insertSeminar(sem2);
        assertEquals(lList.searchSeminar(sem2), sem2);
    }


    /**
     * tests get for empty list,
     * when index out of bounds,
     * and when index in range
     * but less than list size.
     */
    public void getTestAgain() {
        LinkedList<Seminar> list = new LinkedList<>();
        assertNull(list.get(0));
        assertNull(list.get(1));

        assertEquals(list.get(0), null);
        assertEquals(list.getListSize(), 0);
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        list.insertSeminar(sem1);
        assertEquals(list.getListSize(), 1);

        list.insertSeminar(sem1);
        assertEquals(list.getListSize(), 2);
        assertNull(list.get(2));
        assertNull(list.get(-1));

        list.insertSeminar(sem1);
        list.insertSeminar(sem1);
        // currently have 4 items in the list...

        assertEquals(list.get(2), sem1);

    }


    /**
     * Tests inserting, getting an index out of range.
     */
    public void testGet3() {
        LinkedList lList = new LinkedList();
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        Seminar sem2 = new Seminar(2, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        lList.insertSeminar(sem1);
        lList.insertSeminar(sem2);
        assertEquals(lList.getListSize(), 2);
        assertNull(lList.get(3));
    }


    /**
     * tests 2 inserts, a removal, and a get.
     */
    public void testGet4() {
        LinkedList lList = new LinkedList();
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        Seminar sem2 = new Seminar(2, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        lList.insertSeminar(sem1);
        lList.insertSeminar(sem2);
        lList.removeSeminar(sem1);
        assertEquals(lList.get(0), sem2);
    }


    /**
     * tests 3 inserts and checks the size increased.
     */
    public void testInsertSeminar2() {
        LinkedList lList = new LinkedList();
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        Seminar sem2 = new Seminar(2, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        Seminar sem3 = new Seminar(3, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        lList.insertSeminar(sem1);
        lList.insertSeminar(sem2);
        assertEquals(lList.getListSize(), 2);
        lList.insertSeminar(sem3);
        assertEquals(lList.getListSize(), 3);
    }


    /**
     * Tests 2 inserts and 1 removal.
     * removes the last item in the list 
     */
    public void testRemoveSeminar() {
        LinkedList lList = new LinkedList();
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        Seminar sem2 = new Seminar(2, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        lList.insertSeminar(sem1);
        lList.insertSeminar(sem2);
        assertTrue(lList.removeSeminar(sem2));
    }


    /**
     * tests remove seminar when the list has
     * more than 1 element, but removes the first.
     */
    public void testRemoveSeminar2() {
        LinkedList<Seminar> lList = new LinkedList<>();
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        Seminar sem2 = new Seminar(2, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        lList.insertSeminar(sem1);
        lList.insertSeminar(sem2);
        assertTrue(lList.removeSeminar(sem1));
    }


    /**
     * tests seminar searches that are null.
     */
    public void testSearchSeminar() {
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        LinkedList<Seminar> list = new LinkedList<>();
        assertNull(list.searchSeminar(sem1));
        assertEquals(list.searchSeminar(sem1), null);
        list.insertSeminar(sem1);
        list.searchSeminar(sem1);
        assertEquals(list.searchSeminar(sem1), sem1);
        assertNull(list.searchSeminar(null));

    }
}
