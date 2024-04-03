import student.TestCase;

/**
 * This class tests the command processor for
 * insert, delete, search, and print. It
 * also tests the constructor for the
 * CommandProcessor.
 * 
 * @author Connor Marks (connorm20)
 * @version 09/26/2023
 */
public class CommandProcessorTest extends TestCase {
    /**
     * This sets up the test
     * class with anything that
     * we need to initialize.
     */
    public void setUp() {
        // Nothing to do here.
    }


    /**
     * This tests the insert method for
     * when it is called within the processCommands
     * method. This specifically tests the if
     * statement in the code that checks if the
     * given x or y value is negative.
     * 
     * @throws Exception
     *             if there is an error
     *             or the file is empty.
     */
    public void testInsert() throws Exception {
        CommandProcessor cmp = new CommandProcessor("InsertFile.txt", 128);
        cmp.processCommand("InsertFile.txt", 4);
        assertEquals(systemOut().getHistory(),
            "Insert FAILED - Bad x, y coordinates: -1, 10\r\n"
                + "Insert FAILED - Bad x, y coordinates: 1, -10\r\n"
                + "Insert FAILED - Bad x, y coordinates: 1, 10\r\n"
                + "Insert FAILED - Bad x, y coordinates: 10, 1\r\n"
                + "Successfully inserted record with ID 5\r\n"
                + "ID: 5, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 2, Y: 2, Cost: 45\r\n"
                + "Description: This seminar will present an overview of "
                + "HCI research at VT\r\n"
                + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\n");
    }


    /**
     * This tests the insert method.
     * 
     * @throws Exception
     *             if the file is
     *             empty or there is an error.
     */
    public void testInsert2() throws Exception {

        CommandProcessor cmp = new CommandProcessor("InsertFile.txt", 128);
        cmp.processCommand("InsertFile.txt", 4);
        assertEquals(systemOut().getHistory(),
            "Insert FAILED - Bad x, y coordinates: -1, 10\r\n"
                + "Insert FAILED - Bad x, y coordinates: 1, -10\r\n"
                + "Insert FAILED - Bad x, y coordinates: 1, 10\r\n"
                + "Insert FAILED - Bad x, y coordinates: 10, 1\r\n"
                + "Successfully inserted record with ID 5\r\n"
                + "ID: 5, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 2, Y: 2, Cost: 45\r\n"
                + "Description: This seminar will present an overview of "
                + "HCI research at VT\r\n"
                + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
                + "");
    }


    /**
     * Need to test delete when working.
     */

    /**
     * This tests the search method when
     * we are looking for a specific ID.
     * This will test when an Id is found
     * and when an ID is not found.
     * 
     * @throws Exception
     *             if there is an error
     *             or the file is empty.
     */
    public void testSearchID() throws Exception {
        CommandProcessor cmp = new CommandProcessor("SearchFile.txt", 128);
        cmp.processCommand("SearchFile.txt", 0);
        assertEquals(systemOut().getHistory(),
            "Insert FAILED - Bad x, y coordinates: 1, 10\r\n"
                + "Search FAILED -- There is no record with ID 1\r\n"
                + "Search FAILED -- There is no record with ID 2\n");
    }


    /**
     * This tests the searchID branch
     * when an ID is inserted successfully and
     * is found.
     * 
     * @throws Exception
     *             if there is an error
     *             or the file is empty.
     */
    public void testSearchID2() throws Exception {
        CommandProcessor cmp = new CommandProcessor("SearchFile.txt", 128);
        cmp.processCommand("SearchFile.txt", 16);
        assertEquals(systemOut().getHistory(),
            "Successfully inserted record with ID 1\r\n"
                + "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 1, Y: 10, Cost: 45\r\n"
                + "Description: This seminar will present"
                + " an overview of HCI research at VT\r\n"
                + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
                + "Found record with ID 1:\r\n"
                + "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 1, Y: 10, Cost: 45\r\n"
                + "Description: This seminar will present "
                + "an overview of HCI research at VT\r\n"
                + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
                + "Search FAILED -- There is no record with ID 2\n");
    }


    /**
     * This tests the search cost branch
     * in the processCommands method.
     * This will test when the cost does
     * not fall in the specified range.
     * 
     * @throws Exception
     *             if there is an error
     *             or the file is empty.
     */
    public void testSearchCost() throws Exception {
        CommandProcessor cmp = new CommandProcessor("SearchFile2.txt", 128);
        cmp.processCommand("SearchFile2.txt", 2);
        assertEquals(systemOut().getHistory(),
            "Insert FAILED - Bad x, y coordinates: 1, 10\r\n"
                + "Seminars with costs in range 0 to 44:\r\n"
                + "1 nodes visited in this search\r\n"
                + "Seminars with costs in range 45 to 99:\r\n"
                + "1 nodes visited in this search\n");
    }


    /**
     * This tests the search cost branch
     * in the processCommands method.
     * This will test when the cost does
     * fall in the specified range.
     * 
     * @throws Exception
     *             if there is an error
     *             or the file is empty.
     */
    public void testSearchCost2() throws Exception {
        CommandProcessor cmp = new CommandProcessor("SearchFile2.txt", 128);
        cmp.processCommand("SearchFile2.txt", 16);
        assertEquals(systemOut().getHistory(),
            "Successfully inserted record with ID 1\r\n"
                + "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 1, Y: 10, Cost: 45\r\n"
                + "Description: This seminar will present"
                + " an overview of HCI research at VT\r\n"
                + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
                + "Seminars with costs in range 0 to 44:\r\n"
                + "2 nodes visited in this search\r\n"
                + "Seminars with costs in range 45 to 99:\r\n"
                + "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 1, Y: 10, Cost: 45\r\n"
                + "Description: This seminar will present "
                + "an overview of HCI research at VT\r\n"
                + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
                + "3 nodes visited in this search\n");
    }


    /**
     * This tests the search cost branch
     * in the processCommands method.
     * This will test when the cost does
     * not fall in the specified range.
     * 
     * @throws Exception
     *             if there is an error
     *             or the file is empty.
     */
    public void testSearchDate() throws Exception {
        CommandProcessor cmp = new CommandProcessor("SearchFile3.txt", 128);
        cmp.processCommand("SearchFile3.txt", 2);
        assertEquals(systemOut().getHistory(),
            "Insert FAILED - Bad x, y coordinates: 1, 10\r\n"
                + "Seminars with dates in range 0 to 1:\r\n"
                + "1 nodes visited in this search\r\n"
                + "Seminars with dates in range 0 to 0610051601:\r\n"
                + "1 nodes visited in this search\n");
    }


    /**
     * This tests the search cost branch
     * in the processCommands method.
     * This will test when the cost does
     * not fall in the specified range.
     * 
     * @throws Exception
     *             if there is an error
     *             or the file is empty.
     */
    public void testSearchDate2() throws Exception {
        CommandProcessor cmp = new CommandProcessor("SearchFile3.txt", 128);
        cmp.processCommand("SearchFile3.txt", 16);
        assertEquals(systemOut().getHistory(),
            "Successfully inserted record with ID 1\r\n"
                + "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 1, Y: 10, Cost: 45\r\n"
                + "Description: This seminar will present"
                + " an overview of HCI research at VT\r\n"
                + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
                + "Seminars with dates in range 0 to 1:\r\n"
                + "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 1, Y: 10, Cost: 45\r\n"
                + "Description: This seminar will present "
                + "an overview of HCI research at VT\r\n"
                + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
                + "3 nodes visited in this search\r\n"
                + "Seminars with dates in range 0 to 0610051601:\r\n"
                + "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 1, Y: 10, Cost: 45\r\n"
                + "Description: This seminar will present "
                + "an overview of HCI research at VT\r\n"
                + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
                + "3 nodes visited in this search\n");
    }


    /**
     * This tests the search cost branch
     * in the processCommands method.
     * This will test when the cost does
     * not fall in the specified range.
     * 
     * @throws Exception
     *             if there is an error
     *             or the file is empty.
     */
    public void testSearchKeywords() throws Exception {
        CommandProcessor cmp = new CommandProcessor("SearchFile4.txt", 128);
        cmp.processCommand("SearchFile4.txt", 2);
        assertEquals(systemOut().getHistory(),
            "Insert FAILED - Bad x, y coordinates: 1, 10\r\n"
                + "Seminars matching keyword TV:\r\n"
                + "Seminars matching keyword VT:\n");
    }


    /**
     * This tests the search cost branch
     * in the processCommands method.
     * This will test when the cost does
     * not fall in the specified range.
     * 
     * @throws Exception
     *             if there is an error
     *             or the file is empty.
     */
    public void testSearchKeywords2() throws Exception {
        CommandProcessor cmp = new CommandProcessor("SearchFile4.txt", 128);
        cmp.processCommand("SearchFile4.txt", 16);
        assertEquals(systemOut().getHistory(),
            "Successfully inserted record with ID 1\r\n"
                + "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 1, Y: 10, Cost: 45\r\n"
                + "Description: This seminar will present "
                + "an overview of HCI research at VT\r\n"
                + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
                + "Seminars matching keyword TV:\r\n"
                + "Seminars matching keyword VT:\r\n"
                + "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 1, Y: 10, Cost: 45\r\n"
                + "Description: This seminar will present "
                + "an overview of HCI research at VT\r\n"
                + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\n");
    }


    /**
     * This tests the print method inside
     * of the commandProcessor method. This will
     * cover all the branches for printing each
     * tree in the project. It will call print
     * when the trees are empty, and print
     * when the trees are empty.
     * 
     * @throws Exception
     *             if there is an error
     *             or the file is empty.
     */
    public void testPrint() throws Exception {
        CommandProcessor cmp = new CommandProcessor("PrintFile.txt", 128);
        cmp.processCommand("PrintFile.txt", 0);
        assertEquals(systemOut().getHistory(), "ID Tree:\r\n"
            + "This tree is empty\r\n" + "Cost Tree:\r\n"
            + "This tree is empty\r\n" + "Date Tree:\r\n"
            + "This tree is empty\r\n"
            + "Insert FAILED - Bad x, y coordinates: 1, 10\r\n" + "ID Tree:\r\n"
            + "This tree is empty\r\n" + "Cost Tree:\r\n"
            + "This tree is empty\r\n" + "Date Tree:\r\n"
            + "This tree is empty\n");
    }


    /**
     * This tests the print method inside
     * of the commandProcessor method. This will
     * cover all the branches for printing each
     * tree in the project. It will call print
     * when the trees are empty, and print
     * when the trees aren't empty.
     * 
     * @throws Exception
     *             if there is an error
     *             or the file is empty.
     */
    public void testPrint2() throws Exception {
        CommandProcessor cmp = new CommandProcessor("PrintFile.txt", 128);
        cmp.processCommand("PrintFile.txt", 16);
        assertEquals(systemOut().getHistory(), "ID Tree:\r\n"
            + "This tree is empty\r\n" + "Cost Tree:\r\n"
            + "This tree is empty\r\n" + "Date Tree:\r\n"
            + "This tree is empty\r\n"
            + "Successfully inserted record with ID 1\r\n"
            + "ID: 1, Title: Overview of HCI Research at VT\r\n"
            + "Date: 0610051600, Length: 90, X: 1, Y: 10, Cost: 45\r\n"
            + "Description: This seminar will present "
            + "an overview of HCI research at VT\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "ID Tree:\r\n" + "  null\r\n" + "1\r\n" + "  null\r\n"
            + "Number of records: 1\r\n" + "Cost Tree:\r\n" + "  null\r\n"
            + "45\r\n" + "  null\r\n" + "Number of records: 1\r\n"
            + "Date Tree:\r\n" + "  null\r\n" + "0610051600\r\n" + "  null\r\n"
            + "Number of records: 1\n");
    }

    /**
     * Need to test when we print location.
     */
}
