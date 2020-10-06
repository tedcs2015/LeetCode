public class MissingNumber {
	/*
	 * Time complexity : O(n)
	 * Space complexity : O(1))
	 */
	public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n+1) / 2;
        for(int num : nums) {
        	sum -= num;
        }
        
        return sum;
    }
}