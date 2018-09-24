/**
 * 
 */
package 水池;

/**
 * @author ybt
 *
 * @date 2018年8月31日  
 * @version 1.0  
 */
public class Container_With_Most_Water
{
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int sum = 0;
        
        while(i<=j)
        {
        	sum =  Math.max((j-i) * Math.min(height[i], height[j]), sum);
        	if(height[i] <= height[j])
        	{
        		i++;
        	}
        	else
        	{
        		j--;
        	}
        }
    	return sum;
    }
    
    public static void main(String[] args)
	{
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
	}
}
