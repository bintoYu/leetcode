/**
 * 
 */
package linkedlist;

/**
 * @author ybt
 *
 * @date 2018年9月12日  
 * @version 1.0  
 */
public class Merge_Two_Sorted_Lists_21
{
	/**
	 * 新建一个链表，然后谁小连谁
	 * 最后的时候，还要将有剩余的链表连上
	 * @param l1
	 * @param l2
	 * @return
	 */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        ListNode i = l1;
        ListNode j = l2;
        
        while(i!=null && j!=null)
        {
        	if(i.val > j.val)
        	{
        		node.next = j;
        		j = j.next;
        	}
        	else
        	{
        		node.next = i;
        		i = i.next;
        	}
        	node = node.next;
        }
        
        node.next = (i ==null?j:i);
        return dummy.next;
    }
    
	/**
	 * 方法2:使用递归
	 * @param l1
	 * @param l2
	 * @return
	 */
    public ListNode mergeTwoListsWithRecursion(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoListsWithRecursion(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoListsWithRecursion(l1, l2.next);
			return l2;
		}
}
}
