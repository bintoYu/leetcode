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
public class Regular_Expression_Matching_10
{
    /**
     * 先不考虑带*的情况，也就是最简单的情况
     * @param s
     * @param p
     * @return
     */
    public boolean isMatchWithoutStar(String s, String p)
    {
    	//得保证p和s得同时走完
    	if(p.isEmpty()) return s.isEmpty();

    	//(!s.isEmpty()) : 同样的，p不为空时，s也不能为空
    	boolean first_match = (!s.isEmpty()) && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0));
    	
    	//相当于指针i++，j++
    	return first_match && isMatchWithoutStar(s.substring(1), p.substring(1));
    }
    
    
    public boolean isMatch(String s, String p) {
        return false;
    }
    
    public static void main(String[] args)
	{
		boolean match = new Regular_Expression_Matching_10().isMatch("a", "b");
		
		System.out.println(match);
	}
}
