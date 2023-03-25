package JavaCoreLearning2;

import JavaCoreLearning1.package1.Employee;
import JavaCoreLearning1.package1.Manager;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Chap2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // byte[] b = new byte[5];
        // int n = in.read(b);
        // System.out.printf("%d", n);
        //用户系统路径
        System.out.println(System.getProperty(("user.dir")));
        //用户系统文件分隔符
        System.out.println(File.separator);
        
        FileOutputStream Fo = new FileOutputStream("./src/acc.txt", true);
        // Fo.write('b');
        BufferedInputStream Bi = new BufferedInputStream(new FileInputStream("./src/acc.txt"));
        System.out.println((Arrays.toString(Bi.readAllBytes())));
        
        var in = new InputStreamReader(new FileInputStream("./src/acc.txt"), StandardCharsets.UTF_8);
        var out = new PrintWriter("./src/acc.txt", StandardCharsets.UTF_8);
        String name = "Harry porter";
        double salary = 400;
        out.print(name);
        out.print("\n");
        out.println(salary);
        out.close();
        
        var out1 = new ObjectOutputStream(new FileOutputStream("./src/e.dat"));
        var harry = new Employee("harry", 50000, 1989, 10, 1);
        var boss = new Manager("boss", 50000, 1989, 10, 1);
        out1.writeObject(harry);
        out1.writeObject(boss);
        var in1 = new ObjectInputStream(new FileInputStream("./src/e.dat"));
        //想要反序列化 需要在父类加上 implements Serializable
        var e1 = (Employee)in1.readObject();
        var e2 = (Employee)in1.readObject();
        System.out.println(e1.getDescription());
        System.out.println(e2.getName());
    }
}
