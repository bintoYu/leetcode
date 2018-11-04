import java.util.HashMap;
import java.util.Map;

public class Longest_Consecutive_Sequence_128
{
	private int res = 0;
	private Map<Integer, Integer> map = new HashMap<>();
    public int longestConsecutive(int[] nums) {
    	for(int i = 0; i < nums.length; i++)
    	{
    		if(map.get(nums[i]) == null)
    		{
        		int left = (map.get(nums[i]-1) == null)?0:map.get(nums[i]-1);
        		int right = (map.get(nums[i]+1) == null)?0:map.get(nums[i]+1);
        		int length = left + right + 1;
        		map.put(nums[i], length);
        		map.put(nums[i]-left, length);
        		map.put(nums[i]+right, length);
        		res = Math.max(res, length);
    		}
    	}
		return res;
    }
    
    public static void main(String[] args)
	{
    	int[] nums = {100, 4, 200, 1, 3, 2};
		int res = new Longest_Consecutive_Sequence_128().longestConsecutive(nums);
		System.out.println(res);
	}
}
