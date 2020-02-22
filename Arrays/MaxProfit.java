public class MaxProfit {
	/*
	 * Time complexity : O(n)
	 * Space complexity : O(1)
	 */
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
        	return 0;
        
        int maxProfit = 0, min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
        	if(prices[i] < min)
        		min = prices[i];
        	else if(prices[i]-min > maxProfit)
        		maxProfit = prices[i]-min;
        }
        return maxProfit;
    }
}