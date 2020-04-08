import java.util.*;

public class GroupAnagrams {
	/*
	 * Time Complexity: O(N)
	 * Space Complexity: O(N)
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
		if(strs == null || strs.length == 0)
    		return res;
		
		// map: sorted word -> list of anagrams
		Map<String, List<String>> map  = new HashMap<String, List<String>>();
		for(int i = 0; i < strs.length; i++) {
			String word = strs[i];
			char[] arr = word.toCharArray();
			Arrays.sort(arr);			
			String sorted = new String(arr);
			
			// check if map contains sorted string
			if(!map.containsKey(sorted)) {
				map.put(sorted, new ArrayList<String>());
			}
			map.get(sorted).add(word);
		}
		
		// add map's values to res
		res.addAll(map.values());
		
		return res;
    }
}