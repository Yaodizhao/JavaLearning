package 数据结构;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class JosephCircle {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(List.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int num = scanner.nextInt();
        int i = 3;
        int count = 1;
        int index = 0;
        for (int j = size; j > 0; ) {
            if (count < num) {
                count++;
                while (linkedList.get(index) == - 1) {
                    index = (index + 1) % size;
                }
                index = (index + 1) % size;
            }
            if (count == num) {
                while (linkedList.get(index) == - 1) {
                    index = (index + 1) % size;
                }
                linkedList.set(index, - 1);
                System.out.printf("%d ", index + 1);
                count = 1;
                index = (index + 1) % size;
                j--;
            }
        }
    }
}
