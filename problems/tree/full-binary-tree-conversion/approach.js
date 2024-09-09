class TreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

// Method to convert the binary tree to a full binary tree
function convertToFullBinaryTree(node) {
  let tempL = null,
    tempR = null;

  // If the node is a leaf node, return it
  if (node.left === null && node.right === null) {
    return node;
  }

  // Recursively process the left and right subtrees
  if (node.left !== null) {
    tempL = convertToFullBinaryTree(node.left);
  }
  if (node.right !== null) {
    tempR = convertToFullBinaryTree(node.right);
  }

  // If the node has two children, keep the node
  if (node.left !== null && node.right !== null) {
    node.left = tempL;
    node.right = tempR;
    return node;
  }

  // If the node has only one child, return the non-null child
  return tempL === null ? tempR : tempL;
}

// Method to print the tree in InOrder (used for testing)
function printInOrder(node) {
  if (node === null) return;

  printInOrder(node.left);
  process.stdout.write(node.value + " ");
  printInOrder(node.right);
}

// Main function to test the functionality
function main() {
  // Construct the binary tree
  let root = new TreeNode(0);
  root.left = new TreeNode(1);
  root.right = new TreeNode(2);
  root.left.left = new TreeNode(3);
  root.left.left.right = new TreeNode(5);
  root.right.right = new TreeNode(4);
  root.right.right.left = new TreeNode(6);
  root.right.right.right = new TreeNode(7);

  console.log("Original Binary Tree (InOrder):");
  printInOrder(root);
  console.log();

  // Convert to full binary tree
  let fullTree = convertToFullBinaryTree(root);

  console.log("Full Binary Tree (InOrder):");
  printInOrder(fullTree);
  console.log();
}

main();
