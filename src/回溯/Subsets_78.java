package 回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Subsets_78
{
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	List<Integer> tempList = new ArrayList<>();
        backTrace(nums, res, tempList,0);
        	
        return res;
    }
    
    public void backTrace(int[] nums,List<List<Integer>> res, List<Integer> tempList,int start)
    {
    	res.add(new ArrayList<>(tempList));
    	
	    for(int i = start; i < nums.length; i++)
	    {
	    	if(tempList.contains(nums[i]))
	    		continue;
	    	tempList.add(nums[i]);
	    	backTrace(nums, res, tempList,i+1);
	    	tempList.remove(tempList.size()-1);
	    }
    }
    
    public static void main(String[] args)
	{
		int[] nums = {0,1,2};
		List<List<Integer>> res = new Subsets_78().subsets(nums);
		for (List<Integer> list : res)
		{
			System.out.println(list);
		}
	}
}
