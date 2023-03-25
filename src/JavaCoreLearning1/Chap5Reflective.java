package JavaCoreLearning1;

import JavaCoreLearning1.package1.Employee;
import JavaCoreLearning1.package1.Manager;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Chap5Reflective {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Employee e = new Employee("11", 1, 11, 1, 1);
        Manager e1 = new Manager("11", 1, 11, 1, 1);
        Class c = e.getClass();
        System.out.println(c.getName());
        System.out.println(Double[].class.getName());
        //前面为Class类型的参数类型，后面为参数值
        Employee e2 = e1.getClass().getDeclaredConstructor(String.class, double.class, int.class, int.class, int.class, double.class).newInstance("11", 1, 11, 1, 1, 1.0);
        System.out.println(e2.getSalary());
        
        int length = 3;  
        Employee[] a = new Employee[3];
        a[0] = new Employee("11", 1, 1, 1, 1);
        a[1] = new Employee("11", 1, 1, 1, 1);
        a[2] = new Employee("11", 1, 1, 1, 1);
        
        int newLength = 10;
        Object newArray = Array.newInstance(a.getClass().getComponentType(), newLength);
        
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        System.out.println(((Employee[])newArray)[0].getSalary());
        
        Method m1 = Employee.class.getMethod("getName");
        Method m2 = Employee.class.getMethod("raiseSalary", double.class);
        String n = (String)m1.invoke(a[0]);
        System.out.println(n);
    }
}
