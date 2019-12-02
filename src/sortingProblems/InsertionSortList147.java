package sortingProblems;

public class InsertionSortList147 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }

    public ListNode insertionSortList(ListNode head){
        ListNode res = new ListNode(0);

        while (head != null){
            ListNode node = res;
            while (node.next != null && node.next.val < head.val){ //find the place to insert head from res
                node = node.next;
            }
            ListNode tmp = head.next;
            head = tmp;     //assign new head to be processed be the next node after head

            head.next = node.next;   //insert head after node
            node.next = head;

        }
        return res.next;
    }

}
