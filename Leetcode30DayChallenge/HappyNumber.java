public class HappyNumber {
	/*
	 * Time complexity: O(NlogN)
	 * Space complexity: O(1)
	 */
	public boolean isHappy(int n) {
		int slow = n, fast = getSquare(n);
		while(fast != 1 && slow != fast) {
        	slow = getSquare(slow);
        	fast = getSquare(getSquare(fast));
        };
        
        return fast == 1;
    }
	
	private int getSquare(int n) {
		int sum = 0;
		while(n > 0) {
			int d = n % 10;
			n /= 10;
			sum += d * d;
		}
		return sum;
	}
}
