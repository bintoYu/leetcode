package tree;

import java.util.LinkedList;

public class Maximum_Depth_of_Binary_Tree_104
{
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
    	
        int res = 0;
    	LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty())
        {
        	res++;
        	int num = queue.size();
        	for(int i = 0; i < num; i++)
        	{
        		TreeNode pNode = queue.poll();
        		if(pNode.left != null) queue.offer(pNode.left);
        		if(pNode.right != null) queue.offer(pNode.right);
        	}
        }
        
        return res;
    }
}
