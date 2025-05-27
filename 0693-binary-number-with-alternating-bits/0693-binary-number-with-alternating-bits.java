class Solution {
    public boolean hasAlternatingBits(int n) {
        int count=0;
        int prev=(n&1);
        n=n>>1;
        while(n>0){
            if(count%2==0&&(n&1)==prev){
                return false;
            }

            if(count%2!=0&&(n&1)!=prev){
                return false;
            }

            n>>=1;

            count++;
        }
        return true;
    }
}