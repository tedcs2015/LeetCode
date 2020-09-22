import java.util.HashSet;
import java.util.Set;

public class IsPowerOfFour {
	/*
	 * Time complexity: O(logn). n to the base 4
	 * Space complexity: O(1)
	 */
    public static boolean isPowerOfFour(int n) {
    	if(n < 1)
    		return false;
    	while(n % 4 == 0)
    		n /= 4;
    	
    	return n == 1;
    }
    
    /*
	 * Time complexity: O(1)
	 * Space complexity: O(1)
	 */
    public static boolean isPowerOfFour2(int n) {
    	return n > 0 && Math.log(n)/Math.log(2) % 2 == 0;
    }
    
    /*
	 * Time complexity: O(1)
	 * Space complexity: O(1)
	 */
    public static boolean isPowerOfFour3(int n) {
    	int maxPower = 15; // max power of 4 in 32 bit int
    	Set<Integer> powers = new HashSet<Integer>();
    	powers.add(1);
    	int prod = 1;
    	for(int i = 1; i <= maxPower; i++) {
    		prod *= 4;
    		powers.add(prod);
    	}
    	
    	return powers.contains(n);
    }
    
    /*
	 * Time complexity: O(1)
	 * Space complexity: O(1)
	 */
    public static boolean isPowerOfFour4(int n) {
    	return n > 0 && ((n & (n-1)) == 0) && ((n & 0xaaaaaaaa) == 0);
    }
    
	public static void main(String[] args) {
		int[] nums = {0,1,2,3,4,5,8,9,12,16,24,27,32,64,81,128};
		for(int i : nums) {
			System.out.println(i + " is power of 4 : " + isPowerOfFour4(i));
		}
	}

}
