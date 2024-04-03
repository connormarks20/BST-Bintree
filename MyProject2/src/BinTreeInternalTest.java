import student.TestCase;

/**
 * This class tests the Internal Node 
 * Class for BinTree.
 * @author Connor Marks (connorm20)
 * @version 10.13.2023
 */
public class BinTreeInternalTest extends TestCase {

    /**
     * Empty Setup method.
     */
    public void setUp() {
        // Nothing to do here.
    }


    /**
     * tests get and set for left and right children.
     */
    public void testLeftAndRight() {

        LinkedList<Seminar> list = new LinkedList<>();
        String[] keys = new String[1];
        keys[0] = "keywords";
        Seminar seminar = new Seminar(1, "title", "dateandtime", 5, (short)5,
            (short)5, 5, keys, "description");
        list.insertSeminar(seminar);
        BinTreeLeaf leaf = new BinTreeLeaf(list);

        BinTreeInternal internal = new BinTreeInternal(FlyWeight.getInstance(),
            FlyWeight.getInstance());
        assertTrue(internal.getLeft().isEmpty() && internal.getRight()
            .isEmpty());
        internal.setLeft(leaf);
        assertTrue(internal.getLeft().isLeaf());
        assertTrue(internal.getRight().isEmpty());
        internal.setLeft(internal);
        assertTrue(internal.getLeft().isInternal());
        internal.setRight(leaf);
        assertTrue(internal.getRight().isLeaf());

    }


    /**
     * tests the insert method
     */
    public void testInsert() {
        String[] keys = new String[1];
        keys[0] = "keywords";
        Seminar seminar = new Seminar(1, "title", "dateandtime", 5, (short)5,
            (short)5, 5, keys, "description");
        BinTreeInternal intern = new BinTreeInternal(FlyWeight.getInstance(),
            FlyWeight.getInstance());
        BinTreeLeaf insertLeaf = new BinTreeLeaf(new LinkedList<>());
        insertLeaf.getList().insertSeminar(seminar);
        intern.insert(seminar, 0, 0, 128, 0, 128);
        assertTrue(intern.getLeft().isLeaf());
        assertTrue(intern.getRight().isEmpty());
        assertEquals(intern.getLeft().getList().getListSize(), 1);

        Seminar sem2 = new Seminar(2, "title", "dateandtime", 5, (short)120,
            (short)120, 30, keys, "description");
        intern.insert(sem2, 0, 0, 128, 0, 128);
        BinTreeLeaf newLeaf = new BinTreeLeaf(new LinkedList<>());
        newLeaf.getList().insertSeminar(sem2);
        intern.insert(sem2, 0, 0, 128, 0, 128);

        assertTrue(intern.getRight().isLeaf());
        Seminar sem3 = new Seminar(2, "title", "dateandtime", 5, (short)124,
            (short)124, 30, keys, "description");
        intern.insert(sem3, 0, 0, 128, 0, 128);
        assertTrue(intern.getRight().isInternal());
    }


    /**
     * tests insert at the maximum level
     */
    public void testInsertAtMax() {
        BinTree binTree = new BinTree(128);

        for (int i = 1; i <= 10; i++) {
            Seminar seminar = new Seminar(i, "Seminar " + i, "0404040404", i
                * 10, (short)10, (short)10, 5, new String[] { "keyword" },
                "Description");
            binTree.insertRecord(seminar, 100);
        }

        assertEquals(10, binTree.getRoot().getList().getListSize());
    }


    /**
     * tests inserting 4 seminar records
     */
    public void testInsertMil() {

        BinTreeInternal internal = new BinTreeInternal(FlyWeight.getInstance(),
            FlyWeight.getInstance());

        Seminar sem1 = new Seminar(1, "Seminar 1", "Date 1", 10, (short)10,
            (short)10, 5, new String[] { "keyword" }, "Description 1");
        internal.insert(sem1, 0, 0, 128, 0, 128);

        assertTrue(internal.getLeft().isLeaf());

        Seminar sem2 = new Seminar(2, "Seminar 2", "Date 2", 80, (short)80,
            (short)80, 5, new String[] { "keyword" }, "Description 2");
        internal.insert(sem2, 0, 0, 128, 0, 128);

        assertTrue(internal.getRight().isLeaf());

        Seminar sem3 = new Seminar(3, "Seminar 3", "Date 3", 5, (short)5,
            (short)5, 40, new String[] { "keyword" }, "Description 3");
        internal.insert(sem3, 1, 0, 128, 0, 128);

        assertTrue(internal.getLeft().isInternal());
        assertTrue(internal.getLeft().getLeft().getLeft().isInternal());

        Seminar sem4 = new Seminar(4, "Seminar 4", "Date 4", 120, (short)120,
            (short)120, 40, new String[] { "keyword" }, "Description 4");
        internal.insert(sem4, 1, 0, 128, 0, 128);

        assertTrue(internal.getRight().isInternal());
    }


    /**
     * tests the getList() method
     */
    public void testGetList() {
        BinTreeInternal in = new BinTreeInternal(FlyWeight.getInstance(),
            FlyWeight.getInstance());
        assertEquals(in.getList(), null);
    }

}
