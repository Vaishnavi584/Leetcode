class Solution {
    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];

        for(int i=0; i<boxes.length(); i++){
            char curr= boxes.charAt(i);
            if(curr=='1') {
                for(int j=0; j<ans.length; j++){
                    ans[j] += Math.abs(j-i);
                }
            }
        }

        return ans;
    }
}