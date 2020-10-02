public class SearchRotatedSortedArray {
	/*
	 * Time complexity : O(logn).
	 * Space complexity : O(1).
	 */
    public static int search(int[] nums, int target) {
    	if(nums == null || nums.length == 0)
    		return -1;
    	
    	int lo = 0, hi = nums.length-1;
    	while(lo <= hi) {
    		int mid = lo + (hi - lo) / 2;
    		if(nums[mid] == target) {
    			return mid;
    		} else if(nums[lo] <= nums[mid]) {	// left half is sorted
    			// check if target found in left half
    			if(target >= nums[lo] && target < nums[mid]) // go left
    				hi = mid-1;
    			else 	// go right
    				lo = mid+1;
    		} else {	// right half is sorted
    			// check if target found in right half
    			if(target > nums[mid] && target <= nums[hi]) // go right
    				lo = mid+1;
    			else 	// go left
    				hi = mid-1;
    		}
    	}
    	
    	// target not found
    	return -1;
    }
    
    /*
	 * Time complexity : O(logn).
	 * Space complexity : O(logn).
	 */
    public static int search2(int[] nums, int target) {
		if(nums == null || nums.length == 0)
			return -1;
    	return search2(nums,target,0,nums.length-1);
    }

	private static int search2(int[] nums, int target, int lo, int hi) {
		if(lo > hi)
			return -1;
		else if(lo == hi) {
			if(nums[lo] == target)
				return lo;
			else
				return -1;
		} else {
			int mid = lo + (hi - lo) / 2;
    		if(nums[mid] == target) {
    			return mid;
    		} else if(nums[lo] <= nums[mid]) {	// left half is sorted
    			// check if target found in left half
    			if(target >= nums[lo] && target < nums[mid]) // go left
    				return search2(nums,target,lo,mid-1);
    			else 	// go right
    				return search2(nums,target,mid+1,hi);
    		} else {	// right half is sorted
    			// check if target found in right half
    			if(target > nums[mid] && target <= nums[hi]) // go right
    				return search2(nums,target,mid+1,hi);
    			else 	// go left
    				return search2(nums,target,lo,mid-1);
    		}
		}
	}

	public static void main(String[] args) {
		int[] a = {4,5,6,7,0,1,2};
		int[] b = {4,5,6,7,0,1,2};
		int[] c = {1};
		int[] d = {3,1};
		
		System.out.println("Output: " + search(a,0));
		System.out.println("Output: " + search(b,3));
		System.out.println("Output: " + search(c,0));
		System.out.println("Output: " + search(d,1));
	}

}
