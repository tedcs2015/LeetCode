public class ReverseWords {
	/*
	 * Time complexity : O(N) 
	 * Space complexity : O(N)
	 */
	public static String reverseWords(String s) {
        if(s == null || s.length() == 0)
        	return s;
        
        // trim leading and trailing spaces
        s = s.trim();
        if(s.length() < 2)
        	return s;
        
        // split string by one or multiple spaces
        String[] words = s.split("\\s+");
        
        // save the final result
        StringBuilder sb = new StringBuilder();
        int n = words.length-1;
        sb.append(words[n]);
        for(int i = n-1; i >= 0; i--) {
        	sb.append(" ");
        	sb.append(words[i]);
        }
        	
        return sb.toString();
    }
}