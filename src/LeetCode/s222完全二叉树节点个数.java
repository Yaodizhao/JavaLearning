package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 如月车站
 */
public class s222完全二叉树节点个数 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        // 左右子树高度差大于1，return -1表示已经不是平衡树了
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    List<String> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }
        pre(root);
        return res;
    }

    public void pre(TreeNode root) {
        if (root != null) {
            temp.add(root.val);
            if (root.left == null && root.right == null) {
                StringBuilder s = new StringBuilder();
                for (Integer integer : temp) {
                    s.append(Integer.toString(integer));
                    s.append("->");
                }
                res.add(s.substring(0, s.length() - 2));

            }
            pre(root.left);
            pre(root.right);
            temp.remove(temp.size() - 1);
        }
    }

    int target = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root != null) {
            target += root.val;
            if (targetSum == target && root.left == null && root.right == null) {
                return true;
            }
            boolean bl = hasPathSum(root.left, targetSum);
            boolean br = hasPathSum(root.right, targetSum);
            if (bl || br) {
                return true;
            }
            target -= root.val;
        }
        return false;
    }

    TreeNode pre = null;
    int maxCount = 0;
    int count = 1;
    ArrayList<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return null;
        }
        findMode(root.left);
        if (pre == null) {
            count = 1;
        } else if (pre.val == root.val) {
            count++;
        } else {
            count = 1;
        }
        pre = root;
        if (count == maxCount) {
            result.add(root.val);
        }
        if (count > maxCount) {
            result.clear();
            result.add(root.val);
            maxCount = count;
        }
        findMode(root.right);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
