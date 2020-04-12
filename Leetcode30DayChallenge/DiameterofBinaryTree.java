public class DiameterofBinaryTree {
	/*
	 * Time Complexity: O(N). We visit every node once.
	 * Space Complexity: O(N), the size of call stack during depth-first search.
	 */
	int longest = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		helper(root);
        return longest;
    }
    
    private int helper(TreeNode root) {
        if(root == null) 
        	return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        longest = Math.max(longest, left + right);
        return Math.max(left, right) + 1;
    }

    // Definition for a binary tree node.
 	public class TreeNode {
 	     int val;
 	     TreeNode left;
 	     TreeNode right;
 	     TreeNode(int x) { val = x; }
     }
}