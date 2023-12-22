import java.sql.Wrapper;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

record Employee(String firstName, String lastName, int hireDate){
    @Override
    public String toString() {
        return "%s %s %d%n".formatted(firstName, lastName, hireDate);
    }
}
public class Main {
    public static void main(String[] args) {
        List<Employee> listEmployee = new ArrayList<>();

        Employee danny =  new Employee("Danny", "Stevenson", 1991);
        Employee steven =  new Employee("Steven", "Johnson", 2001);
        Employee clara =  new Employee("Clara", "Malik", 2010);
        Employee timothy =  new Employee("Timothy", "Galth", 2020);

         listEmployee.addAll(List.of(danny, clara, timothy, steven));

        System.out.println(listEmployee);

        List afterWrapper = thingsToDo(listEmployee);

        System.out.println(afterWrapper);

    }

private static List thingsToDo(List<Employee> list) {
        class Wrapper {
            private Employee employee;
            private String fullName;
            private int yearsWorked;

            public Wrapper(Employee employee) {
               this.employee = employee;
                this.fullName = employee.firstName()  + employee .lastName();
                int currentYear = LocalDate.now().getYear();
                this.yearsWorked = currentYear - employee.hireDate();
            }

            @Override
            public String toString() {
                return "%s %s %d%n".formatted(employee, fullName, yearsWorked);
            }
        }

        List<Wrapper> wrapperList = new ArrayList<>();

    for (Employee e :
            list) {
        wrapperList.add(new Wrapper(e));
    }

    wrapperList.sort(new Comparator<Wrapper>() {
        @Override
        public int compare(Wrapper o1, Wrapper o2) {
            return Integer.compare(o1.yearsWorked, o2.yearsWorked);
        }
    }.reversed());

    return wrapperList;
    }
}

