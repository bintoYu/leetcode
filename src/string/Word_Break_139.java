package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Word_Break_139
{
	/**
	 * 错误版本
	 * 十分接近答案。（或许字典不可重复用版本可以使用该方法）
	 * 将dp[]中的值设置为匹配开始的地方，例如：
	 * applepenapple  字典：apple,pen
	 * 那么遍历apple时，存的是a的位置，
	 * 遍历pen时，存的是p的位置
	 * 致命问题在于：
	 * aaaaaaa 字典：aaaa，aaa
	 * 每次遇到aaa都会进行下一次搜索，不会有aaaa的情况。
	 */
    public boolean wordBreakFalse(String s, List<String> wordDict) {
        int[] dp = new int[s.length()+1];
        HashSet<String> set = new HashSet<>();
        for(String word : wordDict)
        	set.add(word);
        
        dp[0] = 0;
        for(int i = 1; i < s.length()+1; i++)
        {
        	String sub = s.substring(dp[i-1],i);
        	if(set.contains(sub)) dp[i] = i;
        	else dp[i] = dp[i-1];
        }
        
        if(dp[s.length()] == s.length())
        	return true;
        else
        	return false;
    }
    
    /**
     * 正确版本
     * 不考虑匹配开始的地方，每次都从0到i开始找。
     * applepenapple  字典：apple,pen
     * 第一个匹配上的（apple），那么下一个点p（实际上就是位置i）就应该标记为true
     * 之后遍历时，如果匹配上（例如pen），看看匹配的起始点（点p）是不是true
     * 这样能解决错位方法的问题。
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        HashSet<String> set = new HashSet<>();
        for(String word : wordDict)
        	set.add(word);
        
        dp[0] = true;
        for(int i = 1; i < s.length()+1; i++)
        {
        	for(int j = 0; j < i; j++)
        	{
            	String sub = s.substring(j,i);
            	if(set.contains(sub) && dp[j])
            	{
            		dp[i] = true;
            		break;
            	}
        	}
        }
        return dp[s.length()];
    }
    
    public static void main(String[] args)
	{
		String s = "applepenapple";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("apple");
		wordDict.add("pen");
		
		boolean res = new Word_Break_139().wordBreak(s, wordDict);
		System.out.println(res);
	}
}
