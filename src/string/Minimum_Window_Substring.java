package string;

import java.util.HashMap;

public class Minimum_Window_Substring
{
	public String minWindow(String s, String t){
		int[] map = new int[128];
		int counter = t.length();
		int begin = 0, end = 0, head = 0;
		int res = Integer.MAX_VALUE;

		for (char c : t.toCharArray()) map[c]++;

		while (end < s.length())
		{
			if (map[s.charAt(end++)]-- > 0) counter--;
			while (counter == 0)
			{
				if (res > end - begin)
				{
					res = end - begin;
					head = begin;
				}
				if (map[s.charAt(begin++)]++ == 0) counter++;
			}
		}

		return res == Integer.MAX_VALUE ? "" : s.substring(head, head + res);
	}

}
