package linkedlist;

public class Linked_List_Cycle_141
{
    public boolean hasCycle(ListNode head) {
    	if(head == null) return false;
    	
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null)
        {
        	slow = slow.next;
        	fast = fast.next.next;
        	
        	if(slow == fast)
        		return true;
        }
        
        return false;
    }
    
    public static void main(String[] args)
	{
    	ListNode node = new ListNode(1);
    	ListNode head = node;
    	node.next = new ListNode(2);
//    	node.next.next = new ListNode(3);
    	
    	boolean hasCycle = new Linked_List_Cycle_141().hasCycle(head);
    	System.out.println(hasCycle);
	}
}
