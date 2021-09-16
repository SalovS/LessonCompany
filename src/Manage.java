import java.util.Random;

public class Manage implements Employee{
    private double minProfit = 115000;
    private double maxProfit = 140000;
    private double bonus = 0.05;
    Random random = new Random();
    private double salary;

    Manage(double salary){
        this.salary = salary;
    }

    public void setMonthSalary(double salary){
        this.salary = salary;
    }

    @Override
    public double getMonthSalary() {
        return salary + (random.nextDouble() * (maxProfit - minProfit) + minProfit) * bonus;
    }
}
