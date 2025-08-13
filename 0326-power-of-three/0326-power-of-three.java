class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false; // No powers of 3 for zero or negatives
        
        for (int i = 0; Math.pow(3, i) <= n; i++) {
            if (n == (int) Math.pow(3, i)) {
                return true;
            }
        }
        return false;
    }
}
