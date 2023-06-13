package LeetCode;

import LeetCode.困难.s1302建树and深度广度树查询;

import static LeetCode.困难.s1302建树and深度广度树查询.makeTree;

/**
 * @author 如月车站
 */
public class s654创建最大二叉树 {
    public static void main(String[] args) {
        TreeNode treeNode = constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        s1302建树and深度广度树查询.TreeNode node = makeTree(new Integer[]{1, 0, 48, null, null, 12, 49});
        int minimumDifference = getMinimumDifference(node);
    }

    static int js = -999999;
    static int gaps = Integer.MAX_VALUE;

    private static int getMinimumDifference(s1302建树and深度广度树查询.TreeNode root) {
        if (root.left != null) {
            getMinimumDifference(root.left);
        }

        if (Math.abs(js - root.val) < gaps) {
            gaps = Math.abs(js - root.val);
        }
        js = root.val;
        if (root.right != null) {
            getMinimumDifference(root.right);
        }
        return gap;
    }


    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return createMaxTree(nums, 0, nums.length - 1);
    }

    private static TreeNode createMaxTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int index = findMaxIndex(nums, start, end);
        TreeNode res = new TreeNode(nums[index]);
        res.left = createMaxTree(nums, start, index - 1);
        res.right = createMaxTree(nums, index + 1, end);
        return res;
    }

    static int findMaxIndex(int[] nums, int start, int end) {
        int index = 0, max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        return index;
    }

    Long i = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean il = isValidBST(root.left);
        if (i >= root.val) {
            return false;
        }
        i = (long) root.val;
        boolean ir = isValidBST(root.right);
        return il && ir;

    }

    int j = Integer.MIN_VALUE;
    static int gap = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root.left != null) {
            getMinimumDifference(root.left);
        }

        if (Math.abs(j - root.val) < gap) {
            gap = Math.abs(j - root.val);
        }
        j = root.val;
        if (root.right != null) {
            getMinimumDifference(root.right);
        }
        return gap;
    }
}
