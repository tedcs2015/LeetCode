/*
 * Write a function that takes a string as input and reverse only the vowels of a string.
 */
public class ReverseVowels {
	/*
	 * Time complexity : O(N)
     * Space complexity : O(N)
	 */
	public String reverseVowels(String s) {
        if(s == null || s.isEmpty())
        	return s;
        
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length-1;
        while(l < r) {
        	if(!isVowel(arr[l])) {
        		l++;
        		continue;
        	}
        	
        	if(!isVowel(arr[r])) {
        		r--;
        		continue;
        	}
        	
        	// swap the vowels
        	char tmp = arr[l];
        	arr[l++] = arr[r];
        	arr[r--] = tmp;
        }
        
        return new String(arr);
    }
	
	private boolean isVowel(char c) {
		return (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' 
				|| c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U');
	}
}
