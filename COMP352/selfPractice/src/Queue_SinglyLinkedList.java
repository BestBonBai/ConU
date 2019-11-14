/**
 * An implementation of queue ADT using Singly Linked List
 * @param <E>
 */

public class Queue_SinglyLinkedList<E> implements Queue_Interface<E> {
    private class Node {
        private E data;
        private Node next;

        public Node() {
            this(null, null);
        }

        private Node(E e, Node next) {
            this.data= e;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public Node getNext(){
            return next;
        }
    }

    private Node front, rear;

    public void enqueue(E data) {
        Node temp = new Node(data, null);
        if (isEmpty()) {
            front = rear = temp;
        } else {
            rear.next = temp;
            rear = rear.next;
        }
    }

    public E dequeue() {
        if(isEmpty()) {
            return null;
        } else {
            E temp = front.getData();
            front = front.next;
            return temp;
        }
    }

    public E front() {
        if(isEmpty()) {
            return null;
        } else {
            return front.getData();
        }
    }

    public int size() {
        if(isEmpty()) { return 0; }
        else {
            int count  = 1;
            Node index = front;
            while(index.next != null) {
                count++;
                index = index.next;
            }
            return count;
        }
    }

    public boolean isEmpty(){return (front == null);}

}
