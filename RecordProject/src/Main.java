public class Main {
    public static void main(String[] args) {
    for (int i = 1; i <= 5; i++) {
        LPAStudent s = new LPAStudent("S92300" + i,
                switch (i) {
            case 1 -> "Maciek";
            case 2 -> "Karol";
            case 3 -> "Tomek";
            case 4 -> "Patryk";
            case 5 -> "Luna";
                    default -> "Anonymous";
                },"1999/05/02","open");
        System.out.println(s);
    }
    Student pojoStudent = new Student("S923006", "Anna", "1066/08/22", "JavaMasterClass");
    LPAStudent recordStudent = new LPAStudent("S923007", "Bunny", "1995/04/03", "JacaMasterClass");

        System.out.println(pojoStudent);
        System.out.println(recordStudent);

        pojoStudent.setClassList(pojoStudent.getClassList() + ", Java OCP Exam 829");
      //  recordStudent.setClassList(recordStudent.classList() + ", Java OCP Exam 829");

        System.out.println(pojoStudent.getName() + " is taking " + pojoStudent.getClassList());
        System.out.println(recordStudent.name() + " is taking " + recordStudent.classList());

        Point point = new Point(3,6);
        System.out.println(point.distance(5,19));


        Carpet carpet = new Carpet(3.5);
        Floor floor = new Floor(2.75, 4.0);
        Calculator calculator =new Calculator(floor, carpet);
        System.out.println("total = " + calculator.getTotalCost());
    }
}
