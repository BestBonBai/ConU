import java.util.Deque;
import java.util.NoSuchElementException;

public class deque_LinkedList<E> implements Deque<E>{

    private class Node {
        E data;
        Node next, prev;

        public Node() {
            this(null, null, null);
        }

        public Node(Node prev, E data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }

        public E getData() { return data;}
    }

    private Node head, tail;

    @Override
    public void addFirst(E e) {
        Node temp = new Node(null, e, head);
        if (isEmpty()) {
            head = tail = temp;
        } else {
            head.prev = temp;
            head = temp;
        }
    }

    @Override
    public void addLast(E e) {
        Node temp = new Node(tail, e, null);
        if(isEmpty()) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
    }

    @Override
    public E removeFirst() {
       if (isEmpty()) {throw new NoSuchElementException();}
       else if(size() == 1) {
           E temp = head.getData();
           head = tail = null;
           return temp;
       }
       else {
           E temp = head.getData();
           head.next.prev = null;
           head = head.next;
           return temp;
       }
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {throw new NoSuchElementException();}
        else if(size() == 1) {
            E temp = tail.getData();
            head = tail = null;
            return temp;
        } else {
            E temp = tail.getData();
            tail.prev.next = null;
            tail = tail.prev;
            return temp;
        }
    }

    @Override
    public E getFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return head.getData();
        }
    }

    @Override
    public E getLast() {
       if(isEmpty()) {
           throw new NoSuchElementException();
       } else {
           return tail.getData();
       }
    }

    @Override
    public int size() {
        if(isEmpty()) {return 0;}
        else {
            Node index = head;
            int count = 0;
            while (index.next != null) {
                count++;
                index = index.next;
            }
            return count;
        }
    }

    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    @Override
    public boolean offerFirst(E e) {
        return false;
    }
}
