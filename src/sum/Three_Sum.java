/**
 * 
 */
package sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ybt
 *
 * @date 2018年8月31日  
 * @version 1.0  
 */
public class Three_Sum
{
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
    	for(int i = 0; i < nums.length; i++)
        {
        	map.put(nums[i], i);
        }
    	
    	for(int i = 0; i < nums.length - 2; i++)
        {
    		for(int j = i + 1; j < nums.length - 1; j++)
    		{
    			int num = -(nums[i] + nums[j]);
    			Integer k = map.get(num);
    			if(k != null && k>j)
    			{
    				result.add(Arrays.asList(nums[i],nums[j],nums[k]));
    				j = map.get(nums[j]);		// To remove duplicates,to skip the same num
    			}
    		}
    		
            i = map.get(nums[i]);  // To remove duplicates
            if(i > nums.length-1)
                break;
        }
    	return result;
    }
    
    public static void main(String[] args)
	{
		int[] nums = {0,0,0,0};
		List<List<Integer>> result = new Three_Sum().threeSum(nums);
		for (List<Integer> list : result)
		{
			System.out.println(list.toString());
		}
	}
}
