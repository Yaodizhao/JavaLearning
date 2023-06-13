package LeetCode;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 如月车站
 */
public class s101对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    private boolean check1(TreeNode p, TreeNode q) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addFirst(p);
        queue.addLast(q);
        while (!queue.isEmpty()) {
            TreeNode head = queue.pollFirst();
            TreeNode tail = queue.pollLast();
            if (head.val == tail.val) {
                if (head.left != null && tail.right != null) {
                    queue.addFirst(head.left);
                    queue.addLast(tail.right);
                } else if (head.left == null && tail.right == null) {

                } else {
                    return false;
                }
                if (head.right != null && tail.left != null) {
                    queue.addFirst(head.right);
                    queue.addLast(tail.left);
                } else if (head.right == null && tail.left == null) {

                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}