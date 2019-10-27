/*
Queue implemented by singly linked list
 */

public class Queue_SinglyLinkedListBased {
    private static class Node {
        private Object data;
        private Node next;

        public Node() {
            this(null, null);
        }

        private Node(Object e, Node next) {
            this.data= e;
            this.next = next;
        }

        public Object getData() {
            return data;
        }

        public Node getNext(){
            return next;
        }
    }

    private Node front, rear;

    private void enqueue(Object data) {
        Node temp = new Node(data, null);
        if (isEmpty()) {
            front = rear = temp;
        } else {
            rear.next = temp;
            rear = rear.next;
        }
    }

    private Object dequeue() throws EmptyQueueException {
        if(isEmpty()) { throw  new EmptyQueueException(); }
        else {
            Object temp = front.getData();
            front = front.next;
            return temp;
        }
    }

    private Object front() throws EmptyQueueException{
        if(isEmpty()) {throw new EmptyQueueException();}
        else {return front.getData(); }
    }

    private boolean isEmpty(){return (front == null);}

    private int size() {
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

    private static class test {
        public static void main(String[] args) {
            Queue_SinglyLinkedListBased queue = new Queue_SinglyLinkedListBased();
            queue.enqueue(0);
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.enqueue(4);
            queue.enqueue(5);
            queue.enqueue(6);
            queue.enqueue(7);
            queue.enqueue(8);
            System.out.println("The current size of the queue is " + queue.size());
            try {
                System.out.println("Dequeued " + queue.dequeue());
                System.out.println("Dequeued " + queue.dequeue());
                System.out.println("Dequeued " + queue.dequeue());
                System.out.println("Dequeued " + queue.dequeue());
                System.out.println("Dequeued " + queue.dequeue());
                System.out.println("The current front of the queue is " + queue.front());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
