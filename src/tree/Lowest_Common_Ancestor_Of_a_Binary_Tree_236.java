/**
 * 
 */
package tree;

/**
 * 寻找最近祖先
 *
 */
public class Lowest_Common_Ancestor_Of_a_Binary_Tree_236
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	//递归找左右节点，遇到就返回
    	if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //左右节点都在的话，它自身就是最近的祖先
        if(left != null && right != null)
        	return root;
        //左右节点有一个没有，例如左节点没有的话，那就证明右节点是左节点的子树，这才会遍历不到（因为遇到左节点存在时就不再访问左节点的子树了），因此最近祖先就是左节点。
        return left != null?left:right;
    }
    
    public static void main(String[] args)
	{
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right  = new TreeNode(1);
		root.right.left  = new TreeNode(0);
		root.right.right  = new TreeNode(8);
		
		TreeNode lowestCommonAncestor = new Lowest_Common_Ancestor_Of_a_Binary_Tree_236().lowestCommonAncestor(root,root.left.left , root.right.right);
		System.out.println(lowestCommonAncestor.val);
	}
}
