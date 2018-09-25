package array;

import java.util.ArrayList;
import java.util.List;

public class Merge_Intervals_56
{
    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> res = new ArrayList<>();
    	
    	if(intervals.size() ==0 || intervals == null)
    		return res;
    	
        Interval interval = intervals.get(0);
	    for(int i = 1; i < intervals.size(); i++)
	    {
	    	Interval interval2 = intervals.get(i);
	    	if(interval.start <= interval2.end && interval.end >= interval2.start )
	    	{
	    		interval.start = Math.min(interval.start, interval2.start);
	    		interval.end = Math.max(interval.end, interval2.end);
	    	}
	    	else
	    	{
	    		res.add(interval);
	    		interval = interval2;
	    	}
	    }
	    
	    res.add(interval);
	    return res;
    }
    
    public static void main(String[] args)
	{
		Interval interval1= new Interval(1, 3);
		Interval interval2= new Interval(2, 6);
		Interval interval3= new Interval(8, 10);
		Interval interval4= new Interval(15, 18);
		List<Interval> intervals = new ArrayList<Interval>(){};
		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);
		intervals.add(interval4);
		
		new Merge_Intervals_56().merge(intervals);
	}
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}