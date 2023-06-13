package LeetCode;

public class s106前中后选两个构建二叉树 {


    public static void main(String[] args) {
        int[] a1 = new int[]{3, 9, 20, 15, 7};
        int[] a2 = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = buildTreeFromInPre(a1, a2);
        System.out.println(treeNode);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return inPostCreateTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private static TreeNode inPostCreateTree(int[] inorder, int[] postorder, int i1, int i2, int j1, int j2) {
        if (i1 == i2) {
            return new TreeNode(inorder[i1]);
        }
        if (i1 > i2) {
            return null;
        }
        int val = postorder[j2];
        int flag = 0, length = 0;
        for (int i = i1; i <= i2; i++) {
            if (inorder[i] == val) {
                flag = i;
                break;
            }
            length++;
        }
        TreeNode node = new TreeNode(postorder[j2]);
        node.left = inPostCreateTree(inorder, postorder, i1, flag - 1, j1, j1 + length - 1);
        node.right = inPostCreateTree(inorder, postorder, flag + 1, i2, j1 + length, j2 - 1);
        return node;
    }

    public static TreeNode buildTreeFromInPre(int[] preorder, int[] inorder) {
        return inPreCreateTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private static TreeNode inPreCreateTree(int[] preorder, int[] inorder, int i1, int i2, int j1, int j2) {
        if (i1 == i2) {
            return new TreeNode(preorder[i1]);
        }
        if (i1 > i2) {
            return null;
        }
        int val = preorder[i1];
        int flag = 0, length = 0;
        for (int i = j1; i <= j2; i++) {
            if (inorder[i] == val) {
                flag = i;
                break;
            }
            length++;
        }
        TreeNode node = new TreeNode(preorder[i1]);
        node.left = inPreCreateTree(preorder, inorder, i1 + 1, i1 + length, j1, flag - 1);
        node.right = inPreCreateTree(preorder, inorder, i1 + length + 1, i2, flag + 1, j2);
        return node;
    }
}
