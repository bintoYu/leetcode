package array;

public class Maximum_Product_Subarray_152
{
    public int maxProduct(int[] nums) {
    	//dp[][]：第一行存当前位置的最大值
    	//		    第二行存当前位置的最小值（因为负*最小值=最大值）
    	int[][] dp = new int[2][nums.length];
    	dp[0][0] = nums[0];
    	dp[1][0] = nums[0];
    	
    	int max = nums[0];
    	for(int i = 1; i < nums.length; i++)
    	{
    		//正数时，最大=自己 或 上一时刻最大*自己
    		//		最小=自己 或 上一时刻最小*自己
    		if(nums[i] >= 0)
    		{
    			dp[0][i] = Math.max(nums[i], nums[i]*dp[0][i-1]);
    			dp[1][i] = Math.min(nums[i], nums[i]*dp[1][i-1]);
    		}
    		//为负数时，乘要反着来（负负得正）
    		else
    		{
    			dp[0][i] = Math.max(nums[i], nums[i]*dp[1][i-1]);
    			dp[1][i] = Math.min(nums[i], nums[i]*dp[0][i-1]);
    		}
    		
    		max = Math.max(max, dp[0][i]);
    	}
    	
    	return max;
    }
    
    public static void main(String[] args)
	{
		int[] nums = {-2,0,-1};
		int maxProduct = new Maximum_Product_Subarray_152().maxProduct(nums);
		System.out.println(maxProduct);
	}
}
