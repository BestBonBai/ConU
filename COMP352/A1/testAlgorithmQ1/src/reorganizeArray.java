/*
@author: Duc Nguyen
This program is out of scope for this assignment. But it is a good demonstrator, and implementation for the first question.
@requirement:
INPUT: an array of any size, n >= 4
OUTPUT: an array was reordered by the following rules:
+ Reverse every 2 consecutive elements of the left half (ex: reverse element index 0 & 1, index 2 & 3, etc)
+ Change the second element of every 2 consecutive elements to have the product (multiplication) of the 2 elements
(ex: right half starts at index 14, value at index 14 and 15 are 5 and 12 => the value at index 15 is changed to 60.
+ if the given is of an odd size, the number of element in the left half is ceiling of n/2
+ The algorithm must use the least storage to perform the task.
 */

public class reorganizeArray {
    public static void main(String[] args) {
        //Change the test array here
        int[] A = {0, 1, 2, 3, 4, 5, 6};
        System.out.println("The current array: ");
        printArray(A);

        System.out.println("Tranforming array...");
        A = ReverseOrMultiply(A, A.length, 0, 1, false);

        System.out.println("The new array: ");
        printArray(A);

    }

    //TAIL RECIURSIVE ALGORITHM
    private static int[] ReverseOrMultiply(int[] A, int n, int i, int j, boolean cross) {
        if (j >= n) {
            return A;
        }

        if (n%2 == 0) {
            if (j < Math.floor(n/2)) {
                swap(A, i, j);
                return ReverseOrMultiply(A, n, i+2, j+2, false);
            }
            else {
                if (cross == false && Math.floor(n/2)%2 == 1) {
                    i++;
                    j++;
                }
                mult(A, i, j);
                return ReverseOrMultiply(A, n, i+2, j+2, true);
            }
        } else {
            if (j <= Math.floor(n/2)) {
                swap(A, i, j);
                return ReverseOrMultiply(A, n, i+2, j+2, false);
            }
            else {
                mult(A, i, j);
                return ReverseOrMultiply(A, n, i+2, j+2, true);
            }
        }
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static void mult(int[] A, int i, int j) {
        A[j] = A[i] * A[j];
    }

    private static void printArray(int[] A) {
        System.out.print("\n[");
        for (int value : A) {
            System.out.print(value + " || ");
        }
        System.out.println("]");
    }
}
