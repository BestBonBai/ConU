/**
 * An interface supports the implementation of Queue ADT(FIFO)
 * @author Duc Nguyen
 */

public interface Queue_Interface<E> {
    /**
     * Insert a new element at the rear of the queue
     * @param e : new element to be enqueued
     */
    void enqueue(E e);

    /**
     * Removes, and returns the first element
     * @return the removed element (null if empty)
     */
    E dequeue();


    E front();
    /**
     * The number of elements in the queue
     * @return the number of element in the queue currently
     */
    int size();

    /**
     * Check if the queue is empty
     * @return boolean value tests if the queue is empty
     */
    boolean isEmpty();



}
