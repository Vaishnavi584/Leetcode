class Solution {
    public boolean isHappy(int n) {
       int slow=n;
        int fast=n;
        do{
            slow=sq(slow);
            fast=sq(sq(fast));
        }while(slow!=fast);
        if(slow==1){
            return true;
        }
        return false;
    }
    static int sq(int n){
        int rem=0;
        int sq=0;
        while(n>0){
            rem=n%10;
            sq=sq+(rem*rem);
            n=n/10;
        }
        return sq;
    }
}