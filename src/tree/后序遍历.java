package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class 后序遍历
{
	 public List<Integer> postorderTraversal(TreeNode root) 
	 {
		 ArrayList<Integer> list = new ArrayList<>();
	     Stack<TreeNode> stack = new Stack<>();
	     Map<TreeNode, Integer> map = new HashMap<>();
	     TreeNode pNode = root;  
	     
	     while(pNode != null || !stack.isEmpty())
	     {
	    	 if(pNode!=null)
	    	 {
	    		 stack.push(pNode);
	    		 pNode = pNode.left;
	    	 }
	    	 else
	    	 {
	    		 pNode = stack.peek();
	    		 if(pNode != null)
	    		 {
	    			 //已经访问过的话，直接pop出来，输出结果，然后这棵子数已完毕，pNode设为null
	    			 if(map.get(pNode)!=null)
	    			 {
	    				 pNode = stack.pop();
	    				 list.add(pNode.val);
	    				 pNode = null;
	    			 }
	    			 //没有访问的话，标记为已访问，并直接进入右结点，
	    			 else 
	    			 {
	    				 map.put(pNode, 1);
	    				 pNode = pNode.right;
	    			 }
	    		 }
	    	 }
	     }
	     return list;
	 }
	 
	 public static void main(String[] args)
	{
		 TreeNode root = new TreeNode(1);
		 TreeNode pNode = root;
		 pNode.left = new TreeNode(2);
		 pNode.right = new TreeNode(3);
		 pNode.left.left = new TreeNode(4);
		 pNode.left.right = new TreeNode(5);
		 pNode.right.left = new TreeNode(6);
		 
		 List<Integer> list = new 后序遍历().postorderTraversal(root);
		 
		 System.out.println(list);
	}
}
