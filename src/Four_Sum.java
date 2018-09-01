import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four_Sum
{
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 4; i++)
        {
        	int j = i + 1;
        	int l = nums.length -1;
        	for(int k = j+1; k < nums.length - 3 ; k++)
        	{
        		int num = target-nums[i]-nums[j]-nums[k]-nums[l];
        		if(num > 0)
        			k++;
        		else if(num < 0)
        			l--;
        		else
        			result.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));

        	}
        }
    }
}
