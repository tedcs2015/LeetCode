import java.util.Arrays;

public class MergeSortedArray {
	
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    	int len = m + n - 1;
    	while(m > 0 && n > 0) {
    		if(nums2[n-1] >= nums1[m-1]) {
    			nums1[len--] = nums2[n-1];
    			n--;
    		} else {
    			nums1[len--] = nums1[m-1];
    			m--;
    		}
    	}
    	
    	// add any left nums2 elements to nums1
    	while(n > 0 && len >= 0) {
    		nums1[len--] = nums2[n-1];
			n--;
    	}
    }

	public static void main(String[] args) {
		int[] a = {1,2,3,0,0,0};
		int[] b = {2,5,6};
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		merge(a,3,b,3);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}
}