import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
	// Definition for a Node.
	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	
	public Node copyRandomList(Node head) {
        if(head == null)
        	return null;
        
        // create hashtable to map original nodes to their clones
        Map<Node,Node> map = new HashMap<Node,Node>();
        
        // create new nodes and add them to map
        Node curr = head;
        while(curr != null) {
        	Node n = new Node(curr.val);
        	map.put(curr, n);
        	curr = curr.next;
        }
        
        // link clone's next and random pointers using map
        curr = head;
        while(curr != null) {
        	map.get(curr).next = map.get(curr.next);
        	map.get(curr).random = map.get(curr.random);
        	curr = curr.next;
        }
        
        // return clone head
        return map.get(head);
    }
}