
/**
 * The worlddatabase class is responsible for communication
 * with the rest of the classes.
 * it is the medium through which insert,search,
 * delete, and print
 * operations take place. It is critical for
 * encapsulation.
 * 
 * @author Connor Marks (connorm20)
 * @version 9.29.2023
 */
public class WorldDataBase {

    /**
     * These fields represent the 4 types of binary trees we will be storing
     * information into.
     */
    private BST<Integer, Seminar> idTree;
    private BST<Integer, Seminar> costTree;
    private BST<String, Seminar> dateTree;
    private BST<String, Seminar> keyWordsTree;
    private BinTree binTree;
    // initialize count variable for visitednodes
    private int count;

    /**
     * constructor for world database
     * 
     * @param worldSize
     *            takes in a power of 2
     *            worldsize
     */
    public WorldDataBase(int worldSize) {

        /**
         * initializes each tree.
         */
        idTree = new BST<>();
        costTree = new BST<>();
        dateTree = new BST<>();
        keyWordsTree = new BST<>();
        binTree = new BinTree(worldSize);
        count = 0;

    }


    /**
     * Method to insert keywords into the keywords tree
     * 
     * @param keyWordsKvp
     *            is the KVPair to insert.
     */
    public void insertKeyWords(KVPair<String, Seminar> keyWordsKvp) {
        BSTNode<String, Seminar> keyWordsNode = new BSTNode<String, Seminar>(
            keyWordsKvp);

        keyWordsTree.insert(keyWordsNode);
    }


    /**
     * This is the delete method that prints out whether an ID was successfully
     * deleted or not.
     * 
     * @param iD
     *            the ID to find and delete.
     */
    public void delete(int iD) {
        if (!idTree.contains(iD)) {
            System.out.println("Delete FAILED -- There is no record with ID "
                + iD);
            return;
        }

        Seminar sem = getIDSem(iD);
        idTree.delete(iD);
        binTree.binTreeDelete(iD);
        costTree.delete(sem.cost());
        dateTree.delete(sem.date());
        // binTree.BinTreeDelete(iD);
        for (int i = 0; i < sem.keywords().length; i++) {
            String keyword = sem.keywords()[i];
            keyWordsTree.delete(keyword);
        }

        System.out.println("Record with ID " + iD
            + " successfully deleted from the database");

    }


    /**
     * Passes KVPair objects for id,cost, and date trees. These kvpairs are used
     * to
     * create nodes for the binary search trees, then the nodes are inserted
     * into
     * the correct binary search tree based on key value.
     * 
     * @param idKvp
     *            is the ID KVPair to insert.
     * @param costKvp
     *            is the cost KVPair to insert.
     * @param dateKvp
     *            is the date KVPair to insert.
     */
    public void insert(
        KVPair<Integer, Seminar> idKvp,
        KVPair<Integer, Seminar> costKvp,
        KVPair<String, Seminar> dateKvp) {

        BSTNode<Integer, Seminar> idNode = new BSTNode<Integer, Seminar>(idKvp);
        BSTNode<Integer, Seminar> costNode = new BSTNode<Integer, Seminar>(
            costKvp);
        BSTNode<String, Seminar> dateNode = new BSTNode<String, Seminar>(
            dateKvp);

        if (!idTree.contains(idNode.getKey())) {
            idTree.insert(idNode);
            costTree.insert(costNode);
            dateTree.insert(dateNode);
            binTree.insertRecord(idNode.getValue(), 0);
            System.out.println("Successfully inserted record with ID " + idKvp
                .getKey() + "\n" + idKvp.getVal().toString());
        }

        else if (idTree.contains(idNode.getKey())) {
            System.out.println(
                "Insert FAILED - There is already a record with ID " + idNode
                    .getKey());
            return;
        }
    }


    /**
     * public method to print the ID tree
     */
    public void printIDTree() {
        System.out.println("ID Tree:");
        if (idTree.getRoot() == null) {
            System.out.println("This tree is empty");
            return;
        }
        idTree.printTree();
        System.out.println("Number of records: " + idTree.countNodes(idTree
            .getRoot()));
    }


