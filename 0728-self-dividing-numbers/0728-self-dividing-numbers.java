class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (selfDividing(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean selfDividing(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        for (char c : arr) {
            int digit = c - '0';
            if (digit == 0 || num % digit != 0) {
                return false;
            }
        }
        return true;
    }
}