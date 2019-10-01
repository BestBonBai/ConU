/*
@Purpose: The program is an implementation for the given pseudo code of Q3 to assert the result, and efficiency of the algorithm MyAlgorithm()
 */

public class testAlgorithmQ3 {
    private static int count = 0;
    //the main algorithm
    private static int[] MyAlgorithm(int[] A, int n) {
        count++;
        boolean done = true;
        int j = 0;
        while (j<= (n-2) ) {
            count++;
            if (A[j] > A[j+1]) {
                swap(A, j, j+1);
                done = false;
            }
            j++;
        }

        j = n-1;
        while (j>=1) {
            count++;
            if (A[j] < A[j-1]) {
                swap(A, j-1, j);
                done = false;
            }
            j = j-1;
        }

        if (!done) {
            return MyAlgorithm(A, n);
        } else {
            return A;
        }
    }

    private static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        //edit the array A for testing
        int[] A = {5, 4, 3, 2, 1};
        A = MyAlgorithm(A, A.length);

        System.out.print("[ ");
        for(int each: A) {
            System.out.print(each + " || ");
        }
        System.out.println(" ]");

        System.out.println("The number of execution is: " + count);
    }
}
