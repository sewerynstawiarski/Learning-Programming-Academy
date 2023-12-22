import java.net.http.WebSocket;
import java.util.List;

public class SearchTree implements NodeList {
    private ListItem root;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem listItem) {
        ListItem current = getRoot();
        if (current.compareTo(listItem) == 0) {
            return false;
        }

        boolean flag = true;

        while (flag) {
            flag = false;
            if (current.compareTo(listItem) > 0) {
                if (current.previous() == null) {
                    listItem.setNext(current);
                    current.setPrevious(listItem);
                    current = listItem;
                    return true;
                } else {
                    current = current.previous();
                    flag = true;
                }
            }
            if (current.compareTo(listItem) < 0) {
                if (current.next() == null) {
                    listItem.setPrevious(current);
                    current.setNext(listItem);
                    current = listItem;
                    return true;
                } else {
                    current = current.next();
                    flag = true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem listItem) {
        if (root.compareTo(listItem) == 0) {
            performRemoval(root, root.previous());
            return true;
        } else if (root.next() != null) {
            root = root.next();
            removeItem(listItem);
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {

        System.out.println(root.value + " = root" + root.previous().value + "= previous" + root.next().value + " next");
        while (root.previous() != null) {
        traverse(root.previous());
        return;
            }

        while (root.next() != null) {
            if (root.previous() == null) {
                System.out.println(root.value);
                System.out.println(root.rightLink.value);
            root = root.next();
                    }
        System.out.println(root.leftLink.value);
        System.out.println(root.value);
        System.out.println(root.rightLink.value);
        root = root.next();
        }
        if (root.next() == null)  {
        System.out.println(root.leftLink.value);
        System.out.println(root.value);
    }
    }


    private void performRemoval(ListItem toBeRemoved, ListItem parent) {
        if (toBeRemoved.next()  != null) {
            parent.setNext(toBeRemoved.next());
            toBeRemoved.next().setPrevious(parent);
        }
        if (toBeRemoved.next() == null) {
            parent.setNext(null);
        }
    }
}
