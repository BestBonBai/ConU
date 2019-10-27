/*
Queue implementation by doubling strategy growable circular array-based .
 */

public class Queue_ArrayBased<E> {
    private E[] queue ;
    private int front = 0, rear = 0;

    public Queue_ArrayBased(E[] queue ) {
        this.queue = queue ;
    }

    public Queue_ArrayBased(int length) {
        this.queue = (E[])new Object[length];
    }

    private void enqueue(E element) {
        if(size() == queue .length - 1) {
            E[] newArray = (E[])new Object[2*queue .length];
            System.arraycopy(queue , 0, newArray, 0, queue.length);

            queue = newArray;
            queue[rear] = element;
            rear = (rear+1)% queue .length;
        }
        else {
            queue [rear] = element;
            rear = (rear+1)% queue .length;
        }
    }

    private E dequeue() throws EmptyQueueException {
        if(!isEmpty()) {
            E temp = queue[front];
            queue[front] = null;
            front = (front + 1) % queue.length;
            return temp;
        } else {
            throw new EmptyQueueException();
        }
    }

    private E front() throws EmptyQueueException  {
        if(!isEmpty()) {
            return queue[front];
        } else {
            throw new EmptyQueueException();
        }
    }

    private int size(){ return ((queue .length - front) + rear) % queue .length;}

    private int sizeArray() {return queue.length;}

    private boolean isEmpty() { return (front == rear);}

    //TEST EXAMPLES
    public static void main(String[] args) {
        Queue_ArrayBased<Integer> test = new Queue_ArrayBased<Integer>(4);
        test.enqueue(0);
        test.enqueue(1);
        test.enqueue(2);
        test.enqueue(3);
        test.enqueue(4);
        test.enqueue(5);
        System.out.println("Current size of the queue is " + test.size());
        System.out.println("Current size of the array is " + test.sizeArray());
        try {
            System.out.println("Dequeued " + test.dequeue());
            System.out.println("Dequeued " + test.dequeue());
            System.out.println("Dequeued " + test.dequeue());
            System.out.println("Dequeued " + test.dequeue());
            System.out.println("Top element now is " + test.front());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
