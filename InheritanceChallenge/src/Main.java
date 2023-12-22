public class Main {
    public static void main(String[] args) {

        Worker worker = new Worker("Generic", "09081991", "10102022");
        System.out.println(worker.getAge());
        System.out.println(worker.collectPay());

        SalariedEmployee jimmy = new SalariedEmployee("Jimmy", "20091992", "0", "02032020", 20000,false);
        System.out.println(jimmy);
        System.out.println(jimmy.getAge());
       jimmy.terminate("11092023");
        System.out.println(jimmy.collectPay());
        jimmy.retire();
        System.out.println(jimmy);

        SalariedEmployee Tim = new SalariedEmployee("Tim", "09081999" , "0" , "09092022", 15000,false);
        System.out.println(Tim);

        HourlyEmployee Amy = new HourlyEmployee("Amy" , "09081887","0", "02032021", 5.56);
        System.out.println(Amy);
        System.out.println("Amy's paycheck is: " + Amy.collectPay());
        System.out.println("Holiday paycheck is " + Amy.getDoublePay());
    }
}
