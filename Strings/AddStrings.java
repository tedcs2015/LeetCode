/**
 * 
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

    Note:

    The length of both num1 and num2 is < 5100.
    Both num1 and num2 contains only digits 0-9.
    Both num1 and num2 does not contain any leading zero.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.

 * @author tewodroswolde
 *
 */
public class AddStrings {
	/*
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 */
	public static String addStrings(String num1, String num2) {
        int n = num1.length() - 1;
        int m = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(n >= 0 || m >= 0 || carry > 0) {
        	int n1 = (n >= 0) ? num1.charAt(n--) - '0' : 0;
        	int n2 = (m >= 0) ? num2.charAt(m--) - '0' : 0;
        	int sum = n1 + n2 + carry;
        	sb.append(sum % 10);
        	carry = sum / 10;
        }
        
        return sb.reverse().toString();
    }
}
