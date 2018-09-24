package 查找;

public class Search_in_Rotated_Sorted_Array_33
{
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left <= right)
        {
        	int mid = (left+right)/2;
        	int num = nums[mid];
        	
        	//落于左半边：>=nums[0] ,落于右半边：<nums[0]
        	//mid在右边，而target在左边
        	if(nums[mid] < nums[0] && target >= nums[0])
        	{
        		num = Integer.MAX_VALUE;
        	}
        	//mid在左边，而target在右边
        	else if(nums[mid] >= nums[0] && target < nums[0])
        	{	
        		num = Integer.MIN_VALUE;
        	}
        	
        	if(num < target)
        	{
        		left = mid+1;
        	}
        	else if(num > target)
        	{
        		right = mid-1;
        	}
        	else return mid;
        }
        return -1;
    }
    
    
    public static void main(String[] args)
	{
		int[] nums = {1,3};
		int target = 2;
		int search = new Search_in_Rotated_Sorted_Array_33().search(nums, target);
		System.out.println(search);
	}
}
