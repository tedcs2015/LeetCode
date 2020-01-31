package Trees;

public class SortedArrayToBST {
	
	public static TreeNode sortedArrayToBST(int[] nums) {
		if(nums == null || nums.length == 0)
			return null;

		return sortedArrayToBST(nums,0,nums.length-1);
    }

	private static TreeNode sortedArrayToBST(int[] nums, int i, int j) {
		if(j < i)
			return null;
		int mid = i + (j-i)/2;
		TreeNode n = new TreeNode(nums[mid]);
		n.left = sortedArrayToBST(nums,i,mid-1);
		n.right = sortedArrayToBST(nums,mid+1,j);
		return n;
	}
}
