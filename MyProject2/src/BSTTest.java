import student.TestCase;

/**
 * This tests the methods and constructor
 * in the BST class.
 * 
 * @author Connor Marks (connorm20)
 * @version 9.24.2023
 * 
 */
public class BSTTest extends TestCase {
    private KVPair<String, String> kvp = new KVPair<String, String>("left",
        "0");
    private KVPair<String, String> kvp2 = new KVPair<String, String>("right",
        "1");
    private BST<String, String> root = new BST<String, String>();
    private BSTNode<String, String> nodeLeft = new BSTNode<String, String>(kvp);
    private BSTNode<String, String> nodeRight = new BSTNode<String, String>(
        kvp2);
    private BST<Integer, Integer> test = new BST<>();

    /**
     * This is where the initialization
     * of objects occurs to help tests.
     */
    public void setUp() {
        // Nothing to do here.
    }


    /**
     * This tests the insert method
     * when the root is empty, and when
     * the root is not empty.
     */
    public void testInsert() {
        assertNull(test.getRoot());

        // Insert nodes with unique keys
        BSTNode<Integer, Integer> node1 = new BSTNode<>(new KVPair<>(5, 5));
        BSTNode<Integer, Integer> node2 = new BSTNode<>(new KVPair<>(3, 3));
        BSTNode<Integer, Integer> node3 = new BSTNode<>(new KVPair<>(7, 7));

        BSTNode<Integer, Integer> node4 = new BSTNode<>(new KVPair<>(10, 10));

        test.insert(node1);
        assertNotNull(test.getRoot());
        assertNull(test.getRoot().getLeft());
        assertNull(test.getRoot().getRight());

    }


    /**
     * This tests the insert method
     * when the tree has a root, a left
     * child and a right child that are
     * connected to the root.
     */
    public void testInsert4() {
        assertNull(test.getRoot());

        // Insert nodes with unique keys
        BSTNode<Integer, Integer> node1 = new BSTNode<>(new KVPair<>(5, 5));
        BSTNode<Integer, Integer> node2 = new BSTNode<>(new KVPair<>(3, 3));
        BSTNode<Integer, Integer> node3 = new BSTNode<>(new KVPair<>(7, 7));

        BSTNode<Integer, Integer> node4 = new BSTNode<>(new KVPair<>(10, 10));

        test.printTree();

        test.insert(node1);
        assertNotNull(test.getRoot());
        assertNull(test.getRoot().getLeft());
        assertNull(test.getRoot().getRight());

        test.insert(node2);
        assertNotNull(test.getRoot().getLeft());
        assertNull(test.getRoot().getRight());

        test.insert(node3);
        assertNotNull(test.getRoot().getLeft());
        assertNotNull(test.getRoot().getRight());

        test.insert(node4);
        assertNotNull(test.getRoot().getRight().getRight());

    }


    /**
     * This tests if the cost tree
     * is printing correctly with the
     * expected output.
     */
    public void testPrintCostTree() {

        BST<Integer, Seminar> costTree = new BST<>();

        Seminar sem = new Seminar(1, "Overview of HCI Research at VT",
            "0610051600", 90, (short)10, (short)10, 45, new String[] {
                "HCI Computer_Science VT Virginia_Tech" },
            "This seminar will present " + "an overview of HCI research at VT");

        BSTNode<Integer, Seminar> node1 = new BSTNode<>(new KVPair<>(45, sem));

        costTree.insert(node1);

    }
    


    /**
     * This tests the insert method when
     * there are a bunch of consecutive
     * inserts of different values.
     */
    public void testInsert2() {
        BSTNode<Integer, Integer> node1 = new BSTNode<>(new KVPair<>(1, 1));
        BSTNode<Integer, Integer> node2 = new BSTNode<>(new KVPair<>(2, 2));
        BSTNode<Integer, Integer> node3 = new BSTNode<>(new KVPair<>(10, 10));

        BSTNode<Integer, Integer> node4 = new BSTNode<>(new KVPair<>(3, 3));
        // insert a 1 2 10 3

        BST<Integer, Integer> test1 = new BST<>();

        test1.insert(node1);
        test1.insert(node2);
        test1.insert(node3);
        test1.insert(node4);

    }


