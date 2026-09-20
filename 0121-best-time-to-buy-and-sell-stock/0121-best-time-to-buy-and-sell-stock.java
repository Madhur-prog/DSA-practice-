class Solution {
    public int maxProfit(int[] prices) {

        int n=prices.length;
        int maxprofit=0;
        int minprices=prices[0];

        for (int i=1;i<prices.length;i++){
            if (prices[i]<minprices){
                minprices=prices[i];

            }else{
                int profit=prices[i]-minprices;
                maxprofit=Math.max(maxprofit,profit);

            }

        }
        return maxprofit;
       
    }
}