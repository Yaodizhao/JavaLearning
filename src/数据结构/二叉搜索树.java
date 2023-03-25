package 数据结构;

public class 二叉搜索树 {
    
    
    public static void main(String[] args) {
        BSTNode<Integer> root = new BSTNode<>(null, null, null, null);
        insert(root, 1);
        insert(root, 5);
        insert(root, 4);
        insert(root, 3);
        insert(root, 2);
        insert(root, 6);
        BSTNode<Integer> searchnode = search(root, 6);
        System.out.println(searchnode.key);
        PreOrder(root);
    }
    
    public static class BSTNode<T extends Comparable<T>> {
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
    
    public static <T extends Comparable<T>> void insert(BSTNode<T> root, T key) {
        if (root.key == null) {
            root.key = key;
            return;
        }
        BSTNode<T> x = root;
        BSTNode<T> y = null;
        int cmp;
        while (x != null) {
            y = x;
            cmp = x.key.compareTo(key);
            if (cmp > 0) {
                x = x.lchild;
            } else {
                x = x.rchild;
            }
        }
        BSTNode<T> node = new BSTNode<>(key, y, null, null);
        if (y == null) {
            root = node;
        } else {
            cmp = y.key.compareTo(key);
            if (cmp > 0)
                y.lchild = node;
            else
                y.rchild = node;
        }
    }
    
    
    public static <T extends Comparable<T>> BSTNode<T> search(BSTNode<T> root, T key) {
        if (root == null)
            return null;
        int cmp = key.compareTo(root.key);
        if (cmp < 0)
            return search(root.lchild, key);
        else if (cmp > 0)
            return search(root.rchild, key);
        else
            return root;
    }
    
    public static <T extends Comparable<T>> void PreOrder(BSTNode<T> root) {
        if (root != null) {
            System.out.println(root.key);
            PreOrder(root.lchild);
            PreOrder(root.rchild);
        }
    }
    
    
}

