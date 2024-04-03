/**
 * This class is responsible for representing
 * the internal nodes of the BinTree. It has
 * methods to get and set children, and to insert
 * a record into the tree through a splitting process
 * based a discriminator.
 * 
 * @author Connor Marks (connorm20)
 * @version 10.4.2023
 * 
 * 
 */
public class BinTreeInternal implements BinTreeNode {
    /**
     * field variables
     */
    private BinTreeNode left;
    private BinTreeNode right;

    /**
     * constructor for internal nodes
     * 
     * @param left
     *            initialize left child
     * @param right
     *            initialize right child
     */
    public BinTreeInternal(BinTreeNode left, BinTreeNode right) {
        this.left = left;
        this.right = right;
    }


    @Override
    public boolean isLeaf() {
        return false;
    }


    @Override
    public boolean isEmpty() {
        return false;
    }


    /**
     * Tests the isInternal() method for true/false.
     * 
     * @return boolean
     */
    public boolean isInternal() {
        return true;
    }


    @Override
    public BinTreeNode remove(Seminar sem) {
        return null;
    }


    @Override
    public boolean search(double x, double y, double radius) {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public BinTreeNode insert(
        Seminar sem,
        int level,
        int xMin,
        int xMax,
        int yMin,
        int yMax) {
        if (level % 2 == 0) {
            if (sem.x() < (xMin + xMax) / 2) {
                this.setLeft(this.getLeft().insert(sem, level + 1, xMin, xMax
                    / 2, yMin, yMax));
            }
            else {
                this.setRight(this.getRight().insert(sem, level + 1, xMin
                    + (xMax / 2), xMax/2, yMin, yMax));
            }
        }
        else {
            if (sem.y() < (yMin + yMax) / 2) {
                this.setLeft(this.getLeft().insert(sem, level + 1, xMin, xMax,
                    yMin, yMax / 2));
            }
            else {
                this.setRight(this.getRight().insert(sem, level + 1, xMin, xMax,
                    yMin + (yMax / 2), yMax));
            }
        }

        return this;
    }


    /**
     * gets the left child of the tree.
     * 
     * @return the left child.
     */
    public BinTreeNode getLeft() {
        return left;
    }


    /**
     * gets the right child of the tree.
     * 
     * @return the right child.
     */
    public BinTreeNode getRight() {
        return right;
    }


   /**
    * Sets the right child of the internal node.
    * @param right for the right node to be set. 
    */
    public void setRight(BinTreeNode right) {
        this.right = right;
    }


   /**
    * Sets the internal nodes left child. 
    * @param left for setting the left child.
    */
    public void setLeft(BinTreeNode left) {
        this.left = left;
    }

   

    @Override
    public int getX(Seminar sem) {

        return 0;
    }


    @Override
    public int getY(Seminar sem) {

        return 0;
    }


    @Override
    public LinkedList<Seminar> getList() {
        // TODO Auto-generated method stub
        return null;
    }

}
