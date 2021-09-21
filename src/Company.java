import java.util.*;
import java.util.stream.Collectors;

public class Company {
    List<Employee> employees = new ArrayList<>();
    private double income;

    Company(double income){
        this.income = income;
    }

    public double getIncome(){
        return income;
    }

    public void setIncome(double income){
        this.income = income;
    }

    public void  hire(Employee employee){
        this.employees.add(employee);
    }

    public void hireAll(List<Employee> workers){
        this.employees.addAll(workers);
    }

    public void fire(int index){
        if(index < 0 || index >= employees.size()) {
            printError();
        }else {
            employees.remove(index);
        }
    }

    private void printError(){
        try {
            throw new inputException("Невозможно уволить сотрудника под этим индексом");
        } catch (inputException e) {
        }
    }


    public List <Employee> getTopSalaryStaff(int count){
        return employees.stream().sorted((o1,o2) -> {
            if(o1.getMonthSalary() == o2.getMonthSalary()){
                return 0;
            }else if(o1.getMonthSalary() < o2.getMonthSalary()){
                return 1;
            }else{
                return -1;
            }
        }).limit(count).collect(Collectors.toList());
    }

    public List <Employee> getLowestSalaryStaff(int count) {
        return employees.stream().sorted(Comparator.comparing(employees ->
                employees.getMonthSalary())).limit(count).collect(Collectors.toList());
    }
}
