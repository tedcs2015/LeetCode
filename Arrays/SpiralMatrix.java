import java.util.*;

public class SpiralMatrix {
	/*
	 * Time Complexity: O(N), where N is the total number of elements in the input matrix.
	 * Space Complexity: O(N), the information stored in res.
	 */
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        	return res;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m-1;
        int left = 0, right = n-1;
        while(res.size() < m*n) {
        	// add top row to list: left -> right
        	for(int i = left; i <= right; i++) {
        		res.add(matrix[top][i]);
        	}
        	top++;
        	
        	// add right col to list: top -> bottom
        	for(int i = top; i <= bottom; i++) {
        		res.add(matrix[i][right]);
        	}
        	right--;
        	
        	// check if top and bottom rows overlap
        	if(bottom < top)
        		break;
        	
        	// add bottom row to list: right -> left
        	for(int i = right; i >= left; i--) {
        		res.add(matrix[bottom][i]);
        	}
        	bottom--;
        	
        	// check if left and right columns overlap
        	if(right < left)
        		break;
        	
        	// add left col to list: bottom -> top
        	for(int i = bottom; i >= top; i--) {
        		res.add(matrix[i][left]);
        	}
        	left++;
        }
        
        return res;
    }
}