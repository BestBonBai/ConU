/*
@Author: Duc Nguyen.
@Purpose: This program implements linear recursive method to find a Tetranacci number.
And, also it serves as a comparision to the multiple recursive method in term of time, and space efficiency.
The program creates a log file named "output.txt" with detail about the result, the method it used, and the execution time of the algorithm.
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class linearRecursiveTetra{
	public static void main(String[] args) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream("linearRecursiveLog.txt", true));
		}
		catch (FileNotFoundException e){
			System.out.println("Could not open output file");
			System.exit(0);
		}

		for (int index = 0; index < 100; index++) {
			pw.println("Calculating Tetranacci number using linear recursive algorithm ...");
			//Start timer
			long startTime = System.nanoTime();
			long result = linearTetra(index)[3];
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
	
	// THE LINEAR RECURSIVE ALGORITHM
	private static long[] linearTetra(int index) {
		long[] temp = {0,0,0,0}; 
		if (index <= 2) {
			return temp;
		}
		else if (index == 3) {
			temp[index] = 1;
			return temp;
		}
		else {
			temp = linearTetra(index-1);
			long h = temp[0];
			long i = temp[1];
			long j = temp[2];
			long k = temp[3];
			
			temp[0] = i;
			temp[1] = j;
			temp[2] = k;
			temp[3] = h + i + j + k;
			return temp;
		}
	}
}

