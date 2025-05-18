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
    public static class Pair {
        int leftZigZag  = -1; // In terms of edges otherwise in terms of nodes it will be zero
        int rightZigZag = -1;
        int maxZigZag = -1;

        public Pair(int leftZigZag, int rightZigZag, int maxZigZag) {
            this.leftZigZag = leftZigZag;
            this.rightZigZag = rightZigZag;
            this.maxZigZag = maxZigZag;
        }
    }

    /**
     * Logic: The idea is to return three values from each node:
     * 1. The length of the longest zigzag path starting from the left child including the current node
     * 2. The length of the longest zigzag path starting from the right child including the current node
     * 3. The maximum length of the zigzag path found so far
     * The Answer is the maximum of all the three values returned from the root node.
     * @param root
     * @return
     */
    public Pair longestZigZag_(TreeNode root) {
        if (root == null)
            return new Pair(-1, -1, -1); // In terms of edges otherwise in terms of nodes it will be zero

        Pair left = longestZigZag_(root.left);
        Pair right = longestZigZag_(root.right);

        int leftZigZag = left.rightZigZag + 1;
        int rightZigZag = right.leftZigZag + 1;
        int maxZigZag = Math.max(left.maxZigZag, Math.max(right.maxZigZag, Math.max(leftZigZag, rightZigZag)));

        return new Pair(leftZigZag, rightZigZag, maxZigZag);
    }

    public int longestZigZag(TreeNode root) {
        Pair pair = longestZigZag_(root);
        return pair.maxZigZag;
    }
}