/*
Stack implementation by array.
 */

import java.util.EmptyStackException;

public class Stack_ArrayBased<T> {
    private T[] array;
    private int headStack = -1;

    public Stack_ArrayBased(T[] array) {
        this.array = array;
    }

    public Stack_ArrayBased(int length) {
        this.array = (T[])new Object[length];
    }

    private void push(T element) {
        if (headStack == array.length - 1) {
            T[] newArray = (T[])new Object[2*array.length];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;

            headStack++;
            array[headStack] = element;
        }
        else {
            headStack++;
            array[headStack] = element;
        }
    }

    private T pop() throws EmptyStackException {
        if(!isEmpty()) {
            T temp = array[headStack];
            array[headStack] = null;
            headStack--;
            return temp;
        } else {
            throw new EmptyStackException();
        }
    }

    private T top() throws  EmptyStackException {
        if(!isEmpty()) {
            return array[headStack];
        } else {
            throw new EmptyStackException();
        }
    }

    private int size(){ return headStack + 1; }

    private int arraySize() {return array.length;}

    private boolean isEmpty() { return (headStack == -1); }

    private void printStack() {
        for(int i = 0; i <= headStack; i++) {
            System.out.print("| " + array[i] + " ");
        }
    }

    //TEST EXAMPLES
    public static void main(String[] args) {
        Stack_ArrayBased<Integer> test = new Stack_ArrayBased<Integer>(5);
        test.push(0);
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        System.out.println("The size of stack now is " + test.size());
        System.out.println("The size of the array now is " + test.arraySize());
        System.out.println("The top of the stack now is " + test.top());
        try {
            for (int i = 0; i<4; i++) {
                System.out.println("Popping out " + test.pop());
            }
            System.out.println("The top of the stack now is " + test.top());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        test.printStack();
    }
}


