class Solution {
    public boolean check(int[] nums) {
        int breakpoints =0;
        for(int i =0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]) breakpoints++;
        }
            if(nums[0]<nums[nums.length-1]) breakpoints ++;
            return breakpoints<=1;
        
    }
}