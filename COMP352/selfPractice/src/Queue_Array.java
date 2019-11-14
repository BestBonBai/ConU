/**
 * An implementation of Queue ADT by array with:
 * + Expandable capacity as enqueue requests coming
 * @author Duc Nguyen
 */
public class Queue_Array<E> implements Queue_Interface<E> {
    private int CAPACITY;
    private E[] queue ;
    private int front = 0, rear = 0;

    public Queue_Array() {
        this(100); //Default length for queue
    }

    public Queue_Array(int capacity) {
        this.CAPACITY = capacity;
        this.queue = (E[])new Object[capacity];
    }

    public void enqueue(E element) {
        if(size() == CAPACITY - 1) {
            E[] newArray = (E[])new Object[2*CAPACITY];
            System.arraycopy(queue , 0, newArray, 0, CAPACITY);

            queue = newArray;
            queue[rear] = element;
            rear = (rear+1)% CAPACITY;
        }
        else {
            queue [rear] = element;
            rear = (rear+1)% CAPACITY;
        }
    }

    public E dequeue() {
        if(!isEmpty()) {
            E temp = queue[front];
            queue[front] = null;
            front = (front + 1) % CAPACITY;
            return temp;
        } else {
            return null;
        }
    }

    public E front() {
        if(!isEmpty()) {
            return queue[front];
        } else {
            return null;
        }
    }

    public int size(){
        return ((CAPACITY - front) + rear) % CAPACITY;
    }

    private int sizeArray() {return CAPACITY;}

    public boolean isEmpty() { return (front == rear);}

}
