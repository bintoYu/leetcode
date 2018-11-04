package 递归;

public class Minimum_Path_Sum_64
{
	public int minPathSum(int[][] grid)
	{
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		int n = grid.length;
		int m = grid[0].length;
		int[][] dp = new int[n][m];

		// 初始化第一行以及第一列
		dp[0][0] = grid[0][0];
		for (int i = 1; i < n; i++)
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		for (int j = 1; j < m; j++)
			dp[0][j] = dp[0][j - 1] + grid[0][j];

		//时刻i有两种情况，从左边过来或者从上面过来
		for (int i = 1; i < n; i++)
		{
			for (int j = 1; j < m; j++)
			{
				dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		return dp[n - 1][m - 1];
	}

	public static void main(String[] args)
	{
		int[][] grid =
		{{ 1, 3, 1 },{ 1, 5, 1 },{ 4, 2, 1 } };
		
		int minPathSum = new Minimum_Path_Sum_64().minPathSum(grid);
		System.out.println(minPathSum);
	}
}
