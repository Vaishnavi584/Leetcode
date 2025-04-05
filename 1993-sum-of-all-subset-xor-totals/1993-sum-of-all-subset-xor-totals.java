class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }

    private int helper(int[] nums, int index, int currentXOR) {
        if (index == nums.length) {
            return currentXOR;
        }
        return helper(nums, index + 1, currentXOR ^ nums[index]) + helper(nums, index + 1, currentXOR);
    }
}
