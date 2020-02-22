public class MaxProfitIndex {
	/*
	 * Time complexity : O(n)
	 * Space complexity : O(1)
	 */
	public int[] getMaxProfitIndex(int[] prices) {
		if(prices == null || prices.length == 0)
        	return null;
		
		int maxProfit = 0, maxProfitIdx = 0, min = Integer.MAX_VALUE, minIdx = 0;
        for(int i = 0; i < prices.length; i++) {
        	if(prices[i] < min) {
        		min = prices[i];
        		minIdx = i;
        		
        	} else if(prices[i]-min > maxProfit) {
        		maxProfit = prices[i]-min;
        		maxProfitIdx = i;
        	}
        }
        
        // case for 0 profit
        if(minIdx == prices.length-1)
        	return new int[] {0,0};
        
        return new int[] {minIdx, maxProfitIdx};
    }
}