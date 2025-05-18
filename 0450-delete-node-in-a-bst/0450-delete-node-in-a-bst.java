class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // Base case: If the tree is empty
        if (root == null) {
            return null;
        }

        // Traverse the tree to find the node to delete
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node to delete found
            // Case 1: No children (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: One child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: Two children
            // find the inorder successor (smallest in the right subtree)
            TreeNode successor = findMin(root.right);
            // replace root's value with the successor's value
            root.val = successor.val;
            // delete the successor node
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }

    // helper function to find the minimum value node in a tree
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}