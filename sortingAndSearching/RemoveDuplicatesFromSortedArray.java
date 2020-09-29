public class RemoveDuplicatesFromSortedArray {
	/*
	 * Time complexity : O(n). Assume that n is the length of array.
	 * Space complexity : O(1)
	 */
    public static int removeDuplicates(int[] nums) {
    	if(nums == null || nums.length == 0)
    		return 0;
    	
    	int writeIndex = 0;
    	for(int i = 1; i < nums.length; i++) {
    		if(nums[writeIndex] != nums[i])
    			nums[++writeIndex] = nums[i];
    	}
    	
    	return writeIndex+1;
    }
}
