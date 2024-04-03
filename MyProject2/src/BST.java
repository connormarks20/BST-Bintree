/**
 * This is the Binary Search Tree class.
 * 
 * @author Connor Marks (connorm20)
 * @version 10/1/2023
 * @param <K>
 *            the first parameter
 *            type for the BST.
 * @param <E>
 *            the second parameter
 *            type for the BST.
 */
public class BST<K extends Comparable<K>, E> {

    /**
     * root node
     */
    private BSTNode<K, E> root;

    /**
     * Constructor for Binary Search Tree
     */
    public BST() {
        this.root = null;
    }


    /**
     * helper method to insert a node into the BST
     * 
     * @param newNode
     *            for the node to be inserted
     */
    public void insert(BSTNode<K, E> newNode) {

        root = insertRecord(root, newNode);
    }


    /**
     * inserts a record into the appropriate location in the BST.
     * 
     * @param current
     *            for the current node
     * @param newNode
     *            for the node to be inserted
     * @return the current node
     */
    private BSTNode<K, E> insertRecord(
        BSTNode<K, E> current,
        BSTNode<K, E> newNode) {
        // first checks that the current node (root) is not null.
        if (current == null) {
            return newNode;
        }

        // uses the comparator interface methods to compare two key values from
        // the

        if (newNode.getKey().compareTo(current.getKey()) < 0) {

            current.setLeft(insertRecord(current.getLeft(), newNode));
        }
        else if (newNode.getKey().compareTo(current.getKey()) > 0) {

            current.setRight(insertRecord(current.getRight(), newNode));
        }
        else if (newNode.getKey().compareTo(current.getKey()) == 0) {
            current.setLeft(insertRecord(current.getLeft(), newNode));
        }

        return current;
    }


    /**
     * helper method to see if a BST contains a certain key value
     * 
     * @param keyToFind
     *            for the key we are searching for
     * @return true if it is in the BST, or false if it isn't
     */
    public boolean contains(K keyToFind) {
        return contains(root, keyToFind);
    }


    /**
     * checks if a key is contained in the BST
     * 
     * @param current
     *            for the current node
     * @param key
     *            for the key to be searched for
     * @return true or false depending on if the key is found or not
     */
    private boolean contains(BSTNode<K, E> current, K key) {
        if (current == null) {
            return false; 
        }

        if (key.compareTo(current.getKey()) < 0) {
            return contains(current.getLeft(), key); 
        }
        else if (key.compareTo(current.getKey()) > 0) {
            return contains(current.getRight(), key); 
        }
        else {
            return true; 
        }
    }


    /**
     * helper method to print the BST's
     */
    public void printTree() {

        printTree(root, "");

    }


    /**
     * traverses the BST and prints out the records in a modified in-order
     * traversal
     * 
     * @param node
     *            for the node to be printed
     * @param prefix
     *            for the spacing
     */
    private void printTree(BSTNode<K, E> node, String spacing) {
        if (node != null) {
            String newSpacing = spacing + "  ";

            printTree(node.getRight(), newSpacing);

            System.out.print(spacing);

            System.out.println(node.getKey());

            printTree(node.getLeft(), newSpacing);

        }
        else {
            System.out.println(spacing + "null");
        }

    }


    /**
     * Recursively counts the number of nodes in a BST
     * 
     * @param node
     *            for the node to be counted
     * @return the number of nodes in the tree
     */
    public int countNodes(BSTNode<K, E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
    }


    /**
     * This method deletes a
     * specified key from a
     * BST.
     * 
     * @param key
     *            the key to delete
     *            from the BST.
     * @return true if it is
     *         successfully deleted and false
     *         if it is not deleted.
     */
    public boolean delete(K key) {
        boolean flag = false;

        while (contains(key)) {
            root = delete(root, key);
            flag = true;
        }

        return flag;
    }


    /**
     * 
     * @param current
     *            for the current node
     * @param key
     *            for the key to be deleted
     * @return null if the root is empty or
     *         return the BSTNode if it is deleted.
     */
    private BSTNode<K, E> delete(BSTNode<K, E> current, K key) {
        if (current == null) {
            return null;
        }

        if (key.compareTo(current.getKey()) < 0) {
            current.setLeft(delete(current.getLeft(), key));
        }
        else if (key.compareTo(current.getKey()) > 0) {
            current.setRight(delete(current.getRight(), key));
        }
        else { // found it

            if (current.getLeft() == null) {
                return current.getRight();
            }
            else if (current.getRight() == null) {
                return current.getLeft();
            }
            else { // two children

                BSTNode<K, E> max = findMax(current.getLeft());

                // set max key and max value
                current.setKey(max.getKey());
                current.setValue(max.getValue());

                // delete max node from left subtree
                current.setLeft(deleteMax(current.getLeft()));
            }
        }

        return current;
    }


    private BSTNode<K, E> findMax(BSTNode<K, E> rt) {
        while (rt.getRight() != null) {
            rt = rt.getRight();
        }
        return rt;
    }


    private BSTNode<K, E> deleteMax(BSTNode<K, E> rt) {
        if (rt.getRight() == null) {
            return rt.getLeft();
        }
        rt.setRight(deleteMax(rt.getRight()));
        return rt;
    }


    /**
     * returns the root
     * 
     * @return the root
     */
    public BSTNode<K, E> getRoot() {
        return root;
    }
}
