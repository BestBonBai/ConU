import java.util.Stack;
public class ScoreFarRight {
    private static Stack<Integer> indexStack = new Stack<>();
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

    public static void main(String[] args) {
        int[] board = new int[]{1, 5, 2, 3, 4, 5, 6, 0};
        if (checkWinnable(0, board)) {
            System.out.println("This game is winnable.");
        } else {
            System.out.println("This game is unwinnable.");
        }
    }
}