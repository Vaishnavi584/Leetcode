class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
     for(int arr : nums){
         ans ^= arr; 
     }   
     return ans;
    }
}