import java.util.*;

class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        
        // Step 1: Sort the array to group same numbers together
        Arrays.sort(nums);

        // Step 2: Store each unique number and its total value (number * frequency)
        List<int[]> distinctValues = new ArrayList<>();
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum += nums[i];
            // When the next number is different or it's the last element
            if (i + 1 == n || nums[i + 1] != nums[i]) {
                // Store the number and the sum of its occurrences
                distinctValues.add(new int[]{nums[i], currentSum});
                currentSum = 0; // Reset for the next number
            }
        }

        // Step 3: If there's only one unique number, return its total
        if (distinctValues.size() == 1) {
            return distinctValues.get(0)[1];
        }

        // Step 4: Initialize DP-like variables
        int prevToPrev = distinctValues.get(0)[1]; // max points if we take first number
        int prev;

        // Check if first two numbers are consecutive
        if (distinctValues.get(1)[0] - 1 != distinctValues.get(0)[0]) {
            // Not consecutive, so we can take both
            prev = distinctValues.get(0)[1] + distinctValues.get(1)[1];
        } else {
            // Consecutive, choose the max
            prev = Math.max(distinctValues.get(0)[1], distinctValues.get(1)[1]);
        }

        // Step 5: Loop through the rest of the elements
        for (int i = 2; i < distinctValues.size(); i++) {
            int currentVal = distinctValues.get(i)[0];
            int currentPoints = distinctValues.get(i)[1];

            int pick;
            // If current and previous are consecutive
            if (distinctValues.get(i - 1)[0] + 1 == currentVal) {
                // We can't take both, so add current to prevToPrev
                pick = currentPoints + prevToPrev;
            } else {
                // Not consecutive, safely add current to prev
                pick = currentPoints + prev;
            }

            int notPick = prev; // Skip current

            // Take the max of picking or not picking current
            int current = Math.max(pick, notPick);

            // Move window forward
            prevToPrev = prev;
            prev = current;
        }

        // Step 6: Return the final maximum points
        return prev;
    }
}