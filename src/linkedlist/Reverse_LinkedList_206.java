package linkedlist;

public class Reverse_LinkedList_206
{
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;
        }
        return pre;
    }
    
    public ListNode reverseListDFS(ListNode head) {
    	if(head == null || head.next == null) return head;
    	ListNode p = reverseListDFS(head.next);
    	head.next.next = head;
    	head.next = null;
    	return p; 
    }
    
    public static void main(String[] args)
	{
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	head.next.next.next = new ListNode(4);
    	head.next.next.next.next = new ListNode(5);
		new Reverse_LinkedList_206().reverseListDFS(head);
	}
}
