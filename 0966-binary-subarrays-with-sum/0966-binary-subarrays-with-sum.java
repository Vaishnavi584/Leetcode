class Solution {
    public int numSubarraysWithSum(int[] arr, int goal) {
      int count=0;
        for(int i = 0 ;i <arr.length ;i++){
            int sum=0;
            for(int j=i ;j<arr.length;j++){
                sum = sum+arr[j];
                if(sum==goal){
                    count++;
                }
            }
        }
        return count;
        
    }
}