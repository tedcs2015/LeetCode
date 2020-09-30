public class FindMinOfRotatedArray {
	/*
	 * Time Complexity : Same as Binary Search O(logN)
	 * Space Complexity : O(1)
	 */
    public static int findMin(int[] nums) {
    	if(nums == null || nums.length == 0)
    		return -1;
    	
    	// If the list has just one element then return that element.
        if (nums.length == 1) {
          return nums[0];
        }
    	
    	int lo = 0, hi = nums.length-1;
    	if(nums[0] < nums[hi]) // already sorted
			return nums[0];
    	
    	while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(nums[lo] < nums[hi])
                return nums[lo];
            else if(nums[mid] > nums[mid+1])
                return nums[mid+1];
            else if(nums[mid] < nums[mid-1])
                return nums[mid-1];

            // update pointers
            if(nums[mid] < nums[hi])
                hi = mid-1;
            else
                lo = mid+1;
        }

        return -1;
    }

    /*
	 * Time Complexity : Same as Binary Search O(logN)
	 * Space Complexity : O(1)
	 */
    public static int findMin(int[] nums) {
    	if(nums == null || nums.length == 0)
            return -1;

        int lo = 0, hi = nums.length-1;
        while(lo < hi) {
            int mid = lo + (hi-lo)/2;
            if(nums[mid] < nums[hi]) // go left
                hi = mid;
            else // go right
                lo = mid+1;
        }

         return nums[lo];   
    }

}