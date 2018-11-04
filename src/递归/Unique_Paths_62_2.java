package 递归;

/**
 * 正解：使用dp算法
 * 
 * @author binto
 *
 */
public class Unique_Paths_62_2
{
    public int uniquePaths(int m, int n) {
    	int[][] path = new int[m][n];
    	for(int i = 0; i < m; i++)
    		path[i][0] = 1;
    	for(int j = 0; j < n; j++)
    		path[0][j] = 1;
    	
    	for(int i = 1; i < m; i++)
    	{
    		for(int j = 1; j < n; j++)
    		{
    			path[i][j] = path[i-1][j] + path[i][j-1];
     		}
    	}
    	
    	return path[m-1][n-1];
    }
    
    
    public static void main(String[] args)
	{
		int uniquePaths = new Unique_Paths_62_2().uniquePaths(3,7);
		
		System.out.println(uniquePaths);
	}
    
}
