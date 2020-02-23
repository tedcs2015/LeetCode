public class MaxProductSubarray {
    /*
	 * Time complexity : O(n). Only one iteration over the nums array of length n is required.
	 * Space complexity : O(1). Constant extra space is used.
	 */
	public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0)
            throw new IllegalArgumentException();

        int maxProduct = nums[0], min = nums[0], max = nums[0];
        for(int i = 1; i < nums.length; i++) {
        	if(nums[i] >= 0) {	// for positive numbers
        		max = Math.max(nums[i], max*nums[i]);
        		min = Math.min(nums[i], min*nums[i]);
        	} else { 	// for negative numbers
        		int temp = max;
        		max = Math.max(nums[i], min*nums[i]);
        		min = Math.min(nums[i], temp*nums[i]);
        	}
        	maxProduct = Math.max(maxProduct, max);
        }
        return maxProduct;
    }
}