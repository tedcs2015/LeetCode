import java.util.*;
/*
 * Given an array of integers, return indices of the two 
 * numbers such that they add up to a specific target.
 */
public class TwoSums {
    /*
	 * Time complexity : O(N)
     * Space complexity : O(N)
	 */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(map.containsKey(diff)) {
                return new int[] {map.get(diff),i};
            } else {
                map.put(nums[i],i);
            }
        }
        return null;   
    }
}