class Solution {
    public int majorityElement(int[] nums) {
        int ans=0;
        for(int i =0;i<nums.length;i++){
            int count =0;
            for(int j =i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            if(count +1 > (int) (nums.length/2)){
                ans=nums[i];
                
            }
        }
        return ans;
        
    }
}