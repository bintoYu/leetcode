package string;

import java.util.HashMap;

public class Longest_Substring_03
{

	/*
	 * ��������ָ��i����ָ�룩��j����ָ�룩
	 * ��i�����ظ����ַ�ʱ����j���ڡ���һ�Ρ������Ǹ��ظ��ַ�����һλ
	 * max����i-j+1 ��֮ǰ��max�е����ֵ
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
