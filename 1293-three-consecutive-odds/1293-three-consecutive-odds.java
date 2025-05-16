class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;  // To count consecutive odd numbers
        
        for (int num : arr) {
            if (num % 2 != 0) {  // Check if odd
                count++;
                if (count == 3) {
                    return true;  // Found 3 consecutive odds
                }
            } else {
                count = 0;  // Reset count if number is even
            }
        }
        
        return false;  // No three consecutive odds found
    }
}
