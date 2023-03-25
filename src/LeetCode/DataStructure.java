package LeetCode;

public class DataStructure {
    public static void main(String[] args) {
    
    }
    
    // 链表
    public static class ListNode {
        public int val;
        public ListNode next;
        
        public ListNode() {
        }
        
        public ListNode(int val) {
            this.val = val;
        }
        
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    // 二叉树
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        
        public TreeNode() {
        }
        
        public TreeNode(int val) {
            this.val = val;
        }
        
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public static class BSTNode<T extends Comparable> {
        
        T key;
        BSTNode<T> parent;
        BSTNode<T> lchild;
        BSTNode<T> rchild;
        
        public BSTNode(T key, BSTNode<T> parent, BSTNode<T> lchild, BSTNode<T> rchild) {
            this.key = key;
            this.parent = parent;
            this.lchild = lchild;
            this.rchild = rchild;
        }
        
    }
}
