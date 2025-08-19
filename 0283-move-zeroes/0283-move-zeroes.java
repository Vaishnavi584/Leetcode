class Solution {
    public void moveZeroes(int[] nums) {
        int i =0;
        for(int j =1;j<nums.length; j++){
            if(nums[i]==0 && nums[j]!=0){
                int temp =nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
            }
            if(nums[i]==0 && nums[j]==0){
                i=i+0;

            }
            if(nums[i]!=0 && nums[j]!=0){
                i++;
            }
            if(nums[i]!=0 && nums[j]==0){
                i++;
            }
        }
        
    }
}