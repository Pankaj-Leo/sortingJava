public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

        public void append(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            length++;
        }

        public Integer pop() {
            if (tail == null) return null;
            Node popped = tail;
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            length--;
            return popped.value;
        }

        public void prepend(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            length++;
        }

        public Integer popFirst() {
            if (head == null) return null;
            Node popped = head;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            length--;
            return popped.value;
        }

        public Integer get(int index) {
            if (index < 0 || index >= length) return null;
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        }

        public boolean set(int index, int value) {
            if (index < 0 || index >= length) return false;
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.value = value;
            return true;
        }

        public boolean insert(int index, int value) {
            if (index < 0 || index > length) return false;
            if (index == 0) {
                prepend(value);
                return true;
            }
            if (index == length) {
                append(value);
                return true;
            }
            Node newNode = new Node(value);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
            length++;
            return true;
        }

        public boolean remove(int index) {
            if (index < 0 || index >= length) return false;
            if (index == 0) {
                popFirst();
                return true;
            }
            if (index == length - 1) {
                pop();
                return true;
            }
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            length--;
            return true;
        }

        public void printList() {
            Node current = head;
            while (current != null) {
                System.out.print(current.value + " <-> ");
                current = current.next;
            }
            System.out.println("null");
        }

    public void reverse() {
        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        temp = head;
        head = tail;
        tail = temp;
    }


    // Example Usage

    public static void main(String[] args) {
            DoublyLinkedList dll = new DoublyLinkedList();
            dll.append(1);
            dll.append(2);
            dll.append(3);
            dll.prepend(0);
            dll.insert(2, 1);
            dll.printList();
            dll.pop();
            dll.printList();
            dll.popFirst();
            dll.printList();
            dll.remove(1);
            dll.printList();
        }

}
