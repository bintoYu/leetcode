/**
 * 
 */
package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ybt
 *
 * @date 2018年9月13日  
 * @version 1.0  
 */
public class Merge_k_Sorted_Lists_23
{
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
        	return null;
        return mergeKLists(lists, 0, lists.length-1);
    }
    
    public ListNode mergeKLists(ListNode[] lists,int begin,int end) {
    	if(begin<end)
    	{
	    	int mid = (begin+end)/2;
	    	ListNode left = mergeKLists(lists, begin, mid);
	    	ListNode right = mergeKLists(lists, mid+1, end);
	    	return mergeTwoListsWithRecursion(left, right);
    	}
    	return lists[begin];
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
    
//	public ListNode mergeKLists(ListNode[] lists) {  
//        if(lists==null || lists.length==0)  
//            return null;  
//        return MSort(lists,0,lists.length-1);  
//    }  
//    
//    public ListNode MSort(ListNode[] lists, int low, int high){  
//        if(low < high){  
//            int mid = (low+high)/2;
//            ListNode leftlist = MSort(lists,low,mid);
//            ListNode rightlist = MSort(lists,mid+1,high);
//            return mergeTwoLists(leftlist,rightlist);  
//        }  
//        return lists[low];  
//    }
//
    public static void main(String[] args)
	{
    	int[] ll1 = {1,2};
    	int[] ll2 = {1,3};
    	int[] ll3 = {2,4};
    	int[] ll4 = {3,5};
    	int[] ll5 = {4,6};
    	int[] ll6 = {5,7};
    	
    	ListNode l1 = new ListNode(ll1[0]);
    	ListNode l2 = new ListNode(ll2[0]);
    	ListNode l3 = new ListNode(ll3[0]);
    	ListNode l4 = new ListNode(ll4[0]);
    	ListNode l5 = new ListNode(ll5[0]);
    	ListNode l6 = new ListNode(ll6[0]);
    	
    	ListNode start1 = l1;
    	ListNode start2 = l2;
    	ListNode start3 = l3;
    	ListNode start4 = l4;
    	ListNode start5 = l5;
    	ListNode start6 = l6;
    	
    	for(int i = 0; i < ll1.length -1 ; i++)
    	{
    		l1.next = new ListNode(ll1[i+1]);
    		l2.next = new ListNode(ll2[i+1]);
    		l3.next = new ListNode(ll3[i+1]);
    		l4.next = new ListNode(ll4[i+1]);
    		l5.next = new ListNode(ll5[i+1]);
    		l6.next = new ListNode(ll6[i+1]);
    		
    		l1 = l1.next;
    		l2 = l2.next;
    		l3 = l3.next;
    		l4 = l4.next;
    		l5 = l5.next;
    		l6 = l6.next;
    	}
    	
    	ListNode[] lists = new ListNode[6];
    	lists[0] = start1;
    	lists[1] = start2;
    	lists[2] = start3;
    	lists[3] = start4;
    	lists[4] = start5;
    	lists[5] = start6;
    	
    	ListNode mergeKLists = new Merge_k_Sorted_Lists_23().mergeKLists(lists);
    
    	while(mergeKLists != null)
    	{
    		System.out.print(mergeKLists.val + "-->");
    		mergeKLists = mergeKLists.next;
    	}
	}
		
}
