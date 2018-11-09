/**
 * 
 */

public class Perfect_Squares_279
{
    public int numSquares(int n) {
    	int num = 0;
    	while(n != 0)
    	{
    		int sqrt = (int)Math.sqrt(n);
    		
    		n = n - sqrt*sqrt;
    		
    		System.out.println(sqrt);
    		num++;
    	}
        return num;
    }
    
    public static void main(String[] args)
	{
		int numSquares = new Perfect_Squares_279().numSquares(12);
		
		System.out.println(numSquares);
	}
}
