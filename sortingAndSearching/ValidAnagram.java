public class ValidAnagram {
	/*
	 * Time complexity : O(n)
	 * Space complexity : O(1)
	 */
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
	        return false;
	    }
	    int[] table = new int[26];
	    for (int i = 0; i < s.length(); i++) {
	        table[s.charAt(i) - 'a']++;
	    }
	    for (int i = 0; i < t.length(); i++) {
	        table[t.charAt(i) - 'a']--;
	        if (table[t.charAt(i) - 'a'] < 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
	/*
	 * Time complexity : O(n)
	 * Space complexity : O(n)
	 */
	public boolean isAnagram3(String s, String t) {
		if (s.length() != t.length()) {
	        return false;
	    }
		
		Map<Character,Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
		}
		
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if(!map.containsKey(c) || map.get(c) == 0)
				return false;
			map.put(c, map.get(c)-1);
		}

	    return true;
		
    }
}