package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Binary_Tree_Inorder_Traversal_94
{
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pNode = root;  
        
        while(pNode != null || !stack.isEmpty()){
        	if(pNode != null)
        	{
        		stack.push(pNode);
        		pNode = pNode.left;
        	}else
        	{
        		pNode = stack.pop();
        		list.add(pNode.val);
        		pNode = pNode.right;
        	}
        }
        return list;
    }
}
