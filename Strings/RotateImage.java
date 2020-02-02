public class RotateImage {
	public static void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
        	return;
        
        int N = matrix.length;
        // first transpose matrix
        for(int i = 0; i < N; i++) {
        	for(int j = i; j < N; j++) {
        		int temp = matrix[j][i];
        		matrix[j][i] = matrix[i][j];
        		matrix[i][j] = temp;
        	}
        }
        
        // reverse each row of matrix
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N/2; j++) {
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[i][N-1-j];
        		matrix[i][N-1-j] = temp;
        	}
        }
    }
}