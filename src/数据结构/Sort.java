package 数据结构;

import java.util.Arrays;

/**
 * @author 如月车站
 */
public class Sort {
    
    public static void main(String[] args) {
        int[] array = new int[]{71, 8, 61, 9, 1, 31, 4, 52, 102, 2};
//        int[] a = new int[]{2, 1, 3, 4, 5, 6, 7, 8, 9, 10};
        Sort sort = new Sort();
        System.out.println(Arrays.toString(array));
    }
    
    public void heapSortAsc(int[] a, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapDown(a, i, n - 1);
        }
        
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, 0, i);
            maxHeapDown(a, 0, i - 1);
            
        }
    }
    
    public static void maxHeapDown(int[] a, int start, int end) {
        int current = start;
        int leftChild = start * 2 + 1;
        int temp = a[current];
        
        while (leftChild <= end) {
            // 保证右孩子不超出数组
            if (leftChild < end && a[leftChild] < a[leftChild + 1]) {
                leftChild++;
            }
            if (temp >= a[leftChild]) {
                break;
            }
            a[current] = a[leftChild];
            current = leftChild;
            leftChild = leftChild * 2 + 1;
        }
        a[current] = temp;
    }
    
    public void heapSortDesc(int[] a, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapDown(a, i, n - 1);
        }
        
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, 0, i);
            minHeapDown(a, 0, i - 1);
            
        }
    }
    
    public static void minHeapDown(int[] a, int start, int end) {
        int current = start;
        int leftChild = start * 2 + 1;
        int temp = a[current];
        
        while (leftChild <= end) {
            // 保证右孩子不超出数组
            if (leftChild < end && a[leftChild] > a[leftChild + 1]) {
                leftChild++;
            }
            if (temp <= a[leftChild]) {
                break;
            }
            a[current] = a[leftChild];
            current = leftChild;
            leftChild = leftChild * 2 + 1;
        }
        a[current] = temp;
    }
    
    public void bucketSort(int[] a, int max) {
        int[] buckets;
        
        if (a == null || max < 1) {
            return;
        }
        
        // 创建一个容量为max的数组buckets，并且将buckets中的所有数据都初始化为0。
        buckets = new int[max];
        
        // 1. 计数
        for (int k: a) {
            buckets[k]++;
        }
        
        // 2. 排序
        for (int i = 0, j = 0; i < max; i++) {
            while ((buckets[i]--) > 0) {
                a[j++] = i;
            }
        }
        
    }
    
    private void radixSort(int[] array) {
        int max = Arrays.stream(array).max().orElse(0);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            singleSort(array, exp);
        }
    }
    
    private void singleSort(int[] array, int exp) {
        int[] buckets = new int[10];
        int[] output = new int[array.length];
        
        for (int j: array) {
            buckets[(j / exp) % 10]++;
        }
        
        for (int i = 1; i < 10; i++) {
            buckets[i] += buckets[i - 1];
        }
        
        // 必须倒着插入 因为从后开始插入
        for (int j = array.length - 1; j >= 0; j--) {
            output[buckets[array[j] / exp % 10] - 1] = array[j];
            buckets[array[j] / exp % 10]--;
        }
        
        System.arraycopy(output, 0, array, 0, array.length);
    }
    
    public void mergeSortDown2Up(int[] a) {
        if (a == null) {
            return;
        }
        
        for (int n = 1; n < a.length; n *= 2) {
            mergeGroups(a, a.length, n);
        }
    }
    
    public void mergeGroups(int[] a, int len, int gap) {
        int i;
        int twolen = 2 * gap;
        // 两个相邻的子数组的长度
        
        // 将"每2个相邻的子数组" 进行合并排序。
        for (i = 0; i + 2 * gap - 1 < len; i += (2 * gap)) {
            merge(a, i, i + gap - 1, i + 2 * gap - 1);
        }
        
        // 若 i+gap-1 < len-1，则剩余一个子数组没有配对。
        // 将该子数组合并到已排序的数组中。
        if (i + gap - 1 < len - 1) {
            merge(a, i, i + gap - 1, len - 1);
        }
    }
    
    private void mergeSortUp2Down(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSortUp2Down(array, start, mid);
            mergeSortUp2Down(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }
    
    private void merge(int[] array, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];    // tmp是汇总2个有序区的临时区域
        int i = start;            // 第1个有序区的索引
        int j = mid + 1;        // 第2个有序区的索引
        int k = 0;                // 临时区域的索引
        
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
            }
        }
        
        while (i <= mid) {
            tmp[k++] = array[i++];
        }
        
        while (j <= end) {
            tmp[k++] = array[j++];
        }
        
        // 将排序后的元素，全部都整合到数组a中。
        for (i = 0; i < k; i++) {
            array[start + i] = tmp[i];
        }
        
        //        int i = start, j = mid + 1;
