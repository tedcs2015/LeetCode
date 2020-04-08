public class SingleNumber {
    /*
	 * Time Complexity: O(N)
	 * Space Complexity: O(1)
	 */
	public int singleNumber(int[] nums) {
		int ans = 0;
		for(int i : nums)
			ans ^= i;
		return ans;
	}
}