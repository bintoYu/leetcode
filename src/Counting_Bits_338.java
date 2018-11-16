
public class Counting_Bits_338
{
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        for(int i = 1; i < num+1; i++)
        {
        	if(i%2 == 0) res[i] = res[i/2];
        	else res[i] = res[i/2]+1;
        }
        
        return res;
    }
    
    public static void main(String[] args)
	{
		new Counting_Bits_338().countBits(0);
	}
}
