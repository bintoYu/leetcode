/**
 * 
 */
package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Top_K_Frequent_Elements_347
{
    public List<Integer> topKFrequent(int[] nums, int k) {
    	if(nums == null || nums.length == 0) return null;
    	
    	List<Integer>[] bucket = new List[nums.length+1];
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	
    	for(int num : nums)
    	{
    		if(map.containsKey(num))
    			map.put(num, map.get(num)+1);
    		else
    			map.put(num, 1);
    	}
    	
    	for(int key : map.keySet())
    	{
    		int frequency = map.get(key);
    		if(bucket[frequency] == null)
    			bucket[frequency] = new ArrayList<>();
    		bucket[frequency].add(key);
    	}
    	
    	List<Integer> res = new ArrayList<>();
    	for(int pos = bucket.length-1 ; pos > 0 && res.size() < k; pos--)
    	{
    		if(bucket[pos] != null)
    			res.addAll(bucket[pos]);
    	}
    	
    	return res;
    }
}
