package JavaCoreLearning1.package1;

import java.time.LocalDate;

public class Employee extends Person implements Comparable<Employee> {
    private String name;
    private double salary;
    private LocalDate hireDay;
    
    public Employee(String name) {
        super(name);
        this.name = name;
    }
    
    public Employee(String name, double salary, int year, int month, int day) {
        super(name);
//        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }
    
    
    @Override
    public String getDescription() {
        return ("a employee");
    }
    
    @Override
    public String getName() {
        return super.getName();
//       子类中与超类的同名方法需要使用super
    }
    
    public double getSalary() {
        return salary;
    }
    
    public LocalDate getHireDay() {
        return hireDay;
    }
    
    public void raiseSalary(double byPercent) {
        
        double raise = salary * byPercent / 100;
        salary += raise;
    }
    
    public void print(int... args) {
        for (int arg: args) {
            System.out.println(arg);
        }
    }
    
    @Override
    public int compareTo(Employee o) {
        return Double.compare(salary, o.salary);
    }
}