    /**
     * This tests the insert method when
     * the root and the left child are equal.
     */
    public void testInsert3() {
        BSTNode<Integer, Integer> node1 = new BSTNode<>(new KVPair<>(5, 5));
        test.insert(node1);
        test.insert(node1);
        assertNotNull(test.getRoot());
        assertNotNull(test.getRoot().getLeft());
    }


    /**
     * This tests the insert method when
     * the root and the left child is
     * equal.
     */
    public void testInsert5() {
        BSTNode<Integer, Integer> node1 = new BSTNode<>(new KVPair<>(5, 5));
        BSTNode<Integer, Integer> node2 = new BSTNode<>(new KVPair<>(5, 5));
        test.insert(node1);
        test.insert(node2);
        assertNotNull(test.getRoot());
        assertNotNull(test.getRoot().getLeft());
    }


    /**
     * This tests the contains
     * method for when the tree
     * does contain the key and
     * when it does not.
     */
    public void testContains() {
        BST<Integer, Integer> tree = new BST<>();
        assertEquals(tree.countNodes(tree.getRoot()), 0);
        BSTNode<Integer, Integer> node1 = new BSTNode<>(new KVPair<>(5, 5));
        test.insert(node1);
        assertTrue(test.contains(5));
        assertFalse(test.contains(3));
        assertFalse(test.contains(-1));
    }


    /**
     * This tests when the contains
     * method looks for a key and
     * the tree is empty.
     */
    public void testContains2() {
        BSTNode<Integer, Integer> node1 = new BSTNode<>(new KVPair<>(5, 5));
        assertFalse(test.contains(5));
        assertFalse(test.contains(0));
        assertFalse(test.contains(-1));

    }


    /**
     * This will test the contains method
     * for when it looks past the root
     * at the left subtree and the
     * right subtree of the root.
     * Both for when a node is found
     * in either subtree and also
     * when the node isn't found
     * in either subtree.
     */
    public void testContains3() {
        BSTNode<Integer, Integer> node1 = new BSTNode<>(new KVPair<>(5, 5));
        BSTNode<Integer, Integer> node2 = new BSTNode<>(new KVPair<>(6, 6));
        BSTNode<Integer, Integer> node3 = new BSTNode<>(new KVPair<>(4, 4));
        test.insert(node1);
        test.insert(node2);
        test.insert(node3);
        assertTrue(test.contains(6));
        assertTrue(test.contains(4));
        assertFalse(test.contains(7));
        assertFalse(test.contains(3));

    }


    /**
     * This tests the print tree
     * method for when the tree
     * is completely empty.
     */
    public void testPrintTree() {
        test.printTree();
        assertEquals(systemOut().getHistory(), "null\n");
    }


    /**
     * This tests the print tree
     * method for when the tree
     * has only the root.
     */
    public void testPrintTree2() {
        BSTNode<Integer, Integer> node1 = new BSTNode<>(new KVPair<>(5, 5));
        test.insert(node1);
        test.printTree();
        assertEquals(systemOut().getHistory(), "  null\r\n" + "5\r\n"
            + "  null\n");
    }


    /**
     * This tests the print tree
     * method for when the tree
     * has a root and a left child.
     */
    public void testPrintTree3() {
        BSTNode<Integer, Integer> node1 = new BSTNode<>(new KVPair<>(5, 5));
        BSTNode<Integer, Integer> node2 = new BSTNode<>(new KVPair<>(4, 4));
        test.insert(node1);
        test.insert(node2);
        test.printTree();
        assertEquals(systemOut().getHistory(), "  null\r\n" + "5\r\n"
            + "    null\r\n" + "  4\r\n" + "    null\n");
    }


    /**
     * This tests the print tree
     * method for when the tree
     * has a root and a right child.
     */
    public void testPrintTree4() {
        BSTNode<Integer, Integer> node1 = new BSTNode<>(new KVPair<>(5, 5));
        BSTNode<Integer, Integer> node2 = new BSTNode<>(new KVPair<>(6, 6));
        test.insert(node1);
        test.insert(node2);
        test.printTree();
        assertEquals(systemOut().getHistory(), "    null\r\n" + "  6\r\n"
            + "    null\r\n" + "5\r\n" + "  null\n");
    }


