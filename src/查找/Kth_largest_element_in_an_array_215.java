/**
 * 
 */
package 查找;

/**
 * @author Administrator
 *
 * @date 2018年11月5日  
 * @version 1.0  
 */
public class Kth_largest_element_in_an_array_215
{
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0)
        	return 0;
        
        int start = 0;
        int end = nums.length-1;
        int index = Partition(nums, start, end);
        
        while(index != k-1)
        {
        	if(index > k-1)
        	{
        		index = Partition(nums, start, index - 1);
        	}
        	else
        	{
        		index = Partition(nums, index + 1, end);
        	}
        }
        
        return nums[nums.length-1-k];
    }
    
	public static int Partition(int[] array,int start,int end){
        int key=array[start];
        while(start < end){
            while(array[end] > key && end > start){//从后半部分向前扫描
                end--;
            }
            array[start]=array[end];
            while(array[start] <= key && end>start){//从前半部分向后扫描
                start++;
            }
            array[end]=array[start];
        }
        array[end]=key;
        return end;
    }
}
