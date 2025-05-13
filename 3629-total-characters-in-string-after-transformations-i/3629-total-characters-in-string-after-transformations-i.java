class Solution {
    public int lengthAfterTransformations(String s, int t) {
        final int MOD = 1_000_000_007;
        long[] freq = new long[26];
        
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int step = 0; step < t; step++) {
            long[] nextFreq = new long[26];
            for (int i = 0; i < 26; i++) {
                if (freq[i] == 0) continue;
                if (i == 25) {
                    nextFreq[0] = (nextFreq[0] + freq[i]) % MOD;
                    nextFreq[1] = (nextFreq[1] + freq[i]) % MOD;
                } else {
                    nextFreq[i + 1] = (nextFreq[i + 1] + freq[i]) % MOD;
                }
            }
            freq = nextFreq;
        }

        long result = 0;
        for (int i = 0; i < 26; i++) {
            result = (result + freq[i]) % MOD;
        }

        return (int) result;
    }
}
