package LeetCode.困难;

import java.util.*;

public class s1302建树and深度广度树查询 {
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
    
    public static TreeNode makeTree(Integer[] nums) {
        if (nums.length == 0 || nums[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(nums[0]);
        TreeNode cur;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int j = 1;
        while (! queue.isEmpty() && j < nums.length) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (j < nums.length && nums[j] != null) {
                    cur.left = new TreeNode(nums[j]);
                    queue.offer(cur.left);
                }
                j++;
                if (j < nums.length && nums[j] != null) {
                    cur.right = new TreeNode(nums[j]);
                    queue.offer(cur.right);
                }
                j++;
            }
        }
        return root;
    }
    
    
    public static int deepestLeavesSum(TreeNode root) {
        int ans = 0;
        int rear = 0;
        int level = 0;
        
        Map<TreeNode, Integer> map = new HashMap<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        
        map.put(root, level);
        queue.add(rear++, root);
        
        while (! queue.isEmpty()) {
            TreeNode node = queue.remove(0);
            rear--;
            if (node.left != null) {
                map.put(node.left, map.get(node) + 1);
                
                queue.add(rear++, node.left);
                level = Math.max(level, map.get(node) + 1);
            }
            if (node.right != null) {
                map.put(node.right, map.get(node) + 1);
                queue.add(rear++, node.right);
                level = Math.max(level, map.get(node) + 1);
            }
        }
        for (TreeNode node: map.keySet()) {
            if (map.get(node) == level) {
                ans += node.val;
            }
        }
        return ans;
    }
    
    //广度优先搜索 层序遍历
    public static int deepestLeavesSum_improvement1(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (! queue.isEmpty()) {
            sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return sum;
    }
    
    //深度优先搜索 遍历过程中维护最大层数与最深节点之和。
    static int maxLevel = - 1;
    static int sum = 0;
    
    public static int deepestLeavesSum_improvement2(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
    
    public static void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level > maxLevel) {
            maxLevel = level;
            sum = node.val;
        } else if (level == maxLevel) {
            sum += node.val;
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
    
}