    /**
     * method to print the cost tree
     */
    public void printCostTree() {
        System.out.println("Cost Tree:");
        if (costTree.getRoot() == null) {
            System.out.println("This tree is empty");
            return;
        }
        costTree.printTree();
        System.out.println("Number of records: " + costTree.countNodes(costTree
            .getRoot()));
    }


    /**
     * method to print the date tree
     */
    public void printDateTree() {
        System.out.println("Date Tree:");
        if (dateTree.getRoot() == null) {
            System.out.println("This tree is empty");
            return;
        }
        dateTree.printTree();
        System.out.println("Number of records: " + dateTree.countNodes(dateTree
            .getRoot()));
    }


    /**
     * method to print the keywords tree
     */
    public void printKeyWordsTree() {
        System.out.println("Keyword Tree:");
        if (keyWordsTree.getRoot() == null) {
            System.out.println("This tree is empty");
            return;
        }
        keyWordsTree.printTree();
        System.out.println("Number of records: " + keyWordsTree.countNodes(
            keyWordsTree.getRoot()));

    }


    /**
     * This prints the location tree.
     */
    public void printLocationTree() {
        binTree.printLocation();
    }


    /**
     * helper method to search for given keywordss in the keywords tree
     * 
     * @param word
     *            for the keyword we are searching for
     */
    public void searchKeyWord(String word) {
        System.out.println("Seminars matching keyword " + word + ":");
        searchKeyWord(keyWordsTree.getRoot(), word);
    }


    /**
     * Method to search for keyword
     * 
     * @param current
     *            for the current node
     * @param word
     *            for the word we are searching for
     */
    private void searchKeyWord(BSTNode<String, Seminar> current, String word) {
        if (current == null) {
            return;
        }

        searchKeyWord(current.getLeft(), word);

        if (current.getKey().contains(word)) {
            System.out.println(current.getValue());
        }

        searchKeyWord(current.getRight(), word);
    }


    /**
     * searches by cost range helper method
     * 
     * @param low
     *            for lower bound
     * @param high
     *            for upper bound
     */
    public void searchByCostRange(int low, int high) {
        System.out.println("Seminars with costs in range " + low + " to " + high
            + ":");
        count = 0;
        searchByCostRange(costTree.getRoot(), low, high);
        System.out.println(count + " nodes visited in this search");
    }


    /**
     * searches cost range of bst
     * 
     * @param current
     *            for current node
     * @param low
     *            for lower bound
     * @param high
     *            for upper bound
     */
    private int searchByCostRange(
        BSTNode<Integer, Seminar> current,
        int low,
        int high) {
        if (current == null) {
            count++; // Increment the count for null nodes
            return 0;
        }

        int leftCount = searchByCostRange(current.getLeft(), low, high);
        int rightCount = searchByCostRange(current.getRight(), low, high);

        if (current.getKey() >= low && current.getKey() <= high) {
            System.out.println(current.getValue());
            count++;
        }

        return leftCount + rightCount + 1;
    }


    /**
     * method to search the date range
     * 
     * @param startDate
     *            is the lower value of the search range.
     * @param endDate
     *            is the higher value of the search range.
     */
    public void searchByDateRange(String startDate, String endDate) {
        System.out.println("Seminars with dates in range " + startDate + " to "
            + endDate + ":");
        count = 0;
        searchByDateRange(dateTree.getRoot(), startDate, endDate);
        System.out.println(count + " nodes visited in this search");
    }


