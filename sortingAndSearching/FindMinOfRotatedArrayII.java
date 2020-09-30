/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

	(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

	Find the minimum element.

	The array may contain duplicates.

	Example 1: Input: [1,3,5]   Output: 1
    Example 2: Input: [2,2,2,0,1]   Output: 0
 *
 */
public class FindMinOfRotatedArrayII {
	/*
	 * Time complexity: on average O(logN) where N is the length of the array, since in general it 
	 * is a binary search algorithm. However, in the worst case where the array contains identical 
	 * elements (i.e. case #3 nums[mid]==nums[high]), the algorithm would deteriorate to iterating 
	 * each element, as a result, the time complexity becomes O(N).
	 * 
	 * Space complexity: O(1), it's a constant space solution.
	 */
	public static int findMin(int[] nums) {
        int lo = 0, hi = nums.length-1;
        while(lo < hi) {
        	int mid = lo + (hi-lo)/2;
        	if(nums[mid] < nums[hi]) // go left
        		hi = mid;
        	else if(nums[mid] > nums[hi]) // go right
        		lo = mid + 1;
        	else // nums[mid] == nums[hi]
        		hi--;
        }
        
        return nums[lo];
    }

	public static void main(String[] args) {
		int[] a = {3,4,5,1,2};
		int[] b = {4,5,6,7,0,1,2};
		int[] c = {2,2,2,0,0,0,1,1,1};
		System.out.println("min: " + findMin(a));
		System.out.println("min: " + findMin(b));
		System.out.println("min: " + findMin(c));
	}
}