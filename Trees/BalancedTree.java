public class BalancedTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
         TreeNode(int x) { 
             val = x; 
        }
    }
	
	public boolean isBalanced(TreeNode root) {
        if(root == null)
        	return true;
        
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if(Math.abs(heightDiff) > 1) {
        	return false;
        }
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
	
	private int getHeight(TreeNode n) {
		if(n == null)
			return -1;
		return Math.max(getHeight(n.left), getHeight(n.right)) + 1;
    }
}