    /**
     * This tests the print tree
     * method for when the tree
     * has a root, a left child
     * and a right child.
     */
    public void testPrintTree5() {
        BSTNode<Integer, Integer> node1 = new BSTNode<>(new KVPair<>(5, 5));
        BSTNode<Integer, Integer> node2 = new BSTNode<>(new KVPair<>(4, 4));
        BSTNode<Integer, Integer> node3 = new BSTNode<>(new KVPair<>(6, 6));
        test.insert(node1);
        test.insert(node2);
        test.insert(node3);
        test.printTree();
        assertEquals(systemOut().getHistory(), "    null\r\n" + "  6\r\n"
            + "    null\r\n" + "5\r\n" + "    null\r\n" + "  4\r\n"
            + "    null\n");
    }


    /**
     * This will test all of the
     * cases for count nodes, which
     * will be when the number of
     * nodes is 0, 1, 2, and 3.
     * This is because it will test
     * when the tree is empty,
     * when the tree only has a root,
     * when the tree has a root and a left child,
     * when the tree has a root and a right child,
     * and when the tree has a root with two children.
     */
    public void testCountNodes() {
        // Need to figure out how to test for an empty node
        // I tried to create an empty BSTNode constructor in the BSTNode class
        // and that didn't work.
        BSTNode<Integer, Integer> node1 = new BSTNode<>(new KVPair<>(5, 5));
        test.insert(node1);
        assertEquals(test.countNodes(node1), 1);
        BSTNode<Integer, Integer> node2 = new BSTNode<>(new KVPair<>(4, 4));
        test.insert(node2);
        assertEquals(test.countNodes(node1), 2);
        BSTNode<Integer, Integer> node3 = new BSTNode<>(new KVPair<>(6, 6));
        test.insert(node3);
        assertEquals(test.countNodes(node1), 3);
    }


    /**
     * This will test the countNodes
     * method for when the tree has only
     * a right child and a root.
     */
    public void testCountNodes2() {
        BSTNode<Integer, Integer> node1 = new BSTNode<>(new KVPair<>(5, 5));
        test.insert(node1);
        BSTNode<Integer, Integer> node2 = new BSTNode<>(new KVPair<>(6, 6));
        test.insert(node2);
        assertEquals(test.countNodes(node1), 2);
    }


    /**
     * This will test the getRoot method
     * when there is not a root
     * and when there is.
     */
    public void testGetRoot() {
        assertEquals(test.getRoot(), null);
        BSTNode<Integer, Integer> node1 = new BSTNode<>(new KVPair<>(5, 5));
        test.insert(node1);
        assertEquals(test.getRoot(), node1);

    }


    /**
     * This tests the insertRecord method.
     */
    public void testInsertRecord() {
        BSTNode<Integer, Integer> node1 = new BSTNode<>(new KVPair<>(5, 5));
        BSTNode<Integer, Integer> node2 = new BSTNode<>(new KVPair<>(5, 5));
        test.insert(node1);
        test.insert(node2);
        assertEquals(test.getRoot(), node1);
        assertEquals(test.getRoot().getLeft(), node2);
    }


    /**
     * This tests the remove method.
     */
    public void testDelete() {
        assertFalse(test.delete(1));
        BSTNode<Integer, Integer> node1 = new BSTNode<>(new KVPair<>(5, 5));
        test.insert(node1);
        assertTrue(test.delete(5));
        assertFalse(test.delete(10));
        assertFalse(test.delete(4));
    }


    /**
     * This tests the findMax method.
     */
    public void testFindMax() {
        BSTNode<Integer, Integer> node1 = new BSTNode<>(new KVPair<>(6, 6));
        BSTNode<Integer, Integer> node2 = new BSTNode<>(new KVPair<>(4, 4));
        BSTNode<Integer, Integer> node3 = new BSTNode<>(new KVPair<>(7, 7));
        BSTNode<Integer, Integer> node4 = new BSTNode<>(new KVPair<>(5, 5));
        test.insert(node2);
        test.insert(node1);
        test.insert(node4);
        test.insert(node3);
        assertTrue(test.delete(5));
        assertTrue(test.delete(7));
    }


    /**
     * This tests the insertRecrod method.
     */
    public void testInsertRecord2() {
        int num = 4;
        BSTNode<Integer, Integer> node1 = new BSTNode<>(new KVPair<>(num, 4));
        BSTNode<Integer, Integer> node2 = new BSTNode<>(new KVPair<>(num, 4));
        test.insert(node1);
        test.insert(node2);
        assertEquals(node1.getKey().compareTo(node2.getKey()), 0);
    }


