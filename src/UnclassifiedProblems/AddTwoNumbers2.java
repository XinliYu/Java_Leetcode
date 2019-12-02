package UnclassifiedProblems;

public class AddTwoNumbers2 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode mynode = new ListNode(-1);
        ListNode head = mynode;
        while(l1 != null && l2 != null){
            int myvalue = l1.val + l2.val+carry; // 2 + 7 = 9
            int cur_digit = myvalue % 10; // 9
            mynode.next = new ListNode(cur_digit); // 10
            carry = myvalue / 10;
            l1 = l1.next;
            l2 = l2.next;
            mynode = mynode.next;
        }
        while(l2 != null){
            int myvalue = l2.val + carry;
            int cur_digit = myvalue%10;
            mynode.next = new ListNode(cur_digit);
            carry = myvalue /10;
            mynode = mynode.next;
            l2 =l2.next;
        }
        while(l1 != null){
            int myvalue = l1.val + carry;
            int cur_digit = myvalue%10;
            mynode.next = new ListNode(cur_digit);
            carry = myvalue /10;
            mynode = mynode.next;
            l1 =l1.next;
        }
        if(carry != 0){
            mynode.next = new ListNode(carry);
        }
        return head.next;

    }
}
