/*
@author: Duc Nguyen
This is a program demonstrate the implementation of a double stack in a fixed array type (Java)
Check out the pseudo codes and analysis of this implementation at writtenPart.pdf
 */

public class doubleStack {
    /*
    Case 1:
    Fixed size stack implementation
     */
    private static class fixedStacks<T> {
        private T[] array;
        private int capacity;
        private int stack1Max, stack2Max;
        private int headStack1, headStack2;

        public fixedStacks(int capacity, int stack1Max, int stack2Max) {
            array = (T[])new Object[capacity];
            this.capacity = capacity;
            this.stack1Max = stack1Max;
            this.stack2Max = stack2Max;
            setHead();
        }

        public void setHead() {
            headStack1 = -1;
            headStack2 = capacity;
        }

        public T[] getArray() {
            return array;
        }

        public int getCapacity() {
            return capacity;
        }

        public int getHeadStack1() {
            return headStack1;
        }

        public int getHeadStack2() {
            return headStack2;
        }

        public T getElement(int index) throws IndexOutOfBoundsException {
            if(index >= capacity || index < 0) {
                throw new IndexOutOfBoundsException("getElement");
            } else {
                return array[index];
            }
        }

        public void pushStack1(T element) throws FullStackException {
            if (!isStack1Full()) {
                headStack1++;
                array[headStack1] = element;
            } else {
                throw new FullStackException("pushStack1");
            }
        }

        public void pushStack2(T element) throws FullStackException {
            if(!isStack2Full()) {
                headStack2--;
                array[headStack2] = element;
            } else {
                throw new FullStackException("pushStack2");
            }
        }

        public T popStack1() throws EmptyStackException {
            if(!isStack1Empty()) {
                T temp = array[headStack1];
                array[headStack1] = null;
                headStack1--;
                return  temp;
            } else {
                throw new EmptyStackException("popStack1");
            }
        }

        public T popStack2() throws EmptyStackException {
            if(!isStack2Empty()) {
                T temp = array[headStack2];
                array[headStack2] = null;
                headStack2++;
                return temp;
            } else {
                throw new EmptyStackException("popStack2");
            }
        }

        public int sizeStack1() { return headStack1 + 1; }

        public int sizeStack2() { return capacity - headStack2; }

        public boolean isStack1Empty() {return (headStack1 == -1);}

        public boolean isStack2Empty() {return (headStack2 == capacity);}

        public boolean isStack1Full() {return (headStack1 + 1== stack1Max); }

        public boolean isStack2Full() {return (capacity- headStack2 == stack2Max);}

        public void printStack1() throws EmptyStackException {
            if (!isStack1Empty()) {
                for(int i = 0; i <= headStack1; i++) {
                    System.out.print(array[i] + " || ");
                }
                System.out.println();
            }
            else {
                throw new EmptyStackException("printStack1");
            }
        }

        public void printStack2() throws EmptyStackException{
            if(!isStack2Empty()) {
                for(int i = headStack2; i<capacity; i++) {
                    System.out.print(array[i] + " || ");
                }
                System.out.println();
            } else {
                throw new EmptyStackException("printStack2");
            }
        }

    }

    ////////////////////////////////////////////////////////
    /*
   Case 2:
   Allocatable size stack implementation -> Optimize memory for purpose.
    */
    private static class allocatableStacks<T> {
        private T[] array;
        private int capacity;
        private int headStack1, headStack2;

        public allocatableStacks(int capacity) {
            this.array = (T[])new Object[capacity];
            this.capacity= capacity;
            setHead();
        }

        public void setHead() {
            headStack1 = -1;
            headStack2 = capacity;
        }

        public T[] getArray() {
            return array;
        }

        public T getElement(int index) throws IndexOutOfBoundsException{
            if (index >= capacity) {
                throw new IndexOutOfBoundsException("Index " + index + " does not exist");
            }
            return array[index];
        }

        public void pushStack1(T element) throws FullStackException {
            if (!isFull()) {
                headStack1++;
                array[headStack1] = element;
            } else {
                throw new FullStackException("pushStack1");
            }
        }

        public void pushStack2(T element) throws FullStackException {
            if (!isFull()) {
                headStack2--;
                array[headStack2] = element;
            } else {
                throw new FullStackException("pushStack2");
            }
        }

