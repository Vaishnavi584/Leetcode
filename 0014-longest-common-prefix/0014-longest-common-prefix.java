class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        Arrays.sort(strs);
        String first = strs[0];
        String last =strs[strs.length-1];
        String ans="";
        for(int i = 0 ; i < first.length();i++){
                if(first.charAt(i)==last.charAt(i)){
                    ans=ans+""+first.charAt(i);
                }
                else {
                break; 
            }
        }
        return ans;
    }
}