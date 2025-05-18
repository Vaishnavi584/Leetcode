/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> seq1 = new ArrayList<>();
        List<Integer> seq2 = new ArrayList<>();

        generateLeafSequence(root1, seq1);

        generateLeafSequence(root2, seq2);

        // Compare sequences
        if (seq1.size() != seq2.size())
            return false;

        for (int i = 0; i < seq1.size(); i++)
            if (!seq1.get(i).equals(seq2.get(i)))
                return false; // Fixed comparison

        return true;
    }

    private void generateLeafSequence(TreeNode root, List<Integer> sequence) {
        if (root == null)
            return;

        // Check if the current node is a leaf
        if (root.left == null && root.right == null) {
            sequence.add(root.val);
            return;
        }

        // Recursively traverse left and right subtrees
        generateLeafSequence(root.left, sequence);

        generateLeafSequence(root.right, sequence);
    }
}