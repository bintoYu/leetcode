package 图形;

public class Rotate_Image_48
{
	//顺先行再翻
    public void rotate(int[][] matrix) {
    	int N = matrix.length;
    	//先进行行置换
    	for(int i = 0; i < N/2;i++)
    	{
    		for(int j = 0; j < N;j++)
    		{
    			int tmp = matrix[i][j];
    			matrix[i][j] = matrix[N-1-i][j];
    			matrix[N-1-i][j] = tmp;
    		}
    	}
    	
    	//再进行翻转
    	for(int i = 0; i < N;i++)
    	{
    		for(int j = i; j < N;j++)
    		{
    			int tmp = matrix[i][j];
    			matrix[i][j] = matrix[j][i];
    			matrix[j][i] = tmp;
    		}
    	}
    }
    
}
