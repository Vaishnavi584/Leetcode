import java.util.*;

class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // Build edges only from i -> j where j > i
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (canConnect(words[i], words[j], groups[i], groups[j])) {
                    adj.get(i).add(j);
                }
            }
        }

        int[] dp = new int[n];
        int[] nextIndex = new int[n];
        Arrays.fill(dp, -1);
        Arrays.fill(nextIndex, -1);

        int maxLen = 0, start = 0;
        for (int i = 0; i < n; i++) {
            int len = dfs(i, adj, dp, nextIndex);
            if (len > maxLen) {
                maxLen = len;
                start = i;
            }
        }

        List<String> result = new ArrayList<>();
        int idx = start;
        while (idx != -1) {
            result.add(words[idx]);
            idx = nextIndex[idx];
        }
        return result;
    }

    private int dfs(int i, List<List<Integer>> adj, int[] dp, int[] nextIndex) {
        if (dp[i] != -1) return dp[i];
        int maxLen = 1;
        int next = -1;
        for (int nei : adj.get(i)) {
            int len = 1 + dfs(nei, adj, dp, nextIndex);
            if (len > maxLen) {
                maxLen = len;
                next = nei;
            }
        }
        dp[i] = maxLen;
        nextIndex[i] = next;
        return dp[i];
    }

    private boolean canConnect(String w1, String w2, int g1, int g2) {
        if (g1 == g2) return false;
        if (w1.length() != w2.length()) return false;
        int diffCount = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                diffCount++;
                if (diffCount > 1) return false;
            }
        }
        return diffCount == 1;
    }
}
