
public class Main {

	public static void main(String [] args) {
		
		ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(8, new ListNode(11))));
		ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(8, new ListNode(11))));
		
		ListNode sorted = mergeTwoLists(list1, list2);
		print(sorted);
		
	}
	
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
    	if(list1 == null) return list2;
    	else if(list2 == null) return list1;
    	ListNode current1 = list1;
    	ListNode current2 = list2;
    	byte pointer; //Point to the list in which we are currently
    	if(current1.val < current2.val) pointer = 1; //Initial pointer position
    	else pointer = 2;
    	
    	while(current1 != null && current2 != null) {
    		
    		ListNode next1 = current1.next;
    		ListNode next2 = current2.next;
    		
    		if(pointer == 1) {
    			
    			if(next1 == null) {
    				current1.next = current2;
    				break;
    			}
    			else {
    				if(current1.next.val < current2.val) {
    					current1 = next1;
    					pointer = 1;
    				}else {
    					current1.next = current2;
    					current1 = next1;
    					pointer = 2;
    				}
    			}
    			
    		} else if(pointer == 2) {
    			
    			if(next2 == null) {
    				current2.next = current1;
    				break;
    			}
    			else {
    				if(current2.next.val < current1.val) {
    					current2 = next2;
    					pointer = 2;
    				}else {
    					current2.next = current1;
    					current2 = next2;
    					pointer = 1;
    				}
    			}
    			
    		}
    		
    	}
    	
    	if(list1.val < list2.val) return list1;
    	else return list2;
    	
    }
	
    public static void print(ListNode head) {
    	
    	ListNode current = head;
    	
    	while(current != null) {
    		
    		System.out.println(current.val);
    		current = current.next;
    		
    	}
    	
    }
    
}