/*
Stack Abstract Data Type implementation by singly linked list
 */
public class Stack_SinglyLinkedList<E> implements Stack_Interface<E> {
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

    private Node head;

    //ADD AT FIRST
    public void push(E data) {
        if(isEmpty()) {
            head = new Node(data, null);
        } else {
            head = new Node(data, head);
        }
    }

    //POP AT FIRST
    public E pop() {
        if(isEmpty()) {
            return null;
        } else {
            E temp = head.getData();
            head = head.next;
            return temp;
        }
    }

    public E top() {
        if(isEmpty()) {
            return null;
        } else {
            return head.getData();
        }
    }

    public int size() {
        if(isEmpty()) { return 0;}
        else {
            int count = 1;
            Node temp = head;
            while(temp.next != null) {
                count++;
                temp = temp.next;
            }
            return count;
        }
    }

    public boolean isEmpty() {
        return (head == null);
    }

}
