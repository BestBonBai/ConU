/*
Score Far Right is a 1-player game consisting of a row of squares of any size each containing an integer
Ex:
[<4>, 8, 5, 2, 3, 5, 1, 6, 4, 0]

The < > on the initial square (which can be initialized anywhere in the array)
is a marker that can move to other squares along the row.
At each step in the game, you may move the marker right or left by the number of squares indicated by the integer in the square it currently occupies.
The marker may move either left or right along the row but may not move past either end.
For example, the only legal first move is to move the marker four squares to the right because there is no room to move four spaces to the left.
The goal of the game is to move the marker to the cave,
the “0” at the far right end of the row. In this configuration, you can solve the game by making the following set of moves:


[<4>, 8, 5, 2, 3, 5, 1, 6, 4, 0]

[4, 8, 5, 2, <3>, 5, 1, 6, 4, 0]

[4, 8, 5, 2, 3, 5, 1, <6>, 4, 0]

[4, <8>, 5, 2, 3, 5, 1, 6, 4, 0]

[4, 8, 5, 2, 3, 5, 1, 6, 4, <0>] => game ends.

This program is an implementation of the game to check if the configuration is winnable.
The program will generate 20 random cases with
 + random length of array
 + random elements inside the array
 + random starting index
to check if the game is winnable.
It will write all the calculated results to a log file .txt after that.
 */

import java.util.Stack;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ScoreFarRight {
    private static Stack<Integer> indexStack = new Stack<>();

    //MAIN ALGORITHM
    private static boolean checkWinnable(int index, int[] board) {
        // base case
        if (index + 1 == board.length) {
            return true;
        }

        // Repeating step
        if (indexStack.search(index) != -1) {
            return false;
        }

        // move out of border
        if ((index < 0) || (index >= board.length)) {
            return false;
        }

        indexStack.push(index);
        return (checkWinnable(index - board[index], board) || checkWinnable(index + board[index], board));
    }

    private static int getRandom(int min, int max) {
        return (int)(Math.random() * (max + 1 -min)) + min;
    }

    private static void printLog(int firstIndex, int[] board, boolean isWinnable, PrintWriter pw) {
        //Clear the used stack
        indexStack.clear();

        pw.println("Board's configuration:");
        pw.print("[");
        for (int i = 0; i< board.length; i++) {
            if(i == firstIndex) {
                pw.print("< " + board[i] + " >");
            } else {
                pw.print("| " + board[i] + " |");
            }
        }
        pw.print("]\n");
        pw.println("The first index is " + firstIndex);
        if (isWinnable) {
            pw.println("This is a WINNABLE configuration.\n");
        } else {
            pw.println("This is an UNWINNABLE configuration.\n");
        }
    }

    //GENERATE TEST CASES. WRITE RESULTS TO LOG FILE
    public static void main(String[] args) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream("ScoreFarRightLOG.txt"));
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not open log file");
            System.exit(0);
        }
        pw.println("------LOG FILE FOR SCORE FAR RIGHT------");
        pw.println("The starting index is denoted with < index >\n");

        System.out.println("Generating random test boards");
        System.out.println("First index will be denoted with < value > in log file");
        for (int i = 0; i < 20; i++) {
            //Init the board
            int size = getRandom(1, 25);
            int firstIndex = getRandom(0, size-1);
            int[] board = new int[size];
            for (int j = 0; j< size - 1; j++) {
                board[j] = getRandom(0, size);
            }
            //The last element is always 0 to terminate the game
            board[size-1] = 0;

            //Test and write results to log file
            printLog(firstIndex, board, checkWinnable(firstIndex, board), pw);
        }

        System.out.println("Finish checking random tests. Start checking personal configuration.");
        pw.println("----Personal configuration----");
        //Other configuration
        int[][] board = new int[4][];
        //winnable
        board[0] = new int[]{4, 8, 5, 2, 3, 5, 1, 6, 4, 0};
        //unwinnable
        board[1] = new int[]{5, 8, 2, 3, 1, 5, 0};
        //unwinnable
        board[2] = new int[]{2, 1, 5, 8, 2, 3, 1, 5, 0};
        //uniwinnable
        board[3] = new int[]{5, 8, 2, 3, 1, 5, 2, 3, 4, 3, 5, 2, 0};
        int firstIndex = 0;
        for (int i = 0; i<=3; i++) {
            printLog(firstIndex, board[i], checkWinnable(firstIndex, board[i]), pw);
        }

        pw.println("\n----FINISHED----");
        pw.close();
        System.out.println("Process finished");
    }
}