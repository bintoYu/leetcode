package string;

import java.util.HashMap;

public class Longest_Substring_03
{

	/*
	 * 设置两个指针i（右指针），j（左指针）
	 * 当i遇到重复的字符时，将j放在“上一次”遇到那个重复字符的下一位
	 * max就是i-j+1 与之前的max中的最大值
	 */
	public int lengthOfLongestSubstring(String s)
	{
		if (s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		for (int i = 0, j = 0; i < s.length(); ++i)
		{
			if (map.containsKey(s.charAt(i)))
			{
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}

	
	public static void main(String[] args)
	{
		String s = "pwwkewa";
		System.out.println(new Longest_Substring_03().lengthOfLongestSubstring(s));
	}
}
