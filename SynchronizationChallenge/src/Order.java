import java.util.Random;

public record Order(long id, String shoeType, int quantity) {
    @Override
    public String toString() {
        return "Order Id: %d, Shoe Type: %s, Quantity: %d".formatted(id, shoeType, quantity);
    }
}
