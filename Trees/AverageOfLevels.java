package Trees;

public class AverageOfLevels {
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> res = new ArrayList<Double>();
		if(root == null)
			return res;
		
		Queue<TreeNode>	q = new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty()) {
			double sum = 0;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				TreeNode n = q.remove();
				sum += n.val;
				if(n.left != null)
					q.add(n.left);
				if(n.right != null)
					q.add(n.right);
			}
			res.add(sum/size);
		}
		
		return res;
    }
}
