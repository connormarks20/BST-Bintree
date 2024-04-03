import student.TestCase;

/**
 * This is the WorldDataBaseTest
 * class that tests all the
 * methods and constructors
 * in the WorldDataBase class.
 * 
 * @author Connor Marks
 * @version 9.28.2023
 */
public class WorldDataBaseTest extends TestCase {

    /**
     * The WorldDataBase constructor creates new empty binary search trees for
     * the
     * id,cost,date, and keyword trees.
     */

    // test when empty keywords
    // test when there are keywords

    public void testInsert() {

        WorldDataBase worldDB = new WorldDataBase(128);

        Seminar sem = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");

        KVPair<Integer, Seminar> idKvp = new KVPair<>(1, sem);
        KVPair<Integer, Seminar> costKvp = new KVPair<>(45, sem);
        KVPair<String, Seminar> dateKvp = new KVPair<>("0610051600", sem);

        idKvp.setKey(1);

        String output = "ID: 1, Title: Overview of HCI Research at VT\r\n"
            + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
            + "Description: This seminar will present"
            + " an overview of HCI research at VT\r\n"
            + "Keywords: HCI Computer_Science VT Virginia_Tech" + "\n";

        worldDB.insert(idKvp, costKvp, dateKvp);

        assertEquals(systemOut().getHistory(),
            "Successfully inserted record with ID 1\r\n"
                + "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
                + "Description: This seminar will present"
                + " an overview of HCI research at VT\r\n"
                + "Keywords: HCI Computer_Science VT Virginia_Tech\r\n");

        assertEquals(output, worldDB.searchID(1).toString() + "\n");

    }


    /**
     * This method tests for when there
     * is a duplicate insert that occurs.
     */
    public void testInsertDuplicate() {

        WorldDataBase dataBase = new WorldDataBase(128);

        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");

        Seminar sem2 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");

        Seminar sem3 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");

        KVPair<Integer, Seminar> idKvp = new KVPair<>(1, sem1);
        KVPair<Integer, Seminar> costKvp = new KVPair<>(45, sem2);
        KVPair<String, Seminar> dateKvp = new KVPair<>("0610051600", sem3);

        dataBase.insert(idKvp, costKvp, dateKvp);

        dataBase.insert(idKvp, costKvp, dateKvp);

        assertEquals(1, dataBase.searchID(1).id());
        assertNull(dataBase.searchID(2));
    }


    /**
     * test method for inserting duplicates
     */
    public void testInsertDuplicate2() {
        WorldDataBase dataBase = new WorldDataBase(128);
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        KVPair<Integer, Seminar> idKvp = new KVPair<>(1, sem1);
        KVPair<Integer, Seminar> costKvp = new KVPair<>(45, sem1);
        KVPair<String, Seminar> dateKvp = new KVPair<>("0610051600", sem1);
        dataBase.insert(idKvp, costKvp, dateKvp);

        for (int i = 0; i < sem1.keywords().length; i++) {
            KVPair<String, Seminar> keyKvp = new KVPair<>(sem1.keywords()[i],
                sem1);
            dataBase.insertKeyWords(keyKvp);

        }
        systemOut().clearHistory();
        dataBase.insert(idKvp, costKvp, dateKvp);
        assertEquals(systemOut().getHistory(),
            "Insert FAILED - There is already a record with ID 1\r\n" + "");
        dataBase.insertKeyWords(dateKvp);

    }


