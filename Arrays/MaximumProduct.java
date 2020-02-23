public class MaximumProduct {
	/*
	 * Time complexity : O(n). Only one iteration over the nums array of length n is required.
	 * Space complexity : O(1). Constant extra space is used.
	 */
	public int maximumProduct(int[] nums) {
        if(nums == null || nums.length < 3)
            throw new IllegalArgumentException();
        
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
		for(int n : nums) {
			if(n <= min1) {				// n <= min1 <= min2
				min2 = min1;
				min1 = n;
			} else if(n <= min2) {		// min1 <= n <= min2
				min2 = n;
			}
			
			if(n >= max1) {				// max3 <= max2 <= max1 <= n
				max3 = max2;
				max2 = max1;
				max1 = n;
			} else if(n >= max2) {		// max3 <= max2 <= n <= max1
				max3 = max2;
				max2 = n;
			} else if(n >= max3) {		// max3 <= n <= max2 <= max1
				max3 = n;
			}
		}
		
		return Math.max(min1*min2*max1, max1*max2*max3);
    }
}