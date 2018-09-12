/**
 * 
 */

/**
 * @author Administrator
 *
 * @date 2018年9月7日  
 * @version 1.0  
 */
public class 背包问题
{
	public int[][] dynamic_0_1(int v[],int w[],int n,int W)
	{
		int[][] c = new int[n+1][W+1];
		for(int i = 0; i < W; i++)
		{
			c[0][i] = 0;
		}
		
		for(int i = 1; i <= n; i++)
		{
			c[i][0] = 0;
			for(int j =  1; j <= W; j++)
			{
				if(w[i-1] <= j)
				{
					c[i][j] = Math.max(v[i-1] + c[i-1][j - w[i-1]],c[i-1][j]);
				}
				else
				{
					c[i][j] = c[i-1][j];
				}
			}
			
		}
		
		return c;
	}
	
	public static void main(String[] args)
	{
		int[] w = {2,2,6,5,4};
		int[] v = {6,3,5,4,6};
		int n = 5;
		int W = 10;
		int[][] out = new 背包问题().dynamic_0_1(v, w, n, W);
		
		for(int i = 1; i <= n; i++)
		{
			for(int j =  1; j <= W; j++)
			{
				System.out.print(out[i][j] + " ");
			}
			System.out.println();
		}
	}
}
