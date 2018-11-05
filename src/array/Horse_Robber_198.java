package array;
/**
 * 
 */

/**
 * @author Administrator
 *
 * @date 2018年11月2日  
 * @version 1.0  
 */
public class Horse_Robber_198
{
    public int rob(int[] nums) {
    	if(nums.length==0 || nums == null) return 0;
    	if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++)
        {
        	dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
    
    public static void main(String[] args)
	{
		int[] nums = {2};
		int rob = new Horse_Robber_198().rob(nums);
		System.out.println(rob);
	}
}
