class Solution {
    public String largestOddNumber(String num) {
      int i=0;
      String c="";
      while(i<num.length()){
        if( (num.charAt(i)-'0')%2 ==1){
            c=num.substring(0,i+1);
        }
        i++;
      }
      return c;
    }
}