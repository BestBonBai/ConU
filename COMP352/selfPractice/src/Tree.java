import java.util.Iterator;

/**
 * An interface supports the implementation of tree
 * Interfaces being used:
 * + Iterator
 * + Position
 * @author Duc Nguyen
 */

public interface Tree<E> extends Iterable<E> {
    Position<E> root();
    Position<E> parent(Position<E> p) throws IllegalStateException;
    Iterable<Position<E>> children(Position<E> p) throws IllegalStateException;
    int numChildren(Position<E> p) throws IllegalStateException;
    boolean isInternal(Position<E> p) throws IllegalStateException;
    boolean isExternal(Position<E> p) throws IllegalStateException;
    boolean isRoot(Position<E> p) throws IllegalStateException;
    int size();
    boolean isEmpty();
    Iterator<E> iterator();
    Iterable<Position<E>> position();

}
