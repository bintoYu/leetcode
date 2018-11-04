package 排序;

import java.util.Collections;

public class Sort_Colors_75
{
	/**
	 * 直接能想到的最简单版本：
	 * 先遍历一遍，算出0、1、2的个数
	 * 然后再遍历一遍，依次填充即可
	 * @param nums
	 */
    public void sortColors_simple(int[] nums) {
        int idx = 0; 
        int[] count = new int[3];
        for(int i = 0; i < nums.length; i++)
        {
        	count[nums[i]]++;
        }
        
        for(int i = 0; i < 3; i++)
        {
        	int j = 0;
        	while(j < count[i])
        	{
        		nums[idx++] = i;
        		j++;
        	}
        }
    }
    
    /**
     * 只遍历一遍的方法
     * 使用双指针，当nums[i] == 0时，与left指针交换位置，并右移left指针
     * 当nums[i] == 2时，与right指针交换位置，并左移right指针以及指针i
     * @param nums
     */
    public void sortColors(int[] nums) {
    	int left = 0,right = nums.length -1 ;
        for(int i = 0; i <= right; i++)
        {
        	if(nums[i] == 0)
        	{
        		//交换
        		int tmp = nums[left];
        		nums[left] = nums[i];
        		nums[i] = tmp;
        		left++;
        	}
        	else if(nums[i] == 2)
        	{
        		//交换
        		int tmp = nums[right];
        		nums[right] = nums[i];
        		nums[i] = tmp;
        		i--;right--;
        	}
        }
    }
    
    public static void main(String[] args)
	{
    	int[] nums = {1,2,0};
		new Sort_Colors_75().sortColors(nums);
		System.out.println(1);
	}
}
