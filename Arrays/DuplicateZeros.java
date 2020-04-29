public class DuplicateZeros {
	/*
	 * Time Complexity: O(N), where N is the number of elements in the array.
	 * Space Complexity: O(1). We do not use any extra space.
	 */
    public void duplicateZeros(int[] arr) {
    	if(arr == null || arr.length == 0)
    		return;
    	
    	// count zeros
    	int count = 0;
    	int n = arr.length-1;
    	for(int i = 0; i <= (n-count); i++) {
    		if(arr[i] == 0) {
    			// edge case
    			if(i == (n-count)) {
    				arr[n--] = 0;
    				break;
    			}
    			count++;
    		}
    	}
    	
		// add duplicate zeros by overwriting array starting from the end
    	int last = n-count;
    	for(int i = last; i >= 0; i--) {
    		if(arr[i] == 0) {
    			arr[i+count] = 0;
    			count--;
    			arr[i+count] = 0;
    		} else {
    			arr[i+count] = arr[i];
    		}
    	}
    }
    
}