/**
 * An interface contains all the needed methods to implement stack ADT.
 * @author Duc Nguyen
 */

public interface Stack_Interface <E> {

    /*
    * Insert an element at the top of the Stack
    * @param e: The element to be inserted
     */
    void push(E e);

    /**
     * Remove and returns the top element from the Stack
     * @return the removed element (null when it is empty)
     */
    E pop();
    /**
     * Return the first element on top of the Stack without removing it
     * @return top element of the Stack
     */
    E top();

    /**
     * Return the number of elements in the Stack
     * @return number of elements in the stack
     */
    int size();

    /**
     * Check if the stack is empty
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();
}
