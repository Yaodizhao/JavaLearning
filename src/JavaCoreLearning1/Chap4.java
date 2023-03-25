package JavaCoreLearning1;

import JavaCoreLearning1.package1.Employee;
import JavaCoreLearning1.package1.Manager;

import java.util.Date;
import java.util.Random;

public class Chap4 {
    
    public static void main(String[] args) {
            break_data:
        while (1 < 100) {
            while (1 < 100) {
                break break_data;
            }
        }
        Date ddl = new Date();
        String ddls = ddl.toString();
        System.out.println(ddl + "~" + ddls);
        Random r = new Random();
        
        System.out.println(r.nextInt(5));
        Employee e = new Employee("abc", 5000, 1, 1, 1);
        Manager m = new Manager("abc", 5000, 1, 1, 1, 1);
        
        Manager n = null;
//        不能向下转换
//        try {
//            n = (Manager)e;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        System.out.println(n.getSalary());
    }
}



