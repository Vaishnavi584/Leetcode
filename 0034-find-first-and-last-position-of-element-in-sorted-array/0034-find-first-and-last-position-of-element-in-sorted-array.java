class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans []={-1,-1};
        int first = search(nums , target , true);
        int last = search(nums, target , false);
        ans[0]=first;
        ans [1]=last;

        return ans;
         
        
    }
    public int search (int []nums , int target , boolean isfirstoccurance){
        int s=0;
        int ans=-1;
        int e = nums.length-1;
        while(s<=e){
            int mid= s+(e-s)/2;
            if(nums[mid]>target){
                e=mid-1;
            }else if(nums[mid]<target){
                s=mid+1;
            }else{
                ans=mid;
                if(isfirstoccurance){
                    e=mid-1;
                }else{
                    s=mid+1;
                }

            }
        }
        return ans;

    }
}