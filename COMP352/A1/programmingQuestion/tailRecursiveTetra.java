/*
@Author: Duc Nguyen.
@Purpose: This program implements tail recursive method to find a Tetranacci number.
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class tailRecursiveTetra{
    public static void main(String[] args) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream("tailRecursiveLog.txt", true));
        }
        catch (FileNotFoundException e){
            System.out.println("Could not open output file");
            System.exit(0);
        }

        for (int index = 0; index < 100; index++) {
            pw.println("Calculating Tetranacci number using tail recursive algorithm ...");
            //Start timer
            long startTime = System.nanoTime();
            long result = tailTetra(index, 0,0,0,1);
            long endTime = System.nanoTime();

            long durationTime = (endTime - startTime);
            pw.println("Tetranacci number at index " + index + " is " + result +
                    "\nExecution time: " + durationTime + " ns.\n");
            //Step: 5
            index = index + 4;
        }

        pw.close();
        System.out.println("Done!");
    }

    // THE TAIL RECURSIVE ALGORITHM
    private static long tailTetra(int index, long h, long i, long j, long k) {
        if (index <=2) {
            return 0;
        }
        //Base case
        if (index == 3) {
            return k;
        }
        long total = h + i + j + k;
        return tailTetra(index-1, i, j, k, total);

    }
}

