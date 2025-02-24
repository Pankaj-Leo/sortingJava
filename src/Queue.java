public class Queue {

    private Node front;
    private Node rear;
    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

    // Enqueue method to add an element to the rear
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {  // If the queue is empty
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Dequeue method to remove an element from the front
    public int dequeue() {
        if (front == null) {  // If the queue is empty
            System.out.println("Queue is empty");
            return -1;
        }
        int value = front.value;
        front = front.next;
        if (front == null) {  // If the queue becomes empty
            rear = null;
        }
        size--;
        return value;
    }

    // Peek method to return the front element without removing it
    public int peek() {
        if (front == null) {
            return -1;  // Indicating the queue is empty
        }
        return front.value;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Return the size of the queue
    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("Queue: ");
        Node current = front;
        while (current != null) {
            result.append(current.value).append(" -> ");
            current = current.next;
        }
        return result.append("null").toString();
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println(q);
        System.out.println("Dequeued: " + q.dequeue());  // Output: 10
        System.out.println(q);
        System.out.println("Front element: " + q.peek());  // Output: 20
        System.out.println(q);
        System.out.println("Queue size: " + q.size());  // Output: 2
    }
}