import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Company company = new Company(11000000);
        List<Employee> operators = new ArrayList<Employee>();
        Random random = new Random();
        for(int i = 0; i < 180; i++){
            operators.add(new Operator(random.nextDouble()*10000 + 25000));
        }
        List<Employee> managers = new ArrayList<Employee>();
        for(int i = 0; i < 80; i++){
            managers.add(new Manage(random.nextDouble()*20000 + 35000));
        }
        List<Employee> topManagers = new ArrayList<Employee>();
        for(int i = 0; i < 10; i++){
            topManagers.add(new TopManager(random.nextDouble()*200000 + 300000, company));
        }
        company.hireAll(operators);
        company.hireAll(managers);
        company.hireAll(topManagers);
        DecimalFormat dF = new DecimalFormat("###,###");

        System.out.println("Список зарплат по убыванию");
        for(Employee employee: company.getLowestSalaryStaff(30)) {
            System.out.println(dF.format(employee.getMonthSalary()) + " руб.");
        }
        System.out.println("Список зарплат по возрастанию");
        for(Employee employee: company.getTopSalaryStaff(15)) {
            System.out.println(dF.format(employee.getMonthSalary()) + " руб.");
        }
        System.out.println("-----------------");


        for(int i = 0; i < 135; i++){
            company.fire(i);
        }

        System.out.println("Список зарплат по убыванию");
        for(Employee employee: company.getLowestSalaryStaff(30)) {
            System.out.println(dF.format(employee.getMonthSalary()) + " руб.");
        }
        System.out.println("Список зарплат по возрастанию");
        for(Employee employee: company.getTopSalaryStaff(15)) {
            System.out.println(dF.format(employee.getMonthSalary()) + " руб.");
        }
        System.out.println("-----------------");

        company.setIncome(7000000);
        System.out.println("Список зарплат по возрастанию");
        for(Employee employee: company.getTopSalaryStaff(15)) {
            System.out.println(dF.format(employee.getMonthSalary()) + " руб.");
        }
    }
}
