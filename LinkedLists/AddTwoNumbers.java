/*
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    /**
     * Iteratively Approach
     * 
	 * Time complexity : O(max(m,n)). Assume that m and n represents the length of l1 and l2 
	 * 					respectively, the algorithm above iterates at most max(m,n) times.
	 * Space complexity : O(max(m,n)). The length of the new list is at most max(m,n)+1.
	 */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if(l1 == null && l2 == null)
    		return null;
    	
    	ListNode head = new ListNode(0); // dummy node
    	ListNode curr = head;
    	int carry = 0;
    	while(l1 != null || l2 != null || carry != 0) {
    		int sum = carry;
    		if(l1 != null) {
    			sum += l1.val;
    			l1 = l1.next;
    		}
    		
    		if(l2 != null) {
    			sum += l2.val;
    			l2 = l2.next;
    		}
    		
    		curr.next = new ListNode(sum%10);
    		curr = curr.next;
    		carry = sum / 10;
    	}
    	
    	return head.next;
    }
    
    /**
     * Iteratively Approach
     * 
	 * Time complexity : O(max(m,n)). Assume that m and n represents the length of l1 and l2 
	 * 					respectively, the algorithm above iterates at most max(m,n) times.
	 * Space complexity : O(max(m,n)). The length of the new list is at most max(m,n)+1.
	 */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    	if(l1 == null && l2 == null)
    		return null;
    	return helper(l1,l2,0);
    }
    
    private ListNode helper(ListNode l1, ListNode l2, int carry) {
    	if(l1 == null && l2 == null) {
    		if(carry == 0)
    			return null;
    		else
    			return new ListNode(carry);
    	}
    	
    	int sum = carry;
    	if(l1 != null) {
    		sum += l1.val;
    	}
    	
    	if(l2 != null) {
    		sum += l2.val;
    	}
    	
    	ListNode n = new ListNode(sum%10);
    	n.next = helper(l1.next,l2.next,sum/10);
    	return n;
	}
	
	public class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			val = x;
		}
	}
}