    /**
     * search by date range
     * 
     * @param current
     *            for current node
     * @param startDate
     *            for lower bound date
     * @param endDate
     *            for upper bound date
     */
    private int searchByDateRange(
        BSTNode<String, Seminar> current,
        String startDate,
        String endDate) {
        if (current == null) {
            count++;
            return 0;
        }
        
        int leftCount = searchByDateRange(current.getLeft(), startDate,
            endDate);
        int rightCount = searchByDateRange(current.getRight(), startDate,
            endDate);

        if (current.getKey().compareTo(endDate) <= 0 && current.getKey()
            .compareTo(startDate) >= 0) {
            System.out.println(current.getValue());
            count++;
        }

        return leftCount + rightCount + 1;
    }


    /**
     * Helper method to search by location
     * handles prints
     * 
     * @param x
     *            for x search
     * @param y
     *            for y search
     * @param radius
     *            for radius of search
     */
    public void searchByLocation(int x, int y, int radius) {
        System.out.println("Seminars within " + radius + " units of " + x + ", "
            + y + ":");
        int nodesVisited = searchByLocation(binTree.getRoot(), x, y, radius, 0);

        System.out.println(nodesVisited + " nodes visited in this search");
    }


    /**
     * 
     * @param node
     *            for initial node
     * @param x
     *            for x coordinate
     * @param y
     *            for y coordinate
     * @param radius
     *            for radius of search distance
     * @param nodesVisited
     *            for num nodes visited
     * @return the num nodes visited
     */
    private int searchByLocation(
        BinTreeNode node,
        int x,
        int y,
        int radius,
        int nodesVisited) {

        if (node == null) {
            nodesVisited++;
            return nodesVisited;
        }

        if (node.isLeaf()) {
            for (int i = 0; i < node.getList().getListSize(); i++) {
                Seminar seminar = node.getList().get(i);
                int boxX = seminar.x();
                int boxY = seminar.y();
                int distanceSquared = (boxX - x) * (boxX - x) + (boxY - y)
                    * (boxY - y);
                if (distanceSquared <= radius * radius) {
                    System.out.println("Found a record with key " + "value "
                        + seminar.id() + " at " + boxX + ", " + boxY);
                    nodesVisited++;
                }
            }
        }
        else if (node.isInternal()) {
            nodesVisited++;
            nodesVisited = searchByLocation(node.getLeft(), x, y, radius,
                nodesVisited);
            nodesVisited = searchByLocation(node.getRight(), x, y, radius,
                nodesVisited);
        }

        return nodesVisited;
    }


    /**
     * 
     * @param idToSearch
     *            for the id we are searching for
     * @return the seminar associated with it
     */
    public Seminar searchID(int idToSearch) {
        return searchID(idTree.getRoot(), idToSearch);
    }


    /**
     * 
     * @param current
     *            for the current node
     * @param idToSearch
     *            for the id we are searching for
     * @return the seminar record associated with that id
     */
    private Seminar searchID(BSTNode<Integer, Seminar> current, int iD) {

        if (current == null) {
            System.out.println("Search FAILED -- There is no record with ID "
                + iD);
            return null;
        }

        if (current.getKey() > iD) {

            return searchID(current.getLeft(), iD);

        }
        else if (current.getKey() < iD) {

            return searchID(current.getRight(), iD);
        }
        else {
            System.out.println("Found record with ID " + current.getKey()
                + ":\n" + current.getValue());

            return current.getValue();
        }

    }


    /**
     * This method simply gets the ID of the object that is being looked for.
     * 
     * @param idToSearch
     *            the ID to find
     * @return null if the tree is empty, or the ID if it is found.
     */
    public Seminar getIDSem(int idToSearch) {
        return getIDSem(idTree.getRoot(), idToSearch);
    }


    /**
     * 
     * @param current
     *            for the current node
     * @param idToSearch
     *            for the id we are searching for
     * @return the seminar record associated with that id
     */
    private Seminar getIDSem(BSTNode<Integer, Seminar> current, int iD) {

        if (current == null) {

            return null;
        }

        if (current.getKey() > iD) {

            return getIDSem(current.getLeft(), iD);

        }
        else if (current.getKey() < iD) {

            return getIDSem(current.getRight(), iD);
        }
        else {

            return current.getValue();
        }

    }

}
