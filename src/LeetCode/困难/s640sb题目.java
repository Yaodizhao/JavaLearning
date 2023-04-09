package LeetCode.困难;

public class s640sb题目 {
    public static String solveEquation(String equation) {
        //标识等号左右
        int flag = 1, k = 0, b = 0, op = 1, num = 0;
        
        for (int i = 0; i < equation.length(); ) {
            if (equation.charAt(i) == '+') {
                op = 1;
                i++;
            } else if (equation.charAt(i) == '-') {
                op = - 1;
                i++;
            } else if (equation.charAt(i) == '=') {
                flag *= - 1;
                op = 1;
                i++;
            } else {
                while (equation.charAt(i) != '+' && equation.charAt(i) != '-' && equation.charAt(i) != '=') {
                    if (equation.charAt(i) != 'x') {
                        // num = num * 10 + (equation.charAt(i) - '0');
                        if (num == 0 && equation.charAt(i) == '0') {
                            if (i + 1 < equation.length() && equation.charAt(i + 1) == 'x') {
                                i++;
                            }
                            i++;
                            break;
                        } else {
                            num = num * 10 + Integer.parseInt(String.valueOf(equation.charAt(i)));
                        }
                    } else {
                        if (num == 0) {
                            k += flag * op;
                        } else {
                            k = k + op * flag * num;
                            num = 0;
                        }
                        
                    }
                    if (++ i == equation.length()) {
                        break;
                    }
                    
                }
                if (num != 0) {
                    b = b + op * flag * num;
                    num = 0;
                }
            }
        }
        
        if (k == 0) return b == 0 ? "Infinite solutions" : "No solution";
        return "x=" + (- b / k);
        
    }
}
