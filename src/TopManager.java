public class TopManager implements Employee{
    private double salary;
    private double sufficientIncome = 10000000;
    private double bonus = 2.50;
    private Company company;

    public void setMonthSalary(double salary, Company company){
        this.salary = salary;
        this.company = company;
    }

    TopManager(double salary, Company company){
        this.salary = salary;
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        if(company.getIncome() > sufficientIncome){
            return salary * bonus;
        }
        return salary;
    }
}
