
/**
 * This is the flyWeight class.
 * 
 * @author Connor Marks (connorm20)
 * @version 10.01.2023
 */
public class FlyWeight implements BinTreeNode {
    private static final FlyWeight FLY = new FlyWeight();

    /**
     * This is an empty constructor for the FlyWeight class.
     */
    public FlyWeight() {
        // Nothing needs to go here.
    }

    /**
     * Returns the same instance of flyweight every time
     * this is called.
     * @return the flyweight object.
     */
    public static FlyWeight getInstance() {
        return FLY;
    }


    /**
     * This method checks to see if the FlyWeight is empty or not.
     */
    @Override
    public boolean isEmpty() {
        return true;
    }


    /**
     * This method simply checks to see if the FlyWeight is a leaf or not.
     * 
     * @return false if it is not a leaf or true if it is.
     */
    @Override
    public boolean isLeaf() {
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
        LinkedList<Seminar> list = new LinkedList<>();
        list.insertSeminar(sem);
        BinTreeLeaf leaf = new BinTreeLeaf(list);
        return leaf;
    }


    @Override
    public BinTreeNode remove(Seminar sem) {
        // Cant remove an empty leaf, so nothing to do here...
        return null;
    }


    @Override
    public boolean search(double x, double y, double radius) {
        // Also can't search for an empty leaf...
        return false;
    }



    @Override
    public boolean isInternal() {
        return false;
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
    public BinTreeNode getRight() {
        return null;
    }


    @Override
    public BinTreeNode getLeft() {
        return null;
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
    public LinkedList<Seminar> getList() {
        return null;
    }
}
