public class Main {
    public static void main(String[] args) {
//Printer printer = new Printer(50,true);
//Printer printer1 = new Printer(20,false);
//printer.printPages(50);
//printer.printPages(673 );
//        System.out.println("All printed pages are " + printer.getPagesPrinted());
//        printer.addToner(50);
//        System.out.println("Toner level is: " + printer.getTonerLevel());
//
//        printer1.addToner(66);
//        printer1.printPages(356);
//         int pagesPrinted = printer1.printPages(6);
//        System.out.printf("Current Job Pages %d, Total printed %d %n", pagesPrinted, printer1.getPagesPrinted());
//
//        pagesPrinted = printer1.printPages(10);
//        System.out.printf("Current Job Pages %d, Total printed %d %n", pagesPrinted, printer1.getPagesPrinted());
//
//        System.out.println("Printed pages " + printer1.getPagesPrinted());
//        System.out.println("Toner level is " + printer1.getTonerLevel());

        Printer2 printer = new Printer2(50, true);
        System.out.println(printer.addToner(50));
        System.out.println("initial page count = " +printer.getPagesPrinted());
        int pagesPrinted = printer.printPages(4);
        System.out.println("Pages printed was " + pagesPrinted +" new total print count for printer = " +printer.getPagesPrinted());
        pagesPrinted = printer.printPages(2);
        System.out.println("Pages printed was " + pagesPrinted +" new total print count for printer = " +printer.getPagesPrinted());
    }
}
