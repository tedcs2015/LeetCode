public class IsPowerOfTwo {
    /*
	 * Time complexity: O(logn). n to the base 2
	 * Space complexity: O(1)
	 */
    public boolean isPowerOfTwo(int n) {
        if(n < 1)
            return false;
        
        while(n%2 == 0)
            n /= 2;
        
        return n == 1;
    }

    /*
	 * Time complexity: O(1)
	 * Space complexity: O(1)
	 */
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & n-1)) == 0;
    }
}