package string;

public class ZigZag_Conversion
{
    public String convert(String s, int numRows) 
    {
		if (numRows == 1) return s;
		
		StringBuilder ret = new StringBuilder();
		for(int i = 0; i < numRows; i++)
		{
			int j = i;
			while(j < s.length())
			{
				ret.append(s.charAt(j));
				if(i!=0 && i!=numRows-1 && (j+(numRows-i-1)*2)<s.length())
					ret.append(s.charAt(j+(numRows-i-1)*2));
				j += 2 *(numRows-1);
			}
		}
		
		return ret.toString();
	}
    
    public static void main(String[] args)
	{
		String convert = new ZigZag_Conversion().convert("PAYPALISHIRING", 3);
		System.out.println(convert);
	}
}
