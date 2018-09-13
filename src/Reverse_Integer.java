
public class Reverse_Integer
{
    public int reverse(int x) {
    	int i = 0;
    	int num = 0;
    	long result = 0;
        while(x!=0)
        {
        	num = x%10;
        	if(num == 0 && result == 0)
        	{
        	}
        	else
        	{
        		result = result*10 + num;
        	}
        	x = x/10;
        }
    	
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
        	return 0;
        else
        	return (int)result;
    }
    
    public static void main(String[] args)
	{
		int reverse = new Reverse_Integer().reverse(1534236469);
		System.out.println(reverse);
	}
}
