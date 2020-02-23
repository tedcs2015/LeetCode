public class MergeTrees {
	/*
	 * Using Recursion Approach
	 * Time complexity : O(m). A total of m nodes need to be traversed. Here, m represents 
	 * 					 the minimum number of nodes from the two given trees.
	 * Space complexity : O(m). The depth of the recursion tree can go upto m in the case 
	 * 					  of a skewed tree. In average case, depth will be O(logm).
	 */
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
        	return null;
        if(t1 == null)
        	return t2;
        if(t2 == null)
        	return t1;
        TreeNode n = new TreeNode(t1.val + t2.val);
        n.left = mergeTrees(t1.left,t2.left);
        n.right = mergeTrees(t1.right,t2.right);
        return n;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
         TreeNode(int x) { 
             val = x; 
        }
    }
}