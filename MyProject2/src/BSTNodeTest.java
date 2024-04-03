import student.TestCase;

/**
 * This tests the methods and constructor
 * in the BSTNode class.
 * 
 * @author Connor Marks (connorm20)
 * @version 9.23.2023
 */
public class BSTNodeTest extends TestCase {
    private KVPair<String, String> kvp = new KVPair<String, String>("key", "0");

    /**
     * This is here for any initialization
     * of objects is needed for testing.
     */
    public void setUp() {
        // Nothing to do here.
    }


    /**
     * This tests the getKey method.
     */
    public void testGetKey() {
        BSTNode<String, String> bstNode = new BSTNode<String, String>(kvp);
        assertEquals(bstNode.getKey(), "key");
    }


    /**
     * This tests the getKey method.
     */
    public void testGetValue() {
        BSTNode<String, String> bstNode = new BSTNode<String, String>(kvp);
        assertEquals(bstNode.getValue(), "0");
    }


    /**
     * This tests the getLeft and setLeft method.
     */
    public void testGetLeft() {
        BSTNode<String, String> bstNode = new BSTNode<String, String>(kvp);
        bstNode.setLeft(bstNode);
        assertEquals(bstNode.getLeft(), bstNode);
    }


    /**
     * This tests the getRight and setRight method.
     */
    public void testGetRight() {
        BSTNode<String, String> bstNode = new BSTNode<String, String>(kvp);
        bstNode.setRight(bstNode);
        assertEquals(bstNode.getRight(), bstNode);
    }


    /**
     * This tests the setKey method.
     */
    public void testSetKey() {
        BSTNode<String, String> node = new BSTNode<String, String>(kvp);
        node.setKey("New Key");
        assertEquals(node.getKey(), "New Key");
    }


    /**
     * This tests the setValue method.
     */
    public void testSetValue() {
        BSTNode<String, String> node = new BSTNode<String, String>(kvp);
        node.setValue("11");
        assertEquals(node.getValue(), "11");
    }
}
