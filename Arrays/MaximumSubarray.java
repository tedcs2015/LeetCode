public class MaximumSubarray {
	/*
	 * Complexity Analysis
	 *      Time complexity : O(N) since it's one pass along the array.
	 *      Space complexity : O(1), since it's a constant space solution.
	 */
	public static int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0)
			throw new IllegalArgumentException();
		
        int maxSum = nums[0];
        int curSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
        	curSum += nums[i];
        	curSum = Math.max(curSum, nums[i]);
        	maxSum = Math.max(maxSum, curSum);
        }
        
        return maxSum;
    }
}