    /**
     * This tests for when we print
     * the four different trees.
     */
    public void testPrintTrees() {
        WorldDataBase dataBase = new WorldDataBase(128);

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

        KVPair<Integer, Seminar> idKvp = new KVPair<>(1, sem1);
        KVPair<Integer, Seminar> costKvp = new KVPair<>(45, sem2);
        KVPair<String, Seminar> dateKvp = new KVPair<>("0610051600", sem3);

        dataBase.insert(idKvp, costKvp, dateKvp);

        dataBase.printCostTree();
        assertEquals(systemOut().getHistory(),
            "Successfully inserted record with ID 1\r\n"
                + "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
                + "Description: This seminar will present"
                + " an overview of HCI research at VT\r\n"
                + "Keywords: HCI Computer_Science VT Virginia_Tech\r\n"
                + "Cost Tree:\r\n" + "  null\r\n" + "45\r\n" + "  null\r\n"
                + "Number of records: 1\n");
        dataBase.printDateTree();
        assertEquals(systemOut().getHistory(),
            "Successfully inserted record with ID 1\r\n"
                + "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
                + "Description: This seminar will present"
                + " an overview of HCI research at VT\r\n"
                + "Keywords: HCI Computer_Science VT Virginia_Tech\r\n"
                + "Cost Tree:\r\n" + "  null\r\n" + "45\r\n" + "  null\r\n"
                + "Number of records: 1\r\n" + "Date Tree:\r\n" + "  null\r\n"
                + "0610051600\r\n" + "  null\r\n" + "Number of records: 1\n");
        dataBase.printIDTree();
        assertEquals(systemOut().getHistory(),
            "Successfully inserted record with ID 1\r\n"
                + "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
                + "Description: This seminar will present"
                + " an overview of HCI research at VT\r\n"
                + "Keywords: HCI Computer_Science VT Virginia_Tech\r\n"
                + "Cost Tree:\r\n" + "  null\r\n" + "45\r\n" + "  null\r\n"
                + "Number of records: 1\r\n" + "Date Tree:\r\n" + "  null\r\n"
                + "0610051600\r\n" + "  null\r\n" + "Number of records: 1\r\n"
                + "ID Tree:\r\n" + "  null\r\n" + "1\r\n" + "  null\r\n"
                + "Number of records: 1\n");

    }


    /**
     * This will test when we are
     * searching for a specific ID in
     * the ID tree.
     */
    public void testSearchID() {
        WorldDataBase dataBase = new WorldDataBase(128);

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

        KVPair<Integer, Seminar> idKvp = new KVPair<>(1, sem1);
        KVPair<Integer, Seminar> costKvp = new KVPair<>(45, sem2);
        KVPair<String, Seminar> dateKvp = new KVPair<>("0610051600", sem3);

        dataBase.insert(idKvp, costKvp, dateKvp);

    }


    /**
     * This method tests the delete method.
     */
    public void testDelete() {
        WorldDataBase dataBase = new WorldDataBase(128);
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

        KVPair<Integer, Seminar> idKvp = new KVPair<>(1, sem1);
        KVPair<Integer, Seminar> costKvp = new KVPair<>(45, sem2);
        KVPair<String, Seminar> dateKvp = new KVPair<>("0610051600", sem3);

        dataBase.insert(idKvp, costKvp, dateKvp);

        dataBase.delete(1);
        dataBase.delete(0);
        assertEquals(systemOut().getHistory(),
            "Successfully inserted record with ID 1\r\n"
                + "ID: 1, Title: Overview of HCI Research " + "at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 10, Y: "
                + "10, Cost: 45\r\n"
                + "Description: This seminar will present an overview of "
                + "HCI research at VT\r\n"
                + "Keywords: HCI Computer_Science VT Virginia_Tech\r\n"
                + "Record with ID 1 successfully deleted from the "
                + "database\r\n"
                + "Delete FAILED -- There is no record with ID 0\n");
    }


    /**
     * This tests the getID method.
     */
    public void testGetID() {
        WorldDataBase dataBase = new WorldDataBase(128);
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

        KVPair<Integer, Seminar> idKvp = new KVPair<>(1, sem1);
        KVPair<Integer, Seminar> costKvp = new KVPair<>(45, sem2);
        KVPair<String, Seminar> dateKvp = new KVPair<>("0610051600", sem3);
        assertEquals(dataBase.getIDSem(1), null);
        dataBase.insert(idKvp, costKvp, dateKvp);

        assertEquals(dataBase.getIDSem(1), sem1);
        assertEquals(dataBase.getIDSem(0), null);
        assertEquals(systemOut().getHistory(),
            "Successfully inserted record with ID 1\r\n"
                + "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 10, Y: 10, "
                + "Cost: 45\r\n" + "Description: This seminar will "
                + "present an overview of HCI research at VT\r\n"
                + "Keywords: HCI Computer_Science VT Virginia_Tech\n");
    }


