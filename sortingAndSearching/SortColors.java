import java.util.Arrays;

public class SortColors {
	/*
	 * Brute-force - two pass algorithm
	 * Time complexity : O(n). Assume that n is the length of the array.
	 * Space complexity : O(1)
	 */
    public static void sortColorsBF(int[] nums) {
    	// using counters for 0s, 1s, and 2s
    	int c0 = 0, c1 = 0, c2 = 0;
    	int n = nums.length;
    	for(int i = 0; i < n; i++) {
    		if(nums[i] == 0)
    			c0++;
    		else if(nums[i] == 1)
    			c1++;
    		else 
    			c2++;
    	}
    	
    	// overwrite array values
    	int i = 0;
    	while(i < n && c0 > 0) {
    		nums[i++] = 0;
    		c0--;
    	}
    	
    	while(i < n && c1 > 0) {
    		nums[i++] = 1;
    		c1--;
    	}
    	
    	while(i < n && c2 > 0) {
    		nums[i++] = 2;
    		c2--;
    	}
    }

	/*
	 * One pass algorithm
	 * 
	 * Time complexity : O(n). n is the length of the array.
	 * Space complexity : O(1)
	 */
    public static void sortColors(int[] nums) {
    	// using three pointer to track the rightmost 0, 
    	// the leftmost 2 and the current element
    	int lo = 0, hi = nums.length-1, i = 0;
    	while(i <= hi) {
    		if(nums[i] == 0) 
    			swap(nums,i++,lo++);
    		else if(nums[i] == 2)
    			swap(nums,i,hi--);
    		else
    			i++;
    	}
    }
    
    private static void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
    
	public static void main(String[] args) {
		int[] a = {2,0,2,1,1,0};
		System.out.println(Arrays.toString(a));
		sortColors(a);
		System.out.println(Arrays.toString(a));

		int[] b = {2,0,1};
		System.out.println(Arrays.toString(b));
		sortColors(b);
		System.out.println(Arrays.toString(b));
		
		int[] c = {0};
		System.out.println(Arrays.toString(c));
		sortColors(c);
		System.out.println(Arrays.toString(c));
		
		int[] d = {1};
		System.out.println(Arrays.toString(d));
		sortColors(d);
		System.out.println(Arrays.toString(d));

	}
}