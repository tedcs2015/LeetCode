package LinkedLists;

/**
 * Reverse a linked list
 */
public class ReverseList {
	/**
	 * Iterative Approach
	 * 
	 * Time complexity : O(n). n is the list's length.
	 * Space complexity : O(1).
	 */
	public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        
        ListNode prev = null, curr = head;
        while(curr != null) {
        	ListNode n = curr.next;
        	curr.next = prev;
        	prev = curr;
        	curr = n;
        }
        return prev;
    }
	
	/**
	 * Recursive Approach
	 * 
	 * Time complexity : O(n). n is the list's length.
	 * Space complexity : O(n). The extra space comes from implicit stack space due to recursion. 
	 */
	public ListNode reverseListRecursive(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        
        ListNode n = reverseListRecursive(head.next);
    	head.next.next = head;
        head.next = null;
        return n;
	}

	public class ListNode {
		int val;
		ListNode next;
		public ListNode(int v) {
			val = v;
		}
	}
}
