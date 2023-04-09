package LeetCode.困难;


import static java.util.Arrays.sort;

public class s593有效正方形 {
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return IsIsoscelesRightTriangle(p1, p2, p3) && IsIsoscelesRightTriangle(p1, p2, p4) && IsIsoscelesRightTriangle(p4, p2, p3);
    }
    
    // 判断是否是等腰直角三角形
    public static boolean IsIsoscelesRightTriangle(int[] p1, int[] p2, int[] p3) {
        int l1 = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        int l2 = (p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1]);
        int l3 = (p3[0] - p2[0]) * (p3[0] - p2[0]) + (p3[1] - p2[1]) * (p3[1] - p2[1]);
        if (l1 == l2 && l1 + l2 == l3 || l3 == l2 && l3 + l2 == l1 || l1 == l3 && l1 + l3 == l2) {
            if (Math.min(l1, l2) == 0 || Math.min(l3, l2) == 0) {
                return false;
            }
            return true;
        }
        return false;
    }
    
    public static boolean validSquare_correction(int[] p1, int[] p2, int[] p3, int[] p4) {
//        计算六条边 并排序
        int[] length_array = new int[6];
        length_array[0] = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        length_array[1] = (p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1]);
        length_array[2] = (p1[0] - p4[0]) * (p1[0] - p4[0]) + (p1[1] - p4[1]) * (p1[1] - p4[1]);
        length_array[3] = (p2[0] - p3[0]) * (p2[0] - p3[0]) + (p2[1] - p3[1]) * (p2[1] - p3[1]);
        length_array[4] = (p2[0] - p4[0]) * (p2[0] - p4[0]) + (p2[1] - p4[1]) * (p2[1] - p4[1]);
        length_array[5] = (p3[0] - p4[0]) * (p3[0] - p4[0]) + (p3[1] - p4[1]) * (p3[1] - p4[1]);
        sort(length_array);
        if (length_array[0] == length_array[1] && length_array[1] == length_array[2] && length_array[2] == length_array[3] && length_array[0] > 0 && length_array[4] == length_array[5] && length_array[4] == 2 * length_array[1]) {
            return true;
        }
        return false;
    }
    
}
