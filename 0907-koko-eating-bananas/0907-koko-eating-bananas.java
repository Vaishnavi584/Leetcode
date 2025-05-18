class Solution {
    /**
    


     */
    public int minEatingSpeed(int[] piles, int h) {

        //finds the max vaule in piles, which will be used for our end point in our binary search
        int max=piles[0];
        for(int i=0; i<piles.length;i++){
            if(piles[i]>max){
                max=piles[i];
            }
        }
        
        //binary search
        int start=1;
        int end= max;
        
        while(start<=end){
            int mid= start + (end- start)/2;
            //sum is set to store sum vaules 
            //k is used as a divsior for our vaules
            int k= mid;
            int sum=0;
            for(int pile: piles){
               sum+= Math.ceil((double)pile/k);
            }
          
            if(sum>h){
                start= mid+1;
    
            } else {
                end=mid-1;
                
            }
        }
//return start since it will poiting at the lowest vaule 
return start;
        
    }
}