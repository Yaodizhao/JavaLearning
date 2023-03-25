package JavaCoreLearning1;

import JavaCoreLearning1.package1.Employee;
import JavaCoreLearning1.package1.Person;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.nullsFirst;

public class Chap6 {
    public static void main(String[] args) {
        
        Employee e1 = new Employee("11", 1, 1, 1, 1);
        Employee e2 = new Employee("11", 0, 1, 1, 1);
        System.out.println(e1.compareTo(e2));
        
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Harry Hacker", 35000, 1, 1, 1);
        staff[1] = new Employee("Carl Cracker", 36000, 2, 1, 1);
        staff[2] = new Employee("Tony Tester", 38000, 3, 1, 1);
        MyComparator mc = new MyComparator();
//        等于Comparator<Employee> mc = new JavaCoreLearning.MyComparator();
//        Arrays.sort(staff, mc);
//        for (Employee e: staff) {
//            System.out.println(e.getName() + ' ' + e.getSalary());
//        }
        Arrays.sort(staff, Comparator.comparing(Person::getName, nullsFirst(naturalOrder())));
        for (Employee e: staff) {
            System.out.println(e.getName() + ' ' + e.getSalary());
        }
        Comparable<Employee> a = new Employee("Tony Tester", 38000, 3, 1, 1);
        int b = a.compareTo(staff[0]);
        System.out.println("b=" + b);
        
        System.out.println(Paths.get("fjdk1.8.0", "jre", "bin"));
        
        student st = new student("a");
        System.out.println(st.getName());

//        JOptionPane.showMessageDialog(null, "aaa");
        int aa = 1;
        int bb = aa;
        System.out.println(aa + "," + bb);
        bb = 2;
        System.out.println(aa + "," + bb);
        
    }
}

class MyComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        //如果n1小于n2，我们就返回正值，如果n1大于n2我们就返回负值，
        //这样颠倒一下，就可以实现反向排序了
        if (o1.getHireDay().getYear() < o2.getHireDay().getYear()) {
            return 1;
        } else if (o1.getHireDay().getYear() > o2.getHireDay().getYear()) {
            return - 1;
        } else {
            return 0;
        }
    }
}

interface Named {
    String getName();
}

class student extends Person implements Named {
    String name;
    
    public student(String name) {
        super(name);
        this.getName();
        this.name = name;
    }
    
    @Override
    public String getDescription() {
        return null;
    }
    
    public String getName() {
        return name + "ydz";
//        子类实现了接口方法，实际上是对父类方法的重写，同时此方法对应了接口方法。
    }
}