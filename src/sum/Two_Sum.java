/**
 * 
 */
package sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ybt
 *
 * @date 2018年8月31日  
 * @version 1.0  
 */
public class Two_Sum
{
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
    	for(int i = 0; i < nums.length; i++)
        {
        	map.put(nums[i], i);
        }
    	
    	for (int i = 0; i < nums.length; i++)
		{
			Integer j = map.get(target - nums[i]);
			if(j != null && j != i)
			{
				result[0] = i;
				result[1] = j;
				return result;
			}
		}
    	
    	return result;
    }
    
    
    public static void main(String[] args)
	{
		int[] height = {3,2,4};
		int[] twoSum = new Two_Sum().twoSum(height,6);
		
		System.out.println(twoSum[0]);
		System.out.println(twoSum[1]);
	}
}
