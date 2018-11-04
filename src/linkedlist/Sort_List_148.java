package linkedlist;

import linkedlist.ListNode;

public class Sort_List_148
{
	public ListNode sortList(ListNode head)
	{
		if(head == null || head.next == null) return head;
		
		ListNode mid = getMid(head);
		ListNode left = sortList(head);
		ListNode right = sortList(mid);
		return merge(left, right);
		
	}
	
	private ListNode getMid(ListNode head)
	{
		ListNode slow = head;
		ListNode fast = head;
		ListNode pre = slow;
		
		while (slow != null && fast != null)
		{
			pre = slow;
			slow = slow.next;
			if (fast.next != null && fast.next.next != null)
				fast = fast.next.next;
			else
				break;
		}
		
		pre.next = null; // 将链一分为二
		return slow;
	}
	
	private ListNode merge(ListNode left, ListNode right)
	{
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while(left != null && right != null)
		{
			if(left.val < right.val)
			{
				cur.next = left;
				left = left.next;
			}
			else
			{
				cur.next = right;
				right = right.next;
			}
			cur = cur.next;
		}
		cur.next = (left!=null ? left:right);
		return dummy.next;
	}
}
