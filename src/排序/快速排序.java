/**
 * 
 */
package 排序;

/**
 * @author Administrator
 *
 * @date 2018年11月5日  
 * @version 1.0  
 */
public class 快速排序
{
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
	
	public void quickSort(int[] array,int start,int end)
	{
		if(start == end)
			return ;
		int index = Partition(array, start, end);
		if(index > start)
			quickSort(array, start, index - 1);
		if(index < end)
			quickSort(array, index + 1, end);
	}
}
