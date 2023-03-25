package 数据结构;

public class RBTree<T extends Comparable<T>> {
    private RBTNode<T> root;
    
    private static final boolean RED = false;
    private static final boolean BLACK = true;
    
    public static class RBTNode<T extends Comparable<T>> {
        boolean color;
        T key;
        RBTNode<T> lchild;
        RBTNode<T> rchild;
        RBTNode<T> parent;
        
        public RBTNode(T key, boolean color, RBTNode<T> lchild, RBTNode<T> rchild, RBTNode<T> parent) {
            this.key = key;
            this.lchild = lchild;
            this.rchild = rchild;
            this.parent = parent;
            this.color = color;
        }
        
    }
    
    
    
}
