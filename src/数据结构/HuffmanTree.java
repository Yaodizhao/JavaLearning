package 数据结构;

public class HuffmanTree {
    private final HuffmanNode root;
    
    public HuffmanTree(int[] data) {
        HuffmanNode parent = null;
        MinHeap heap;
        
        heap = new MinHeap(data);
        
        for (int i = 0; i < data.length - 1; i++) {
            HuffmanNode lchild = heap.dumpFromMinimum();
            HuffmanNode rchild = heap.dumpFromMinimum();
            parent = new HuffmanNode(lchild.key + rchild.key, lchild, rchild, null);
            lchild.parent = parent;
            rchild.parent = parent;
            
            heap.insert(parent);
        }
        
        root = parent;
        
        heap.destroy();
    }
    
    private void PreOrder(HuffmanNode tree) {
        if (tree != null) {
            System.out.println(tree.key);
            PreOrder(tree.left);
            PreOrder(tree.right);
        }
    }
    
    public void proOrder() {
        PreOrder(root);
    }
    
    
    private void print(HuffmanNode tree, int key, int direction) {
        
        if(tree != null) {
            
            if(direction==0)	// tree是根节点
                System.out.printf("%2d is root\n", tree.key);
            else				// tree是分支节点
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction==1?"right" : "left");
            
            print(tree.left, tree.key, -1);
            print(tree.right,tree.key,  1);
        }
    }
    
    public void print() {
        if (root != null)
            print(root, root.key, 0);
    }
}
