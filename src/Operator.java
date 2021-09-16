public class Operator implements Employee{
    private double salary;

    Operator(double salary){
        this.salary = salary;
    }

    public void setMonthSalary(double salary){
        this.salary = salary;
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }
}
