package 递归;

/**
 * 1、使用递归
 * 但遍历所有路径的话，时间复杂度太高
 * 不符合本题
 * @author binto
 *
 */
public class Unique_Paths_62_1
{
	private int res = 0;
	
    public int uniquePaths(int m, int n) {
        uniquePaths(1,1,m,n);
        
        return res;
    }
    
    public void uniquePaths(int i, int j,int m, int n)
    {
    	if(i==m && j==n)
    	{
    		res++;
    		return ;
    	}
    	
    	if(i > m || j > n)
    		return ;
    	
    	uniquePaths(i+1, j, m, n);
    	uniquePaths(i, j+1, m, n);
    }
    
    public static void main(String[] args)
	{
		int uniquePaths = new Unique_Paths_62_1().uniquePaths(23,12);
		
		System.out.println(uniquePaths);
	}
    
}
