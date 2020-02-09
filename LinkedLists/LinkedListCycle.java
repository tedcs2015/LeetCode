public class LinkedListCycle {
	/**
	 * Time complexity : O(n). Assume that n is the list's length, the time complexity is O(n).
	 * Space complexity : O(1).
	 */
	public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
        	return false;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
        	if(slow == fast)
        		return true;
        	slow = slow.next;
        	fast = fast.next.next;
        }
        return false;
    }
    
    // inner class for ListNode
	public class ListNode {
		int val;
		ListNode next;
		public ListNode(int v) {
			val = v;
		}
    }
}