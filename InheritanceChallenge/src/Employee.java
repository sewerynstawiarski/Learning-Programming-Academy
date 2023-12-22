public class Employee extends Worker{
    private long employeeID;
    private String hireDate;

    private static int employeeNo = 1;



    Employee() {
    }

    public Employee(String name, String birthDate, String endDate, String hireDate) {
        super(name, birthDate, endDate);
        this.employeeID = Employee.employeeNo++;
        this.hireDate = hireDate;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public String getHireDate() {
        return hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", hireDate='" + hireDate + '\'' +
                "} " + super.toString();
    }
}
