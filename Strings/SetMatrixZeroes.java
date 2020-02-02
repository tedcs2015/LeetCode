public class SetMatrixZeroes {
	/*
	 * Time Complexity : O(NM) N and M are lengths of row and col.
	 * Space Complexity : O(1)
	 */
	public static void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
        	return;
        
        int N = matrix.length; // row length
        int M = matrix[0].length; // col length
        
        // use two variables to track if 1st row/col has zeroes
        boolean rowHasZero = false;
        boolean colHasZero = false;
        
        // update colHasZero
        for(int i = 0; i < N; i++) {
        	if(matrix[i][0] == 0) {
        		colHasZero = true;
        		break;
        	}
        }
        
        // update rowHasZero
        for(int i = 0; i < M; i++) {
        	if(matrix[0][i] == 0) {
        		rowHasZero = true;
        		break;
        	}
        }
        	
        // update the values of 1st row/col based on the rest
        for(int i = 1; i < N; i++) {
        	for(int j = 1; j < M; j++) {
        		if(matrix[i][j] == 0) {
        			matrix[0][j] = 0;
        			matrix[i][0] = 0;
        		}
        	}
        }
        
        // update the matrix using the values of 1st row/col
        for(int i = 1; i < N; i++) {
        	for(int j = 1; j < M; j++) {
        		if(matrix[0][j] == 0 || matrix[i][0] == 0) {
        			matrix[i][j] = 0;
        		}
        	}
        }
        
        // update the 1st row
        if(rowHasZero) {
        	for(int i = 0; i < M; i++) {
        		matrix[0][i] = 0;
        	}
        }
        
        // update the 1st col
        if(colHasZero) {
        	for(int i = 0; i < N; i++) {
        		matrix[i][0] = 0;
        	}
        }
    }
}