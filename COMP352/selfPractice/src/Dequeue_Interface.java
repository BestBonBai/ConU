/**
 * An interface supports for the implementation of Queue ADT
 * @author Duc Nguyen
 */

public interface Dequeue_Interface<E> {
    /**
     * Insert new element at front of the queue
     * @param e : new element to be inserted
     */
    void addFront(E e);

    /**
     * Insert a new element at the rear of the queue
     * @param e : new element to be inserted
     */
    void addRear(E e);

    /**
     * Remove, and return the value at front of the queue
     * @return the removed value
     */
    E removeFront();

    /**
     * Remove, return the value at the rear of the queue
     * @return the value at rear
     */
    E removeRear();

    /**
     * Return without removing the front element of the queue
     * @return the value at front
     */
    E front();

    /**
     * Return without removing the rear element of the queue
     * @return the value at rear
     */
    E rear();

    /**
     * Return the number of elements in the queue currently
     * @return the number of elements in the queue
     */
    int size();

    /**
     * Check if the queue is empty
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();

}
