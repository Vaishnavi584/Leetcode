import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        // Step 1: Count frequency of each number
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Store frequencies in a set and check for duplicates
        Set<Integer> freqSet = new HashSet<>();
        for (int freq : freqMap.values()) {
            if (!freqSet.add(freq)) {
                return false; // Duplicate frequency found
            }
        }

        return true; // All frequencies are unique
    }
}
