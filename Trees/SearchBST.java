public class SearchBST {
	// time - O(H) --> average case O(logN), worst case O(N) 	
	// space - O(H) --> average case O(logN), worst case O(N)
    public static TreeNode searchBST(TreeNode root, int val) {
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
    public static TreeNode searchBST_Iterative(TreeNode root, int val) {
        while (root != null && val != root.val)
          root = val < root.val ? root.left : root.right;
        return root;
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