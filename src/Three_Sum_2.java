import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Three_Sum_2
{
	public List<List<Integer>> threeSum(int[] nums)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++)
		{
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) // 去重
			{
				int j = i + 1;
				int k = nums.length - 1;
				while (j < k)
				{
					int num = 0 - nums[i] - nums[j] - nums[k];
					if (num > 0)
						j++;
					else if (num < 0)
						k--;
					else
					{
						result.add(Arrays.asList(nums[i], nums[j], nums[k]));
						while (j < k && nums[j] == nums[j + 1])
							j++; // 去重
						while (j < k && nums[k] == nums[k - 1])
							k--; // 去重
						j++;
						k--;
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		int[] nums =
		{ -1,0,0,0 };
		List<List<Integer>> result = new Three_Sum_2().threeSum(nums);

		for (List<Integer> list : result)
		{
			System.out.println(list);
		}
	}
}
