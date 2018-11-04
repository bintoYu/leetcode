package tree;

import java.util.Stack;

public class Validate_Binary_Search_Tree_98
{
    public boolean isValidBST(TreeNode root) {
    	if(root == null)
    		return true;
    	
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pNode = root;
        TreeNode pre = null;
        
        while(pNode != null || !stack.isEmpty())
        {
        	if(pNode != null)
        	{
        		stack.push(pNode);
        		pNode = pNode.left;
        	}
        	else
        	{
        		pNode =stack.pop();
        		if(pre != null && pre.val >= pNode.val) return false;
        		pre = pNode;
        		pNode = pNode.right;
        	}
        }
        
        return true;
    }
    
    public static void main(String[] args)
	{
		
	}
}
