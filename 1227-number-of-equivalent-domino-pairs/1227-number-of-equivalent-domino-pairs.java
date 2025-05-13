class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];
        int res = 0;
        for (int[] d : dominoes) {
            int key = d[0] < d[1] ? d[0] * 10 + d[1] : d[1] * 10 + d[0];
            res += count[key];
            count[key]++;
        }
        return res;
    }
}
