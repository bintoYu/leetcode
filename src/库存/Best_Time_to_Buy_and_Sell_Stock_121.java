package 库存;

public class Best_Time_to_Buy_and_Sell_Stock_121
{
    public int maxProfit(int[] prices) {
    	int min = Integer.MAX_VALUE;
    	int res = 0;
        for(int i = 0; i < prices.length; i++)
        {
        	res = Math.max(res, prices[i]-min);
        	min = Math.min(prices[i] , min);
        }
        
        return res;
    }
    
    public static void main(String[] args)
	{
		int[] prices = {7,6,4,3,1};
		int maxProfit = new Best_Time_to_Buy_and_Sell_Stock_121().maxProfit(prices);
		System.out.println(maxProfit);
	}
}
