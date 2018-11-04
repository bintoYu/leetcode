package 自己构造类;

import java.util.Stack;


/**
 * @author Administrator
 *
 * @date 2018年10月31日  
 * @version 1.0  
 */
public class MinStack
{
	//s1：正常存数字
	private Stack<Integer> s1;
	//s2:存出现过的最小值
	private Stack<Integer> s2;
	
    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
        if(s2.isEmpty() || s2.peek()>=x) s2.push(x);
    }
    
    public void pop() {
    	int x = s1.pop();
    	if(x == s2.peek()) s2.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return s2.peek();
    }
}
