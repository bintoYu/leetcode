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
    	
    	//s和p同时进一位
    	return first_match && isMatchWithoutStar(s.substring(1), p.substring(1));
    }
    
    /**
     * 增加了*号后，其实就多了一行代码，现在来解释这行代码
     * 当遇到x*时，接下来有如下几种情况：
     * 1、s没有x   --> p直接跳过x* (即进两位)
     * 2、s有x    --> s进一位，然后接着比较
     * 然后使用递归算法就行
     * 例：s=aaa,p=a*a
     * 需要注意的是，charAt(1)及substring(2)可能会报"String index out of range"错
     * 因此需要在前面加条件p.length() > 1
     * 同时，substring(1)不会报错，因此大大便捷了代码
     * 
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
    	if(p.isEmpty()) return s.isEmpty();
    	
    	boolean first_match = (!s.isEmpty()) && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0));
    	
    	if(p.length() > 1 && p.charAt(1) == '*')
    	{
    		return (isMatch(s,p.substring(2)) || (first_match && isMatch(s.substring(1), p)));
    	}
    	else
    	{
    		return first_match && isMatch(s.substring(1), p.substring(1));
    	}
    }
    
    public static void main(String[] args)
	{
		boolean match = new Regular_Expression_Matching_10().isMatch("a", "a*");
		System.out.println(match);
		
	}
}
