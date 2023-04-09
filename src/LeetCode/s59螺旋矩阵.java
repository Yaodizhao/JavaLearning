package LeetCode;

public class s59螺旋矩阵 {

    public static void main(String[] args) {
        int[][] res = generateMatrix(6);
        for (int[] anInt : res) {
            for (int i : anInt) {
                System.out.print(i);
                System.out.print("  ");
            }
            System.out.println("\n");
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;
        int index = n - 1;
        int start = 0;
        while (count < n * n) {

            for (int i = start; i < start + index; i++) {
                res[start][i] = count++;
            }

            for (int i = start; i < start + index; i++) {
                res[i][n - 1 - start] = count++;
            }

            for (int i = n - 1 - start; i > start; i--) {
                res[n - 1 - start][i] = count++;
            }

            for (int i = n - 1 - start; i > start; i--) {
                res[i][start] = count++;
            }
            index -= 2;
            start++;
        }
        if (n % 2 != 0) {
            res[n / 2][n / 2] = n * n;
        }
        return res;
    }
}
