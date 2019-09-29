/*
@Author: Duc Nguyen.
@Purpose: This program implements multiple recursive method to find a Tetranacci number.
Also, it serves as a comparision to linear recursive method in term of time, and space efficiency.
The program generates a log file named "output.txt" with detail about the result, the method it used and the execution time of the algorithm.
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class multipleRecursiveTetra {
	public static void main(String[] args){
		Scanner keyIn = new Scanner(System.in);
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream("multRecursiveLog.txt", true));
		} 
		catch (FileNotFoundException e) {
			System.out.println("Could not find file");
			System.exit(0);
		}

		//Ask for index
		System.out.println("Input an index to start: ");
		int index = keyIn.nextInt();

		System.out.println("Calculating Tetranacci number using multiple recursive method...");
		pw.println("Calculating Tetranacci number using multiple recursive method ...");

		//Start timer
		long startTime = System.nanoTime();
		long result = multipleTetra(index);
		long endTime = System.nanoTime();

		long durationTime = (endTime - startTime);

		pw.println("Tetranacci number at index " + index + " is " + result +
				".\nExecution time:" + durationTime + " ns.\n");

		keyIn.close();
		pw.close();
		System.out.println("Done!");
	}

	//THE MULTIPLE RECURSIVE ALGORITHM
	private static long multipleTetra(int index) {
		if(index <= 2) {
			return 0;
		}
		else if (index <=4) {
			return 1;
		}
		else {
			return multipleTetra(index-1) + multipleTetra(index-2) + multipleTetra(index-3) + multipleTetra(index -4);
		}
	}
}
