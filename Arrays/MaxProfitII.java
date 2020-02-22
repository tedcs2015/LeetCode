public class MaxProfitII {
	/*
	 * Time complexity : O(n). Single pass.
	 * Space complexity : O(1). Constant space required.
	 */
    public int maxProfit(int[] prices) {
    	if(prices == null || prices.length == 0)
    		return 0;
    	int maxProfit = 0;
    	for(int i = 1; i < prices.length; i++) {
    		if(prices[i] > prices[i-1])
    			maxProfit += prices[i]-prices[i-1];
    	}
    	
    	return maxProfit;
    }
}