
public class Maximum_Subarray_53
{
	/**
	 * 方法：使用dp算法
	 * 最大子串 = 自己 或 (前一时刻的最长字串 + 自己)
	 * @param nums
	 * @return
	 */
	 public int maxSubArray(int[] nums) {
		 int[] dp = new int[nums.length];
		 dp[0] = nums[0];
		 int max = dp[0];
		 
		 for(int i = 1; i < nums.length; i++)
		 {
			 dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1]:0);
			 max = Math.max(max, dp[i]);
		 }
		 
		 return max;
	 }
	 
	 
	 public static void main(String[] args)
	{
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int maxSubArray = new Maximum_Subarray_53().maxSubArray(nums);
		System.out.println(maxSubArray);
	}
}
