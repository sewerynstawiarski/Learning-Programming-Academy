import java.util.Arrays;

public class Line implements Mappable{
    private String name;
    private String type;

    private double[][] setPoints;

    public Line(String name, String type, double[][] setPoints) {
        this.name = name;
        this.type = type;
        this.setPoints = setPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSetPoints(double[][] setPoints) {
        this.setPoints = setPoints;
    }
    public StringBuilder doubleArrayToString(double[][] doubleAarray) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < doubleAarray.length; i++) {
            string.append(Arrays.toString(doubleAarray[i]));
        } return string;
    }

    @Override
    public String render() {
        return switch (type) {
            case "River" -> "Render: " + name + " as " + Color.BLUE + Marker.LINE + " (" + Arrays.deepToString(setPoints) + ")";
            case "Gas pipe" -> "Render: " + name + " as " + Color.YELLOW + Marker.LINE + " (" + doubleArrayToString(this.setPoints) + ")";
            case "Railways" -> "Render: " + name + " as " + Color.RED + Marker.LINE + " (" + doubleArrayToString(this.setPoints) + ")";
            case "Road" -> "Render: " + name + " as " + Color.GREY + Marker.LINE + " (" + doubleArrayToString(this.setPoints) + ")";
            default -> "Render: " + name + " as " + Color.BLACK + Marker.LINE + " (" + doubleArrayToString(this.setPoints) + ")";
        };
    }
}
