public class Stack {

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }


        private Node top;
        private int size;

        // Constructor
        public Stack() {
            this.top = null;
            this.size = 0;
        }

        // Push a value onto the stack
        public void push(int value) {
            Node newNode = new Node(value);
            newNode.next = top;
            top = newNode;
            size++;
        }

        // Pop a value off the stack
        public int pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty!");
            }
            int poppedValue = top.value;
            top = top.next;
            size--;
            return poppedValue;
        }

        // Check if the stack is empty
        public boolean isEmpty() {
            return top == null;
        }

        // Peek the top value of the stack without removing it
        public int peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty!");
            }
            return top.value;
        }

        // String representation of the stack
        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("Stack: ");
            Node current = top;
            while (current != null) {
                result.append(current.value).append(" -> ");
                current = current.next;
            }
            return result.append("null").toString();
        }

        // Example Usage
        public static void main(String[] args) {
            Stack stack = new Stack();
            stack.push(10);
            stack.push(20);
            stack.push(30);
            System.out.println(stack); // Stack: 30 -> 20 -> 10 -> null
            System.out.println(stack.pop()); // 30
            System.out.println(stack); // Stack: 20 -> 10 -> null
            System.out.println(stack.peek()); // 20
        }



}
