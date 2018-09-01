package string;

public class ������ִ�_5_����1
{
	public String longestPalindrome(String s)
	{
		char[] chars = s.toCharArray();
		int length = s.length();
		int maxlen = 1;
		int longestbegin = 0;

		int[][] table = new int[length][length];

		//ͬһλ����ĸ�϶���һ����
		for (int i = 0; i < length; i++)
		{
			table[i][i] = 1;
		}

		//��������������ͬ��λ�ü�¼����
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
		 * �ӳ���Ϊ3��ʼ
		 * ���������⣬��i������ߣ�j�����ұߣ�Ȼ������ͬʱ������һ��
		 * ����ͬ���¼�������ַ������Լ�������λ�õ�tableҲ��¼����
		 * ��Ϊ�ǴӶ̵��ַ�����ʼ������ѭ���䳤�����ջ����
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
		String s= new ������ִ�_5_����1().longestPalindrome("babad");
		
		System.out.println(s);
	}
}
