package string;

import java.util.Stack;

public class Longest_Valid_Parentheses_32
{    
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
    
    public static void main(String[] args)
	{
		int i = new Longest_Valid_Parentheses_32().longestValidParentheses(")(())");
		System.out.println(i);
	}
}
