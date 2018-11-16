/**
 * 
 */
package tree;

import java.util.Arrays;
import java.util.LinkedList;

public class Serialize_and_Deserialize_Binary_Tree_297
{
    public String serialize(TreeNode root) {
    	StringBuffer sb = new StringBuffer();
    	buildString(root, sb);
        String res = sb.toString();
    	return res.substring(0,res.length()-1);
    }

    private void buildString(TreeNode root,StringBuffer sb)
    {
    	if(root == null)
        {
        	sb.append("null,");
        	return ;
        }
    	sb.append(root.val + ",");
    	buildString(root.left,sb);
    	buildString(root.right,sb);
    }
    
    public TreeNode deserialize(String data) {
        LinkedList<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return buildTree(queue);
    }
    
    private TreeNode buildTree(LinkedList<String> queue)
    {
    	String val = queue.poll();
    	if(val.equals("null"))
    		return null;
    	TreeNode root = new TreeNode(Integer.parseInt(val));
    	root.left = buildTree(queue);
    	root.right = buildTree(queue);
    	return root;
    }
    
    public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		String res = new Serialize_and_Deserialize_Binary_Tree_297().serialize(root);
		System.out.println(res);
	}
}
