package 数据结构;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 如月车站
 */
public class MinHeap {
    private List<数据结构.HuffmanNode> heap;

    protected MinHeap(int[] a) {
        heap = new ArrayList<>();
        for (int j : a) {
            heap.add(new 数据结构.HuffmanNode(j, null, null, null));
        }

        for (int i = a.length / 2 - 1; i >= 0; i--) {
            filterdown(i, a.length - 1);
        }
    }

    // 向下调整
    protected void filterdown(int start, int end) {
        int first = start * 2 + 1;
        数据结构.HuffmanNode temp = heap.get(start);
        while (first <= end) {
            if (first < end && heap.get(first).compareTo(heap.get(first + 1)) > 0) {
                first++;
            }
            if (heap.get(start).compareTo(heap.get(first)) > 0) {
                heap.set(start, heap.get(first));
                start = first;
                first = start * 2 + 1;
            } else {
                break;
            }
        }
        heap.set(start, temp);
    }

    // 向上调整
    protected void filterup(int start) {
        int parent = (start - 1) / 2;
        数据结构.HuffmanNode temp = heap.get(start);
        while (parent > 0) {
            if (heap.get(start).compareTo(heap.get(parent)) <= 0) {
                heap.set(parent, heap.get(start));
                start = parent;
                parent = (start - 1) / 2;
            } else {
                break;
            }
        }
        heap.set(start, temp);
    }

    protected void insert(数据结构.HuffmanNode node) {
        int size = heap.size();
        heap.add(node);
        filterup(size);
    }

    private void swapNode(int i, int j) {
        数据结构.HuffmanNode tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    // 销毁最小堆
    protected void destroy() {
        heap.clear();
        heap = null;
    }

    protected 数据结构.HuffmanNode dumpFromMinimum() {
        int size = heap.size();

        if (size == 0) {
            return null;
        }

        数据结构.HuffmanNode node = (数据结构.HuffmanNode) heap.get(0).clone();

        // 交换"最小节点"和"最后一个节点"
        heap.set(0, heap.get(size - 1));
        // 删除最后的元素
        heap.remove(size - 1);

        if (heap.size() > 1) {
            filterdown(0, heap.size() - 1);
        }

        return node;
    }

}
