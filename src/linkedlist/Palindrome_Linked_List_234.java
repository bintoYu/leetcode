/**
 * 
 */
package linkedlist;

public class Palindrome_Linked_List_234
{
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        
        //强行和前面做过的题保持一致，但这样的话，slow会落在左半边的最后一个。
        while(fast.next != null && fast.next.next != null)
        {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        //slow.next才是右半边的第一个,进行翻转
        ListNode right = reverse(slow.next);
        //比较
        ListNode left = head;
        while(right!=null && left!=null)
        {
        	if(right.val != left.val)
        		return false;
        	right = right.next;
        	left = left.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head)
    {
    	ListNode cur = head;
    	ListNode pre = null;
    	while(cur != null)
    	{
    		ListNode nextNode = cur.next;
    		cur.next = pre;
    		pre = cur;
    		cur = nextNode;
    	}
    	
    	return pre;
    }
    
    public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);
		
		boolean palindrome = new Palindrome_Linked_List_234().isPalindrome(head);
		System.out.println(palindrome);
	}
}
