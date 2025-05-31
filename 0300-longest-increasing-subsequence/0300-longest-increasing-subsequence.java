

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        
        for (int num : nums) {
            int pos = Collections.binarySearch(sub, num);
            if (pos < 0) pos = -(pos + 1); // Convert negative index to insertion point
            
            if (pos == sub.size()) {
                sub.add(num); // Extend the sequence
            } else {
                sub.set(pos, num); // Replace element to maintain the smallest possible LIS
            }
        }
        
        return sub.size(); // Length of LIS
    }
}
