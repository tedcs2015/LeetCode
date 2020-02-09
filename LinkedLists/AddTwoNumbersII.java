import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant 
 * digit comes first and each of their nodes contain a single digit. Add the two numbers and return it 
 * as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * 
 * Example:
 *      Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 *      Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbersII {
	/**
     * Approach 1: by reversing lists
	 * Time complexity : O(max(m,n)). Assume that m and n represents the length of l1 and l2 
	 * 					respectively, the algorithm above iterates at most max(m,n) times.
	 * Space complexity : O(max(m,n)). The length of the new list is at most max(m,n)+1.
	 */
	public ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
        return reverse(addTwoNumbers(reverse(l1),reverse(l2)));
    }
	
	private ListNode reverse(ListNode n) {
		if(n == null || n.next == null)
			return n;
		ListNode prev = null, curr = n;
		while(curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
	private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null)
			return null;
		
		// dummy node to save for final result
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
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
			carry = sum/10;
		}
		
		return dummy.next;
	}

    /**
     * Follow up: Using Stack
     * 
	 * Time complexity : O(max(m,n)). Assume that m and n represents the length of l1 and l2 
	 * 					respectively, the algorithm above iterates at most max(m,n) times.
	 * Space complexity : O(max(m,n)). The length of the new list is at most max(m,n)+1.
	 */
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null)
			return null;
		
		// using stacks to reverse lists without modifying the input lists
		Stack<ListNode> s1 = new Stack<>();	// save l1 elements
		Stack<ListNode> s2 = new Stack<>();	// save l2 elements
		
		// add each list values to respective stacks
		ListNode curr1 = l1, curr2 = l2;
		while(curr1 != null) {
			s1.push(curr1);
			curr1 = curr1.next;
		}
		while(curr2 != null) {
			s2.push(curr2);
			curr2 = curr2.next;
		}
		
		ListNode head = null;
		int carry = 0;
		while(!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
			int sum = (s1.isEmpty() ? 0 : s1.pop().val) + (s2.isEmpty() ? 0 : s2.pop().val) + carry;
			ListNode n = new ListNode(sum%10);
			n.next = head;
			head = n;
			carry = sum/10;
		}
		
		return head;
	}
	
	// ListNode class
	public class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			val = x;
		}
    }
}