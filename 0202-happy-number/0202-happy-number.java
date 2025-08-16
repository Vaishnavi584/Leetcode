class Solution {
    public boolean isHappy(int n) {
        if(n==1){
            return true;
        }
        if(n==4){
            return false;
        }
        int rem=0;
        int sq=0;
        while(n>0){
            rem=n%10;
            sq=sq+rem*rem;
            n=n/10;
        }
        return isHappy(sq);
        
    }
}