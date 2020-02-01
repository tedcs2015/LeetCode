public class StringToInteger {
    /*
	 * Time complexity : O(N)
     * Space complexity : O(1)
	 */
	public static int myAtoi(String str) {
		if(str == null || str.length() == 0)
    		return 0;
    	
    	// trim whitespace
    	str = str.trim();
    	
    	// check if the string is empty after trimming
    	if(str.isEmpty())
    		return 0;
    	
        int i = 0, sign = 1, ret = 0;
        if(str.charAt(0) == '-') {
        	sign = -1;
        	i++;
        } else if(str.charAt(0) == '+') {
        	i++;
        }
        
        while(i < str.length()) {
        	// check if char is digit
        	if(!Character.isDigit(str.charAt(i)))
        		return sign * ret;
        	
        	int d = str.charAt(i) - '0';
        	
        	// check for integer overflow
        	if(sign * ret > Integer.MAX_VALUE/10 || (sign * ret == Integer.MAX_VALUE/10 && d > 7))
        		return Integer.MAX_VALUE;
        	
        	if(sign * ret < Integer.MIN_VALUE/10 || (sign * ret == Integer.MIN_VALUE/10 && d > 8))
        		return Integer.MIN_VALUE;
        	
        	ret = ret * 10 + d;
        	i++;
        }
        
        return sign * ret;	
    }
}