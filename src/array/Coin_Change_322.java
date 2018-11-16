/**
 * 
 */
package array;

import java.util.Arrays;

public class Coin_Change_322
{
    public int coinChange(int[] coins, int amount) {
    	if(coins == null || coins.length == 0)
    		return 0;
    	
        int[] dp = new int[amount+1];
        
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        
        for(int i = 1; i < amount+1; i++)
        {
        	for(int j = 0; j < coins.length; j++)
        	{
        		if(coins[j] <= i)
        			dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
        	}
        }
        
        
        return dp[amount]>amount ? -1:dp[amount];
    }
    
    public static void main(String[] args)
	{
		int coins[] = {2};
		int coinChange = new Coin_Change_322().coinChange(coins, 3);
		System.out.println(coinChange);
	}
}
