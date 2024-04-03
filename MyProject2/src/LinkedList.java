/**
 * The LinkedList class is responsible for keeping
 * track of the seminar objects stored in the leaf
 * nodes contained in the bintree. It supports search,
 * remove, insert, and can get an element of the list
 * or get the size of the list.
 * 
 * @author Connor Marks (connorm20)
 * @version 10.13.2023s
 * @param <T>
 *            the paramter type of the LinkedList.
 */
public class LinkedList<T> {
    private Node head;
    private int listSize;

    /**
     * This is the constructor for the LinkList class.
     */
    public LinkedList() {
        this.head = null;
        this.listSize = 0;
    }


    /**
     * This method gets the element at the specified index in the linked list.
     * 
     * @param index
     *            the index of the element to retrieve.
     * @return the element at the specified index, or null if the index is out
     *         of
     *         bounds.
     */
    public Seminar get(int index) {
        if (index < 0 || index >= listSize) {
            return null; // Index out of bounds
        }

        Node curr = head;
        int currentIndex = 0;
        while (curr != null) {
            if (currentIndex == index) {
                return curr.getSeminar();
            }
            curr = curr.getNext();
            currentIndex++;
        }

        return null; // Index not found (should not happen if the index is
                     // within bounds)
    }


    /**
     * inserts seminar into linked list
     * 
     * @param sem
     *            for seminar to be inserted
     */
    public void insertSeminar(Seminar sem) {
        Node temp = new Node(sem);
        if (head == null) {
            head = temp;
        }
        else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.setNext(temp);

        }
        listSize++;
    }


    /**
     * This method simply removes an item from the linked list.
     * 
     * @param sem
     *            the seminar object to remove from the linked list.
     * @return true if it is successfully removed or false if not.
     */
    public boolean removeSeminar(Seminar sem) {
        if (head == null) {
            return false;
        }

        if (head.getSeminar().equals(sem)) {
            head = head.next;
            listSize--;
            return true;
        }

        Node curr = head;
        Node prev = null;
        while (curr != null) {
            if (curr.getSeminar().equals(sem)) {
                prev.setNext(curr.getNext());
                listSize--;
                return true;
            }
            prev = curr;
            curr = curr.getNext();
        }
        return false;
    }


    /**
     * This method simply searches the Linked List for a specific seminar
     * object.
     * 
     * @param sem
     *            the seminar object to find.
     * @return the seminar object if found or null if it is not found.
     */
    public Seminar searchSeminar(Seminar sem) {
        Node curr = head;
        while (curr != null) {
            if (curr.getSeminar().equals(sem)) {
                return curr.getSeminar();
            }
            curr = curr.getNext();
        }
        return null;
    }


    /**
     * This method gets the size of the linked list.
     * 
     * @return the size of the linked list.
     */
    public int getListSize() {
        return listSize;
    }

    /**
     * This represents the nodes of a linked list.
     */
    public class Node {
        private Seminar seminar;
        private Node next;

        /**
         * This is the constructor for the Node class.
         * 
         * @param sem
         *            the seminar to be inserted into the linked list.
         */
        public Node(Seminar sem) {
            this.seminar = sem;
            this.next = null;
        }


        /**
         * This method gets the next element in the linked list.
         * 
         * @return the next node in the linked list.
         */
        public Node getNext() {
            return next;
        }


        /**
         * This method gets the current element in the list.
         * 
         * @return the current element in the linked list.
         */
        public Seminar getSeminar() {
            return seminar;
        }


        /**
         * This method sets the next node in the list.
         * 
         * @param temp
         *            the node to set in the linked list.
         */
        public void setNext(Node temp) {
            this.next = temp;
        }


        /**
         * This method sets the current element in the linked list.
         * 
         * @param sem
         *            the seminar to set in the linked list.
         */
        public void setSeminar(Seminar sem) {
            this.seminar = sem;
        }
    }
}
