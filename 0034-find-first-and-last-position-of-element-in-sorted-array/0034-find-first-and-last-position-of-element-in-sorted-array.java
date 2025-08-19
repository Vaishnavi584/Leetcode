class Solution {
    public int[] searchRange(int[] nums, int target) {

        int first = binarysearch(nums,target,true);
        int second = binarysearch(nums,target,false);
        int []ans={first,second};
        return ans;
        
    }
    static int binarysearch(int[]arr,int target,boolean first){
        int s=0;
        int e=arr.length-1;
        int ans=-1;
        while(s<=e){
            int mid= s+(e-s)/2;
            if(arr[mid]>target){
                e=mid-1;
            }
            if(arr[mid]<target){
                s=mid+1;
            }
            if(arr[mid]==target){
                ans=mid;
                if(first){
                    e=mid-1;
                }
                else{
                    s=mid+1;
                }
            }
        }
        return ans;
    }
}