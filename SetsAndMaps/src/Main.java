import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");
        printData("Phone List", phones);
        printData("Email List", emails);

        Set<Contact> emailContacts = new HashSet<>(emails);
        Set<Contact> phonesContacts = new HashSet<>(phones);
        printData("Phone Contacts", phonesContacts);
        printData("Email Contacts", emailContacts);

        int index = emails.indexOf(new Contact("Robin Hood"));
        Contact robinHood = emails.get(index);
        robinHood.addEmail("Sherwood Forest");
        robinHood.addEmail("Sherwood Forest");
        robinHood.replaceEmailIfExists("RHood@sherwoodforest.com", "RHood@sherwoodforest.org");
        System.out.println(robinHood);

        Set<Contact> unionAB = new HashSet<>();
        unionAB.addAll(emailContacts);
        unionAB.addAll(phonesContacts);
        printData("(A ∪ B) Union of emails (A) with photos (B)", unionAB);

        Set<Contact> intersectedAB = new HashSet<>(emailContacts);
        intersectedAB.retainAll(phonesContacts);
        printData("(A \u2229 B) Intersected emails (A) and phones (B)", intersectedAB);

        Set<Contact> intersectedBA = new HashSet<>(phonesContacts);
        intersectedBA.retainAll(emailContacts);
        printData("(B \u2229 A) Intersected phones (B) and emails (A)", intersectedBA);

        Set<Contact> AminusB = new HashSet<>(emailContacts);
        AminusB.removeAll(phonesContacts);
        printData("(A - B)  emails (A) -  phones (B)", AminusB);

        Set<Contact> BminusA = new HashSet<>(phonesContacts);
        BminusA.removeAll(emailContacts);
        printData("(B - A)  phones (B) -  emails (A)", BminusA);

        Set<Contact> symmetricDiff = new HashSet<>(AminusB);
        symmetricDiff.addAll(BminusA);
        printData("Symmetric Difference: phones and emails", symmetricDiff);

        Set<Contact> symmetricDiff2 = new HashSet<>(unionAB);
        symmetricDiff2.removeAll(intersectedAB);
        printData("Symmetric difference: phones and emails", symmetricDiff2);

    }

    public static void printData (String header, Collection<Contact> contacts) {
        System.out.println("-".repeat(50));
        System.out.println(header);
        System.out.println("-".repeat(50));
        contacts.forEach(System.out::println);
    }
}
