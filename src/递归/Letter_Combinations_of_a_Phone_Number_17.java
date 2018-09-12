/**
 * 
 */
package 递归;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ybt
 *
 * @date 2018年9月11日  
 * @version 1.0  
 */
public class Letter_Combinations_of_a_Phone_Number_17
{
	private String[] dict = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	
    public List<String> letterCombinations(String digits) {
    	ArrayList<String> list = new ArrayList<>();
    	
    	letterCombinationsDFS(digits, "", 0, list);
    	
    	return list;
    }
    
    public void letterCombinationsDFS(String digits, String current,int depth,List<String> list)
    {
    	if(depth == digits.length())
    	{
    		if(depth != 0)
    			list.add(current);
    		return ;
    	}
    	
    	int num = digits.charAt(depth) - '0';
    	
    	for(int j = 0; j < dict[num].length(); j++)
    	{
    		letterCombinationsDFS(digits, current + dict[num].charAt(j), depth + 1, list);
    	}
    }
    
    public static void main(String[] args)
	{
    	String digits = "";
    	List<String> letterCombinations = new Letter_Combinations_of_a_Phone_Number_17().letterCombinations(digits);
    	System.out.println(letterCombinations);
	}
}
