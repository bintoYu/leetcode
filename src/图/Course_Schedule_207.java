package 图;

import java.util.LinkedList;

public class Course_Schedule_207
{
	/**
	 * [2,0] 即 2 <-- 0 ,即prerequisites[i][0] 是被指的点，prerequisites[i][1]是指向别人的点
	 * 判断有向图无环的方法：
	 * 如果图中无环的话，必然至少存在一个点，没有指向该点的边（例如一条链的起点），这样的点称为入度为0的点
	 * 因此，我们需要找出所有这样的点，存在队列中
	 * 然后把队列中的点指向的边都给去掉，例如 0 --> 2 ,如果去掉这条边后，2没有任何其他点指向，则也放入队列中。
	 * 如何找出这样的点：存一下每个点被指向的次数，为0的就是这样的点。
	 * 判断条件：没有指向的点个数 = 总个数
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
	    if(numCourses == 0 || prerequisites == null || prerequisites.length == 0)
	    	return true;
		
		int[] pCount = new int[numCourses];
		//存一下每个点的入度（被指向的次数）
		for(int i = 0; i < prerequisites.length; i++)
		{
			pCount[prerequisites[i][0]]++;
		}
		
		//将所有入度为0的点存入queue中
		LinkedList<Integer> queue = new LinkedList<>();
		for(int i = 0; i < numCourses; i++)
		{
			if(pCount[i] == 0)
				queue.offer(i);
		}
		
		int numNoPre = queue.size();
		
		//把队列中的点指向的边都给去掉(即pCount--)
		while(!queue.isEmpty())
		{
			int p = queue.poll();
			for(int i = 0; i < prerequisites.length; i++)
			{
				//指向别人的点 == p
				if(prerequisites[i][1] == p)
				{
					//被指向的点的边去掉
					pCount[prerequisites[i][0]]--;
					//没有任何其他点指向，则也放入队列中
					if(pCount[prerequisites[i][0]] == 0)
					{
						numNoPre++;
						queue.offer(prerequisites[i][0]);
					}
				}
			}
		}
		
		return numNoPre == numCourses;
	}
	
	public static void main(String[] args)
	{
		int [][] prerequisites = {{1,0}};
		new Course_Schedule_207().canFinish(2, prerequisites);
	}
	
//	public boolean canFinish(int numCourses, int[][] prerequisites) {
//	    if(prerequisites == null){
//	        throw new IllegalArgumentException("illegal prerequisites array");
//	    }
//	 
//	    int len = prerequisites.length;
//	 
//	    if(numCourses == 0 || len == 0){
//	        return true;
//	    }
//	 
//	    // counter for number of prerequisites
//	    int[] pCounter = new int[numCourses];
//	    for(int i=0; i<len; i++){
//	        pCounter[prerequisites[i][0]]++;
//	    }
//	 
//	    //store courses that have no prerequisites
//	    LinkedList<Integer> queue = new LinkedList<Integer>();
//	    for(int i=0; i<numCourses; i++){
//	        if(pCounter[i]==0){
//	            queue.add(i);
//	        }
//	    }
//	 
//	    // number of courses that have no prerequisites
//	    int numNoPre = queue.size();
//	 
//	    while(!queue.isEmpty()){
//	        int top = queue.remove();
//	        for(int i=0; i<len; i++){
//	            // if a course's prerequisite can be satisfied by a course in queue
//	            if(prerequisites[i][1]==top){
//	                pCounter[prerequisites[i][0]]--;
//	                if(pCounter[prerequisites[i][0]]==0){
//	                    numNoPre++;
//	                    queue.add(prerequisites[i][0]);
//	                }
//	            }
//	        }
//	    }
//	 
//	    return numNoPre == numCourses;
//	}
}
