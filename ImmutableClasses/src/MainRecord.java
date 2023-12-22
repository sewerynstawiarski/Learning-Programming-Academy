public class MainRecord {
    public static void main(String[] args) {
        PersonRecord jane = new PersonRecord("Jane", "01/01/1930");
        PersonRecord jim = new PersonRecord("Jim", "02/02/1940");
        PersonRecord joe = new PersonRecord("Joe", "05/05/2050");

        PersonRecord[] johnsKids = {jane, jim, joe};
        PersonRecord john = new PersonRecord("John", "04/09/1901", johnsKids);
        System.out.println(john);

        PersonRecord johnCopy = new PersonRecord("John", "05/05/1901");
        System.out.println(johnCopy);

        PersonRecord[] kids = johnCopy.kids();
        kids[0] = jim;
        kids[1] = new PersonRecord("Ann", "03/04/1936");
        System.out.println(johnCopy);

        johnsKids[0] = new PersonRecord("Ann", "03/03/1935");
        System.out.println(john);
    }
}
