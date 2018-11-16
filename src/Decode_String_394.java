import java.util.Stack;

/**
 * 
 */

public class Decode_String_394
{
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int num = 0;
        String str = "";
        for(char c : s.toCharArray())
        {
        	if(c-'0' >= 0 && c-'0'<= 9)
        	{
        		num = 10*num + (c-'0');
        	}
        	else if(c == '[')
        	{
        		numStack.push(num);
        		stringStack.push(str);
        		num = 0;
        		str = "";
        	}
        	else if(c == ']')
        	{
        		Integer repeatTimes  = numStack.pop();
        		StringBuilder temp = new StringBuilder(stringStack.pop());
        		for(int i = 0; i < repeatTimes; i++)
        		{
        			temp.append(str);
        		}
        		str = temp.toString();
        	}
        	else
        	{
        		str += c;
        	}
        }	
        return str;
    }
    
	
    public static void main(String[] args)
	{
    	String s = "100[leetcode]";
		String decodeString = new Decode_String_394().decodeString(s);
		System.out.println(decodeString);
	}
}