//        List<Integer> list = new ArrayList<>();
//        while (i <= mid && j <= end) {
//            if (array[i] < array[j]) {
//                list.add(array[i++]);
//            } else {
//                list.add(array[j++]);
//            }
//        }
//        while (i <= mid) {
//            list.add(array[i++]);
//        }
//
//        while (j <= end) {
//            list.add(array[j++]);
//        }
//
//        int ii = 0;
//        for (int k = start; k <= end; k++, ii++) {
//            array[k] = list.get(ii);
//        }
    }
    
    private void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int left = start, right = end;
            int temp = array[left];
            
            while (left < right) {
                while (right > left && array[right] > temp) {
                    right--;
                }
                if (left < right) {
                    array[left++] = array[right];
                }
                
                while (left < right && array[left] < temp) {
                    left++;
                }
                if (left < right) {
                    array[right--] = array[left];
                }
            }
            array[left] = temp;
            quickSort(array, start, left - 1);
            quickSort(array, left + 1, end);
        }
    }
    
    private void shellSortByExchange(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j] > array[j + gap]) {
                        swap(array, j, j + gap);
                    }
                }
                
            }
            System.out.print("步长为" + gap + "：");
            System.out.println(Arrays.toString(array));
        }
    }
    
    private void shellSortByMove(int[] array) {
        
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                int temp = array[j];
                while (j - gap >= 0 && temp < array[j - gap]) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }
            
            System.out.print("步长为" + gap + "：");
            System.out.println(Arrays.toString(array));
        }
    }
    
    private void insertSort(int[] array) {
        int[] temp = new int[array.length];
        temp[0] = array[0];
        System.out.print("第1次：");
        System.out.println(Arrays.toString(temp));
        int j;
        for (int i = 1; i < array.length; i++) {
            for (j = i - 1; j >= 0; j--) {
//                if (array[i] > temp[j]) {
                if (array[i] < temp[j]) {
                    temp[j + 1] = temp[j];
                } else {
                    break;
                }
            }
            temp[j + 1] = array[i];
            
            System.out.print("第" + (i + 1) + "次：");
            System.out.println(Arrays.toString(temp));
        }
        
    }
    
    public void bubbleSort(int[] array) {
        
        boolean flag = false;
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[i] < array[j]) {
                    swap(array, i, j);
                    flag = true;
                }
            }
            System.out.print("第" + (10 - i) + "次：");
            System.out.println(Arrays.toString(array));
            if (! flag) {
                return;
            } else {
                flag = false;
            }
        }
    }
    
    public void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = min(array, i);
            swap(array, i, min);
            System.out.print("第" + (10 - i) + "次：");
            System.out.println(Arrays.toString(array));
        }
    }
    
    private int min(int[] array, int n) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = n; i < array.length; i++) {
            if ((array[i]) < min) {
                index = i;
                min = array[i];
            }
        }
        return index;
    }
    
    private void swap(int[] array, int i, int j) {
        int c = array[i];
        array[i] = array[j];
        array[j] = c;
    }
}
