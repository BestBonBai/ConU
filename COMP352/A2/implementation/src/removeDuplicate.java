import java.util.Stack;

public class removeDuplicate {

    //MAIN ALGORITHM
    private static int[] removeAllDuplicate(int[] array) {
        var temp = new Stack<Integer>();
        for(int each : array) {
            if (!temp.contains(each)) {
                temp.push(each);
            }
        }
        int[] result = new int[temp.size()];
        for (int i = result.length-1; i>=0; i--) {
            result[i] = temp.pop();
        }
        return result;
    }

    private static void printArray(int[] array) {
        for(int each : array) {
            System.out.print("| " + each);
        }
        System.out.print(" |\n");
    }

    public static void main(String[] args) {
        int[] test = new int[]{22, 61, -10, 61, 10, 9, 9, 21, 35, 22, -10, 19, 5, 77, 92, 85, 21, 35, 12, 9, 61};
        System.out.println("The test array: ");
        printArray(test);
        System.out.println("The array after removing all duplicate elements");
        printArray(removeAllDuplicate(test));
    }
}
