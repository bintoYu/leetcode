/**
 * 
 */
package linkedlist;

/**
 * @author ybt
 *
 * @date 2018年9月13日  
 * @version 1.0  
 */
public class Merge_k_Sorted_Lists_23
{
    public ListNode mergeKLists(ListNode[] lists) {
        
    }
    
    public ListNode mergeKLists(ListNode[] lists,int begin,int end) {
    	int mid = (begin+end)/2;
    	
    	mergeTwoListsWithRecursion(lists[begin], lists[mid]);
    	mergeTwoListsWithRecursion(lists[mid+1], lists[end]);
    }
    
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
