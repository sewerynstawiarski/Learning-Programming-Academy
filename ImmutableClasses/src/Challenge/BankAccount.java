package Challenge;

public class BankAccount {
    enum Type {CHECKING, SAVINGS};

    private final Type type;
    private final int initialAmount;

    public BankAccount(Type type, int initialAmount) {
        this.type = type;
        this.initialAmount = initialAmount;
    }

    public Type getType() {
        return type;
    }

    public int getInitialAmount() {
        return initialAmount;
    }

    @Override
    public String toString() {
        return "Type: " + type + " initial amount = " + initialAmount;
    }
}
