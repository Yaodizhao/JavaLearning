package JavaReview;

import java.io.*;

import static java.lang.Runtime.getRuntime;
import static java.lang.System.currentTimeMillis;

public class QiFeiLou {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(currentTimeMillis());
        System.out.println(getRuntime().maxMemory());
        System.out.println(getRuntime().totalMemory());
        System.out.println(getRuntime().availableProcessors());
        String a = "a" + "b" + "c";
        String b = "abc";
        System.out.println(b == a);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("./src/JavaCoreLearning1/a.txt"));
        objectOutputStream.writeObject(a);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("./src/JavaCoreLearning1/a.txt"));
        Object o = objectInputStream.readObject();
        System.out.println(o);
    }
}
