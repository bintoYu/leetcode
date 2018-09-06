/**
 * 
 */

/**
 * @author ybt
 *
 * @date 2018年9月6日  
 * @version 1.0  
 */
public class String_to_Integer_8
{
    public int myAtoi(String str) {
        String tmp = str.trim();
        long result = 0;
        
        if(tmp.isEmpty())
        	return 0;
        else if(tmp.charAt(0) == '-')
        {
        	if(tmp == "-")
        		return 0;
        }
        else if((tmp.charAt(0) > '9' || tmp.charAt(0) < '0'))
        	return 0;
        
        if(tmp.indexOf(' ') > 0)
        	tmp = tmp.substring(0,tmp.indexOf(' '));
        
        if(tmp.indexOf('.') >= 0)
        	tmp = tmp.substring(0,tmp.indexOf('.'));
        	
        result = Long.parseLong(tmp);
        
        if(result < Integer.MIN_VALUE)
        	return Integer.MIN_VALUE;
        else if(result > Integer.MAX_VALUE)
        	return Integer.MAX_VALUE;
        else
        	return (int)result;
    }
    
    public static void main(String[] args)
	{
    	String tmp = "-";
    	int myAtoi = new String_to_Integer_8().myAtoi(tmp);
    	System.out.println(myAtoi);
	}
}
