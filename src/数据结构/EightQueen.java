package 数据结构;

public class EightQueen {
    static int[] chessboard = new int[8];
    
    public static void main(String[] args) {
        eightQueen(0);
    }


    private static void eightQueen(int count) {
        if (count == 8) {
            printChess(chessboard);
            return;
        }
        for (int i = 0; i < 8; i++) {
            chessboard[count] = i;
            if (Judge(count)) {
                eightQueen(count + 1);
            }
        }
    }
    
    public static boolean Judge(int count) {
        for (int i = 0; i < count; i++) {
            if (chessboard[i] == chessboard[count] || Math.abs(count - i) == Math.abs(chessboard[count] - chessboard[i])) {
                return false;
            }
        }
        return true;
    }
    
    public static void printChess(int[] chessboard) {
        for (int num: chessboard) {
            System.out.printf("%d ", num);
        }
        System.out.println();
    }


}
