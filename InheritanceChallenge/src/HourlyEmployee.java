public class HourlyEmployee extends Employee{
    private double hourlyPayRate;


public double getDoublePay() {
    return 2 * collectPay();
}

@Override
public double collectPay() {
    return 40 * hourlyPayRate;
}
    public HourlyEmployee(String name, String birthDate, String endDate, String hireDate, double hourlyPayRate) {
        super(name, birthDate, endDate, hireDate);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }
}
