public class Main {
    public static void main(String[] args) {
        Node item = new Node(1);
        Node item1 =  new Node(2);

        MyLinkedList myLinkedList = new MyLinkedList(item);

        System.out.println(myLinkedList.addItem(item1));

        myLinkedList.traverse(item);

    }
}
