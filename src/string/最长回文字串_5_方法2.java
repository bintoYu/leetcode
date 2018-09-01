package string;

//������չ��
public class ������ִ�_5_����2
{
	public String longestPalindrome(String s)
	{
		int length = s.length();
		
		//Ĭ�ϵ�һ�����ַ�Ϊ��
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

	//ȷ�����ĵ�λ�ã��е���"xbx"������"xbbx"���������
	public String expendCenter(String s, int index1, int index2)
	{
		int i = index1;
		int j = index2;
		char[] chars = s.toCharArray();
		int length = s.length();
		
		while(true)
		{
			//ע������i�ǿ��Ե���0�ģ���j�ǲ����Ե��ڵ�
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
