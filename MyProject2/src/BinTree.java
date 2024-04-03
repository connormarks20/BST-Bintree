/**
 * 
 * @author Connor Marks (connorm20)
 * @version 10.12.2023
 *          Class responsible for representing the BinTree.
 *          It supports insertion, printing, and deleting.
 */
public class BinTree {
    private BinTreeNode root;

    private int worldSize;

    /**
     * Constructor for the bintree.
     * Initialize the root to be empty.
     * Initialize the worldsize.
     * 
     * @param size
     *            for the worldsize.
     */
    public BinTree(int size) {
        this.worldSize = size;
        this.root = FlyWeight.getInstance();

    }


    /**
     * gets the root of the bintree
     * 
     * @return the root of the bintree
     */
    public BinTreeNode getRoot() {
        return this.root;
    }


    /**
     * Helper method to pass the root and ID.
     * 
     * @param iD
     *            for the ID to be deleted.
     */
    public void binTreeDelete(int iD) {
        root = binTreeDelete(root, iD);
    }


    /**
     * Method to delete the seminar object
     * from the BinTree. Currently
     * sets the leaf node to null if
     * the ID in the list matches, will
     * eventually support deletion of any element.
     * 
     * @param node
     *            for current node
     * @param iD
     *            for id to be deleted
     * @return the
     */
    private BinTreeNode binTreeDelete(BinTreeNode node, int iD) {
        // initially checks for an empty node.
        if (node.isEmpty()) {
            return FlyWeight.getInstance();
        }
        // for leaf nodes, get the linked list and identify
        // a seminar with the id to be deleted.
        else if (node.isLeaf()) {
            BinTreeLeaf leafNode = (BinTreeLeaf)node;
            LinkedList<Seminar> list = leafNode.getList();

            for (int i = 0; i < list.getListSize(); i++) {
                Seminar seminar = list.get(i);
                // if we found that seminar, remove it from the list.
                if (seminar.id() == iD) {
                    list.removeSeminar(seminar);
                    if (list.getListSize() == 0) {
                        return FlyWeight.getInstance();
                    }
                    return node;
                }
            }
        }
        // otherwise, the node is internal and it needs to be updated.
        else {

            BinTreeInternal internalNode = (BinTreeInternal)node;
            if (internalNode.getLeft().isEmpty() && internalNode.getRight()
                .isEmpty()) {
                return FlyWeight.getInstance();
            }
            BinTreeNode newLeft = binTreeDelete(internalNode.getLeft(), iD);
            BinTreeNode newRight = binTreeDelete(internalNode.getRight(), iD);

            internalNode.setLeft(newLeft);
            internalNode.setRight(newRight);

            if (newLeft.isEmpty() && newRight.isEmpty()) {
                return FlyWeight.getInstance();
            }
        }

        return node;
    }


    /**
     * Helper method to insert a record into the bintree.
     * 
     * @param sem
     *            for seminar to be inserted
     * @param level
     *            for the level of tree we're at
     */
    public void insertRecord(Seminar sem, int level) {

        root = root.insert(sem, level, 0, worldSize - 1, 0, worldSize - 1);

    }


    /**
     * public helper method for location print
     * initializes node to be root, and level to 0
     */
    public void printLocation() {
        System.out.println("Location Tree:");
        printTree(root, 0);
    }


    /**
     * Prints the tree in the correct format per
     * formatting guidelines.
     * 
     * @param node
     *            for current node
     * @param level
     *            for current level
     */
    private void printTree(BinTreeNode node, int level) {
        if (node.isEmpty()) {
            indent(level);
            System.out.println("E");
            return;
        }
        indent(level);

        if (node.isInternal()) {
            System.out.println("I");

            BinTreeInternal internalNode = (BinTreeInternal)node;
            printTree(internalNode.getLeft(), level + 1);
            printTree(internalNode.getRight(), level + 1);
        }
        else if (node.isLeaf()) {
            BinTreeLeaf leafNode = (BinTreeLeaf)node;

            if (leafNode.getList().getListSize() == 1) {
                System.out.println("Leaf with 1 objects: " + leafNode.getList()
                    .get(0).id());
            }
            else {
                StringBuilder objects = new StringBuilder("Leaf with "
                    + leafNode.getList().getListSize() + " objects: ");
                for (int i = 0; i < leafNode.getList().getListSize(); i++) {
                    objects.append(leafNode.getList().get(i).id());
                    if (i < leafNode.getList().getListSize() - 1) {
                        objects.append(" ");
                    }
                }
                System.out.println(objects.toString());
            }

        }
    }


    private void indent(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
    }

}
