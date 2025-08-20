class Solution {
    public String largestOddNumber(String num) {
        // Traverse from the end until we find an odd digit
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if ((c - '0') % 2 == 1) { // check if odd
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
