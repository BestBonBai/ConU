import java.util.List;

public class LinkedPositionalList<E> {

    //NODE CLASS
    private static class Node<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() throws IllegalStateException {
            if(next == null) {throw new IllegalStateException("Position no longer valid");}
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
    //END NODE INNER CLASS

    private Node<E> header, trailer;
    private int size = 0;

    public LinkedPositionalList() {
        header = new Node(null, null, null);
        trailer = new Node(null, header, null);
        header.setNext(trailer);
    }

    //VALIDATE A POSITION AND RETURNS IT AS A NODE




}
