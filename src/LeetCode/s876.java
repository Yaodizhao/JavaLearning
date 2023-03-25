package LeetCode;

public class s876 {
    // 初始化链表
    // DataStructure.ListNode ln = new DataStructure.ListNode(1, null);
    // DataStructure.ListNode st = ln;
    // for (int i = 2; i <= 6; i++) {
    // DataStructure.ListNode temp = new DataStructure.ListNode(i, null);
    // ln.next = temp;
    // ln = ln.next;
    // }
    public static DataStructure.ListNode middleNode(DataStructure.ListNode head) {
        DataStructure.ListNode first = head;
        DataStructure.ListNode second = head;
        while (first.next != null) {
            if (second.next == null) {
                return first;
            } else {
                second = second.next;
                if (second.next == null) {
                    return first.next;
                } else {
                    second = second.next;
                }
            }
            first = first.next;
        }
        return first;
    }
}
