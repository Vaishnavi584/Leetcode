class Solution {
    public String removeOuterParentheses(String s) {
        int counter=0;
        String ans = "";
        for(int i =0 ;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(counter == 0){
                    counter ++;
                }
                else{
                    counter++;
                    if(counter>0){
                        ans =ans + s.charAt(i);
                    }
                }
            }
            else{
                counter--;
                if(counter>0){
                    ans = ans + s.charAt(i);

                }
            }
        }
        return ans;
        
    }
}