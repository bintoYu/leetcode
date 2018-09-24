package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Permutations_46
{
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> tempList = new ArrayList<>();
        backtrack(res, tempList, nums);
        return res;
    }
    
    public void backtrack(List<List<Integer>> res,List<Integer> tempList,int[] nums)
    {
    	if(tempList.size() == nums.length)
    		res.add(new ArrayList<>(tempList));
    	else
    	{
    		for(int i = 0; i < nums.length; i++)
    		{
    			if(tempList.contains(nums[i]))
    				continue;
    			tempList.add(nums[i]);
		    	backtrack(res, tempList, nums);
		    	tempList.remove(tempList.size()-1);
    		}
    	}
    }
    
    public static void main(String[] args)
	{
		int[] nums = {1,2,3};
		List<List<Integer>> res = new Permutations_46().permute(nums);
		for (List<Integer> list : res)
		{
			System.out.println(list);
		}
	}
}
