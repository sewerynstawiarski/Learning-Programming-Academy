import java.time.LocalDate;
import java.util.*;

public class Store {
    private Map<String, InventoryItem> inventory = new HashMap<>();
    private NavigableSet<Cart> carts = new TreeSet<>(Comparator.comparing(Cart::getId));
    private Map<Category, Map<String, InventoryItem>> aisleInventory;


    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(List.of(new Product("A100","apple","local",Category.PRODUCE),
                new Product("B100","banana","local",Category.PRODUCE),
                new Product("P100","pear","local",Category.PRODUCE),
                new Product("L103","lemon","local",Category.PRODUCE),
                new Product("M201","milk","farm",Category.DAIRY),
                new Product("Y001","yogurt","farm",Category.DAIRY),
                new Product("C333","cheese","farm",Category.DAIRY),
                new Product("R777","rice chex","Nabisco",Category.CEREAL),
                new Product("G111","granola","Nat Valley",Category.CEREAL),
                new Product("BB11","ground beef","butcher",Category.MEAT),
                new Product("CC11","chicken","butcher",Category.MEAT),
                new Product("BC11","bacon","butcher",Category.MEAT),
                new Product("BC77","coke","coca cola",Category.BEVERAGE),
                new Product("BC88","coffee","value",Category.BEVERAGE),
                new Product("BC99","tea","herbal",Category.BEVERAGE)));

        Store myStore =  new Store();
        addInventory(myStore, products);
        myStore.addAisleInventory();
        System.out.println(myStore.carts);
        myStore.manageStoreCarts();
        myStore.listProductByCategory();
//       myStore.abandonCarts();
        myStore.checkOutCart();
        myStore.listProductByCategory();


    }

    static void manageStoreCarts(NavigableSet<Cart> carts) {
    }
    private static void addInventory(Store store, List<Product> products) {
        Random random = new Random();
        for (Product p :
                products) {
            store.inventory.put(p.sku(), new InventoryItem(p, random.nextDouble(1.00, 5.00),
                    random.nextInt(500, 1000), random.nextInt(30, 100)));
        }
//        store.inventory.forEach((k, v) -> System.out.println("Key: " + k + " Value: " +v));
    }
    private void addAisleInventory() {
        aisleInventory = new EnumMap<>(Category.class);
        for (InventoryItem item :
                inventory.values()) {
            Category aisle = item.getProduct().category();

            Map<String, InventoryItem> productMap = aisleInventory.get(aisle);
            if (productMap == null) {
                productMap = new TreeMap<>();
            }
            productMap.put(item.getProduct().name(), item);
            aisleInventory.putIfAbsent(aisle, productMap);
        }
        }
        private void listProductByCategory() {
            System.out.println("-".repeat(70));
            aisleInventory.forEach((k, v) -> {
                System.out.println("Category: " + k);
                v.forEach((s, m) -> System.out.println(m));
            });
            System.out.println("-".repeat(70));
            inventory.forEach((k ,v) -> System.out.println(v));
        }
        private void manageStoreCarts() {
        Cart cart1 = new Cart(Cart.CartType.PHYSICAL, 1);
            cart1.addItem(inventory.get("Y001"), 120);
            cart1.addItem(inventory.get("CC11"), 50);
            Cart cart2 = new Cart(Cart.CartType.VIRTUAL, 0);
            cart2.addItem(inventory.get("BC99"),89);
            cart2.addItem(inventory.get("C333"), 600);
            cart2.addItem(inventory.get("G111"), 23);
            carts.addAll(List.of(cart1, cart2));
            System.out.println(carts);
        }
        private void checkOutCart() {
        Map<String, InventoryItem> boughtProducts = new HashMap<>();
            for (Cart cart :
                    carts) {
                for (String product :
                        cart.getProducts().keySet()) {
                    boughtProducts.put(product, inventory.get(product));
                    if (!inventory.get(product).sellItem(cart.getProducts().get(product))) return;
                }
                cart.printSalesSlip(boughtProducts);
            }
            carts.clear();
        }
        private void abandonCarts() {
        Set<Cart> toDelete = new HashSet<>();
            for (Cart cart :
                    carts) {
                if (!cart.getCartDate().equals(LocalDate.now())) {
                    toDelete.add(cart);
                    System.out.println("This cart was removed: " + cart);
                    cart.getProducts().forEach((k,v) -> inventory.get(k).releaseItem(v));
                }
                }
            carts.removeAll(toDelete);
        }
    }

