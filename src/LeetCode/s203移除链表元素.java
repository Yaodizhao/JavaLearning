package LeetCode;


/**
 * @author 如月车站
 */
public class s203移除链表元素 {

    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        head.next = new ListNode(7);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(7);
//        head.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next.next = new ListNode(7);
//        head.next.next.next.next.next.next.next.next = new ListNode(8);
//        head.next.next.next.next.next.next.next.next.next = new ListNode(9);
        head = removeElements(head, 7);
        while (head != null) {
            System.out.printf("%d ", head.val);
            head = head.next;
        }
    }

    public ListNode removeElements_Recursion(ListNode head, int val) {
        if(head==null) {
            return null;
        }
        head.next=removeElements(head.next,val);
        if(head.val==val){
            return head.next;
        }else{
            return head;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode index = head;
        if (index == null) {
            return null;
        }
        ListNode first = index;
        head = head.next;
        while (head != null) {
            if (head.val == val) {
                index.next = head.next;
            } else {
                index = index.next;
            }
            head = head.next;
        }
        return first;
    }
}
