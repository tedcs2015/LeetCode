public class ValidPalindrome {
    /**
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public boolean isPalindrome(String s) {
    	if(s == null || s.length() == 0)
    		return true;
    	s = s.toLowerCase();
    	int lo = 0, hi = s.length()-1;
    	while(lo < hi) {
    		while(lo < hi && !isAlphaNumeric(s.charAt(lo)))
    			lo++;
    		while(lo < hi && !isAlphaNumeric(s.charAt(hi)))
    			hi--;
    		if(s.charAt(lo) != s.charAt(hi))
    			return false;
    		lo++;
    		hi--;
    	}
    	
    	return true;
    }

    public static void main(String[] args) {
    	String[] s = {"A man, a plan, a canal: Panama", "race a car",""};
    	ValidPalindrome pali = new ValidPalindrome();
		for(String str : s) {
			System.out.println(str + ": " + pali.isPalindrome(str));
		}
    }
}