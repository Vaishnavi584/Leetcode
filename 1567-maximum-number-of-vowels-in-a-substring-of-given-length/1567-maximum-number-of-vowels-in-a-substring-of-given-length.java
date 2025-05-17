class Solution {
    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        int currentCount = 0;
        
        // Check if a character is a vowel
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        // Count vowels in the first window
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                currentCount++;
            }
        }
        maxVowels = currentCount;

        // Slide the window
        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                currentCount++;
            }
            if (vowels.contains(s.charAt(i - k))) {
                currentCount--;
            }
            maxVowels = Math.max(maxVowels, currentCount);
        }
        
        return maxVowels;
    }
}
