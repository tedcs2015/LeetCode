import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such 
 * that the sum is closest to target. Return the sum of the three integers. You may assume 
 * that each input would have exactly one solution.

	Example 1:
	
	Input: nums = [-1,2,1,-4], target = 1
	Output: 2
	Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	 
	
	Constraints:
	
	3 <= nums.length <= 10^3
	-10^3 <= nums[i] <= 10^3
	-10^4 <= target <= 10^4
 * @author tewodroswolde
 *
 */
public class ThreeSumClosest {

	/*
	 * Time complexity: O(n^2). The time it takes for the nested loop.
	 * Space complexity: from O(logn) to O(n), depending on the implementation of the sorting algorithm.
	 */
	public static int threeSumClosest(int[] nums, int target) {
		// assign closest a max num
		int closest = Integer.MAX_VALUE;
		
		// sort array
		Arrays.sort(nums);
		
		// use two pointer technique to find the closest
		for(int i = 0; i < nums.length-2 && closest != 0; i++) {
			int lo = i+1, hi = nums.length-1;
			while(lo < hi) {
				int sum = nums[i] + nums[lo] + nums[hi];
				if(Math.abs(target-sum) < Math.abs(closest))
					closest = target-sum;
				if(sum < target)
					lo++;
				else 
					hi--;
			}
		}
		
		return target - closest;
	}
	
	public static void main(String[] args) {
		int[] arr = {-1,2,1,-4};
		int target = 1;
		System.out.println(threeSumClosest(arr,target));
	}

}