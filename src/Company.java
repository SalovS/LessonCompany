import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        if(index < 0){
            employees.remove(0);
        }
        if(index >= employees.size()) {
            employees.remove(employees.size() - 1);
        }else {
            employees.remove(index);
        }
    }


    public List <Employee> getTopSalaryStaff(int count){
        sortStaff();
        int quantity = checkCount(count);
        List<Employee> result = new ArrayList<>();
        for(int i = employees.size() - 1; i > employees.size() - 1 - quantity; i--) {
            result.add(employees.get(i));
        }
        return result;
    }

    public List <Employee> getLowestSalaryStaff(int count) {
        sortStaff();
        int quantity = checkCount(count);
        List<Employee> result = new ArrayList<>();
        for(int i = 0; i < quantity; i++) {
            result.add(employees.get(i));
        }
        return result;
    }

    private void sortStaff(){
        Comparator<Employee> comparator = Comparator.comparing(employees -> employees.getMonthSalary());
        Stream<Employee> resultStream = employees.stream().sorted(comparator);
        employees = resultStream.collect(Collectors.toList());
    }

    private int checkCount(int count){
        if(count < 0){
            return 0;
        }
        if(count > employees.size()){
            return employees.size();
        }
        return count;
    }
}
