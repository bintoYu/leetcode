package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal_102
{
    public List<List<Integer>> levelOrder(TreeNode root) {
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	
    	if(root == null)
    		return res;
    	
    	queue.offer(root);
    	
    	while(!queue.isEmpty())
    	{
    		ArrayList<Integer> subList = new ArrayList<>();
    		
    		//遍历该层所有结点
    		int num = queue.size();
    		for(int i = 0; i < num; i++)
    		{
    			//存结果
    			TreeNode pNode = queue.poll();
    			subList.add(pNode.val);
    			//下一层结点放入队列
    			if(pNode.left != null) queue.offer(pNode.left);
    			if(pNode.right != null) queue.offer(pNode.right);
    		}
    		
    		res.add(subList);
    	}
    	
    	return res;
    }
}
