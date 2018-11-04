package linkedlist;

public class Linked_List_Cycle2_142
{
	public ListNode detectCycle(ListNode head)
	{
		if (head == null || head.next == null)
			return null;

		ListNode slow = head;
		ListNode fast = head;
		boolean isCycle = false;

		while (fast.next != null && fast.next.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
			{
				isCycle = true;
				break;
			}
		}

		if (!isCycle)
			return null;

		slow = head;
		while (slow != fast)
		{
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	public static void main(String[] args)
	{
		ListNode node = new ListNode(1);
		ListNode head = node;
		node.next = new ListNode(2);
		 node.next.next = new ListNode(3);
		 node.next.next.next = new ListNode(4);
//		 node.next.next.next.next = node.next;

		ListNode detectCycle = new Linked_List_Cycle2_142().detectCycle(head);
		System.out.println(detectCycle.val);
	}
}
