package linkedList;

/**
 * Reverse the given linked list
 */
public class ReverseList {
	/*
	 * Time complexity : O(n). Assume that n is the list's length, the time complexity is O(n).
	 * Space complexity : O(1).
	 */
	public ListNode reverseList(ListNode head) {
		 if(head == null || head.next == null)
			 return head;
		 
		 ListNode prev = null, curr = head;
		 while(curr != null) {
			 ListNode next = curr.next;
			 curr.next = prev;
			 prev = curr;
			 curr = next;
		 }
		 
		 return prev;
	}
	
	/*
	 * Time complexity : O(n). Assume that n is the list's length, the time complexity is O(n).
	 * Space complexity : O(n). The extra space comes from implicit stack space due to recursion. 
	 * 		              The recursion could go up to n levels deep.
	 */
	public ListNode reverseListRecursive(ListNode head) {
		if(head == null || head.next == null)
			 return head;
		
		ListNode p = reverseListRecursive(head.next);
		head.next.next = head;
		head.next = null;
		
		return p;
	}	

	public class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			val = x;
		}
	}
}
