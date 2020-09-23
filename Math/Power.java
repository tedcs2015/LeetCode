public class Power {
	/*
	 * Brute-force - Iterative approach
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 */
    public static double pow(double x, int n) {
		if(n < 0) {
			n = -n;
			x = 1/x;
		}
		
		double ans = 1;
		for(int i = 0; i < n; i++) {
			ans = ans * x;
		}
		
		return ans;
	}

	/*
     * Recursive approach
     * 
	 * Time complexity: O(logn)
	 * Space complexity: O(logn)
	 */
    public static double pow2(double x, int n) {
    	if(n < 0) {
			n = -n;
			x = 1/x;
		}
    	
    	double half = pow2(x,n/2);
    	if(n%2 == 0) { // even
    		return half * half;
    	} else { // odd
    		return half * half * x;
    	}
    }
    
    /*
	 * Iterative approach using binarry bit 
	 * 
	 * Time complexity: O(logn)
	 * Space complexity: O(1)
	 */
    public static double pow3(double x, int n) {
    	if(n < 0) {
			n = -n;
			x = 1/x;
		}
    	
    	double ans = 1;
    	for(int i = n; i > 0; i /= 2) {
    		if(i%2 == 1)
    			ans = ans * x;
    		x = x * x;
    	}
    	
    	return ans;
    }
    
    /*
   	 * Iterative approach
   	 * 
   	 * Time complexity: O(logn)
   	 * Space complexity: O(1)
   	 */
    public static double pow4(double x, int n) {
    	if(n < 0) {
			n = -n;
			x = 1/x;
		}
    	
    	double ans = 1;
    	while(n != 0) {
    		if(n%2 == 1)
    			ans *= x;
    		x = x * x;
    		n >>>= 1;
    	}
    	
    	return ans;
    }
    
	public static void main(String[] args) {
		System.out.println(pow(2,6));
		System.out.println(pow(2,0));
		System.out.println(pow(2,-3));
	}
}
