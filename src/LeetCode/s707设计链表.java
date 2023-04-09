package LeetCode;

public class s707设计链表 {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(2);
        list.deleteAtIndex(1);
        list.addAtHead(2);
        list.addAtHead(7);
        list.addAtHead(3);
        list.addAtHead(2);
        list.addAtHead(5);
        list.addAtTail(5);
        System.out.println(list.get(5));
        list.deleteAtIndex(6);
        list.deleteAtIndex(4);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class MyLinkedList {
        int size;
        ListNode head;
        ListNode tail;

        public MyLinkedList() {
            size = 0;
            head = new ListNode();
            tail = head;
        }

        public int get(int index) {
            ListNode temp = this.head;
            if (index > size) {
                return -1;
            }
            if (index == 0) {
                return this.head.next.val;
            }
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.val;
        }

        public void addAtHead(int val) {
            ListNode node = new ListNode(val);
            if (head.next == null) {
                head.next = node;
                tail = head.next;
                size++;
                return;
            }
            node.next = head.next;
            head.next = node;
            size++;
        }

        public void addAtTail(int val) {
            ListNode node = new ListNode(val);
            tail.next = node;
            tail = node;
            size++;
        }

        public void addAtIndex(int index, int val) {
            ListNode temp = this.head;
            ListNode node = new ListNode(val);
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
            if (index == size) {
                tail = node;
            }
            size++;
        }

        public void deleteAtIndex(int index) {
            ListNode temp = this.head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            if (index == size) {
                tail = temp;
                temp.next = null;
            } else {
                temp.next = temp.next.next;
            }

            size--;
        }
    }
}
