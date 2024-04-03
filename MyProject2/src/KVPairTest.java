import student.TestCase;

/**
 * This test class tests all the methods
 * and the constructor from the KVPair class.
 * 
 * @author Connor Marks (connorm20)
 * @version 9.23.2023
 */
public class KVPairTest extends TestCase {
    /**
     * This sets up and initializes
     * anything we need to use
     * in the tests.
     */
    public void setUP() {
        // Nothing to do here.
    }


    /**
     * This tests the compareTo method
     * that has type KVPair and the other
     * compareTo method that has type integer.
     */
    public void testCompareTo() {
        KVPair<String, String> kvp = new KVPair<String, String>("Key", "1");
        KVPair<String, String> kvp2 = new KVPair<String, String>("Key", "1");
        KVPair<String, String> kvp3 = new KVPair<String, String>("yeK", "0");
        assertEquals(kvp.compareTo(kvp2), 0);
        assertEquals(kvp.compareTo("Key"), 0);
        assertEquals(kvp.compareTo(kvp3), -46);
        assertEquals(kvp.compareTo("yeK"), -46);
    }


    /**
     * This tests the getValue method
     */
    public void testGetValue() {
        KVPair<String, String> kvp = new KVPair<String, String>("Key", "1");
        assertEquals(kvp.getVal(), "1");
    }


    /**
     * This tests the getKey method
     */
    public void testGetKey() {
        KVPair<String, String> kvp = new KVPair<String, String>("Key", "1");
        assertEquals(kvp.getKey(), "Key");
    }


    /**
     * This tests the setValue method.
     */
    public void testSetValue() {
        KVPair<String, String> kvp = new KVPair<String, String>("Key", "1");
        kvp.setValue("2");
        assertEquals(kvp.getVal(), "2");
    }


    /**
     * This tests the setKey method.
     */
    public void testSetKey() {
        KVPair<String, String> kvp = new KVPair<String, String>("Key", "1");
        kvp.setKey("Key2");
        assertEquals(kvp.getKey(), "Key2");
    }
}
