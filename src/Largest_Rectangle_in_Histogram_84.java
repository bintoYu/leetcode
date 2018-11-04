/**
 * 失败品
 * @author binto
 *
 */
public class Largest_Rectangle_in_Histogram_84
{
    public int largestRectangleArea(int[] heights) {
        if(heights.length==1)
        	return heights[0];
    	
        int left = 0,right = heights.length-1;
        int res = 0;
        while(left<right)
        {
        	res = Math.max(res, (right-left+1)*Math.min(heights[left], heights[right]));
        	if(heights[left]<heights[right])
        		left++;
        	else
        		right--;
        }
        
        return res;
    }
    
    public static void main(String[] args)
	{
		int[] heights = {2,1,5,6,2,3};
		int a = new Largest_Rectangle_in_Histogram_84().largestRectangleArea(heights);
		System.out.println(a);
	}
}
