/**
 * 
 */
package 图形;

/**
 * @author Administrator
 * 
 * @date 2018年11月6日
 * @version 1.0
 */
public class Maximal_Square_221
{
	public int maximalSquare(char[][] matrix)
	{
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		
		int[][] dp = new int[matrix.length][matrix[0].length];
		int max = 0;
		
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				dp[i][j] = matrix[i][j] - '0';
				if (dp[i][j] == 1)
				{
					max = 1;
				}
			}
		}
		
		if (max == 1)
		{
			for (int i = 1; i < matrix.length; i++)
			{
				for (int j = 1; j < matrix[0].length; j++)
				{
					if(dp[i][j] == 1)
					{
						dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
						max = Math.max(max, dp[i][j]);
					}
				}
			}
			
		}
		
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return max * max;
	}
	
	public static void main(String[] args)
	{
		char[][] matrix =
		{
		{ '1', '0', '1', '0' },
		{ '1', '0', '1', '1' },
		{ '1', '0', '1', '1' },
		{ '1', '1', '1', '1' } };
		System.out.println(new Maximal_Square_221().maximalSquare(matrix));
	}
}
