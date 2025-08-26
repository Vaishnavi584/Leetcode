class Solution {
    public int numSubarraysWithSum(int[] arr, int goal) {
         if(goal < 0) return 0; 
     return count(arr,goal)-count(arr,goal-1);
        
    }
    static int count(int []arr,int goal){
        int sum=0;
        int count=0;
        int left=0;
        for(int right=0;right<arr.length;right++){
            sum=sum+arr[right];
            while(left <= right && sum >goal){
                sum-=arr[left];
                left++;
            }
            count=count+(right-left+1);
        }
        return count;
    }
}