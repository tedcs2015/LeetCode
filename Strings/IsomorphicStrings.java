import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 */
public class IsomorphicStrings {
	/*
	 * Time Complexity: O(N)
	 * Space Complexity: O(N)
	 */
	public boolean isIsomorphic(String s, String t) {
		if(s == null || t == null || s.length() != t.length())
			return false;
		
		boolean[] visited = new boolean[256];
		Map<Character, Character> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			
			if(!map.containsKey(c1)){
				if(visited[c2])
					return false;
				visited[c2] = true;
				map.put(c1, c2);
			} else {
				if(map.get(c1) != c2)
					return false;
			}
		}
		
		return true;	
	}
}