        public T popStack1() throws EmptyStackException {
            if (!isStack1Empty()) {
                T temp = array[headStack1];
                array[headStack1] = null;
                headStack1--;
                return temp;
            } else {
                throw new EmptyStackException("popStack1");
            }
        }

        public T popStack2() throws EmptyStackException {
            if(!isStack2Empty()) {
                T temp = array[headStack2];
                array[headStack2] = null;
                headStack2++;
                return temp;
            } else {
                throw new EmptyStackException("popStack2");
            }
        }

        private int sizeStack1() {
            return headStack1 + 1;
        }

        private int sizeStack2() {
            return capacity - headStack2;
        }

        private boolean isStack1Empty() {
            return (headStack1 == -1);
        }

        private boolean isStack2Empty() {
            return (headStack2 == capacity);
        }

        // When the size of stack is allocatable, the only time a stack is full is when the array is full itself
        private boolean isFull() {
            return (headStack1 + 1 == headStack2);
        }

        public void printStack1() throws EmptyStackException {
            if (!isStack1Empty()) {
                for(int i = 0; i <= headStack1; i++) {
                    System.out.print(array[i] + " || ");
                }
                System.out.println();
            }
            else {
                throw new EmptyStackException("printStack1");
            }
        }

        public void printStack2() throws EmptyStackException{
            if(!isStack2Empty()) {
                for(int i = headStack2; i<capacity; i++) {
                    System.out.print(array[i] + " || ");
                }
                System.out.println();
            } else {
                throw new EmptyStackException("printStack2");
            }
        }
    }

// Exception classes
    public static class FullStackException extends Exception {
        private String message;
        public FullStackException(String operation) {
            String message = ("The stack is full. Cannot perform " + operation);
            this.message = message;
        }

        @Override
        public String getMessage(){
            return message;
        }
    }

    public static class EmptyStackException extends Exception {
        private String message;
        public EmptyStackException(String operation) {
            String message = ("The stack is empty. Cannot perform " + operation);
            this.message = message;
        }

        @Override
        public String getMessage(){
            return message;
        }
    }
// --------------

    //Testing examples for the implementation
    public static void main(String[] args) {
        //Initiate
        fixedStacks<Integer> test1 = new fixedStacks<Integer>(10, 3, 4);
        allocatableStacks<Integer> test2= new allocatableStacks<Integer>(6);

        //Start testing:
        System.out.println("Start testing with fixed-size double stack implementation");
        try {
            test1.pushStack1(0);
            test1.pushStack1(1);
            test1.pushStack1(2);
            System.out.println("Added elements to stack 1. Printing stack 1");
            test1.printStack1();
            System.out.println("Stack 1 full: " + test1.isStack1Full());

            test1.pushStack2(10);
            test1.pushStack2(9);
            test1.pushStack2(8);
            System.out.println("Added elements to stack 2. Printing stack 2");
            test1.printStack2();
            System.out.println("Stack 2 full: " + test1.isStack2Full());

            int temp =test1.popStack1();
            System.out.println("Popped 1 element out of stack 1, popped element: " + temp);
            test1.printStack1();

            temp = test1.popStack2();
            System.out.println("Popped 1 element out of stack 2, popped element: " + temp);
            test1.printStack2();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("////////////////////////////////////////////////");

        System.out.println("Start testing with allocatable double stack implementation");
        try {
            test2.pushStack1(0);
            test2.pushStack1(1);
            test2.pushStack1(2);
            System.out.println("Added elements to stack 1. Printing stack 1");
            test2.printStack1();
            System.out.println("Stack 1 full: " + test1.isStack1Full());

            test2.pushStack2(10);
            test2.pushStack2(9);
            test2.pushStack2(8);
            System.out.println("Added elements to stack 2. Printing stack 2");
            test2.printStack2();
            System.out.println("Stack 2 full: " + test1.isStack2Full());

            int temp =test2.popStack1();
            System.out.println("Popped 1 element out of stack 1, popped element: " + temp);
            test2.printStack1();

            temp = test2.popStack2();
            System.out.println("Popped 1 element out of stack 2, popped element: " + temp);
            test2.printStack2();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
