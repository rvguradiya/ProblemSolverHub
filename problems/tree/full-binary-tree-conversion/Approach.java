class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

public class Approach {

    // Method to convert the binary tree to a full binary tree
    public static TreeNode convertToFullBinaryTree(TreeNode node) {
        TreeNode tempL = null, tempR = null, temp = null;
        if (node.left == null && node.right == null) {
            return node;
        }
        if (node.left != null) {
            tempL = convertToFullBinaryTree(node.left);
        }
        if (node.right != null) {
            tempR = convertToFullBinaryTree(node.right);
        }
        if (node.left != null && node.right != null) {
            node.left = tempL;
            node.right = tempR;
            return node;
        }
        return tempL == null ? tempR : tempL;
    }

    // Method to print the tree in InOrder (used for testing)
    public static void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.value + " ");
        printInOrder(node.right);
    }

    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        System.out.println("Original Binary Tree (InOrder):");
        printInOrder(root);
        System.out.println();

        // Convert to full binary tree
        TreeNode fullTree = convertToFullBinaryTree(root);

        System.out.println("Full Binary Tree (InOrder):");
        printInOrder(fullTree);
        System.out.println();
    }
}
