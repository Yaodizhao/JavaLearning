package LeetCode;

import LeetCode.困难.s1302建树and深度广度树查询.TreeNode;

import java.util.*;

import static LeetCode.困难.s1302建树and深度广度树查询.makeTree;

public class s102层序遍历 {

    public static void main(String[] args) {
        TreeNode node = makeTree(new Integer[]{1, 2, 3, 4, null, null, 5});
        List<List<Integer>> listList = levelOrder(node);
        for (List<Integer> integers : listList) {
            System.out.println(integers.toString());
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        arrayDeque.offer(root);
        while (!arrayDeque.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int currentLevelSize = arrayDeque.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode pop = arrayDeque.pop();
                temp.add(pop.val);
                if (pop.left != null) {
                    arrayDeque.offer(pop.left);
                }
                if (pop.right != null) {
                    arrayDeque.offer(pop.right);
                }
            }
            res.add(temp);
        }
        Collections.reverse(res);
        return res;
    }

    public int findBottomLeftValue(TreeNode root) {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        int res = 0;
        arrayDeque.offer(root);
        while (!arrayDeque.isEmpty()) {
            int currentLevelSize = arrayDeque.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode pop = arrayDeque.pop();
                if (i == 1) {
                    res = pop.val;
                }

                if (pop.left != null) {
                    arrayDeque.offer(pop.left);
                }
                if (pop.right != null) {
                    arrayDeque.offer(pop.right);
                }
            }
        }
        return res;
    }

    public static List<Integer> rightSideView(TreeNode root) {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        arrayDeque.offer(root);
        while (!arrayDeque.isEmpty()) {
            int currentLevelSize = arrayDeque.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode pop = arrayDeque.pop();
                if (i == currentLevelSize) {
                    res.add(pop.val);
                }
                if (pop.left != null) {
                    arrayDeque.offer(pop.left);
                }
                if (pop.right != null) {
                    arrayDeque.offer(pop.right);
                }
            }
        }
        return res;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> resAll = new ArrayList<>();
        List<Double> res = new ArrayList<>();
        arrayDeque.offer(root);
        while (!arrayDeque.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int currentLevelSize = arrayDeque.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode pop = arrayDeque.pop();
                temp.add(pop.val);
                if (pop.left != null) {
                    arrayDeque.offer(pop.left);
                }
                if (pop.right != null) {
                    arrayDeque.offer(pop.right);
                }
            }
            resAll.add(temp);
        }
        for (List<Integer> integers : resAll) {
            res.add(integers.stream().mapToDouble(Integer::doubleValue).sum() / integers.size());
        }
        return res;
    }

    public NextNode connect(NextNode root) {
        Queue<NextNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            NextNode node;
            NextNode nodePre = null;

            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    nodePre = queue.poll();
                    // 取出本层头一个节点
                    node = nodePre;
                } else {
                    node = queue.poll();
                    nodePre.next = node;
                    // 本层前一个节点 next 指向当前节点
                    nodePre = nodePre.next;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            nodePre.next = null;
            // 本层最后一个节点 next 指向 null
        }
        return root;
    }

}

class NextNode {
    public int val;
    public NextNode left;
    public NextNode right;
    public NextNode next;

    public NextNode() {
    }

    public NextNode(int val) {
        this.val = val;
    }

    public NextNode(int val, NextNode left, NextNode right, NextNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
};

