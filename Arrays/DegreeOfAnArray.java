import java.util.*;

/*
 * Given a non-empty array of non-negative integers nums, the degree of this array is 
 * defined as the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, 
 * that has the same degree as nums.
 * 
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 */
public class DegreeOfAnArray {
	
	/*
	 * Complexity Analysis
	 * 		Time complexity : O(N)
	 * 		Space complexity : O(N)
	 */
	public static int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
        	throw new IllegalArgumentException();
        
        // build a frequency map; {nums[i] -> [1st index, last index, degree]}
        int n = nums.length;
        int maxDegree = 0, currDegree = 0;
        Map<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        for(int i = 0; i < n; i++) {
        	ArrayList<Integer> list;
        	if(!map.containsKey(nums[i])) {
        		list = new ArrayList<Integer>();
        		list.add(i); // 1st index
        		list.add(i); // last index
        		list.add(1); // degree
        		map.put(nums[i],list);
        	} else {
        		list = map.get(nums[i]);
        		int start = list.get(0); // 1st index
        		int degree = list.get(2);
        		list.clear();
        		list.add(start);
        		list.add(i);
        		list.add(degree + 1);
        		map.put(nums[i],list);
        	}
        	
    		currDegree = list.get(2);
        	if(currDegree > maxDegree)
        		maxDegree = currDegree;
        }
        
        // use the frequency map to find the smallest possible length
    	int smallestLength = Integer.MAX_VALUE;
        for(int k : map.keySet()) {
        	ArrayList<Integer> lst = map.get(k);
        	int degree = lst.get(2);
        	if(degree == maxDegree) {
        		int currLength = lst.get(1) - lst.get(0) + 1;
        		if(currLength < smallestLength)
        			smallestLength = currLength;
        	}
        }
        
        return smallestLength;
	}
	
	/*
	 * Complexity Analysis
	 * 		Time complexity : O(N^2)
	 * 		Space complexity : O(N)
	 */
	public static int findShortestSubArray2(int[] nums) {
        if(nums == null || nums.length == 0)
        	throw new IllegalArgumentException();
        
        // build a frequency map
        int n = nums.length;
        int maxDegree = 0;
        Map<Integer,Integer> freq_map = new HashMap<Integer,Integer>();
        for(int i = 0; i < n; i++) {
        	if(!freq_map.containsKey(nums[i])) {
        		freq_map.put(nums[i],0);
        	}
        	freq_map.put(nums[i],freq_map.get(nums[i])+1);
        	if(freq_map.get(nums[i]) > maxDegree)
        		maxDegree = freq_map.get(nums[i]);
        }
        
        // find the smallest possible length
        int smallestLength = Integer.MAX_VALUE;
        for(int i : freq_map.keySet()) {
        	int degree = freq_map.get(i);
        	if(degree == maxDegree) {
        		int currSmallest = Integer.MAX_VALUE;
        		int lo = 0, hi = n-1;
        		while(lo < hi) {
        			while(nums[lo] != i && lo < hi)
        				lo++;
        			while(nums[hi] != i && lo < hi)
        				hi--;
        			currSmallest = hi - lo + 1;
        			if(currSmallest < smallestLength)
        				smallestLength = currSmallest;
        			break;
        		}
        	}
        }
        
        return smallestLength;
    }
}
