import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
       private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) < 0) {
            myContacts.add(contact);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        if (findContact(oldContact) > -1) {
            myContacts.remove(oldContact);
            myContacts.add(newContact);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeContact(Contact contact) {
        if (findContact(contact) > -1) {
            myContacts.remove(contact);
            return true;
        }
        return false;
    }
    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }
    private int findContact(String name) {
        for (Contact contact :
                myContacts) {
            if (contact.getName().equals(name)) {
                return myContacts.indexOf(contact);
            }
        } return -1;
    }
    public Contact queryContact(String name) {
        for (Contact contact :
                myContacts) {
            if (contact.getName().equals(name)) {
                return contact;
//                return myContacts.get(myContacts.indexOf(contact)); indexOf potrzebuje Contact a nie String !! Bo inaczej daje zawsze -1
            }
//        return myContacts.get(myContacts.indexOf(name));
        } return null;
    }
    public void printContacts() {
        System.out.println("Contact List:");
        for (var i :
                myContacts) {
            System.out.printf(
                    "%d. %s -> %s%n", myContacts.indexOf(i)+1 , i.getName(), i.getPhoneNumber());
        }
    }
}
