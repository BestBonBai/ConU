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

    public Node pop() {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
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
        int count = 0;
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
        inventory.push(5);
        inventory.pop();
        inventory.push(6);
        inventory.push(7);
        inventory.push(2);
        System.out.println("Popped out " + inventory.getValue(inventory.pop()));
        inventory.push(3);
        if(!inventory.isEmpty()) {
            System.out.println("The size of the inventory is " + inventory.size());
            System.out.println("The maximum value in inventory is " +inventory.maxValue());
        }
    }
}

