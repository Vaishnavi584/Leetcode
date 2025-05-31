

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // First, mark the presence of numbers using signs
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // Calculate the index (Remember, numbers are 1-based, indices are 0-based)
            if (nums[index] > 0) {  // If the element is positive, it means we haven't seen the number yet
                nums[index] = -nums[index]; // Flip the sign to indicate presence
            }
        }

        // Second, find the missing numbers (positive elements)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);  // If nums[i] is positive, i+1 is missing
            }
        }

        return result;
    }
}