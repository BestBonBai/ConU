/**
 * An interface supports the implementation of a variety of Positional List ADT
 * @author Duc Nguyen
 */
public interface Position<E> {
    /**
     *
     * @return the element in a position
     * @throws IllegalStateException When the position does not exist
     */
    E element() throws IllegalStateException;

}
