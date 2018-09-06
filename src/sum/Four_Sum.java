package sum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four_Sum
{
	public List<List<Integer>> fourSum(int[] nums, int target)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++)
		{
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) // ȥ��
			{
				int j = i + 1;

				int newTarget = target - nums[i];
				List<List<Integer>> threeSum = threeSum(nums, newTarget, j);

				for (List<Integer> list : threeSum)
				{
					result.add(Arrays.asList(nums[i], list.get(0), list.get(1),
							list.get(2)));
				}
			}
		}

		return result;
	}

	public static List<List<Integer>> threeSum(int[] nums, int target,
			int begin)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = begin; i < nums.length - 2; i++)
		{
			if (i == begin || (i > begin && nums[i] != nums[i - 1])) // ȥ��
			{
				int j = i + 1;
				int k = nums.length - 1;
				while (j < k)
				{
					int num = target - nums[i] - nums[j] - nums[k];
					if (num > 0)
						j++;
					else if (num < 0)
						k--;
					else
					{
						result.add(Arrays.asList(nums[i], nums[j], nums[k]));
						while (j < k && nums[j] == nums[j + 1])
							j++; // ȥ��
						while (j < k && nums[k] == nums[k - 1])
							k--; // ȥ��
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
		{ -1, -5,-1,-5, -5, -3, 2, 5, 0, 4 };
		List<List<Integer>> result = new Four_Sum().fourSum(nums, -7);

		for (List<Integer> list : result)
		{
			System.out.println(list);
		}
	}
}
