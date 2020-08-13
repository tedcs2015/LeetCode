import java.util.Arrays;

/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k 
 * with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

	Example:
	
	Input: nums = [-2,0,1,3], and target = 2
	Output: 2 
	Explanation: Because there are two triplets which sums are less than 2:
	             [-2,0,1]
	             [-2,0,3]
	Follow up: Could you solve it in O(n2) runtime?
 * @author tewodroswolde
 *
 */
public class ThreeSumSmaller {
	/*
	 * Time complexity: O(n^2). The time it takes for the nested loop.
	 * Space complexity: from O(logn) to O(n), depending on the implementation of the sorting algorithm.
	 */
	public static int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
		int count = 0;
		for(int i = 0; i < nums.length-2; i++) {
			int lo = i+1, hi = nums.length-1;
			while(lo < hi) {
				int sum = nums[i] + nums[lo] + nums[hi];
				if(sum < target) {
					count += hi - lo;
					lo++;
				} else {
					hi--;
				}
			}
		}
		
		return count;
    }

	public static void main(String[] args) {
		int[] arr = {-2,0,1,3};
		int target = 2;
		System.out.println(threeSumSmaller(arr,target));
	}
}