    /**
     * This tests the delete method
     * for when the ID is inside
     * of the tree and it deletes
     * it from the database.
     */
    public void testDelete2() {
        WorldDataBase dataBase = new WorldDataBase(128);
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        KVPair<Integer, Seminar> idKvp = new KVPair<>(1, sem1);
        KVPair<Integer, Seminar> costKvp = new KVPair<>(45, sem1);
        KVPair<String, Seminar> dateKvp = new KVPair<>("0610051600", sem1);
        KVPair<String, Seminar> keywordsKVP = new KVPair<>("String", sem1);
        dataBase.insert(idKvp, costKvp, dateKvp);
        dataBase.insertKeyWords(keywordsKVP);
        dataBase.delete(1);
        assertEquals(systemOut().getHistory(),
            "Successfully inserted record with ID 1\r\n"
                + "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
                + "Description: This seminar will present"
                + " an overview of HCI research at VT\r\n"
                + "Keywords: HCI Computer_Science VT Virginia_Tech\r\n"
                + "Record with ID 1 successfully deleted from the database\n");
    }


    /**
     * This tests the insert method
     */
    public void testInsert2() {
        WorldDataBase dataBase = new WorldDataBase(128);
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        KVPair<Integer, Seminar> idKvp = new KVPair<>(2, sem1);
        KVPair<Integer, Seminar> costKvp = new KVPair<>(45, sem1);
        KVPair<String, Seminar> dateKvp = new KVPair<>("0610051600", sem1);
        KVPair<String, Seminar> keywordsKVP = new KVPair<>("String", sem1);
        dataBase.insert(idKvp, costKvp, dateKvp);
        KVPair<Integer, Seminar> idKvp2 = new KVPair<>(2, sem1);
        dataBase.insert(idKvp2, costKvp, dateKvp);
        assertEquals(systemOut().getHistory(),
            "Successfully inserted record with ID 2\r\n"
                + "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
                + "Description: This seminar will present"
                + " an overview of HCI research at VT\r\n"
                + "Keywords: HCI Computer_Science VT Virginia_Tech\r\n"
                + "Insert FAILED - There is already a record with ID 2\n");
    }


    /**
     * This tests the printKeyWordsTree method.
     */
    public void testPrintKeyWordsTree() {
        WorldDataBase dataBase = new WorldDataBase(128);
        dataBase.printKeyWordsTree();
        assertEquals(systemOut().getHistory(), "Keyword Tree:\r\n"
            + "This tree is empty\n");
    }


    /**
     * This tests the searchByCostRange method.
     */
    public void testSearchByCostRange() {
        WorldDataBase dataBase = new WorldDataBase(128);
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        KVPair<Integer, Seminar> costKvp = new KVPair<>(45, sem1);
        dataBase.searchByCostRange(0, 50);
        dataBase.searchByCostRange(45, 45);
        assertEquals(systemOut().getHistory(),
            "Seminars with costs in range 0 to 50:\r\n"
                + "1 nodes visited in this search\r\n"
                + "Seminars with costs in range 45 to 45:\r\n"
                + "1 nodes visited in this search\n");
    }


    /**
     * This tests the searchByDateRange method.
     */
    public void testSearchByDateRange() {
        WorldDataBase dataBase = new WorldDataBase(128);
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        KVPair<String, Seminar> dateKvp = new KVPair<>("0610051600", sem1);

        dataBase.searchByDateRange("0000000000", "1111111111");
        dataBase.searchByDateRange("0610051600", "0610051600");
        dataBase.searchByDateRange("1111111111", "2222222222");
        assertEquals(systemOut().getHistory(),
            "Seminars with dates in range 0000000000 to 1111111111:\r\n"
                + "1 nodes visited in this search\r\n"
                + "Seminars with dates in range 0610051600 to 0610051600:\r\n"
                + "1 nodes visited in this search\r\n"
                + "Seminars with dates in range 1111111111 to 2222222222:\r\n"
                + "1 nodes visited in this search\n");

        BSTNode<String, Seminar> dateNode = new BSTNode<String, Seminar>(
            dateKvp);
        BST<String, Seminar> dateTree = new BST<>();
        dateTree.insert(dateNode);
        dataBase.searchByDateRange(dateTree.getRoot().getValue().date(),
            "000000");

        assertEquals(systemOut().getHistory(),
            "Seminars with dates in range 0000000000 to 1111111111:\r\n"
                + "1 nodes visited in this search\r\n"
                + "Seminars with dates in range 0610051600 to 0610051600:\r\n"
                + "1 nodes visited in this search\r\n"
                + "Seminars with dates in range 1111111111 to 2222222222:\r\n"
                + "1 nodes visited in this search\r\n"
                + "Seminars with dates in range 0610051600 to 000000:\r\n"
                + "1 nodes visited in this search\r\n" + "");
        dateTree.insert(dateNode);

    }


