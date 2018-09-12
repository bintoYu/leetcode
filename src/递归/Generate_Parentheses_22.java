/**
 * 
 */
package 递归;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ybt
 *
 * @date 2018年9月12日  
 * @version 1.0  
 */
public class Generate_Parentheses_22
{
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        
        getParentheses(n, "", 0, 0, list);
        
        return list;
    }
    
    private void getParentheses(int n,String current, int left, int right, List<String> list)
    {
    	if(current.length() == n * 2)
    	{
    		list.add(current);
    		return ;
    	}
    	
    	if(right < left)
    	{
    		getParentheses(n, current + ")", left, right + 1, list);
    	}
    	else if(left < n)
    	{
    		getParentheses(n, current + "(", left + 1, right, list);
    	}
    }
    
    public static void main(String[] args)
	{
		List<String> result = new Generate_Parentheses_22().generateParenthesis(3);
		
		System.out.println(result);
	}
}
