package tree;

public class 逆序遍历
{
    public void reverseOrder(TreeNode root) {
        if (root != null) {
            reverseOrder(root.right);
            reverseOrder(root.left);
            System.out.print(root.val + " ");
        }
    }
    
    
}
