import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLevelOrderTraversal {
	/*
	 * Time complexity : O(N) since each node is processed exactly once.
	 * Space complexity : O(N) to keep the output structure which contains N node values.
	 */
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<>();
    	if(root == null)
    		return res;
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.add(root);
    	
    	while(!q.isEmpty()) {
    		List<Integer> level = new ArrayList<>();
    		int len = q.size();
    		for(int i = 0; i < len; i++) {
        		TreeNode n = q.poll();
        		// add child nodes of the current level
                // in the queue for the next level
    			if(n.left != null)
    				q.add(n.left);
    			if(n.right != null)
    				q.add(n.right);
    			level.add(n.val);
    		}
    		res.add(level);
    	}
    	
    	return res;
    }
    
    /*
	 * Time complexity : O(N) since each node is processed exactly once.
	 * Space complexity : O(N) to keep the output structure which contains N node values.
	 */
    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<>();
    	if(root == null)
    		return res;
    	helper(root,res,0);
    	return res;
    }
    
	private void helper(TreeNode n, List<List<Integer>> res, int level) {
		// start the current level
		if(res.size() == level)
			res.add(new ArrayList<Integer>());
		
		// add node to the current level
		res.get(level).add(n.val);
		
		// process child nodes for the next level
		if(n.left != null)
			helper(n.left,res,level+1);
		if(n.right != null)
			helper(n.right,res,level+1);
	}
}