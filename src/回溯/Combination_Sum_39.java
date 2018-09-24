package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使用回溯算法(backtracking)
 *
 */
public class Combination_Sum_39
{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;	
    }
    
    //回溯算法步骤：
    //1、回溯函数的开头要写好结束回溯的条件（带return）。
    //2、（具体看题目）已经拿过的数不再拿 if(s.contains(num)){continue;}
    //3、templist在递归之前先add。递归后为了回溯到上一步，要去掉已经加入到结果tempList中的当前节点。
    public void backtrack(List<List<Integer>> res, List<Integer> tempList,int[] candidates,int remain,int start)
    {
    	if(remain < 0)
    		return ;
    	else if(remain == 0)
    		res.add(new ArrayList<>(tempList));
    	else
    	{
    		for(int i = start; i < candidates.length; i++)
    		{
    			tempList.add(candidates[i]);
    			backtrack(res, tempList, candidates, remain - candidates[i], i);
    			tempList.remove(tempList.size() - 1);
    		}
    	}
    }
}
