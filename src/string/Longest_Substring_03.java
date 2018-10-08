package string;

import java.util.HashMap;

public class Longest_Substring_03
{
	/*
	 * 方法1：（使用map进行存储，提高取的效率）
	 * 同时，当遇到重复字母时，回滚至上一次出现的地方
	 * 例adbcba，遇到第二个b时，回滚至第一个b
	 * 细节：循环结束后需要重新比较max, length
	 * @param s
	 * @return
	 */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
        	return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int length = 0;
        
		for (int i = 0; i < s.length(); i++)
		{
			length++;
			if (map.containsKey(s.charAt(i)))
			{
				i = map.get(s.charAt(i));
				max = Math.max(max, length-1);
				length = 0;
				map.clear();
			}
			else
			{
				map.put(s.charAt(i), i);
			}
		}
		
		max = Math.max(max, length);
		return max;
    }
    
	public static void main(String[] args)
	{
		String s = "aabcdea";
		System.out.println(new Longest_Substring_03().lengthOfLongestSubstring(s));
	}
}
