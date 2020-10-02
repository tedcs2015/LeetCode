public class SearchRotatedSortedArrayII {
	/*
	 * Time complexity : O(N) worst case, O(logN) best case, where N is the length of the input array.
	 * Space complexity : O(1).
	 */
    public static boolean search(int[] nums, int target) {
    	if(nums == null || nums.length == 0)
    		return false;
    	
    	int lo = 0, hi = nums.length-1;
    	while(lo <= hi) {
    		int mid = lo + (hi - lo) / 2;
    		if(nums[mid] == target) {
    			return true;
    		} else if(nums[lo] < nums[mid]) {	// left half is sorted
    			// check if target found in left half
    			if(target >= nums[lo] && target < nums[mid]) // go left
    				hi = mid-1;
    			else 	// go right
    				lo = mid+1;
    		} else if(nums[lo] > nums[mid]){	// right half is sorted
    			// check if target found in right half
    			if(target > nums[mid] && target <= nums[hi]) // go right
    				lo = mid+1;
    			else 	// go left
    				hi = mid-1;
    		} else {	// nums[mid] == nums[hi]
    			lo++;
    		}
    	}
    	
    	// target not found
    	return false;
    }
    
    /*
	 * Time complexity : O(N) worst case, O(logN) best case, where N is the length of the input array.
	 * Space complexity : O(1).
	 */
    public static boolean search2(int[] nums, int target) {
    	if(nums == null || nums.length == 0)
    		return false;
    	
    	int lo = 0, hi = nums.length-1;
    	while(lo <= hi) {
    		int mid = lo + (hi - lo) / 2;
    		if(nums[mid] == target) {
    			return true;
    		} else if(nums[mid] < nums[hi]) {	// right half is sorted
    			// check if target found in right half
    			if(target > nums[mid] && target <= nums[hi]) // go right
    				lo = mid+1;
    			else 	// go left
    				hi = mid-1;
    		} else if(nums[mid] > nums[hi]){	// left half is sorted
    			// check if target found in left half
    			if(target >= nums[lo] && target < nums[mid]) // go left
    				hi = mid-1;
    			else 	// go right
    				lo = mid+1;
    		} else {	// nums[mid] == nums[hi]
    			hi--;
    		}
    	}
    	
    	// target not found
    	return false;
    }
    
	public static void main(String[] args) {
		int[] a = {2,5,6,0,0,1,2};
		int[] b = {2,5,6,0,0,1,2};
		
		System.out.println("Output: " + search2(a,0));
		System.out.println("Output: " + search2(b,3));
	}
}
