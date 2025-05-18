class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxSum = Integer.MIN_VALUE, levelCount = 0, smallest_level = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();

                levelSum += currNode.val;

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }

            levelCount++;

            if (levelSum > maxSum) {
                maxSum = levelSum;
                smallest_level = levelCount;
            }
        }

        return smallest_level;
    }
}