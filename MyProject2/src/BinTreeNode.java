/**
 * This class represents an interface that will be used by the flyWeight and
 * leafNode class. This class will have all the methods they will need to
 * function like an empty node, leaf node, or internal node.
 * 
 * @author Connor Marks (Connorm20)
 * @version 10.13.2023
 */
public interface BinTreeNode {
    /**
     * This method simply checks to see if the object is a leaf or not.
     * 
     * @return true if it is a leaf and false if it is not.
     */
    public abstract boolean isLeaf();


    /**
     * Gets the linked list of seminars associated with the leaf.
     * 
     * @return the list for the leaf
     */
    public LinkedList<Seminar> getList();


    /**
     * This method simply checks to see if the given class is empty or not.
     * 
     * @return true if the object is empty or false if not.
     */
    public abstract boolean isEmpty();


    /**
     * Gets the x position of the seminar.
     * 
     * @param sem
     *            for the x coordinate of seminar.
     * @return the x coordinate in the seminar.
     */
    public int getX(Seminar sem);


    /**
     * Gets the y position of the seminar.
     * 
     * @param sem
     *            for the seminar.
     * @return the y coordinate of seminar.
     */
    public int getY(Seminar sem);


    /**
     * Gets the right child of the Internal Node.
     * 
     * @return the right child.
     */
    public BinTreeNode getRight();


    /**
     * Gets the left child of the internal Node.
     * 
     * @return the left child.
     */
    public BinTreeNode getLeft();


    /**
     * determines if a node is internal or not.
     * 
     * @return true if internal, false if not.
     */
    public boolean isInternal();


    /**
     * 
     * @param sem
     *            for the seminar.
     * @param level
     *            for the current level.
     * @param xMin
     *            for the minimum x. (initially 0)
     * @param xMax
     *            for the maximum x. (initially worldSize)
     * @param yMin
     *            for the minimum y. (initially 0)
     * @param yMax
     *            for the maximum y. (initially worldSize);
     * @return the updated root node.
     */
    public BinTreeNode insert(

        Seminar sem,
        int level,
        int xMin,
        int xMax,
        int yMin,
        int yMax);


    /**
     * This is the remove method for removing an object from the BinTree.
     * 
     * @param sem
     *            the seminar Object to remove from the BinTree.
     * @return the object once removed.
     */
    public abstract BinTreeNode remove(Seminar sem);


    /**
     * This is a boolean search method for looking for an object in the BinTree.
     * 
     * @param x
     *            the x coordinate of the seminar object.
     * @param y
     *            the y coordinate of the seminar object.
     * @param radius
     *            the radius of the object
     * @return true if the object is found, or false if not.
     */
    public abstract boolean search(double x, double y, double radius);


    /**
     * Sets the left child of the internal node.
     * 
     * @param left
     *            for the left child.
     */
    public void setLeft(BinTreeNode left);


    /**
     * Sets the right child of the internal node.
     * 
     * @param right for setting the right node.
     */
    public void setRight(BinTreeNode right);

}
