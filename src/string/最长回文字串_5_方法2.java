package string;

//中心拓展法
public class 最长回文字串_5_方法2
{
	public String longestPalindrome(String s)
	{
		int length = s.length();
		
		//默认第一个单字符为答案
		String answer = s.substring(0, 1);
		
		for(int i = 0; i < length-1; i++)
		{
			String s1 = expendCenter(s, i, i);
			if(s1.length() > answer.length())
			{
				answer = s1;
			}
			String s2 = expendCenter(s, i, i+1);
			if(s2.length() > answer.length())
			{
				answer = s2;
			}
		}
		
		return answer;
	}

	//确定中心的位置（有单个"xbx"和两个"xbbx"两种情况）
	public String expendCenter(String s, int index1, int index2)
	{
		int i = index1;
		int j = index2;
		char[] chars = s.toCharArray();
		int length = s.length();
		
		while(true)
		{
			//注意这里i是可以等于0的，但j是不可以等于的
			if(i>=0 && j< length && chars[i] == chars[j])
			{ 
				i--;
				j++;
			}
			else
			{
				break;
			}
		}
		
		return s.substring(i+1, j);
	}
}
