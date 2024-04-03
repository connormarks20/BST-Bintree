/**
 * @author Connor Marks (connorm20)
 * @version 10.13.2023
 * 
 *          This class represents the leaf node of a
 *          BinTree.
 */
public class BinTreeLeaf implements BinTreeNode {
    /**
     * field variable for list
     */
    private LinkedList<Seminar> list;

    /**
     * Constructs leaf with linked list
     * 
     * @param list
     *            for the linked list of leaf
     */
    public BinTreeLeaf(LinkedList<Seminar> list) {
        this.list = list;
    }


    /**
     * This method checks to see if the FlyWeight is empty or not.
     */
    @Override
    public boolean isEmpty() {
        return false;
    }


    /**
     * This method simply checks to see if the FlyWeight is a leaf or not.
     * 
     * @return false if it is not a leaf or true if it is.
     */
    @Override
    public boolean isLeaf() {
        return true;
    }


    /**
     * This is the remove method for the BinTree
     * leaf class. This simply looks and removes
     * a seminar object from the leaf if it is
     * found or it returns a fly weight if not.
     */
    @Override
    public BinTreeNode remove(Seminar sem) {
        if (list.getListSize() == 0 || !list.removeSeminar(sem)) {
            FlyWeight fly = new FlyWeight();
            return fly;
        }
        else {
            return this;
        }
    }


    /**
     * method for searching for a value
     * 
     * @param x
     *            for the x value.
     * @param y
     *            for the y value.
     * @param radius
     *            for the search radius.
     * @return true or false if it's found.
     */
    public boolean search(double x, double y, double radius) {
        return false;
    }


    /**
     * gets x for seminar
     * 
     * @param sem
     *            for the seminar
     * @return x value or 0.
     */
    public int getX(Seminar sem) {

        if (list.getListSize() > 0) {
            Seminar seminar = list.searchSeminar(sem);
            return seminar.x();
        }
        return 0;
    }


    /**
     * @return list
     */
    public LinkedList<Seminar> getList() {
        return list;
    }


    /**
     * method for getting y
     * 
     * @param sem
     *            for seminar to be gotten
     * @return int
     */
    public int getY(Seminar sem) {

        if (list.getListSize() > 0) {
            Seminar seminar = list.searchSeminar(sem);
            return seminar.y();
        }
        else {

            return 0;
        }
    }


    /**
     * 
     */
    @Override
    public BinTreeNode insert(
        Seminar sem,
        int level,
        int xMin,
        int xMax,
        int yMin,
        int yMax) {

        boolean match = false;

        for (int i = 0; i < this.getList().getListSize(); i++) {
            if (this.getList().get(i).x() == sem.x() && this.getList().get(i)
                .y() == sem.y()) {

                this.getList().insertSeminar(sem);
                match = true;
                break;
            }
        }

        if (!match) {
            BinTreeLeaf newLeaf = new BinTreeLeaf(new LinkedList<>());
            newLeaf.getList().insertSeminar(sem);

            // Create a new internal node and insert the new leaf
            // along with the existing items.

            BinTreeInternal internalNode = new BinTreeInternal(FlyWeight
                .getInstance(), FlyWeight.getInstance());
            internalNode.insert(newLeaf.getList().get(0), level, xMin, xMax,
                yMin, yMax);

            for (int i = 0; i < this.getList().getListSize(); i++) {
                internalNode.insert(this.getList().get(i), level, xMin, xMax,
                    yMin, yMax);
            }

            return internalNode;
        }

        return this;
    }


    @Override
    public void setLeft(BinTreeNode left) {
        return;

    }


    @Override
    public void setRight(BinTreeNode right) {
        return;

    }


    @Override
    public boolean isInternal() {
        return false;
    }


    @Override
    public BinTreeNode getRight() {
        return null;
    }


    @Override
    public BinTreeNode getLeft() {
        return null;
    }

}
