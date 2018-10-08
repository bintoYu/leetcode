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
     * 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
	 * 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
     * 当遇到x*时，接下来有如下几种情况：
     * 1、s没有x   --> p直接跳过x* (即进两位) if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]
     * 2、s有x    --> 三种情况：
     * 						if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
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

        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    
    public static void main(String[] args)
	{
		boolean match = new Regular_Expression_Matching_10().isMatch("a", "a*");
		System.out.println(match);
		
	}
}
