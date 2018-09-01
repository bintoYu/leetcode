package string;

public class 最长回文字串_5_方法1
{
	public String longestPalindrome(String s)
	{
		char[] chars = s.toCharArray();
		int length = s.length();
		int maxlen = 1;
		int longestbegin = 0;

		int[][] table = new int[length][length];

		//同一位置字母肯定是一样的
		for (int i = 0; i < length; i++)
		{
			table[i][i] = 1;
		}

		//将所有相邻且相同的位置记录下来
		for (int i = 0; i < length - 1; i++)
		{
			if (chars[i] == chars[i + 1])
			{
				table[i][i + 1] = 1;
				maxlen = 2;
				longestbegin = i;
			}
		}

		/*
		 * 从长度为3开始
		 * 从外往里检测，即i在最左边，j在最右边，然后两个同时往里走一格
		 * 若相同则记录下这条字符串，以及这两个位置的table也记录下来
		 * 因为是从短的字符串开始，慢慢循环变长，最终会变成最长
		 */
		for (int len = 3; len <= length; len++)
		{
			for (int i = 0; i < length - len + 1; i++)
			{
				int j = i + len - 1;
				
				if(chars[i] == chars[j] && table[i+1][j-1] == 1)
				{
					table[i][j] = 1;
					maxlen = len;
					longestbegin = i;
				}
			}
		}

		return s.substring(longestbegin, longestbegin + maxlen);

	}
	
	public static void main(String[] args)
	{
		String s= new 最长回文字串_5_方法1().longestPalindrome("babad");
		
		System.out.println(s);
	}
}
