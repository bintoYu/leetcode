package tree;

public class Binary_Tree_Maximum_Path_Sum_124
{
	private int res = Integer.MIN_VALUE;
	
    public int maxPathSum(TreeNode root) {
    	getMax(root);
    	return res;
    }
    
    private int getMax(TreeNode pNode)
    {
    	if(pNode == null) return 0;
    	int left = Math.max(0, getMax(pNode.left));
    	int right = Math.max(0, getMax(pNode.right));
    	res = Math.max(res, left+right+pNode.val);
    	return Math.max(left, right) + pNode.val;
    }
}
