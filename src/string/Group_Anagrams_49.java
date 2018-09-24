package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Group_Anagrams_49
{
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        if(strs.length==0) return null;
        
		for(String str : strs)
		{
        	char[] tmp = str.toCharArray();
        	Arrays.sort(tmp);
        	String key = String.valueOf(tmp);
        	if(!map.containsKey(key))
        		map.put(key, new ArrayList<String>());
        	map.get(key).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
    
    public static void main(String[] args)
	{
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = new Group_Anagrams_49().groupAnagrams(strs);
	}
}
