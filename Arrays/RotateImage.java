
public class RotateImage {
	/*
	 * Time complexity : O(N^2)
     * Space complexity : O(1) since we do a rotation in place.
	 */
    public void rotate(int[][] matrix) {
    	if(matrix == null || matrix.length != matrix[0].length)
    		return;
    	
    	int n = matrix.length;
    	
    	// rotate matrix layer by layer
    	for(int layer = 0; layer < n/2; layer++) {
    		int first = layer;
    		int last = n - 1 - layer;
    		for(int i = first; i < last; i++) {
    			int offset = i - first;
    			
    			// save top
    			int top = matrix[first][i];
    			
    			// left -> top
    			matrix[first][i] = matrix[last-offset][first];
    			
    			// bottom -> left
    			matrix[last-offset][first] = matrix[last][last-offset];
    			
    			// right -> bottom
    			matrix[last][last-offset] = matrix[i][last];
    			
    			// bottom -> top
    			matrix[i][last] = top;
    			
    		}
    	}
    }
    
    /*
	 * Time complexity : O(N^2)
     * Space complexity : O(1) since we do a rotation in place.
	 */
    public void rotate2(int[][] matrix) {
    	int n = matrix.length;
    	
    	// transpose matrix
    	for(int i = 0; i < n; i++) {
    		for(int j = i; j < n; j++) {
    			int tmp = matrix[j][i];
    			matrix[j][i] = matrix[i][j];
    			matrix[i][j] = tmp;
    		}
    	}
    	
    	// reverse each row of the matrix
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n/2; j++) {
    			int tmp = matrix[i][j];
    			matrix[i][j] = matrix[i][n-j-1];
    			matrix[i][n-j-1] = tmp;
    		}
    	}
    	
    }
}
