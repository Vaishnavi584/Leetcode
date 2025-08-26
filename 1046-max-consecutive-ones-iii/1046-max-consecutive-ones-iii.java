class Solution {
    public int longestOnes(int[] nums, int k) {
       int max=0;
       int left=0;
       int zero=0;
       for(int right =0;right<nums.length;right++){
        if(nums[right]==0){
            zero++;
        }
        if(zero<=k){
            int length = right-left+1;
            max=Math.max(max,length);
        }else{
            if(nums[left]==0){
                zero--;
            }
            left++;
        }
       }
       return max;
    }
}