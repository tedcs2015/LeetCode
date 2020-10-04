package arraysAndStrings;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

    Notice that the solution set must not contain duplicate triplets.

    Example 1:

    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
    Example 2:

    Input: nums = []
    Output: []
 */
public class ThreeSum {
	/*
	 * Time Complexity: O(n^2).
	 * Space Complexity: O(n). The memory required for the output.
	 */
    public static List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	if(nums == null)
    		return res;
    	
    	Arrays.sort(nums);
    	for(int i = 0; i < nums.length && nums[i] <= 0; i++) {
    		if(i == 0 || nums[i-1] < nums[i]) {
    			int lo = i+1, hi = nums.length-1;
    			while(lo < hi) {
    				int sum = nums[i] + nums[lo] + nums[hi];
    				if(sum == 0) {
    					res.add(Arrays.asList(nums[i],nums[lo++],nums[hi--]));
    					while(lo < hi && nums[lo-1] == nums[lo]) // skip duplicates
    						lo++;
    				} else if(sum < 0)
    					lo++;
    				else 
    					hi--;
    			}
    		}
    	}
    	
    	return res;
    }

	public static void main(String[] args) {
		int[] a = {-1,0,1,2,-1,-4};
		int[] b = {};
		System.out.println(threeSum(a));
		System.out.println(threeSum(b));
	}
}