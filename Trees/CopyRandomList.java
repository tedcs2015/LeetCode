package Trees;

class CopyRandomList {
	//Definition for a Node.
	class Node {
		 public int val;
		 public Node next;
		 public Node random;
		
		 public Node() {}
		
		 public Node(int v) {
			 this(v,null,null);
		 }
		 
		 public Node(int _val,Node _next,Node _random) {
		     val = _val;
		     next = _next;
		     random = _random;
		 }
	}
	
	/*
	 * Time Complexity : O(N) because we make one pass over the original linked list.
	 * Space Complexity : O(N) as we have a dictionary containing mapping from old list nodes to 
	 * 					new list nodes. Since there are NN nodes, we have O(N) space complexity.
	 */
	public Node copyRandomList(Node head) {
	     if(head == null)
	    	 return null;
	     
	     // map from original node to its clone
	     Map<Node, Node> map = new HashMap<Node, Node>();
	     Node curr = head;
	     while(curr != null) {
	         Node newNode = new Node(curr.val);
	         map.put(curr,newNode);
	    	 curr = curr.next;
	     }
	     
	     // set pointers
	     curr = head;
	     while(curr != null) {
	    	 map.get(curr).next = map.get(curr.next);
	    	 map.get(curr).random = map.get(curr.random);
	    	 curr = curr.next;
	     }
	     
	     // return cloned head
	     return map.get(head);
	}
	
	/*
	 * Time Complexity : O(N)
	 * Space Complexity : O(1)
	 */
	public Node copyRandomListImproved(Node head) {
	     if(head == null)
	    	 return null;
	     
	     Node curr = head;
	     while(curr != null) {
	    	 Node n = new Node(curr.val);
	    	 n.next = curr.next;
	    	 curr.next = n;
	    	 curr = n.next;
	     }
	     
	     // set random pointers
	     curr = head;
	     while(curr != null) {
	    	 curr.next.random = (curr.random != null) ? curr.random.next : null;
	    	 curr = curr.next.next;
	     }
	     
	     Node oldptr = head;
	     Node newptr = head.next;
	     Node oldHead = head.next;
	     while(oldptr != null) {
	    	 oldptr.next = oldptr.next.next;
	    	 newptr.next = (newptr.next != null) ? newptr.next.next : null;
	    	 oldptr = oldptr.next;
	    	 newptr = newptr.next;
	     }
	     
	     return oldHead;
	}
}
