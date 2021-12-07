import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        if(head == null)
        return head;
        
        ListNode dummy = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        
        ListNode odd = dummy2;
        ListNode even = dummy;
        ListNode ptr = head;
        
        while(ptr != null){
            if(ptr.val % 2 == 0){
                even.next = ptr;
                even = even.next;
            }
            else{
                odd.next = ptr;
                odd = odd.next;
            }
            ptr = ptr.next;
        }
        // if we not make it, if it  end with even  then odd will point to pta ni kaha we have to make that null
        odd.next = null;
        
        even.next = dummy2.next;
        
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
