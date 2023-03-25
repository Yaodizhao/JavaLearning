package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class s1161层序遍历 {
    public static int maxLevelSum(DataStructure.TreeNode root) {
        Deque<DataStructure.TreeNode> Dq = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;
        int depth = 1, maxdepth = 0;
        Dq.addLast(root);
        while (! Dq.isEmpty()) {
            int cnt = 0;
            int size = Dq.size();
            while (size-- > 0) {
                DataStructure.TreeNode node = Dq.pollFirst();
                cnt += node.val;
                if (node.left != null)
                    Dq.addLast(node.left);
                if (node.right != null)
                    Dq.addLast(node.right);
                
            }
            if (cnt > max) {
                max = cnt;
                maxdepth = depth;
            }
            depth++;
            
        }
        return maxdepth;
    }
}
