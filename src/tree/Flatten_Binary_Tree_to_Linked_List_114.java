package tree;

import java.util.Stack;

public class Flatten_Binary_Tree_to_Linked_List_114
{
	private TreeNode pre = null;
	
    public void flatten(TreeNode root) {
    	if(root == null) return;
    	flatten(root.right); 
    	flatten(root.left);
    	
    	root.right = pre;
    	root.left = null;
    	pre = root;
    }
}
