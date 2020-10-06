public class FindDuplicateNumber {
	/*
	 * Approach: Cycle Detection
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(1))
	 */
	public static int findDuplicate(int[] nums) {
	    // find the intersection point of the two runners.
		int slow = nums[0], fast = nums[0];
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while(slow != fast);
		
	    // find the entrance of the cycle.
		fast = nums[0];
		while(slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		
		return slow;
    }
}