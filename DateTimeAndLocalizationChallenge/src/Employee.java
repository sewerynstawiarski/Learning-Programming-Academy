import java.time.ZoneId;

public record Employee(String name, ZoneId zoneId) {
    @Override
    public String toString() {
        return "%s [%s]".formatted(name, zoneId.getId());
    }
}