    /**
     * tests searchbylocation with 1 insert
     */
    public void testSearchByLocation() {
        WorldDataBase dataBase = new WorldDataBase(128);
        BinTree binTree = new BinTree(128);

        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        binTree.insertRecord(sem1, 0);

        dataBase.searchByLocation(1, 1, 1);
        assertEquals(systemOut().getHistory(),
            "Seminars within 1 units of 1, 1:\r\n"
                + "0 nodes visited in this search\r\n" + "");

        dataBase.searchByLocation(10, 10, 0);
        assertEquals(systemOut().getHistory(),
            "Seminars within 1 units of 1, 1:\r\n"
                + "0 nodes visited in this search\r\n"
                + "Seminars within 0 units of 10, 10:\r\n"
                + "0 nodes visited in this search\r\n" + "");

    }


    /**
     * tests the delete method with more cases
     */
    public void testDeleteAgain() {
        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present" + " an overview of HCI research at VT");
        WorldDataBase dataBase = new WorldDataBase(128);
        KVPair<Integer, Seminar> idPair = new KVPair<>(sem1.id(), sem1);
        KVPair<Integer, Seminar> costPair = new KVPair<>(sem1.cost(), sem1);
        KVPair<String, Seminar> datePair = new KVPair<>(sem1.date(), sem1);
        for (int i = 0; i < sem1.keywords().length; i++) {
            KVPair<String, Seminar> keyWordPair = new KVPair<>(sem1
                .keywords()[i], sem1);
            dataBase.insertKeyWords(keyWordPair);
        }

        dataBase.insert(idPair, costPair, datePair);
        assertEquals(systemOut().getHistory(),
            "Successfully inserted record with ID 1\r\n"
                + "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
                + "Description: This seminar will "
                + "present an overview of HCI research at VT\r\n"
                + "Keywords: HCI Computer_Science VT Virginia_Tech\r\n" + "");
        systemOut().clearHistory();
        dataBase.delete(sem1.id());
        assertEquals(systemOut().getHistory(),
            "Record with ID 1 successfully deleted from the database\r\n" + "");
        systemOut().clearHistory();
        dataBase.delete(0);

        assertEquals(systemOut().getHistory(),
            "Delete FAILED -- There is no record with ID 0\n");

        systemOut().clearHistory();

        Seminar sem2 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] { "" },
            "This seminar will present" + " an overview of HCI research at VT");
        KVPair<Integer, Seminar> ids = new KVPair<>(sem2.id(), sem2);
        dataBase.insert(ids, ids, datePair);

        KVPair<String, Seminar> keyWords = new KVPair<>(sem2.keywords()[0],
            sem2);
        dataBase.insertKeyWords(keyWords);

    }


    /**
     * method to test searchbylocation with 4 inserts
     */
    public void testSearchLocation2()

    {
        WorldDataBase dataBase = new WorldDataBase(128);

        Seminar sem1 = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] { "" },
            "This seminar will present" + " an overview of HCI research at VT");
        BinTree binTree = new BinTree(128);

        Seminar sem2 = new Seminar(2, "Overview of HCI Research at VT",
            "0610051600", 90, (short)80, (short)80, 45, new String[] { "" },
            "This seminar will present" + " an overview of HCI research at VT");

        Seminar sem3 = new Seminar(3, "Overview of HCI Research at VT",
            "0610051600", 90, (short)100, (short)100, 45, new String[] { "" },
            "This seminar will present" + " an overview of HCI research at VT");
        Seminar sem4 = new Seminar(4, "Overview of HCI Research at VT",
            "0610051600", 90, (short)100, (short)100, 45, new String[] { "" },
            "This seminar will present" + " an overview of HCI research at VT");

        KVPair<Integer, Seminar> idKvp = new KVPair<>(sem1.id(), sem1);
        KVPair<Integer, Seminar> costKvp = new KVPair<>(sem1.cost(), sem1);
        KVPair<String, Seminar> dateKvp = new KVPair<>(sem1.date(), sem1);
        for (int i = 0; i < sem1.keywords().length; i++) {
            KVPair<String, Seminar> keyKvp = new KVPair<>(sem1.keywords()[i],
                sem1);
        }

        dataBase.insert(idKvp, costKvp, dateKvp);
        dataBase.insertKeyWords(dateKvp);

        binTree.insertRecord(sem1, 0);
        systemOut().clearHistory();
        dataBase.searchByLocation(10, 10, 0);

        assertEquals(systemOut().getHistory(),
            "Seminars within 0 units of 10, 10:\r\n"
                + "Found a record with key value 1 at 10, 10\r\n"
                + "1 nodes visited in this search\r\n" + "");

        dataBase.searchByLocation(15, 15, 2000);
        assertEquals(systemOut().getHistory(),
            "Seminars within 0 units of 10, 10:\r\n"
                + "Found a record with key value 1 at 10, 10\r\n"
                + "1 nodes visited in this search\r\n"
                + "Seminars within 2000 units of 15, 15:\r\n"
                + "Found a record with key value 1 at 10, 10\r\n"
                + "1 nodes visited in this search\r\n" + "");

        KVPair<Integer, Seminar> idKvp2 = new KVPair<>(sem2.id(), sem1);
        KVPair<Integer, Seminar> costKvp2 = new KVPair<>(sem1.cost(), sem1);
        KVPair<String, Seminar> dateKvp2 = new KVPair<>(sem1.date(), sem1);
        for (int i = 0; i < sem2.keywords().length; i++) {
            KVPair<String, Seminar> keyKvp2 = new KVPair<>(sem1.keywords()[i],
                sem1);
            dataBase.insertKeyWords(keyKvp2);
        }

        dataBase.insert(idKvp2, costKvp2, dateKvp2);
        binTree.insertRecord(sem2, 0);

        systemOut().clearHistory();

        dataBase.searchByLocation(80, 80, 100);
        assertEquals(systemOut().getHistory(),
            "Seminars within 100 units of 80, 80:\r\n"
                + "Found a record with key value 1 at 10, 10\r\n"
                + "Found a record with key value 1 at 10, 10\r\n"
                + "2 nodes visited in this search\r\n" + "");

        KVPair<Integer, Seminar> idPair3 = new KVPair<>(sem3.id(), sem3);
        dataBase.insert(idPair3, costKvp2, dateKvp2);

        systemOut().clearHistory();
        dataBase.searchByLocation(100, 100, 128);
        assertEquals(systemOut().getHistory(),
            "Seminars within 128 units of 100, 100:\r\n"
                + "Found a record with key value 1 at 10, 10\r\n"
                + "Found a record with key value 1 at 10, 10\r\n"
                + "Found a record with key value 3 at 100, 100\r\n"
                + "4 nodes visited in this search\r\n" + "");

        KVPair<Integer, Seminar> idPair4 = new KVPair<>(sem4.id(), sem4);
        dataBase.insert(idPair4, costKvp2, dateKvp2);

        binTree.insertRecord(sem3, 0);
        systemOut().clearHistory();
        dataBase.searchByLocation(100, 100, 0);
        assertEquals(systemOut().getHistory(),
            "Seminars within 0 units of 100, 100:\r\n"
                + "Found a record with key value 3 at 100, 100\r\n"
                + "Found a record with key value 4 at 100, 100\r\n"
                + "3 nodes visited in this search\n");

        systemOut().clearHistory();
        dataBase.searchByLocation(0, 0, 0);
        assertEquals(systemOut().getHistory(),
            "Seminars within 0 units of 0, 0:\r\n"
                + "1 nodes visited in this search\r\n" + "");
        systemOut().clearHistory();
        dataBase.searchByLocation(5, 5, 2000);
        assertEquals(systemOut().getHistory(),
            "Seminars within 2000 units of 5, 5:\r\n"
                + "Found a record with key value 1 at 10, 10\r\n"
                + "Found a record with key value 1 at 10, 10\r\n"
                + "Found a record with key value 3 at 100, 100\r\n"
                + "Found a record with key value 4 at 100, 100\r\n"
                + "5 nodes visited in this search\r\n" + "");

    }

}
