public class MoveZeroes {
	/*
	 * Time Complexity: O(N)
	 * Space Complexity : O(1)
	 */
	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) 
			return;
		
		int lastNonZeroPos = 0;
	    for (int i = 0; i < nums.length; i++) {
	        if (nums[i] != 0) {
	        	int temp = nums[lastNonZeroPos];
	        	nums[lastNonZeroPos++] = nums[i];
	            nums[i] = temp;
	        }
	    }
    }
}