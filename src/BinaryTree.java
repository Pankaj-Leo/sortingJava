import java.util.LinkedList;
import java.util.Queue;



    public class BinaryTree {
        static class Node {
            int data;
            Node left;
            Node right;

            Node(int data) {
                this.data = data;
                this.left = null;
                this.right = null;
            }
        }

        static class BinaryTreeBuilder {
            static int idx = -1;

            public static Node buildTree(int[] nodes) {
                idx++;
                if (nodes[idx] == -1) {
                    return null;
                }
                Node newNode = new Node(nodes[idx]);
                newNode.left = buildTree(nodes);
                newNode.right = buildTree(nodes);
                return newNode;
            }
        }

        // Preorder Traversal
        public static void preorder(Node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        // Inorder Traversal
        public static void inorder(Node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // Postorder Traversal
        public static void postorder(Node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
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

        // Height of Tree
        public static int height(Node root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }

        // Count of Nodes
        public static int countOfNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int leftNodes = countOfNodes(root.left);
            int rightNodes = countOfNodes(root.right);
            return leftNodes + rightNodes + 1;
        }

        // Sum of Nodes
        public static int sumOfNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);
            return leftSum + rightSum + root.data;
        }

        // Diameter of Tree - O(N^2)
        public static int diameter(Node root) {
            if (root == null) {
                return 0;
            }
            int diam1 = height(root.left) + height(root.right) + 1;
            int diam2 = diameter(root.left);
            int diam3 = diameter(root.right);
            return Math.max(diam1, Math.max(diam2, diam3));
        }

        // Diameter of Tree - O(N)
        static class TreeInfo {
            int height;
            int diam;

            TreeInfo(int height, int diam) {
                this.height = height;
                this.diam = diam;
            }
        }

        public static TreeInfo diameterOptimized(Node root) {
            if (root == null) {
                return new TreeInfo(0, 0);
            }
            TreeInfo leftTI = diameterOptimized(root.left);
            TreeInfo rightTI = diameterOptimized(root.right);
            int myHeight = Math.max(leftTI.height, rightTI.height) + 1;
            int diam1 = leftTI.height + rightTI.height + 1;
            int diam2 = leftTI.diam;
            int diam3 = rightTI.diam;
            int myDiam = Math.max(diam1, Math.max(diam2, diam3));
            return new TreeInfo(myHeight, myDiam);
        }

        // Subtree of Another Tree
        public boolean isIdentical(Node root, Node subRoot) {
            if (subRoot == null && root == null) {
                return true;
            }
            if (root == null || subRoot == null) {
                return false;
            }
            if (root.data == subRoot.data) {
                return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
            }
            return false;
        }

        public boolean isSubtree(Node root, Node subRoot) {
            if (subRoot == null) {
                return true;
            }
            if (root == null) {
                return false;
            }
            if (isIdentical(root, subRoot)) {
                return true;
            }
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        public static void main(String[] args) {
            int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
            BinaryTreeBuilder treeBuilder = new BinaryTreeBuilder();
            Node root = treeBuilder.buildTree(nodes);

            System.out.println("Preorder Traversal:");
            preorder(root);

            System.out.println("\nInorder Traversal:");
            inorder(root);

            System.out.println("\nPostorder Traversal:");
            postorder(root);

            System.out.println("\nLevel Order Traversal:");
            levelOrder(root);

            System.out.println("Height of Tree: " + height(root));
            System.out.println("Count of Nodes: " + countOfNodes(root));
            System.out.println("Sum of Nodes: " + sumOfNodes(root));
            System.out.println("Diameter of Tree (O(N^2)): " + diameter(root));
            System.out.println("Diameter of Tree (O(N)): " + diameterOptimized(root).diam);
        }
    }
