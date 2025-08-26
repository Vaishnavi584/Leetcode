class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int left=0;
        int max=0;
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            while(set.contains(c)){
                 set.remove(s.charAt(left));
                 left++;
            }
           set.add(c);
           max=Math.max(max,right-left+1);
        }
        return max;
        
    }
}