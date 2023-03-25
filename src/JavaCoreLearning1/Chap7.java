package JavaCoreLearning1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Chap7 {
    public static void main(String[] args) {
//        File f = new File(JavaCoreLearning.chap7.class.getResource("/").getPath());
//        System.out.println(f);
//        read("E:\\2021postgraduate1\\programming\\Java\\JavaLearning\\src\\a.txt");
//        read("src\\b.txt");
        Scanner scan = new Scanner(System.in);
        int i = 0;
        float f = 0.0f;
        System.out.print("输入整数：");
        if (scan.hasNextInt()) {
            // 判断输入的是否是整数
            i = scan.nextInt();
            // 接收整数
            System.out.println("整数数据：" + i);
        } else throw new IllegalArgumentException("输入不是整数");
        // 输入错误的信息
//        将该数字吸收
        scan.next();
        System.out.print("输入小数：");
        if (scan.hasNextFloat()) {
            // 判断输入的是否是小数
            f = scan.nextFloat();
            // 接收小数
            System.out.println("小数数据：" + f);
        } else {
            // 输入错误的信息
            System.out.println("输入的不是小数！");
        }
        scan.close();
    }
    
    public static void read(String filename) {
        try {
            InputStream in = new FileInputStream(filename);
            int b;
            while ((b = in.read()) != - 1) {
                System.out.println(b);
            }
        } catch (IOException exception) {
//            打印堆栈轨迹
            StackTraceElement[] frames = exception.getStackTrace();
            for (StackTraceElement frame: frames) {
                System.out.println(frame.toString());
            }
            exception.printStackTrace();
            System.out.println(exception);
        }
    }
}

class FileFormatException extends IOException {
    public FileFormatException() {
    }
    
    public FileFormatException(String gripe) {
        super(gripe);
    }
}