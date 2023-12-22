public class SalariedEmployee extends Employee{

    private double annualSalary;
    private boolean isRetired;



@Override
    public double collectPay() {
        double yearsOfWork = ((Double.parseDouble(super.getEndDate()) % 10000) - (Double.parseDouble(super.getHireDate()) % 10000));
        if (yearsOfWork > 0) {
            return yearsOfWork * annualSalary;
        } else {
            return 0;
        }

    }
    public void retire() {
    terminate("02022024");
    isRetired = true;
//        if (isRetired) {
//            System.out.println(toString() + " is already retired");
//                    } else {
//            System.out.println(toString() + " is retiring from today.");
//            isRetired = true;
//            setEndDate("02032023");
//        }
    }

    public SalariedEmployee(String name, String birthDate, String endDate, String hireDate, double annualSalary, boolean isRetired) {
        super(name, birthDate, endDate, hireDate);
        this.annualSalary = annualSalary;
        this.isRetired = isRetired;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public boolean isRetired() {
        return isRetired;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "annualSalary=" + annualSalary +
                ", isRetired=" + isRetired +
                "} " + super.toString();
    }
}
