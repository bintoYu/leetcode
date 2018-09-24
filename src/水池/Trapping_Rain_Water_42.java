package 水池;

public class Trapping_Rain_Water_42
{
	
	/**
	 * 方法1：时间复杂度O(n2)
	 * 直接考虑每个位置的存水量
	 * 即对于位置i来说，只需要考虑它左边的最大值，及右边的最大值
	 * 这两个中的最小值-i本身的高度，就是存水量
	 * @param height
	 * @return
	 */
	 public int trap1(int[] height) {
		    int ans = 0;
		    int size = height.length;
		    for (int i = 1; i < size - 1; i++) {
		        int max_left = 0, max_right = 0;
		        for (int j = i; j >= 0; j--) { //Search the left part for max bar size
		            max_left = Math.max(max_left, height[j]);
		        }
		        for (int j = i; j < size; j++) { //Search the right part for max bar size
		            max_right = Math.max(max_right, height[j]);
		        }
		        ans += Math.min(max_left, max_right) - height[i];
		    }
		    return ans;
	 }
	
	
	/**
	 * 方法2：时间复杂度O(n)  推荐！！！
	 * 从左往右遍历，获得最大值（递增）
	 * 再从右往坐遍历，获得最大值（递增）
	 * 两者的交集就是解
	 * @param height
	 * @return
	 */
    public int trap2(int[] height) {
    	int[] left_max = new int[height.length];
    	int[] right_max = new int[height.length];
    	int res = 0;
    	
    	//从左往右获得最高长度
    	left_max[0] = height[0];
    	for(int i = 1; i < height.length; i++)
    	{
    		left_max[i] = Math.max(height[i], left_max[i-1]);
    	}
    	//从右往左获得最高长度
    	right_max[height.length-1] = height[height.length-1];
    	for(int i = height.length-2; i >=0; i--)
    	{
    		right_max[i] = Math.max(height[i], right_max[i+1]);
    	}
    	
    	for(int i = 0; i < height.length; i++)
    	{
    		res += Math.min(left_max[i], right_max[i]) - height[i];
    	}
    	
    	return res;
    }
    
    
    
    public static void main(String[] args)
	{
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		int trap = new Trapping_Rain_Water_42().trap1(height);
		System.out.println(trap);
	}
}
