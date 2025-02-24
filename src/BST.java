import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BST {
    // Insert a value into the BST
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Inorder Traversal (Left, Root, Right)
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Search for a value in the BST
    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    // Delete a node from the BST
    public static Node delete(Node root, int val) {
        if (root == null) {
            return null;
        }

        if (root.data > val) {
            root.left = delete(root.left, val);
        } else if (root.data < val) {
            root.right = delete(root.right, val);
        } else {
            // Case 1: Node has no children
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Node has one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Node has two children
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    // Helper method to find the inorder successor
    public static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Print all root-to-leaf paths
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.data);

        if (root.left == null && root.right == null) {
            printPath(path);
        } else {
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }

        path.remove(path.size() - 1);
    }

    // Helper method to print the path
    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    // Level Order Traversal
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] values = {5, 1, 3, 4, 2, 7};
        Node root = null;

        // Insert values into the BST
        for (int val : values) {
            root = insert(root, val);
        }

        // Inorder Traversal
        System.out.println("Inorder Traversal:");
        inorder(root);
        System.out.println();

        // Search for a value
        int key = 3;
        if (search(root, key)) {
            System.out.println(key + " is found in the BST.");
        } else {
            System.out.println(key + " is not found in the BST.");
        }

        // Delete a node
        System.out.println("Deleting node with value 3...");
        root = delete(root, 3);

        // Inorder Traversal after deletion
        System.out.println("Inorder Traversal after deletion:");
        inorder(root);
        System.out.println();

        // Print all root-to-leaf paths
        System.out.println("Root-to-Leaf Paths:");
        printRoot2Leaf(root, new ArrayList<>());

        // Level Order Traversal
        System.out.println("Level Order Traversal:");
        levelOrder(root);
    }
}