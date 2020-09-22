public class IsPowerOfThree {
	/*
	 * Time complexity: O(logn). n to the base 3
	 * Space complexity: O(1)
	 */
	public static boolean isPowerOfThree(int n) {
        if(n < 1)
            return false;
        
        while(n % 3 == 0)
            n /= 3;

        return n == 1;
    }

    /*
	 * Time complexity: O(logn). n to the base 3
	 * Space complexity: O(1)
	 */
	public boolean isPowerOfThree2(int n) {
		return n > 0 && (Math.log(n)/Math.log(3)) % 1 == 0;
	}
	
	/*
	 * Time complexity: O(1)
	 * Space complexity: O(1)
	 */
	public boolean isPowerOfThree3(int n) {
        return n > 0 && 1162261467 % n == 0;
	}
}