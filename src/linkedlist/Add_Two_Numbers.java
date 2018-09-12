package linkedlist;

public class Add_Two_Numbers
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode p = l1;ListNode q = l2;
    	int sum = 0;
    	ListNode result = new ListNode(0);
    	ListNode start = result;
    	while(p != null || q!= null)
    	{
    		int x = (p!=null)?p.val:0;
    		int y = (q!=null)?q.val:0;
    		sum += x + y;

    		result.next = new ListNode(sum%10);
    		sum = sum/10;
    		result = result.next;
    		
    		if(p!=null) p = p.next;
    		if(q!=null) q = q.next;
    	}
    	
    	if(sum > 0)
    		result.next = new ListNode(sum);
    	
    	return start.next;
    }
    
    
    		 
    public static void main(String[] args)
	{
//    	int[] ll1 = {2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9};
//    	int[] ll2 = {5,6,4,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9,9,9,9};

    	int[] ll1 = {5};
    	int[] ll2 = {6};
    	
    	ListNode l1 = new ListNode(ll1[0]);
    	ListNode l2 = new ListNode(ll2[0]);
    	ListNode start1 = l1;
    	ListNode start2 = l2;
    	for(int i = 0; i < ll1.length -1 ; i++)
    	{
    		l1.next = new ListNode(ll1[i+1]);
    		l2.next = new ListNode(ll2[i+1]);
    		l1 = l1.next;
    		l2 = l2.next;
    	}
    	
    	ListNode addTwoNumbers = new Add_Two_Numbers().addTwoNumbers(start1,start2);
    	while(addTwoNumbers != null)
    	{
    		System.out.print(addTwoNumbers.val + "->");
    		addTwoNumbers = addTwoNumbers.next;
    	}
	}
}