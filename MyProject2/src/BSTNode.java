/**
 * This class represents the nodes
 * of a Binary Search Tree. It makes
 * use of the KVPair class to create
 * nodes of KVPair type, and methods that
 * find the information of the node and
 * also being able to set the nodes to a
 * specific key or value.
 * 
 * @author Connor Marks (connorm20)
 * @version 9.29.2023
 * @param <K>
 *            the first parameter of
 *            the node.
 * @param <E>
 *            the second parameter of
 *            the node.
 */
public class BSTNode<K extends Comparable<? super K>, E> {
    private KVPair<K, E> kvPair;
    private BSTNode<K, E> left;
    private BSTNode<K, E> right;

    /**
     * This is the constructor for the
     * BSTNode class.
     * 
     * @param kvPair
     *            is used to create
     *            a node with a key and a value.
     */
    public BSTNode(KVPair<K, E> kvPair) {
        this.kvPair = kvPair;
        this.left = null;
        this.right = null;
    }

    // Getter and Setter methods for kvPair, left, and right
    // ...


    /**
     * Method to get the key from a node
     * 
     * @return the key to get.
     */
    public K getKey() {
        return kvPair.getKey();
    }


    /**
     * Method to get the value, E, which is the seminar object
     * 
     * @return the value to get.
     */
    public E getValue() {
        return kvPair.getVal();
    }


    /**
     * Method to get the KVPair associated with the node
     * 
     * @return the KVPair.
     */
    public KVPair<K, E> getKVPair() {
        return kvPair;
    }


    /**
     * method to get the left node
     * 
     * @return the left node.
     */
    public BSTNode<K, E> getLeft() {
        return left;
    }


    /**
     * method to get the right node
     * 
     * @return the right node of the tree
     */
    public BSTNode<K, E> getRight() {
        return right;
    }


    /**
     * method to set the left node of the tree to a value
     * 
     * @param left
     *            the value to set
     *            the left node at.
     */
    public void setLeft(BSTNode<K, E> left) {
        this.left = left;
    }


    /**
     * method to set the right node of the tree to a value
     * 
     * @param right
     *            the value to set
     *            the right node at.
     */
    public void setRight(BSTNode<K, E> right) {
        this.right = right;
    }


    /**
     * This sets the key value
     * of the Node.
     * 
     * @param key
     *            the key to
     *            set the nodes key value to.
     */
    public void setKey(K key) {
        kvPair.setKey(key);
    }


    /**
     * This sets the value
     * of the Node.
     * 
     * @param value
     *            the value to
     *            set the nodes value too.
     */
    public void setValue(E value) {
        kvPair.setValue(value);
    }
}
