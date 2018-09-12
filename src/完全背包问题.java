import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * 
 */

/**
 * @author ybt
 *
 * @date 2018年9月10日  
 * @version 1.0  
 */
public class 完全背包问题
{
	public int[][] dynamic_all(int v[],int w[],int[] n,int N,int W )
	{
		ArrayList<Integer> list_w = new ArrayList<>();
		ArrayList<Integer> list_v = new ArrayList<>();
		
		for(int i = 0; i < N; i++)
		{
			//t = 2^k
			int t = 1;
			int s = n[i];
			while(t < n[i])
			{
				s = s - t;
				list_w.add(w[i] * t);
				list_v.add(v[i] * t);
				t = t*2;
			}
			//补充不足指数的差值
			list_w.add(w[i] * s);
			list_v.add(v[i] * s);
		}
		
		return null;
	}
	
	public static void main(String[] args)
	{
	}
}
