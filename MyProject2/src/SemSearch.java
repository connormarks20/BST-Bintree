/**
 * 
 * @author Connor Marks (connorm20)
 * @version 10.13.2023
 * 
 *
 * The following program is an implementation of record tracking
 * and database management software. This program implements two
 * main data structures for efficient record tracking: Binary
 * Search Trees and a spatial data structure known as a BinTree.
 * It provides support for inserting records, searching for records,
 * deleting records, and printing records. It provides support
 * for inserting records into a Binary Search Tree (BST) based
 * on a key value which is either an integer ID value, integer Cost value,
 * a Date represented by a String, or an array of Keyword strings.
 * Each one of these representations is known as a "key" for the search
 * and will have an associated seminar object that is stored in a
 * Key,Value pair. These Key,Value pairs will be stored in a Node
 * of the BST to maintain structure and allow easy access of elements
 * for search procedures. There are 4 of these Binary Search Tree structures
 * to differentiate between the Seminar being searched for based on the key
 * value. There is a BST for each of the 4 pair types. This allows us to
 * efficiently employ a search for different keys we may want to find.
 * Support for deletion is also implemented so that a record may be
 * deleted from the database and tree. In doing this, the tree structure
 * can be printed out by using a print command which displays the structure
 * of each tree and updates based on any modifications made. Additionally,
 * the BST's containing keys for dates and costs implement a range search
 * procedure and take in a lower and upperbound which will allow for
 * multiple records within a given range to be searched for and displayed.
 * 
 * 
 * As mentioned above, there is a second main data structure utilized to
 * support a similar type of tracking mechanism, however, it employs
 * a new kind of support for searching locations of seminars. This
 * structure is called a BinTree and will organize its structure through
 * a splitting process by comparing x and y coordinates of an inserted
 * seminar to a location in a rectangle whose dimensions are given by
 * the world size. By doing this, locations can be searched for in
 * the tree by first inputting an x location, y location, and a search
 * radius to search for. All seminars within a given range can be
 * searched for this way. Seminars may also be deleted based on location
 * 
 *
 * 
 * 
 */
// On my honor:
// - I have not used source code obtained from another current or
// former student, or any other unauthorized source, either
// modified or unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
// anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.
public class SemSearch {
    /**
     * @param args
     *            Command line parameters
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // This is the main file for the program.
        Seminar dum = new Seminar();
        if (args == null) {
            return;
        }
        // Parses the command file for the worldSize
        int worldSize = Integer.parseInt(args[0]);
        // Ensures the number of arguments passed is correct.
        if (args.length != 2) {
            System.out.print("Number of arguments incorrect"
                + " There should be one argument for the size"
                + " of the world and one for the file to parse.");
        }
        // Ensures that the worldSize passed is a power of 2.
        else if (powerOfTwo(worldSize) == false) {
            System.out.print("The world size needs to be a power of two");
        }

        // If the worldsize is a power of 2, it will begin processing
        // the file.
        else {
            String filename = args[1];
            // Creates a CommandProcessor object that takes in a file
            // and integer size parameter for parsing.
            CommandProcessor process = new CommandProcessor(filename,
                worldSize);

            // Makes a call to the process command method in
            // our CommandProcessor class.
            process.processCommand(filename, worldSize);

        }
    }


    /**
     * This is a simple method to check and see if something is a power of two
     * or
     * not.
     * 
     * @param a
     *            the integer to check if it is a power of two or not.
     * @return true if it is a power of two or false if not.
     */
    public static boolean powerOfTwo(int a) {
        while (a % 2 == 0) {
            a = a / 2;
        }
        if (a == 1) {
            return true;
        }
        else {
            return false;
        }
    }
}
