import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

/**
 * The class responsible for parsing the input file using a Scanner. It will
 * communicate with the WorldDataBase class in order to let the HashTable know
 * which command is called. It uses a simple switch statement to seperate the
 * different cases of possible command calls.
 * 
 * @author Connor Marks (connorm20)
 * @version 9/19/2023
 */

public class CommandProcessor {

    // write all the field variables
    /**
     * These are all the field variables for Seminar Object.
     */
    private String title;
    private WorldDataBase worldDataBase;
    private String dateAndTime;
    private String dateAndTime2;
    private String nameOfFile;
    private int length;
    private String[] keyWords;
    private short x;
    private short y;
    private String description;
    private int cost;
    private int iD;
    private int low;
    private int high;
    private String keyword;
    private short radius;

    /**
     * This is the constructor for the CommandProcessor class. It takes in a
     * file
     * name from the command line passed by SemManager and also a HashTable
     * size.
     * 
     * @param filename
     *            the name of the file to create the command processor with.
     * @param worldSize
     *            for the passed in worldsize.
     */
    public CommandProcessor(String filename, int worldSize) {
        this.nameOfFile = filename;
        this.worldDataBase = new WorldDataBase(worldSize);
    }


    /**
     * This method processes the commands from the file using a scanner and a
     * switch
     * statement. It takes in a file name which represents the input file to
     * parse,
     * and it also takes in the arguments from the command line.
     * 
     * @param fileName
     *            the name of the file to parse.
     * @param size
     *            is the size of the world.
     * @throws Exception
     *             if the file is empty or cannot be found. Or if the
     *             arguments are incorrect.
     */
    public void processCommand(String fileName, int size) throws Exception {
        this.nameOfFile = fileName;
        // Creates a new Scanner Object to
        // Scan the input file.
        Scanner scan = new Scanner(new File(nameOfFile));
        // While the input file still has lines to read
        // Continue scanning the file.
        while (scan.hasNext()) {
            // This gets the type of command
            // Insert, delete, search, and print.
            String commandType = scan.next();
            switch (commandType) {
                case "insert":
                    /**
                     * Reads in all relevant seminar fields. And their
                     * associated data types.
                     */
                    iD = Integer.parseInt(scan.next().trim());
                    scan.nextLine();
                    title = scan.nextLine().trim();
                    dateAndTime = scan.next().trim();
                    length = Integer.parseInt(scan.next().trim());
                    x = Short.parseShort(scan.next().trim());
                    y = Short.parseShort(scan.next().trim());

                    if (x < 0 || y < 0 || x >= size - 1 || y >= size - 1) {
                        System.out.print(
                            "Insert FAILED - Bad x, y coordinates: " + x + ", "
                                + y + "\n");
                        break;
                    }
                    cost = Integer.parseInt(scan.next().trim());
                    scan.nextLine();

                    // splits the keywords into an array of substrings
                    String keywordsLine = scan.nextLine().trim();
                    // use the regular expression \s to ignore all whitespace
                    // between strings
                    keyWords = keywordsLine.trim().split("\\s+");

                    description = scan.nextLine().trim();
                    // Creates and constructs a new Seminar Object
                    // with the fields that are read in above.

                    Seminar seminar = new Seminar(iD, title, dateAndTime,
                        length, x, y, cost, keyWords, description);

                    KVPair<Integer, Seminar> idKvp = new KVPair<>(iD, seminar);
                    KVPair<Integer, Seminar> costKvp = new KVPair<>(cost,
                        seminar);
                    KVPair<String, Seminar> dateKvp = new KVPair<>(dateAndTime,
                        seminar);

                    worldDataBase.insert(idKvp, costKvp, dateKvp);

                    for (int i = 0; i < keyWords.length; i++) {
                        KVPair<String, Seminar> keyWordsKvp = new KVPair<>(
                            keyWords[i], seminar);
                        worldDataBase.insertKeyWords(keyWordsKvp);
                    }

                    // Passes the Seminar Object to WorldDataBase.
                    break;
                case "delete":
                    this.iD = Integer.parseInt(scan.next().trim());
                    worldDataBase.delete(iD);

                    break;
                case "search":

                    String searchType = scan.next().trim(); // Store the search
                                                            // type in a
                                                            // variable

                    if (searchType.equals("ID")) {
                        iD = Integer.parseInt(scan.next().trim());
                        // Print the record that matches the given ID if it
                        // exists
                        worldDataBase.searchID(iD);
                    }
                    else if (searchType.equals("cost")) {
                        // Get the low number of the range.
                        low = Integer.parseInt(scan.next().trim());
                        // Get the high number of the range.
                        high = Integer.parseInt(scan.next().trim());
                        // Once this is done, print out all the records that
                        // fall within
                        // the range of the low and high parameters.
                        worldDataBase.searchByCostRange(low, high);
                    }
                    else if (searchType.equals("date")) {
                        // Get the first date/time variable parameter.
                        dateAndTime = scan.next().trim();
                        // Get the second date/time variable parameter.
                        dateAndTime2 = scan.next().trim();
                        worldDataBase.searchByDateRange(dateAndTime,
                            dateAndTime2);
                        // Once this is done, print all records that fall within
                        // the range of the two date and times.
                    }
                    else if (searchType.equals("keyword")) {
                        // Get the keyword parameter and print all the records
                        // that match it.
                        keyword = scan.next().trim();
                        worldDataBase.searchKeyWord(keyword);
                    }
                    else if (searchType.equals("location")) {
                        // Set the variables x, y, and radius to parameters.
                        x = Short.parseShort(scan.next().trim());
                        y = Short.parseShort(scan.next().trim());
                        radius = Short.parseShort(scan.next().trim());
                        worldDataBase.searchByLocation(x, y, radius);
                        // Then print out all the records that fall within the
                        // radius distance of the search point.
                    }
                    break;

                case "print":
                    String printType = scan.next().trim(); // Store the print
                                                           // type in a variable

                    if (printType.equals("ID")) {
                        worldDataBase.printIDTree();
                    }
                    else if (printType.equals("cost")) {
                        worldDataBase.printCostTree();
                    }
                    else if (printType.equals("keyword")) {
                        worldDataBase.printKeyWordsTree();
                    }
                    else if (printType.equals("location")) {
                        // print the location
                        worldDataBase.printLocationTree();
                    }
                    else if (printType.equals("date")) {
                        worldDataBase.printDateTree();
                    }
                    break;
            }
        }
    }
}
