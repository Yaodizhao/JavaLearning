package JavaCoreLearning1;

import JavaCoreLearning1.package1.Employee;
import JavaCoreLearning1.package1.Person;
import JavaCoreLearning1.package1.Student;

import java.util.ArrayList;

public class Chap5 {
    public static void main(String[] args) {
        Person[] people = new Person[2];
        people[0] = new Employee("aa", 12, 1, 1, 1);
        people[1] = new Student("aa", "12");
        for (Person p: people)
            System.out.println(p.getName() + ", " + p.getDescription());
        
        int actualSize = 1;
        Employee[] staff = new Employee[actualSize];
        ArrayList<Employee> staff1 = new ArrayList<>();
        staff1.add(new Employee("a", 1, 1, 1, 1));
        System.out.println(staff1.size());
        Employee a = new Employee("a", 1, 1, 1, 1);
        a.print(1, 2, 3);
        Size s = Enum.valueOf(Size.class, "SMALL");
        System.out.println(s.getAbbreviation());
    }
    
    public enum Size {
        SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
        private String abbreviation;
        
        Size(String abbreviation) {
            this.abbreviation = abbreviation;
        }
        
        public String getAbbreviation() {
            return abbreviation;
        }
        
    }
    
}
