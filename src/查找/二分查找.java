package 查找;

public class 二分查找
{
	/*折半查找*/
	public int search(int[] nums, int target) 
	{
        int left = 0,right = nums.length-1;
        while(left <= right)
        {
        	int mid = (left+right)/2;
        	int num = nums[mid];
        	if(num < target)
        	{
        		left = mid+1;
        	}
        	else if(target < num)
        	{
        		right = mid-1;
        	}
        	else return mid;
        }
        return -1;
	}
}
