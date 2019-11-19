/**
 * An interface supports the creation of a List ADT
 * @author Duc Nguyen
 */
public interface List_Interface<E> {
    /**
     * Replace the element at index i with new element e, return the replaced element
     * @param i : index of the element will be replaced
     * @param r : new element
     * @return  : The replaced element
     * @throws IndexOutOfBoundsException :
     */
    E set(int i, E r) throws IndexOutOfBoundsException;

    /**
     * Return without removing the element at index i
     * @param i : index of the element
     * @return Return the element at index i
     * @throws IndexOutOfBoundsException :
     */
    E get(int i) throws IndexOutOfBoundsException;

    /**
     * Insert a new element at index i.
     * Shifts all the elements after it to a new position
     * @param i : index for the new element
     * @param e : The new element to be added to the List
     * @throws IndexOutOfBoundsException :
     */
    void add(int i, E e) throws IndexOutOfBoundsException;

    /**
     * Remove and return the element at index i
     * @param i : the index of the element to be removed
     * @return : the removed element
     * @throws IndexOutOfBoundsException :
     */
    E remove(int i) throws IndexOutOfBoundsException;

    /**
     * return the number of element inside the list
     * @return the size of the list
     */
    int size();

    /**
     * Check if the list is empty or not.
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

}