
/**
 * This class represents the KVPair
 * class that is used in unison to
 * create a tree node for a Binary
 * Search Tree. A KVPair class simply
 * has a Key and a Value to store
 * of any type specified by the user.
 * 
 * @author Connor Marks (connorm20)
 * @version 9.29.2023
 * @param <K>
 *            the first parameter to store.
 * @param <E>
 *            the second parameter to store.
 */
public class KVPair<K extends Comparable<? super K>, E> {
    private K theKey; // The key
    private E theVal; // The value

    /**
     * This method compares a key
     * to another key.
     * 
     * @param it
     *            the KVPair that
     *            is called to compare it's key
     *            to the other key.
     * @return a negative number if the
     *         2nd key is larger than the first one,
     *         it returns a positive number if
     *         the first key is bigger than
     *         the second one. Or zero if
     *         they are equal.
     */
    public int compareTo(KVPair<K, E> it) {
        return theKey.compareTo(it.getKey());
    }


    /**
     * constructs the KV pairs that are associated with the seminar objects
     * 
     * @param key
     *            is the first parameter
     *            type of the KVPair.
     * @param value
     *            is the second parameter
     *            type of the KVPair.
     */
    public KVPair(K key, E value) {
        theKey = key;
        theVal = value;
    }


    /**
     * compare the key to another key
     * 
     * @param it
     *            the key to compare
     *            to the other key.
     * @return 0 if they are the exact same,
     *         1 if the key that is comparing to
     *         the other key(theKey) is larger than (it), or -1 if
     *         the key being compared to the
     *         other key (theKey) is smaller than (it).
     */
    public int compareTo(K it) {
        return theKey.compareTo(it);
    }


    /**
     * returns a key K associated with a KVPair object
     * 
     * @return the key of a KVPair.
     */
    public K getKey() {
        return theKey;
    }


    /**
     * returns a value E associated with a KVPair object
     * 
     * @return the Value of a KVPair.
     */
    public E getVal() {
        return theVal;
    }


    /**
     * Sets the value of a KVPair object to be equal to a specified value
     * 
     * @param value
     *            the value to set the value
     *            of the KVPair at.
     */
    public void setValue(E value) {
        theVal = value;
    }


    /**
     * Sets the key of a KVPair object to be equal to a specified key
     * 
     * @param key
     *            the key to set the key
     *            of the KVPair at.
     */
    public void setKey(K key) {
        theKey = key;
    }

}
