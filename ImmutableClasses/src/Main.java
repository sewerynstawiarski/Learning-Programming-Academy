public class Main {
    public static void main(String[] args) {
//    Person jane = new Person();
//    jane.setName("Jane");
//    Person jim = new Person();
//    jim.setName("Jim");
//    Person joe = new Person();
//    joe.setName("Joe");
//    Person john = new Person();
//    john.setName("John");
//    john.setDob("06/06/1958");
//    john.setKids(new Person[] {jane, jim, joe});
//    System.out.println(john);
//
//    john.setName("Jacob");
//    john.setKids(new Person[]{new Person(), new Person()});
//        System.out.println(john);

        Person jane = new Person("Jane", "01/01/1930");
        Person jim = new Person("Jim", "02/02/1940");
        Person joe = new Person("Joe", "05/05/2050");

        Person[] johnsKids = {jane, jim, joe};
        Person john = new Person("John", "04/09/1901", johnsKids);
        System.out.println(john);

        john.setKids(new  Person[]{new Person("Ann", "04/05/1928")});
        System.out.println(john);

        Person[] kids = john.getKids();
        kids[0] = jim;
        System.out.println(john);

        kids = null;
        System.out.println(john);

        john.setKids(kids);
        System.out.println(john);
    }
}
