package LeetCode;

public class s1342数字变0操作次数 {
    
    public static int numberOfSteps_Improvement(int num) {
        int step = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num - 1;
            }
            step++;
        }
        return step;
    }
    
    public static int numberOfSteps(int num) {
        int step = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num - 1;
            }
            step++;
        }
        return step;
    }
}
