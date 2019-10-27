/*
Stack Abstract Data Type implementation by singly linked list
 */

import java.util.EmptyStackException;

public class Stack_SinglyLinkedListBased {
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

    private Node head;

    //ADD AT FIRST
    private void push(Object data) {
        if(isEmpty()) {
            head = new Node(data, null);
        } else {
            head = new Node(data, head);
        }
    }

    private Object pop() throws EmptyStackException {
        if(isEmpty()) {
            throw new EmptyStackException();
        } else {
            Object temp = head.getData();
            head = head.next;
            return temp;
        }
    }

    private Object peek() throws EmptyStackException {
        if(isEmpty()) {
            throw new EmptyStackException();
        } else {
            return head.getData();
        }
    }

    private boolean isEmpty() {
        return (head == null);
    }

    private int size() {
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

    private static class test{
        public static void main(String[] args) {
            Stack_SinglyLinkedListBased stack= new Stack_SinglyLinkedListBased();
            stack.push(0);
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
            stack.push(6);
            System.out.println("Current size of the stack is " + stack.size());
            try {
                System.out.println("Popped out " + stack.pop());
                System.out.println("Popped out " + stack.pop());
                System.out.println("Popped out " + stack.pop());
                System.out.println("Popped out " + stack.pop());
                System.out.println("Current peek is " + stack.peek());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }

}
