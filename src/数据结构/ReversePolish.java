package 数据结构;

import java.util.Stack;

/**
 * @author 如月车站
 */
public class ReversePolish {
    public static void main(String[] args) {
        String suffix = "3.1 4 + 5 * 6.5 -";
        String infix = "1 + ( ( 2 + 3 ) * 4 ) - 5";
        String suffix1 = infix2Suffix(infix);
        System.out.println(suffix1);
        double v = againstPoland(suffix1);
        System.out.println(v);
    }

    public static double againstPoland(String suffix) {
        String[] strings = suffix.split(" ");
        Stack<Double> stack = new Stack<>();
        for (String string : strings) {
//            if (string.matches("\\d+"))
//            Double.parseDouble(string);
            if (string.equals("+") || string.equals("-") || string.equals("/") || string.equals("*")) {
                double a = stack.pop();
                double b = stack.pop();
                stack.push(caculate(a, b, string.charAt(0)));
            } else {
                stack.push(Double.valueOf((string)));
            }
        }
        return stack.pop();
    }

    public static double caculate(double a, double b, char c) {
        return switch (c) {
            case '+' -> a + b;
            case '-' -> b - a;
            case '*' -> a * b;
            case '/' -> b / a;
            default -> throw new RuntimeException("运算符有误");
        };
    }

    public static String infix2Suffix(String infix) {
        String[] strings = infix.split(" ");
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        for (String string : strings) {
            if ("(".equals(string)) {
                stack1.push(string);
            } else if (string.equals(")")) {
                if (!stack1.isEmpty()) {
                    while (!stack1.peek().equals("(")) {
                        stack2.push(stack1.pop());
                    }
                }
                stack1.pop();
            } else if ("*".equals(string) || "/".equals(string)) {
                stack1.push(string);
            } else if ("+".equals(string) || "-".equals(string)) {
                while (!stack1.isEmpty() && (stack1.peek().equals("*") || stack1.peek().equals("/") || stack1.peek().equals("+") || stack1.peek().equals("-"))) {
                    stack2.push(stack1.pop());
                }
                stack1.push(string);
            } else {
                stack2.push(string);
            }
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.toString().substring(1, stack2.toString().length() - 1).replace(",", "");
    }
}
