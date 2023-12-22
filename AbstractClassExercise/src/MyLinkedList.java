public class MyLinkedList implements NodeList {
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem listItem) {
        ListItem current = this.getRoot();
        System.out.println(current.value + " = root, adding item = " + listItem.value);
        if (listItem == null) {
            return false;
        } else if (current == null) {
            System.out.println("Added in null place");
            this.root = listItem;
            return true;
        } else if (current.compareTo(listItem) == 0) {
            System.out.println("Duplicates not allowed " + listItem.value);
            return false;
        } else {
            boolean flag = true;
            while (flag) {
                flag = false;
                if (current.compareTo(listItem) > 0) {
                    if (current.previous() != null) {
                        if (current.previous().compareTo(listItem) > 0) {
                            this.root = current.previous();
                            System.out.println("Moved left to search with " + listItem.value);
                            addItem(listItem);
                            return false;
                        }
                        current.previous().setNext(listItem);
                        listItem.setPrevious(current.previous());
                        listItem.setNext(current);
                        current.setPrevious(listItem);
                        System.out.println(listItem.value + " Added before object " + current.value );
                        return true;
                    } else if (current.previous() == null) {
                        listItem.setNext(current);
                        current.setPrevious(listItem);
                        System.out.println(listItem.value + " Added before" + current.value + " as first object");
                        return true;
                    }
                } else if (current.compareTo(listItem) < 0) {
                    if (current.next() == null) {
                        current.setNext(listItem);
                        listItem.setPrevious(current);
                        System.out.println(listItem.value + " Added behind object " + current.value );
                        return true;
                    } else if (current.next() != null && current.next().compareTo(listItem) != 0) {
                        this.root = current.next();
                        System.out.println("Moved to the next one " + this.root.value);
                        addItem(listItem);
                        return false;
                    }
                }
            }
            System.out.println(listItem.value + " wasn't added");
            return false;
        }
    }


    @Override
    public boolean removeItem(ListItem listItem) {
        if (root.compareTo(listItem) == 0) {
            root.next().setPrevious(root.previous());
            root.previous().setNext(root.next());
            return true;
        } else if (root.next() != null) {
            root = root.next();
            removeItem(listItem);
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
    if (root == null) {
        System.out.println("The list is empty");
    }
     else {
        System.out.println("sent root was = " + root.value);
        while (root.previous() != null) {
            traverse(root.previous());
            return;
        }
        while (root.next() != null) {
            System.out.println(root.value);
            root = root.next();
        }
        if (root.next() == null) {
            System.out.println(root.value);
        }
        }
    }
    }
