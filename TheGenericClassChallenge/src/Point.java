

public class Point implements Mappable{

    private String name;
    private String type;
    private double latitude;
    private double longitude;

    public Point(String name, String type, double latitude, double longitude) {
        this.name = name;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String render() {
        return  switch (type) {
            case "City" -> "Render: " + name + " as " + Color.RED + Marker.POINT + " (" + latitude + ", " + longitude + ")";
            case "Building" -> "Render: " + name + " as " + Color.GREY + Marker.POINT + " (" + latitude + ", " + longitude + ")";
            case "Lake" -> "Render: " + name + " as " + Color.BLUE + Marker.POINT + " (" + latitude + ", " + longitude + ")";
            case "Museum" -> "Render: " + name + " as " + Color.YELLOW + Marker.POINT + " (" + latitude + ", " + longitude + ")";
            default -> "Render: " + name + " as " + Color.BLACK + Marker.POINT + " (" + latitude + ", " + longitude + ")";
        };
    }
}
