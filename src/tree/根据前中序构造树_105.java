package tree;

import java.util.Arrays;
import java.util.Collections;

public class 根据前中序构造树_105
{
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	TreeNode root = buildTree(preorder,inorder,0,0,inorder.length - 1);
    	return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder,int preBegin, int inBegin,int inEnd) {
    	if(preBegin >= preorder.length || inBegin > inEnd) return null;
    	
    	int index = 0;
    	TreeNode root = new TreeNode(preorder[preBegin]);	
    	
    	for(int i = inBegin; i <= inEnd; i++)
    	{
    		if(inorder[i] ==  preorder[preBegin])
    		{
    			index = i;
    			continue;
    		}
    	}
    	
    	root.left = buildTree(preorder, inorder, preBegin + 1, inBegin, index - 1);
    	root.right = buildTree(preorder, inorder, preBegin + (index - inBegin + 1), index + 1, inEnd);
    	return root;
    }	
}
