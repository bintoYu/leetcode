package 查找;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array_34
{
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        int left = 0, right = nums.length-1;
        
        if(nums.length==0)
        	return res;
        if(target < nums[left] || nums[right] < target)
        	return res;
        
        while(left<=right)
        {
        	int mid = (left+right)/2;
        	int num = nums[mid];
        	if(num < target)
        		left = mid +1;
        	else if(target < num)
        		right = mid-1;
        	else
        	{
        		left = mid;
        		right = mid;
                while(left - 1 >= 0 && nums[left - 1] == target) left--;
                while(right + 1 <= nums.length-1 && nums[right + 1] == target) right++;
                break;
        	}
        }
        
        if(nums[left] == target)
        {
        	res[0] = left;res[1]=right;
        }
        
        return res;
    }
    
    public static void main(String[] args)
	{
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		
		int[] i = new Find_First_and_Last_Position_of_Element_in_Sorted_Array_34().searchRange(nums, target);
		System.out.println(i[0] + "\t" + i[1]);
	}
    
}
