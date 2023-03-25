package JavaReview;

import java.io.File;

public class Java_IO {
    public static void main(String[] args) {
        listAllFiles(new File("./src"));
    
        new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
    }
    
    public static void listAllFiles(File dir) {
        if (dir == null || ! dir.exists()) {
            return;
        }
        if (dir.isFile()) {
            System.out.println(dir.getName());
            return;
        }
        for (File file: dir.listFiles()) {
            listAllFiles(file);
        }
    }
}
