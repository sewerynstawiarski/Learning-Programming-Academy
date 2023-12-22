import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Mappable> mappables = new ArrayList<>();
        mappables.add(new Building("Hala Stulecia", UsageType.ENTERTAINMENT));
        mappables.add(new Building("Urząd Wojewódzki", UsageType.GOVERNMENT));
        mappables.add(new Building("Stadion Wrocław", UsageType.SPORTS));

        mappables.add(new Utility("Uniwersytet", UtilityType.FIBER_OPTIC));
        mappables.add(new Utility("Kanał", UtilityType.WATER));

        for (var m :
                mappables) {
            Mappable.printProperties(m);
        }
    }
}
