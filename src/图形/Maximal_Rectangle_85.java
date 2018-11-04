package 图形;

import com.sun.org.apache.bcel.internal.generic.CPInstruction;

public class Maximal_Rectangle_85
{
    public int maximalRectangle(char[][] matrix) {
    	if(matrix == null || matrix.length == 0 || matrix[0].length ==0)
    		return 0;
    	
        int res = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int[] left = new int[column];
        int[] right = new int[column];
        int[] height = new int[column];
        
        for(int i = 0; i < column; i++)
        {
        	left[i] = 0;
        	right[i] = column;
        	height[i] = 0;
        }
        
        for(int i = 0; i < row; i++)
        {
        	int cur_left = 0,cur_right = column;
        	for(int j = 0; j < column; j++)
        	{
        		if(matrix[i][j] == '1') height[j] +=1;
        		else height[j] = 0;
        	}
        	
        	for(int j = 0; j < column; j++)
        	{
        		if(matrix[i][j] == '1')
        		{
        			left[j] = Math.max(left[j], cur_left);
        		}
        		else
        		{
        			left[j] = 0;
        			cur_left = j+1;
        		}
        	}
        	
        	for(int j = column-1; j >= 0; j--)
        	{
        		if(matrix[i][j] == '1')
        		{
        			right[j] = Math.min(right[j],cur_right);
        		}
        		else
        		{
        			right[j] = column;
        			cur_right = j;
        		}
        	}
        	
        	for(int j = 0; j < column; j++)
        	{
        		res = Math.max(res, height[j]*(right[j] - left[j]));
        	}
        }
        
        return res;
    }
}
