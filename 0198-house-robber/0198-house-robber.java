class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);

        // return topDown(nums.length-1, nums);
        // return memo(nums.length-1, nums, dp);
        // return tabulation(nums.length-1, nums, dp);
        return spaceOpt(nums.length-1, nums);        
    }

    // Recursion (Top-Down approach without memoization)
    public int topDown(int n, int nums[]) {
        if (n < 0) return 0;
        if (n == 0) return nums[n];

        int take = nums[n] + topDown(n - 2, nums);
        int notTake = 0 + topDown(n - 1, nums);

        return Math.max(take, notTake); 
    }

    // Memoization (Top-Down DP with caching)
    public int memo(int n, int nums[], int dp[]) {
        if (n < 0) return 0;
        if (n == 0) return nums[n];
        if (dp[n] != -1) return dp[n];

        int take = nums[n] + memo(n - 2, nums, dp);
        int notTake = 0 + memo(n - 1, nums, dp);

        return dp[n] = Math.max(take, notTake);
    }

    // Tabulation (Bottom-Up DP)
    public int tabulation(int n, int nums[], int dp[]) {
        dp[0] = nums[0];

        for (int i = 1; i <= n; i++) {
            int take = nums[i];
            if (i > 1) take += dp[i - 2];
            int notTake = dp[i - 1];

            dp[i] = Math.max(take, notTake);            
        }
        return dp[n];
    }

    // Space Optimization (Only using two variables)
    public int spaceOpt(int n, int nums[]) {
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i <= n; i++) {
            int take = nums[i];
            if (i > 1) take += prev2;
            int notTake = prev;

            int currMax = Math.max(take, notTake);
            prev2 = prev;
            prev = currMax;
        }
        return prev;
    }
}