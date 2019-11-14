/**
 Stack implementation by array with:
 + Unlimited capacity
 + Expand array space as push requests
 @author Duc Nguyen
 */

public class Stack_Array<E> implements Stack_Interface<E> {
    private int CAPACITY;
    private E[] data;
    private int head= -1;

    /*
     2 constructors for 2 purposes:
     + Create stack when none was given
     + Create stack with an initial given capacity
     */
    public Stack_Array() {
        this(100); //Default capacity
    }

    public Stack_Array(int capacity) {
        CAPACITY = capacity;
        this.data= (E[]) new Object[capacity];
    }

    //GETTERS
    protected int getCAPACITY() {return CAPACITY;}

    protected E[] getArray() {return data;}

    // The stack does not have limit.
    // The data will expand by double if it reaches the maximum capacity
    public void push(E element) {
        if (head == CAPACITY - 1) {
            E[] newArray = (E[]) new Object[2*CAPACITY];
            System.arraycopy(data, 0, newArray, 0, CAPACITY);
            data= newArray;

            head++;
            data[head] = element;
        }
        else {
            head++;
            data[head] = element;
        }
    }

    public E pop() {
        if(!isEmpty()) {
            E temp = data[head];
            data[head] = null;
            head--;
            return temp;
        } else {
            return null;
        }
    }

    public E top() {
        if(!isEmpty()) {
            return data[head];
        } else {
            return null;
        }
    }

    public int size(){ return head + 1; }

    public boolean isEmpty() { return (head == -1); }

    protected String printStack() {
        StringBuilder out = new StringBuilder();
        for(int i = 0; i <= head; ++i) {
            out.append("| ").append(data[i]).append(" ");
        }
        return out.toString();
    }

}


