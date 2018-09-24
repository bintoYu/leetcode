package 排序;

import java.util.Arrays;

public class 归并排序
{
	public static void main(String[] args)
	{
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] nums)
	{
		if(nums.length==0 || nums==null)
			return ;
		
		int[] tmp = new int[nums.length];
		sort(nums, 0, nums.length-1, tmp);
	}
	
	private static void sort(int[]nums,int begin,int end,int[] tmp)
	{
		if(begin < end)
		{
			int mid = (begin+end)/2;
			sort(nums,begin,mid,tmp);
			sort(nums, mid+1, end, tmp);
			merge(nums, begin, mid, end, tmp);
		}
	}
	
	private static void merge(int[]nums,int left,int mid,int right,int[] tmp)
	{
		int i = left;
		int j = mid+1;
		int t = 0;
		
		while(i <= mid && j <= right)
		{
			if(nums[i] < nums[j])
				tmp[t++] = nums[i++];
			else
				tmp[t++] = nums[j++];
		}
		while(i<=mid)
		{
			tmp[t++] = nums[i++];
		}
		while(j<=right)
		{
			tmp[t++] = nums[j++];
		}
		
		t = 0;
		
		//将tmp全部拷贝到原数组中
		while(left <= right)
		{
			nums[left++] = tmp[t++];
		}
	}
}
