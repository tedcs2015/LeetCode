public class BinarySearchTree {
	// time - O(H) --> average case O(logN), worst case O(N) 	
	// space - O(H) --> average case O(logN), worst case O(N)
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        else if(root.val == val)
            return root;
        else if(root.val > val)
            return searchBST(root.left,val);
        else 
            return searchBST(root.right,val);
    }
    
    // time - O(H) --> average case O(logN), worst case O(N) 	
 	// space - O(1)
    public TreeNode searchBST_Iterative(TreeNode root, int val) {
        while (root != null && val != root.val)
          root = val < root.val ? root.left : root.right;
        return root;
    }
}
