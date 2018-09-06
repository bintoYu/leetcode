/**
 * 
 */
package string;

import com.sun.net.ssl.SSLContext;

/**
 * @author ybt
 *
 * @date 2018年9月6日  
 * @version 1.0  
 */
public class Regular_Expression_Matching_10_false
{
	
	/**
	 * 失败品！！！！
	 * 简单粗暴直接匹配，有些情况考虑不够周到
	 * @param s
	 * @param p
	 * @return
	 */
    public boolean isMatch(String s, String p) {
       int i = 0;
       int j = 0;
       boolean result = true;
       
       if (p.isEmpty()) return s.isEmpty();
       if(s.isEmpty()) return false;
       
       while(i<s.length() && j < p.length())
       {
    	   char pattern = p.charAt(j);
    	   if(pattern == '.')
    	   {
    		   if(j < p.length()-1 && p.charAt(j+1) == '*')
    		   {
      			   i = s.length();
    			   j++;j++;
    			   break;
    		   }
    		   else
    		   {
	    		   i++;
	    		   j++;
	    		   continue;
    		   }
    	   }
    	   else if(j < p.length()-1 && p.charAt(j+1) == '*')
    	   {
		    	while(i < s.length() && s.charAt(i) == pattern)
		    	{
		    		   i++;
		    	}
		    	j++;j++;
    	   }
    	   else
    	   {
    		   char c = p.charAt(j);
    		   if(c != s.charAt(i))
    		   {
    			   result = false;
        		   i++;
        		   j++;
    			   break;
    		   }
    		   i++;
    		   j++;
    	   }
       }
       
       if(i<s.length() || j < p.length())
       {
    	   if(j < p.length() && p.charAt(j-1) == '*')
    	   {
    		   if(s.charAt(i-1) == p.charAt(j))
    		   {
    			   return result;
    		   }
    	   }
    	   else
    	   {
    		   result = false;
    	   }
       }
       return result;
    }
    
    public static void main(String[] args)
	{
		boolean match = new Regular_Expression_Matching_10_false().isMatch("a", "b");
		
		System.out.println(match);
	}
}
