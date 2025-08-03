class Solution {
    static int ans=0;
     public int numberOfSteps(int num) {
        ans = 0; // ✅ Reset before starting
        return helper(num);
    }

    public int helper(int num) {
        
         if(num>0){
         if(even(num)){
              num=num/2;
              ans++;
              return helper(num);
              
         }
         else{
            ans++;
            num=num-1;
            return helper(num);
         }
        }
         return ans;
    }
    static boolean even(int num){
        if(num%2==0){
            return true;
        }
        return false;
    }
    
    
}



        
       