public class MergeSortedArray {
	/*
	 * Using two pointers - Start from the end
     * 
     * Time complexity : O((n+m)
     * Space complexity : O(1)
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    	int len = m + n - 1;
    	while(m > 0 && n > 0) {
    		// compare and add the largest one in nums1 
    		if(nums1[m-1] > nums2[n-1]) {
    			nums1[len--] = nums1[m-1];
    			m--;
    		} else {
    			nums1[len--] = nums2[n-1];
    			n--;
    		}
    	}
    	
	    // add missing elements from nums2
    	while(n > 0) {
    		nums1[len--] = nums2[n-1];
			n--;
    	}
    }
}