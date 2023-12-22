import java.util.List;

enum Geometry {LINE, POINT, POLYGON}
enum Color {BLACK, BLUE,  GREEN, ORANGE, RED}
enum PointMaker {CIRCLE, PUSH_PIN, STAR, SQUARE, TRIANGLE}
enum LineMarker {DASHED, DOTTED, SOLID}
public interface Mappable {

    String JSON_PROPERTY = """
            "properties: {%s} """;
    String getLabel();
    Geometry getGeometryType();
    String getIcon();

    default String toJSON() {
        return """
                "type": "%s", "label": "%s", "marker": "%s" """.formatted(getGeometryType(), getLabel(), getIcon());

    }

    static void printProperties(Mappable mappable) {
        System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
    }
}
