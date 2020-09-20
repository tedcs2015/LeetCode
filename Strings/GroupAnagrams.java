import java.util.*;

public class GroupAnagrams {
    /*
	 * Time Complexity: O(NKlogK), where N is the length of strs, and K is the maximum
	 * 		length of a string in strs. The outer loop has complexity O(N) as we iterate 
	 * 		through each string. Then, we sort each string in O(KlogK) time.
	 * Space Complexity: O(NK), the total information content stored in res.
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		if(strs == null || strs.length == 0)
    		return res;
		
		// map: sorted word -> list of anagrams
		Map<String, List<String>> map  = new HashMap<String, List<String>>();
		for(String word : strs) {
			String sorted = sort(word);
			if(!map.containsKey(sorted)) {  // sorted string not in map
				map.put(sorted, new ArrayList<String>());
			}
			map.get(sorted).add(word);
		}
		
		// add map's values to res
		res.addAll(map.values());
		
		return res;
    }
	
	private String sort(String s) {
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
    }
}