class Solution {
    public String reverseWords(String s) {
        String a=s.trim();
        String [] arr = a.split("\\s+");
        String ans ="";
        for(int i = arr.length-1; i>=0;i--){
            ans=ans+""+arr[i];
            if(i!=0){
            ans=ans+" ";
            }
        }
        return ans;

    }
}