package array;

import java.util.Arrays;

public class Find_the_Duplicate_Number_287
{
    public int findDuplicate(int[] nums) {
    	Arrays.sort(nums);
    	for(int i = 1; i < nums.length; i++)
    	{
    		if(nums[i] == nums[i-1])
    			return nums[i];
    	}
    	
    	return -1;
    }
    
    public static void main(String[] args)
	{
    	int[] nums = {1,3,4,2,2};
    	int findDuplicate = new Find_the_Duplicate_Number_287().findDuplicate(nums);
    	System.out.println(findDuplicate);
	}
}
