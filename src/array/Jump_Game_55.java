package array;

enum Index {
    GOOD, BAD, UNKNOWN
}

public class Jump_Game_55
{
	/**
	 * 创建一个dp数组Index[] dp;用来存储“当前位置能否到达下一个Good位置"
	 * 因此先将目的位置设置成GOOD。然后从后往前遍历即可。
	 * 需要注意的细节是，每个位置都要遍历“自己到自己所能到达的最远距离”的所有位置。因此需要计算出最远节点。
	 * @param nums
	 * @return
	 */
    public boolean canJump1(int[] nums) {
    	Index[] dp = new Index[nums.length];
    	
    	for(int i = 0; i < nums.length-1; i++)
    		dp[i] = Index.UNKNOWN;
    	dp[nums.length-1] = Index.GOOD;
    	
    	for(int i = nums.length-2; i >= 0; i--)
    	{
    		int furthestPosition = Math.min(nums.length-1, i + nums[i]);
    		for(int j = i+1; j <= furthestPosition; j++)
    		{
    			if(dp[j] == Index.GOOD)
    			{
    				dp[i] = Index.GOOD;
    				break;
    			}
    		}
    	}
    	
    	return dp[0] == Index.GOOD;
    }
    
    /**
     * 进一步优化，不使用dp数组来进行存储，只存“离当前位置最近的Good的位置”
     * 这样从后往前遍历一次即可
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
    	int lastPos = nums.length - 1;
    	for(int i = nums.length-1; i >= 0; i--)
    	{
    		if(i + nums[i] > lastPos)
    		{
    			lastPos = i;
    		}
    	}
    	return lastPos == 0;
    }
    public static void main(String[] args)
	{
		int[] nums = {2,3,1,1,4};
		boolean canJump = new Jump_Game_55().canJump1(nums);
		System.out.println(canJump);
	}
}
