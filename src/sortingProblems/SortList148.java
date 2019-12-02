

public class SortList148 {
//Sort a linked list in O(n log n) time using constant space complexity.
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public ListNode sortList(ListNode head){
        if (head == null||head.next==null) return head;
        ListNode slow = head;
        ListNode fast = head.next;

        //using the fast and slow to find the middle of the linked list

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(mid));
    }

    private ListNode merge(ListNode l1, ListNode l2){

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;   //initialize the tail of the Linked list as dummy

        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                ListNode tmp = l1;                  //ensure the smaller one is l1.val
                l1 = l2;
                l2 = tmp;
            }

            tail.next = l1;
            l1 = l1.next;
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

}
