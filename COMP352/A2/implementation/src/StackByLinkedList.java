/*
This program serves as the demonstration of a stack implemented by Linked List
Moreover, this program serves as a tool to demonstrate that it is possible to have O(1) in getMax() method of stack
Check out pseudo code and detailed analysis in writtenPart.pdf
 */

public class StackByLinkedList{
    /*
    value holds the current value of the node.
    max holds the current max value of the whole stack
     */
    private class Node {
        double value, max;
        Node next;

        public Node(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        public double getMax() {
            return max;
        }

        public void setMax(double max) {
            this.max = max;
        }
    }

    private Node head;
    public void push(double value) {
        Node temp = new Node(value);
        if (head != null) {
            temp.setMax(Math.max(head.getMax(), value));
            temp.next = head;
            head = temp;
        }
        else {
            temp.setMax(value);
            head = temp;
        }
    }

    //Another way to push
    public void pushTrial(double value) {
        Node temp = new Node(value);
        temp.next = head;
        head = temp;
        if(temp.next == null) {
            temp.max = value;
        } else if(temp.next.getMax() < value) {
            temp.max = value;
        } else {
            temp.max = temp.next.max;
        }
    }

    public Node pop() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        head = head.next;
        return temp;
    }

    public double maxValue() {
        if (head == null) {
           return -1;
        }
        return head.getMax();
    }

    public int size() {
        if(head == null) {
            return 0;
        }
        Node index = head;
        int count = 1;
        while (index.next != null) {
            count++;
            index = index.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public double getValue(Node element) {
        return element.getValue();
    }
}

//TEST EXAMPLE
class antiqueDealer {
    public static void main(String[] args) {
        StackByLinkedList inventory = new StackByLinkedList();
        inventory.push(4);
        inventory.pop();
        System.out.println("The current size is " + inventory.size());
        inventory.push(6);
        inventory.push(7);
        System.out.println("Popped out " + inventory.getValue(inventory.pop()));
        inventory.push(15);
        if(!inventory.isEmpty()) {
            System.out.println("The size of the inventory is " + inventory.size());
            System.out.println("The maximum value in inventory is " +inventory.maxValue());
        }
    }
}

