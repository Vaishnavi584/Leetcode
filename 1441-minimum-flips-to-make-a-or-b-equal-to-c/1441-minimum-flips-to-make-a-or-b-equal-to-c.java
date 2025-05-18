class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        for(int i=0;i<32;i++){
            int aCurr = a & 1 , bCurr = b & 1 , cCurr = c & 1;
           a = a>>1;
           b = b>>1;
           c = c>>1;
            if((aCurr|bCurr) != cCurr){
                if(aCurr == 1 && bCurr == 1) count++;
                count++;
            }
        }
        return count;
    }
}