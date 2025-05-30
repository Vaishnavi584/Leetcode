class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        // [temperature, index]

        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                int[] curr = stack.pop();
                ans[curr[1]] = i - curr[1];
            }
            stack.push(new int[] {temperatures[i], i});
        }
        return ans;
    }
} 