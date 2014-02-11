//only permitted to complete at most one transaction
//time complexity O(N)

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2) {
            return 0;
        }
        int min = prices[0];
        int max = prices[0];
        
        int profit = 0;
        for(int i=1;i<prices.length;i++) {
            profit = Math.max(prices[i] - min,profit);
            min = Math.min(prices[i],min);
        }
        return profit;
    }
}
