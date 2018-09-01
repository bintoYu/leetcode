package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Find_Duplicate_File_in_System_609
{
	public List<List<String>> findDuplicate(String[] paths)
	{
		List<List<String>> result = new ArrayList<List<String>>();
		
		Map<String, Set<String>> map = new HashMap<String, Set<String>>();
		
		for(String path : paths)
		{
			String[] tmp = path.split("\\s+");	
		
			String dictionary = tmp[0];
			
			for(int i = 1; i < tmp.length; i++)
			{
				String contain = tmp[i].substring(tmp[i].indexOf("(") + 1,tmp[i].indexOf(")"));
				
				String file = tmp[i].substring(0, tmp[i].indexOf("("));
				
				String filename = dictionary + "/" + file;
				
				Set<String> filenames = map.getOrDefault(contain, new HashSet<String>());
				
				filenames.add(filename);
				
				map.put(contain, filenames);
			}
		}
		
		for(String key : map.keySet())
		{
			if(map.get(key).size() > 0)
			{
				List<String> tmp = new ArrayList<String>(map.get(key));
				
				result.add(tmp);
			}
		}
		
		return result;
	}
	
	
	public static void main(String[] args)
	{
		String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
		
		List<List<String>> list = new Find_Duplicate_File_in_System_609().findDuplicate(paths);
		
		list.get(0).get(0);
	}
}
