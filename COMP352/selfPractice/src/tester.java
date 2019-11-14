/*
A class to test every data structure implemented
All the result will be printed to a log file
 */
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class tester {
    private static Scanner keyIn;
    private static PrintWriter pw = null;

    private static void setup() {
        try {
            keyIn = new Scanner(System.in);
            pw = new PrintWriter(new FileOutputStream("log.txt"));
            System.out.println("Set up successfully");
            pw.println("\n---------Session starts--------");

        } catch (FileNotFoundException e) {
            System.out.println("Error found when opening I/O ports");
            e.printStackTrace();
        }

    }

    private static void closePorts() {
        pw.println("\n---------Session terminated--------");
        keyIn.close();
        pw.close();
    }

    // Clear console (works only with Command line)
    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void testArrayStack() {
        setup();
        Stack_Array<Integer> test = new Stack_Array<>();

        pw.println("Initialized a new Stack based Array");
        String operation = "\nSelect one operation from below options:" +
                "\n1. Push to Stack" +
                "\n2. Pop out of Stack" +
                "\n3. See current top of Stack" +
                "\n4. See current size of the Stack" +
                "\n5. See current size of the array" +
                "\n6. Is stack empty?" +
                "\n7. Print Stack" +
                "\n8. Exit" +
                "\n>>>> ";

        int choice = 0;
        while (choice != 8) {
            //Initialize choices
            try {
                System.out.print(operation);
                choice = keyIn.nextInt();
                if (choice < 1 || choice > 8) {
                    throw new InputMismatchException();
                }
            } catch (Exception e) {
                e.printStackTrace();
                keyIn.next();
                choice = -1; //Choice is back to no init
                continue;
            }

            switch(choice) {
               //Push to Stack
                case 1:
                    try {
                        clearConsole();
                        System.out.print("Input a number: ");
                        int newElement = keyIn.nextInt();
                        test.push(newElement);
                        System.out.println("Pushed " + newElement + " into the stack");
                        pw.println("Pushed " + newElement + " into the stack");
                    } catch (Exception e) {
                        e.printStackTrace();
                        keyIn.next(); //Reset Scanner and choice
                        choice = -1;
                        System.out.println("Task failed. Try again");
                    }
                    break;

                //Pop from Stack
                case 2:
                    if(test.top() != null) {
                        int element = test.pop();
                        System.out.println("Popped " + element + " out of the Stack");
                        pw.println("Popped " + element + " out of the Stack");
                    } else {
                        System.out.println("Stack is empty. Cannot pop");
                        pw.println("Stack is empty. Cannot pop");
                    }
                    break;

                //Current top
                case 3:
                    if(test.isEmpty()) {
                        System.out.println("No element");
                        pw.println("No element");
                    } else {
                        System.out.println("Top element is " + test.top());
                        pw.println("Top element is " + test.top());
                    }
                    break;

                // Size of Stack
                case 4:
                    System.out.println("Current size of Stack: " + test.size());
                    pw.println("Current size of Stack: " + test.size());
                    break;

                //Size of array aka Capacity
                case 5:
                    System.out.println("Current size of array: " + test.getCAPACITY());
                    pw.println("Current size of array: " + test.getCAPACITY());
                    break;

                //isEmpty()
                case 6:
                    System.out.println("Stack is empty: " + test.isEmpty());
                    pw.println("Stack is empty: " + test.isEmpty());
                    break;

                //Print Stack
                case 7:
                    System.out.println("Printing Stack: \n" + test.printStack());
                    pw.println("Printing Stack: \n" + test.printStack());
                    break;

                case 8:
                    break;

            }

        }
        closePorts();

    }

    public static void main(String[] args) {
        testArrayStack();


    }

}
