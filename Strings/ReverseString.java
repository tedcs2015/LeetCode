public class ReverseString {
	/*
	 * Time complexity : O(N) to swap N/2 element.
	 * Space complexity : O(1), it's a constant space solution.
	 */
    public static void reverseString(char[] s) {
    	if(s == null || s.length == 0)
    		return;
    	
    	int l = 0, r = s.length-1;
    	while(l < r) {
    		char temp = s[l];
    		s[l++] = s[r];
    		s[r--] = temp;
        }
    }
}