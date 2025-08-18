class Solution {
    public int missingNumber(int[] nums) {
        int index=0;
        while(index<nums.length){
            if(nums[index] < nums.length && index != nums[index]){
             swap(nums,index,nums[index]);
            }else{
           index++;
            }
        }
        for(int i=0 ;i <  nums.length;i++){
            if(nums[i]!=i){
                return i;
            }
        }
        return nums.length;
        
    }
    public void swap(int [] arr , int a ,int b){
        int temp=arr[a];
        arr[a] =arr[b];
        arr[b] =temp;
    }
}