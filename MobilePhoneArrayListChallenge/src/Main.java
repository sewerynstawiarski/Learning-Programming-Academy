public class Main {
    public static void main(String[] args) {
Contact bob = new Contact("Bob", "31415926");
Contact alice = new Contact("Alice", "16180339");
MobilePhone mobilePhone = new MobilePhone("66665454");

        System.out.println(mobilePhone.addNewContact(bob));
        System.out.println(mobilePhone.addNewContact(alice));

        mobilePhone.printContacts();

        System.out.println(mobilePhone.addNewContact(bob));
        System.out.println(mobilePhone.addNewContact(alice));

        mobilePhone.printContacts();

        mobilePhone.removeContact(alice);

        mobilePhone.printContacts();
    }
}
