import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    protected static SmartAR_Sequence<Car>  sequence;
    protected static SmartAR_HashTable<Car> table;
    protected static boolean                isLarge;
    protected static boolean                useSequence;
    protected static boolean                useTable;

    protected static String                 logPATH          = "./log.txt";
    protected static Scanner                keyIn            = new Scanner(System.in);

    protected static PrintWriter            pw               = null;

    protected static Scanner                input;
    protected static boolean                inputStat        = false;

    protected static boolean                isFixedKeyLength = false;
    protected static int                    fixedKeyLength;


    //DATA STRUCTURE OPERATIONS
    //Calibrate to restructure data type
    public static void calibrate() {
        if(useSequence) {
            isLarge = sequence.getSize() > sequence.getThrehold();
        }

        if(useTable) {
            isLarge = table.getSize() > table.getThrehold();
        }

        if(isLarge && useSequence) {
            table = sequence.restructure();
            useSequence = false;
            useTable = true;
            sequence = null;
        }

        if(!isLarge && useTable) {
            sequence = table.restructure();
            useSequence = true;
            useTable = false;
            table = null;
        }

    }

    public static void setup() {
        sequence = new SmartAR_Sequence<>();
        isLarge = false;
        useSequence = true;
        useTable = false;
        setupStreams("", false, logPATH);
    }

    public static int getSize() {
        return (useSequence) ? sequence.getSize() : table.getSize();
    }

    public static void newSession() {
        closeStream();
        sequence = null;
        table = null;
        keyIn = new Scanner(System.in);
        setup();
    }

    //////////////////////////////

    // I/O STREAM
    public static void setupStreams(String readPath, boolean hasReadPath, String logPATH) {
        //Setup Scanner to read input file
        if(hasReadPath) {
            File target = new File(readPath);
            try {
                input = new Scanner(new FileInputStream(target));
                inputStat = true;
            } catch (FileNotFoundException e) {
                System.out.println("Cannot operate on targeted file");
                System.exit(0);
            }
        }

        File log = new File(logPATH);
        try {
            pw = new PrintWriter(new FileOutputStream(log));
        } catch (FileNotFoundException e) {
            System.out.println("Permission to write is not granted");
            System.exit(0);
        }

    }

    public static void closeStream() {
            pw.close();
            if(inputStat) {
                input.close();
                inputStat = false;
            }

    }

    public static void readFile() {
        while (input.hasNextLine()) {
            String key = input.nextLine();
            Car temp = new Car(4, "Red");
            if(useSequence) {
                sequence.add(key,temp);
            }

            if(useTable) {
                table.add(key, temp);
            }
            calibrate();
        }

        int collision = (useSequence) ? (sequence.getCollision()) : (table.getCollision());
        System.out.println("Number of overwriting operations was performed: " + collision);
    }
    //////////////////

    //SUPPORT METHODS FOR OPERATIONS WITH KEY
    public static boolean isValidLength(int length) {
        return (length >= 6 && length <= 12);
    }

    public static String askKey() throws IllegalArgumentException {
        keyIn.nextLine();
        System.out.println("Enter key to operate: ");
        String key = keyIn.nextLine();
        if(!isValidLength(key.length())) {
            System.out.println("Key length must be between 6 - 12");
            throw new IllegalArgumentException();
        }
        return key;
    }
    ///////////////////////////////////////////

    /// OPERATIONS
    //CASE 1
    public static void benchmarkFiles() throws IllegalArgumentException {
        String options = "1. test file 1 (10 000 entries)" +
                "\n2. test file 2 (100 000 entries)" +
                "\n3. test file 3 (1,000,000 entries)";
        System.out.println(options);
        int choice = keyIn.nextInt();

        // PATHS
        String path1 = "./benchmarkFiles/ar_test_file1.txt";
        String path2 = "./benchmarkFiles/ar_test_file2.txt";
        String path3 = "./benchmarkFiles/ar_test_file3.txt";

        String designatedPATH = "";
        switch (choice) {
            case 1:
                designatedPATH = path1;
                break;

            case 2:
                designatedPATH = path2;
                break;

            case 3:
                designatedPATH = path3;
                break;

            default:
                throw new IllegalArgumentException();

        }

        setupStreams(designatedPATH, true, logPATH);
        readFile();

    }

    //CASE 2
    public static void changeLogPATH() throws IllegalArgumentException{
        System.out.println("Enter new valid PATH: ");
        String path = keyIn.nextLine();
        File newLOG = new File(path);
        if(!newLOG.canWrite()) {
            System.out.println("PATH is invalid");
            throw new IllegalArgumentException();
        }
        logPATH = path; // assign new log file address
        setupStreams("", false, logPATH); //UPDATE new address for I/O

    }

    //CASE 3
    public static void setThreshold() throws IllegalArgumentException {
        System.out.println("Enter new threhold value: ");
        keyIn.nextLine();
        int threhold = keyIn.nextInt();
        if(threhold <= 0) {
            throw new IllegalArgumentException();
        }

        if(useTable) {
            table.setThrehold(threhold);
        }

        if(useSequence) {
            sequence.setThrehold(threhold);
        }

        calibrate();
    }

    //CASE 4
    public static void setKeyLength() throws IllegalArgumentException {
        if(getSize() != 0) {
            System.out.println("The structure was initialized." +
                    "\nCannot set a fixed key length now.");
            return;
        }

        System.out.println("Enter a new key length");
        int keyLength = keyIn.nextInt();
        if(keyLength < 6 || keyLength > 12) {
            System.out.println("Key length must be between 6 and 12");
            throw new IllegalArgumentException();
        }

        if(useSequence) {
            sequence.setKeyLength(keyLength);
        }

        if(useTable) {
            table.setKeyLength(keyLength);
        }

        isFixedKeyLength = true;
        fixedKeyLength = keyLength;

    }

    //CASE 5
    public static void generate() throws IllegalArgumentException{
        System.out.println("Number of elements to be generated: ");
        int n = keyIn.nextInt();
        if(n < 0) {
            System.out.println("Number of elements must be greater than 0");
            throw new IllegalArgumentException();
        }

        for(int i = 0; i<n; ++i) {
            int keyLength = 0;
            if(!isFixedKeyLength) {
                keyLength = (int) (Math.random()*((12-6)+1))+6;
            } else {
                keyLength = fixedKeyLength;
            }

            String key = getAlphaNumericString(keyLength);
            Car temp = new Car(4, "Red");
            if(useSequence) {
                sequence.add(key, temp);
            }

            if(useTable) {
                table.add(key, temp);
            }

        }
        System.out.println("Done");

    }

    // function to generate a random string of length n
    static String getAlphaNumericString(int n)
    {

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }


    //CASE 6
    public static void allKeys() {
        System.out.println("Sorting and getting sequence of keys");
        String[] keys = new String[getSize()];
        if(useSequence) {
            keys = sequence.allKeys();
        }

        if(useTable) {
            keys = table.allKeys();
        }

        pw.println("########### Sorted keys ###########");
        if(getSize() == 0) {
            pw.println("Empty");
        } else {
            for(String each : keys) {
                pw.println(each);
            }
        }
        pw.println("###################################");
        pw.flush();
        System.out.println("Check log file for the list of sorted keys");

    }

    //CASE 7
    public static void add() throws IllegalArgumentException {
        String key = askKey();

        System.out.println("1 > Enter Car properties manually " +
                "\n2 > Use default item");
        int choice = keyIn.nextInt();

        //Illegal input
        if(choice != 1 && choice != 2) {
            throw new IllegalArgumentException();
        }

        // Setup new Car
        Car temp = new Car();

        if(choice == 1) {
            System.out.println("Number of doors: ");
            int numOfDoor = keyIn.nextInt();
            if(numOfDoor < 0) {
                throw new IllegalArgumentException();
            }
            temp.setNumberOfDoor(numOfDoor);

            keyIn.nextLine();

            System.out.println("Colour of the car: ");
            String colour = keyIn.nextLine();

            temp.setColour(colour);

        }

        if(choice == 2) {
            temp.setNumberOfDoor(4);
            temp.setColour("Red");
        }

        //Adding to the structure
        if(useTable) {
            System.out.println("Adding to Table");
            table.add(key, temp);
        }

        if(useSequence) {
            System.out.println("Adding to Sequence");
            sequence.add(key, temp);
        }
        System.out.println("Added Successfully");

        calibrate();

    }

    //CASE 8
    public static void remove() throws IllegalArgumentException {
        String key = askKey();

        if(useSequence) {
            sequence.remove(key);
        }

        if(useTable) {
            table.remove(key);
        }

        System.out.println("Complete operation");
        calibrate();
    }



    //CASE 9
    public static void getValue() throws IllegalArgumentException{
        String request = askKey();
        Car temp = (useSequence) ? sequence.getValue(request) : table.getValue(request);

        if(temp != null) {
            System.out.println(temp);
        }

    }

    //CASE 10
    public static void nextKey() throws IllegalArgumentException {
        String request = askKey();
        String nextKey = (useSequence) ? sequence.nextKey(request) : table.nextKey(request);

        if(nextKey != null) {
            System.out.println("Next key of " + request + " is: " + nextKey);
        }

    }

    //CASE 11
    public static void prevKey() throws IllegalArgumentException {
        String request = askKey();
        String prevKey = (useSequence) ? sequence.prevKey(request) : table.prevKey(request);

        if(prevKey != null) {
            System.out.println("Prev key of " + request + " is: " + prevKey);
        }

    }

    //CASE 12
    public static void previousCars() throws IllegalArgumentException {
        String request = askKey();
        ArrayList<Entry> record = (useSequence) ? sequence.previousCars(request) : table.previousCars(request);
        if(record != null) {
            System.out.println("Getting record");
            pw.println("\n###### Historical record of key " + request + "######");
            for(Entry each : record) {
                pw.println(each.getValue());
            }
            pw.println("######################################################\n");
            pw.flush();
        }
    }

    //CASE 13
    public static void printSize() {
        System.out.println("The size of the structure now is " + getSize());
        pw.println("\nThe size of the structure now: " + getSize());

    }

    //CASE 14
    public static void currentStr() {
        String str = (useSequence) ? "SEQUENCE" : "HASHTABLE";
        System.out.println("Current structure: " + str);
    }

    //////////////


    public static void main(String[] args) {
        String menu = "---------------MAIN MENU-------------" +
                "\n-----------------------------------" +
                "\n1.  Setup by Given Benchmark Files" +
                "\n2.  Change log PATH" +
                "\n3.  setThreshold" +
                "\n4.  setKeyLength" +
                "\n5.  generate randomly" +
                "\n6.  allKeys() <Sorted sequence>" +
                "\n7.  add" +
                "\n8.  remove" +
                "\n9.  getValue" +
                "\n10. nextKey" +
                "\n11. prevKey" +
                "\n12. previousCars" +
                "\n13. Size" +
                "\n14. Current Structure " +
                "\n15. Clear" +
                "\n16. Exit" +
                "\n-----------------------------------" +
                "\n>";

        String endMessage = "Thank you for using Smart AR";


        //SETTING UP
        setup();

        while(true) {
            System.out.println(menu);
            keyIn.nextLine();

            try {
                int choice = keyIn.nextInt();

                switch (choice) {
                    case 1:
                        benchmarkFiles();
                        break;

                    case 2:
                        changeLogPATH();
                        break;

                    case 3:
                        setThreshold();
                        break;

                    case 4:
                        setKeyLength();
                        break;

                    case 5:
                        generate();
                        break;

                    case 6:
                        allKeys();
                        break;

                    case 7:
                        add();
                        break;

                    case 8:
                        remove();
                        break;

                    case 9:
                        getValue();
                        break;

                    case 10:
                        nextKey();
                        break;

                    case 11:
                        prevKey();
                        break;

                    case 12:
                        previousCars();
                        break;

                    case 13:
                        printSize();
                        break;

                    case 14:
                        currentStr();
                        break;

                    case 15:
                        newSession();
                        break;

                    case 16:
                        closeStream();
                        System.out.println(endMessage);
                        keyIn.close();
                        System.exit(0);

                    default:
                        throw new IllegalArgumentException();

                }
            } catch (Exception e ) {
                System.out.println("Illegal input. Please try again");
            }

        }

    }
}
