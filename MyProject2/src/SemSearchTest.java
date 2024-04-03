import student.TestCase;

/**
 * This test class is responsible for 
 * ensuring the correct behavior of the 
 * SemSearch class, which is the main 
 * class of the program. It tests the 
 * "powerof2" method for verifying a
 * parameter passed for worldsize is
 * a power of 2.
 * 
 * @author Connor Marks (connorm20) 
 * @version 9/19/2023
 */
public class SemSearchTest extends TestCase {
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        // Nothing here
    }


    /**
     * Get code coverage of the class declaration.
     */
    public void testMInitx() {
        SemSearch sem = new SemSearch();
        assertNotNull(sem);
        // SemSearch.main(null);
    }


    /**
     * This tests when the arguments
     * are empty and also nonempty
     * but still not the right amount.
     * 
     * @throws Exception
     *             if the file doesn't contain anything.
     */
    public void testEmptyArgs() throws Exception {
        String[] args = null;
        SemSearch.main(args);
        assertEquals(systemOut().getHistory(), "");
    }


    /**
     * This tests the main method
     * when there are only two arguments.
     * 
     * @throws Exception
     *             if the file doesn't contain anything.
     */
    public void testOneArg() throws Exception {
        String[] args2 = { "16" };
        SemSearch.main(args2);
        assertEquals(systemOut().getHistory(), "Number of arguments incorrect "
            + "There should be one argument " + "for the size of the world and "
            + "one for the file to parse.");
    }


    /**
     * This tests the main method
     * when the second argument isn't
     * a power of two.
     * 
     * @throws Exception
     *             if the file doesn't contain anything.
     */
    public void testPowerOfTwo2() throws Exception {
        String[] args = { "1", "P2Sample_input.txt" };
        SemSearch.main(args);
        assertEquals(systemOut().getHistory(), "Location Tree:\r\n" + "E\r\n"
            + "ID Tree:\r\n" + "This tree is empty\r\n"
            + "Search FAILED -- There is no record with ID 1\r\n"
            + "Seminars matching keyword VT:\r\n"
            + "Insert FAILED - Bad x, y coordinates: -1, 10\r\n"
            + "Insert FAILED - Bad x, y coordinates: 10, 128\r\n"
            + "Insert FAILED - Bad x, y coordinates: 10, 10\r\n"
            + "Insert FAILED - Bad x, y coordinates: 10, 10\r\n"
            + "Insert FAILED - Bad x, y coordinates: 30, 10\r\n"
            + "Insert FAILED - Bad x, y coordinates: 0, 0\r\n" + "ID Tree:\r\n"
            + "This tree is empty\r\n" + "Date Tree:\r\n"
            + "This tree is empty\r\n" + "Keyword Tree:\r\n"
            + "This tree is empty\r\n" + "Cost Tree:\r\n"
            + "This tree is empty\r\n" + "Location Tree:\r\n" + "E\r\n"
            + "Insert FAILED - Bad x, y coordinates: 0, 0\r\n"
            + "Seminars matching keyword VT:\r\n"
            + "Search FAILED -- There is no record with ID 1\r\n"
            + "Seminars with costs in range 30 to 50:\r\n"
            + "1 nodes visited in this search\r\n"
            + "Seminars within 1 units of -1, 0:\r\n"
            + "0 nodes visited in this search\r\n"
            + "Seminars within 2000 units of -1, 0:\r\n"
            + "0 nodes visited in this search\r\n"
            + "Seminars within 0 units of 10, 10:\r\n"
            + "0 nodes visited in this search\r\n"
            + "Seminars within 0 units of 11, 11:\r\n"
            + "0 nodes visited in this search\r\n"
            + "Seminars within 20 units of 10, 10:\r\n"
            + "0 nodes visited in this search\r\n"
            + "Seminars with dates in range 0 to 1:\r\n"
            + "1 nodes visited in this search\r\n"
            + "Delete FAILED -- There is no record with ID 1\r\n"
            + "Delete FAILED -- There is no record with ID 1\r\n"
            + "ID Tree:\r\n" + "This tree is empty\r\n"
            + "Location Tree:\nE\n");
    }


    /**
     * This tests the power of two
     * method that checks to see
     * if the world size is a power
     * of two or not.
     * 
     * @throws Exception
     *             if there is an
     *             error or the file is empty.
     */
    public void testNotPowerOfTwo() throws Exception {
        String[] args = { "3", "P2Sample_input.txt" };
        SemSearch.main(args);
        assertEquals(systemOut().getHistory(),
            "The world size needs to be a power of two");
    }


    /**
     * This tests the powerOfTwo method
     * to see when the method returns false.
     */
    public void testPowerOfTwo() {
        assertFalse(SemSearch.powerOfTwo(100));
        assertFalse(SemSearch.powerOfTwo(-1));
        assertTrue(SemSearch.powerOfTwo(1));
        assertFalse(SemSearch.powerOfTwo(3));
        assertFalse(SemSearch.powerOfTwo(9));
        assertTrue(SemSearch.powerOfTwo(32));
    }
}
