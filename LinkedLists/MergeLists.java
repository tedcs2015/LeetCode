
public class MergeLists {
    /*
     * Time complexity : O(n+m) - n and m are the lengths of l1 and l2.
     * Space complexity : O(1).
     */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
		else if(l1 == null)
			return l2;
		else if(l2 == null)
            return l1;

        // dummy head for edge cases
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if(l1 != null) 
            curr.next = l1;
        else if(l2 != null)
            curr.next = l2;

        return head.next;
    }

    // list node class
    public class ListNode { 
        int val; 
        ListNode next; 
        public ListNode(int d) {
        	val = d;
        	next = null;
        }
    }
}