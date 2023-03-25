package JavaCoreLearning1;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Chap1 {
    public static void main(String[] args) {
        String a = "abc";
        Object b = a.substring(0, 0) + 'b';
        System.out.println(b);
        
        Scanner in = null;
        try {
            in = new Scanner(Paths.get("src/JavaCoreLearning1/a.txt"), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(in.nextLine());
        
        System.out.println(1 + 2 + "aaa" + 3 + 1);
    }
}
