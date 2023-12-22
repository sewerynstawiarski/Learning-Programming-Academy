import com.sun.source.tree.BreakTree;

public class Worker {
    private String name;
    private String birthDate;
    private String endDate;

    Worker() {

    }

    public int getAge() {
        int dateOfBirth = Integer.parseInt(getBirthDate());
        int age = 0;
        try {
            age = (2023 - (dateOfBirth % 10000));
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input! Date of birth should be in DDMMKYYYY format");
        }
        return age;
    }
    public double collectPay() {
     return 0.0;
    }
    public void terminate(String endDate) {
        setEndDate(endDate);
       // System.out.println(name + " finished employment today: " + endDate);

        }

    public Worker(String name, String birthDate, String endDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.endDate = endDate;
    }
    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
