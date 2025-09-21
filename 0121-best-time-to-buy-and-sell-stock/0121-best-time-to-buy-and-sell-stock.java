class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit=0;
        int minprice=0;
        for(int i =1;i<prices.length;i++) {
            int profit =  prices[i]-prices[minprice];
            if(profit > maxprofit){
                maxprofit=profit;
            }
            if(prices[i]<prices[minprice]){
                minprice=i;
            }
        } 
        return maxprofit;      
        
    }
}