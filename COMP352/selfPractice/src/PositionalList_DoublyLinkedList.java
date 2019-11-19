public class PositionalList_DoublyLinkedList<E> implements PositionalList_Interface<E> {

    // Node class
    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> prev, Node<E> next) {
           element = e;
           this.prev = prev;
           this.next = next;

        }

        @Override
        public E getElement() throws IllegalStateException {
            if (next == null )
                throw new IllegalStateException();
            return element;
        }

        //GETTERS, SETTERS
        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

    }
    //----End of Node class -----

    //Sentinels of header and trailer
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public PositionalList_DoublyLinkedList() {
        header = new Node<> (null, null, null);
        trailer = new Node<> (null, header, null);
        header.setNext(trailer);
    }

    //Validate a position. If the position is valid, return a node in this position
    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if(!(p instanceof Node))
            throw new IllegalArgumentException("Invalid requested position");
        Node<E> node = (Node<E>) p;

    }

    @Override
    public E set(Position<E> p, E r) throws IllegalArgumentException {
        return null;
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Position<E> addFirst(E e) {
        return null;
    }

    @Override
    public Position<E> addLast(E e) {
        return null;
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Position<E> first() {
        return null;
    }

    @Override
    public Position<E> last() {
        return null;
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
