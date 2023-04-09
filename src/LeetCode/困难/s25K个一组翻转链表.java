package LeetCode.困难;

import LeetCode.ListNode;

public class s25K个一组翻转链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = reverseKGroup(head, 3);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode end = head;
        for (int i = 1; i < k; i++) {
            if (end == null) {
                return head;
            }
            end = end.next;
        }
        if (end == null) {
            return head;
        }
        ListNode cur = head;
        ListNode temp;
        ListNode pre = null;
        for (int i = 0; i < k; i++) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        while (end.next != null) {
            end = end.next;
        }
        end.next = reverseKGroup(cur, k);
        return pre;
    }

}
