/**
 * 
 */
package linkedlist;

/**
 * @author Administrator
 * 
 * @date 2018年9月11日
 * @version 1.0
 */
public class Remove_Nth_Node_From_End_of_List
{
	public ListNode removeNthFromEnd(ListNode head, int n)
	{
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode i = dummy;
		ListNode j = dummy;
		
		for(int index = 0; index < n+1;index++)
		{
			if(i!=null)
				i = i.next;
		}
		
		while(i!=null)
		{
			i = i.next;
			j = j.next;
		}
		
		j.next = j.next.next;
		return dummy.next;
	}
	
	
	public static void main(String[] args)
	{
		int[] ll = {1};
    	
    	ListNode l = new ListNode(ll[0]);
    	ListNode start = l;
    	for(int i = 0; i < ll.length -1 ; i++)
    	{
    		l.next = new ListNode(ll[i+1]);
    		l = l.next;
    	}
    	
    	ListNode result = new Remove_Nth_Node_From_End_of_List().removeNthFromEnd(start, 1);
    	
    	while(result != null)
    	{
    		System.out.print(result.val + "  ");
    		result = result.next;
    	}
	}
}
