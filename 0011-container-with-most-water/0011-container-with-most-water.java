class Solution {
    public int maxArea(int[] height) {
        int MaximumWaterStored = Integer.MIN_VALUE;
        int i = 0, j = height.length - 1;
        
        while (i < j) {
            int width = j - i;
            int minHeight = Math.min(height[i], height[j]);
            int currentWater = minHeight * width;
            MaximumWaterStored = Math.max(MaximumWaterStored, currentWater);
            
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return MaximumWaterStored;
    }
}