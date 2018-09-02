import java.util.Arrays;

public class Three_Sum_closest
{
    public int threeSumClosest(int[] nums, int target) 
    {
    	Arrays.sort(nums);
    	int result = 0;
    	int gap = Integer.MAX_VALUE;
    	for(int i = 0; i < nums.length; i++)
    	{
    		int j=i+1;
    		int k=nums.length-1;
    		while(j < k)
    		{
    			int tmp = target-nums[i]-nums[j]-nums[k];
    			
    			if(Math.abs(tmp) < gap)
    			{
    				gap = Math.abs(tmp);
    				result = nums[i] + nums[j] + nums[k];
    			}
    			
    			if(tmp > 0)
    				j++;
    			else if(tmp < 0)
    			{
    				tmp = -tmp;
    				k--;
    			}
    			else
    				return target;
    		}
    	}
    	
    	return result;
    }
    
    public static void main(String[] args)
	{
		int[] nums = {-1, 2, 1, -4};
		int threeSumClosest = new Three_Sum_closest().threeSumClosest(nums, -10);
		System.out.println(threeSumClosest);
	}
}
