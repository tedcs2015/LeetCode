import java.util.HashMap;

public class CountingElements {
	/*
	 * Time Complexity: O(N)
	 * Space Complexity: O(N)
	 */
	public int countElements(int[] arr) {
        if(arr == null || arr.length == 0)
        	return 0;
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < arr.length; i++) {
        	map.put(arr[i],i);
        }
        
        int count = 0;
        for(int ele : arr) {
        	if(map.containsKey(ele+1))
        		count++;
        }
        
        return count;
    }
}