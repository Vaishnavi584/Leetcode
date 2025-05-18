class Solution {
    public boolean isSubsequence(String s, String t) {
        return isSub(0, 0, s, t);
    }

    private boolean isSub(int i, int j, String s, String t) {
        if (i == s.length()) return true;
        if (j == t.length()) return false;

        if (s.charAt(i) == t.charAt(j)) {
            return isSub(i + 1, j + 1, s, t);  
        } else {
            return isSub(i, j + 1, s, t);      
        }
    }
}