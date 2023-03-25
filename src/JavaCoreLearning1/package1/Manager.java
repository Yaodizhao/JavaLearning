package JavaCoreLearning1.package1;

public class Manager extends Employee {
    
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }
    
    public Manager(String name, double salary, int year, int month, int day, double bonus) {
        super(name, salary, year, month, day);
        setBonos(bonus);
    }
    
    private double bonus;
    
    public void setBonos(double bonus) {
        this.bonus = bonus;
    }
    
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
}
