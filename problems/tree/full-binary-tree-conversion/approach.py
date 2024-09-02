class TreeNode:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

# Method to convert the binary tree to a full binary tree
def convert_to_full_binary_tree(node):
    tempL = None
    tempR = None

    # If the node is a leaf node, return it
    if node.left is None and node.right is None:
        return node

    # Recursively process the left and right subtrees
    if node.left is not None:
        tempL = convert_to_full_binary_tree(node.left)
    if node.right is not None:
        tempR = convert_to_full_binary_tree(node.right)

    # If the node has two children, keep the node
    if node.left is not None and node.right is not None:
        node.left = tempL
        node.right = tempR
        return node

    # If the node has only one child, return the non-null child
    return tempL if tempL is not None else tempR

# Method to print the tree in InOrder (used for testing)
def print_in_order(node):
    if node is None:
        return
    print_in_order(node.left)
    print(node.value, end=" ")
    print_in_order(node.right)

# Main function to test the functionality
def main():
    # Construct the binary tree
    root = TreeNode(0)
    root.left = TreeNode(1)
    root.right = TreeNode(2)
    root.left.left = TreeNode(3)
    root.left.left.right = TreeNode(5)
    root.right.right = TreeNode(4)
    root.right.right.left = TreeNode(6)
    root.right.right.right = TreeNode(7)

    print("Original Binary Tree (InOrder):")
    print_in_order(root)
    print()

    # Convert to full binary tree
    full_tree = convert_to_full_binary_tree(root)

    print("Full Binary Tree (InOrder):")
    print_in_order(full_tree)
    print()

if __name__ == "__main__":
    main()
