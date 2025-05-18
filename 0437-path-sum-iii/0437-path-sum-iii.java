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
    long targetSum;
    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = (long)targetSum;
        if(root == null){
            return 0;
        }
        
        int curr = helper(root, 0);


        int left = pathSum(root.left, targetSum);
        int right = pathSum(root.right, targetSum);

        return curr + left + right;
    }

    int helper(TreeNode root, long currSum){
        int curr = 0;
        if(root == null){
            return curr;
        }
        
        long newSum = currSum + root.val;
       
        if(newSum == targetSum){
            curr = 1;
        }

        int left = helper(root.left, newSum);
        int right = helper(root.right, newSum);

        return curr + left + right;
    }
}