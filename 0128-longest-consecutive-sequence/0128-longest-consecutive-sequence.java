class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        

        HashSet<Integer> set = new HashSet<>();
        for (int i : nums){
            set.add(i);
        }
        int count=0;
        int longest=1;
        
        for (int item : set){
            if(!(set.contains(item-1))){
                int current =item;
                count=1;
                while(set.contains(current+1)){
                    count++;
                    current++;
                }
                if(count>longest){
                    longest=count;
                }
            }
        }
        return longest;

    
    }
}