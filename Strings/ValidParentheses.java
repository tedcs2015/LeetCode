import java.util.*;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 */
public class ValidParentheses {
	/*
	 * Time complexity : O(N)
     * Space complexity : O(N)
	 */
	public boolean isValid(String s) {
		if(s == null || s.isEmpty())
			return true;
		
		Map<Character, Character> tags = new HashMap<Character,Character>();
		tags.put(')','(');
		tags.put('}','{');
		tags.put(']','[');

		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			// if closing tag, pop from stack
			if(tags.containsKey(c)) {
				if(stack.isEmpty() || tags.get(c) != stack.pop())
					return false;				
			} else { // open tag, push it to stack
				stack.push(c);
			}
		}
		
		return stack.isEmpty();
	}
}
