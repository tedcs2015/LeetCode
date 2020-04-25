
public class RangeBitwiseAnd {
    /*
	 * Time Complexity: O(1)
	 * Space Complexity: O(1)
	 */
	public int rangeBitwiseAnd(int m, int n) {
		int shift = 0;
		// right shift until two numbers are equal
		while(m != n) {
			m >>= 1;
			n >>= 1;
			shift++;
		}
		
		return m << shift;
	}
}