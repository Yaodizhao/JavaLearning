package 数据结构;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private List<数据结构.HuffmanNode> Heap;
    
    protected MinHeap(int[] a) {
        Heap = new ArrayList<>();
        for (int j: a) {
            Heap.add(new 数据结构.HuffmanNode(j, null, null, null));
        }
        
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            filterdown(i, a.length - 1);
        }
    }
    
    // 向下调整
    protected void filterdown(int start, int end) {
        int first = start * 2 + 1;
        数据结构.HuffmanNode temp = Heap.get(start);
        while (first <= end) {
            if (first < end && Heap.get(first).compareTo(Heap.get(first + 1)) > 0) {
                first++;
            }
            if (Heap.get(start).compareTo(Heap.get(first)) > 0) {
                Heap.set(start, Heap.get(first));
                start = first;
                first = start * 2 + 1;
            } else {
                break;
            }
        }
        Heap.set(start, temp);
    }
    
    // 向上调整
    protected void filterup(int start) {
        int parent = (start - 1) / 2;
        数据结构.HuffmanNode temp = Heap.get(start);
        while (parent > 0) {
            if (Heap.get(start).compareTo(Heap.get(parent)) <= 0) {
                Heap.set(parent, Heap.get(start));
                start = parent;
                parent = (start - 1) / 2;
            } else {
                break;
            }
        }
        Heap.set(start, temp);
    }
    
    protected void insert(数据结构.HuffmanNode node) {
        int size = Heap.size();
        Heap.add(node);
        filterup(size);
    }
    
    private void swapNode(int i, int j) {
        数据结构.HuffmanNode tmp = Heap.get(i);
        Heap.set(i, Heap.get(j));
        Heap.set(j, tmp);
    }
    
    // 销毁最小堆
    protected void destroy() {
        Heap.clear();
        Heap = null;
    }
    
    protected 数据结构.HuffmanNode dumpFromMinimum() {
        int size = Heap.size();
        
        if (size == 0)
            return null;
        
        数据结构.HuffmanNode node = (数据结构.HuffmanNode)Heap.get(0).clone();
        
        // 交换"最小节点"和"最后一个节点"
        Heap.set(0, Heap.get(size - 1));
        // 删除最后的元素
        Heap.remove(size - 1);
        
        if (Heap.size() > 1)
            filterdown(0, Heap.size() - 1);
        
        return node;
    }
    
}
