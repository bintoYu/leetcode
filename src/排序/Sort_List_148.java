package 排序;

import linkedlist.ListNode;

public class Sort_List_148
{
	public ListNode sortList(ListNode head)
	{
		if(head == null || head.next == null) return head;
		
		ListNode midNext = getMidNext(head);
		ListNode left = sortList(head);
		ListNode right = sortList(midNext);
		return merge(left, right);
		
	}
	
	private ListNode getMidNext(ListNode head)
	{
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast.next != null && fast.next.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode midNext = slow.next;  //右半链表的开始 
		slow.next = null; // 将链一分为二
		return midNext;
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
