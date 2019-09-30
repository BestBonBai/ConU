public class reorganizeArray {
    public static void main(String[] args) {
        int[] A = {0, 1, 2, 3, 4, 5, 6};
        System.out.println("The current array: ");
        printArray(A);
        System.out.println("Tranforming array...");
        A = organizeAlgorithm(A, A.length, 0, 1, false);
        System.out.println("The new array: ");
        printArray(A);

    }
    private static int[] organizeAlgorithm(int[] A, int n, int i, int j, boolean cross) {
        if (j >= n) {
            return A;
        }

        if (n%2 == 0) {
            if (j < Math.floor(n/2)) {
                swap(A, i, j);
                return organizeAlgorithm(A, n, i+2, j+2, false);
            }
            else {
                if (cross == false && Math.floor(n/2)%2 == 1) {
                    i++;
                    j++;
                }
                mult(A, i, j);
                return organizeAlgorithm(A, n, i+2, j+2, true);
            }
        } else {
            if (j <= Math.floor(n/2)) {
                swap(A, i, j);
                return organizeAlgorithm(A, n, i+2, j+2, false);
            }
            else {
                mult(A, i, j);
                return organizeAlgorithm(A, n, i+2, j+2, true);
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
