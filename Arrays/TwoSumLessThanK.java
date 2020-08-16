import java.util.Arrays;

/**
 * Given an array A of integers and integer K, return the maximum S such that there exists i < j 
 * with A[i] + A[j] = S and S < K. If no i, j exist satisfying this equation, return -1.

	Example 1:
	
	Input: A = [34,23,1,24,75,33,54,8], K = 60
	Output: 58
	Explanation: 
	We can use 34 and 24 to sum 58 which is less than 60.
	Example 2:
	
	Input: A = [10,20,30], K = 15
	Output: -1
	Explanation: 
	In this case it's not possible to get a pair sum less that 15.
 * @author tewodroswolde
 *
 */
public class TwoSumLessThanK {
	/*
	 * Time Complexity: O(nlogn) to sort the array.
	 * Space Complexity: from O(logn) to O(n), depending on the implementation of the sorting algorithm.
	 */
	public static int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int max = -1;
        int lo = 0, hi = A.length-1;
        while(lo < hi) {
        	if(A[lo] >= K)
        		break;
        	
        	while(lo < hi && A[hi] >= K)
        		hi--;
        	
        	int sum = A[lo] + A[hi];
        	if(sum < K) {
        		max = Math.max(max, sum);
        		lo++;
        	} else
        		hi--;    	
        }
        return max;
    }
	
	public static void main(String[] args) {
		int[] a = {34,23,1,24,75,33,54,8};
		System.out.println(Arrays.toString(a) + " -> " + twoSumLessThanK(a,60));
		int[] b = {10,20,30};
		System.out.println(Arrays.toString(b) + " -> " + twoSumLessThanK(b,15));
	}

}
