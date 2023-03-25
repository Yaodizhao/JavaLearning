package 数据结构;

import java.util.TreeMap;

public class TrieTree {
    
    private static class Node {
        
        public boolean isWord; // 是否是某个单词的结束
        
        public TreeMap<Character, Node> next; //到下一个节点的映射
        
        public Node(boolean isWord) {
            this.isWord = isWord;
            //初始化字典树
            next = new TreeMap<>();
        }
        
        public Node() {
            this(false);
        }
    }
    
    
    private Node root;
    
    private int size;
    
    public TrieTree() {
        root = new Node();
        size = 0;
    }
    
    public int getSize() {
        return size;
    }
    
    public void add(String word) {
        
        Node root = this.root;
        
        for (int i = 0; i < word.length(); i++) {
            
            char c = word.charAt(i);
            if (root.next.get(c) == null) {
                root.next.put(c, new Node());
            }
            root = root.next.get(c);
        }
        if (! root.isWord) {
            root.isWord = true;
            size++;
        }
    }
}