    /**
     * This tests the delete method.
     */
    public void testDelete2() {
        assertFalse(test.delete(1));
        BSTNode<Integer, Integer> node1 = new BSTNode<>(new KVPair<>(5, 5));
        BSTNode<Integer, Integer> node2 = new BSTNode<>(new KVPair<>(4, 4));
        BSTNode<Integer, Integer> node3 = new BSTNode<>(new KVPair<>(6, 6));
        test.insert(node1);
        test.insert(node2);
        test.insert(node3);
        assertFalse(test.delete(0));
        assertTrue(test.delete(4));
        assertFalse(test.delete(7));
        assertTrue(test.delete(6));
        assertTrue(test.delete(5));
    }


    /**
     * This tests the delete method.
     */
    public void testDelete3() {
        BSTNode<Integer, Integer> node1 = new BSTNode<>(new KVPair<>(5, 5));
        BSTNode<Integer, Integer> node2 = new BSTNode<>(new KVPair<>(4, 4));
        test.insert(node1);
        test.insert(node2);
        assertFalse(test.delete(6));
        assertTrue(test.delete(4));
    }


    /**
     * This tests the delete method.
     */
    public void testDelete4() {
        BSTNode<Integer, Integer> node1 = new BSTNode<>(new KVPair<>(5, 5));
        BSTNode<Integer, Integer> node3 = new BSTNode<>(new KVPair<>(6, 6));
        test.insert(node1);
        test.insert(node3);
        assertFalse(test.delete(4));
        assertTrue(test.delete(6));
    }

    /**
     * tests a single insert and delete.
     */
    public void testDeleteNode() {
        BST<Integer, String> bst = new BST<>();
        bst.insert(new BSTNode<>(new KVPair<>(5, "Five")));

        bst.delete(5);

        assertFalse(bst.contains(5));
        assertNull(bst.getRoot());
    }


    /**
     * test delete for just left child
     */
    public void testDeleteOnlyLeft() {
        BST<Integer, String> bst = new BST<>();
        BSTNode<Integer, String> node1 = new BSTNode<>(new KVPair<>(5, "Five"));
        BSTNode<Integer, String> node2 = new BSTNode<>(new KVPair<>(3,
            "Three"));

        bst.insert(node1);
        bst.insert(node2);

        bst.delete(5);

        assertFalse(bst.contains(5));
        assertTrue(bst.contains(3));
        assertEquals(bst.getRoot().getKey().intValue(), 3);
    }


    /**
     * test delete for just right child
     */
    public void testDeleteRightKid() {
        BST<Integer, String> bst = new BST<>();
        BSTNode<Integer, String> node1 = new BSTNode<>(new KVPair<>(5, "Five"));
        BSTNode<Integer, String> node2 = new BSTNode<>(new KVPair<>(7,
            "Seven"));

        bst.insert(node1);
        bst.insert(node2);

        bst.delete(5);

        assertFalse(bst.contains(5));
        assertTrue(bst.contains(7));
        assertEquals(bst.getRoot().getKey().intValue(), 7);
    }


    /**
     * test delete for 2 children
     */
    public void testDelete2Kids() {
        BST<Integer, String> bst = new BST<>();
        BSTNode<Integer, String> node1 = new BSTNode<>(new KVPair<>(5, "Five"));
        BSTNode<Integer, String> node2 = new BSTNode<>(new KVPair<>(3,
            "Three"));
        BSTNode<Integer, String> node3 = new BSTNode<>(new KVPair<>(7,
            "Seven"));

        bst.insert(node1);
        bst.insert(node2);
        bst.insert(node3);

        bst.delete(5);

        assertFalse(bst.contains(5));
        assertTrue(bst.contains(3));
        assertTrue(bst.contains(7));
        assertEquals(bst.getRoot().getKey().intValue(), 3);
    }


    /**
     * test deleting the root of the BST
     */
    public void testDeleteRoot() {
        BST<Integer, String> bst = new BST<>();
        BSTNode<Integer, String> node1 = new BSTNode<>(new KVPair<>(5, "Five"));

        bst.insert(node1);

        bst.delete(5);

        assertFalse(bst.contains(5));
        assertNull(bst.getRoot());
    }
}
