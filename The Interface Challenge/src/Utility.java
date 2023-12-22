enum UtilityType {ELECTRICAL, FIBER_OPTIC, GAS, WATER}

public class Utility implements Mappable {

    private String geometryType;
    private String label;
    private String marker;

    private String name;
    private UtilityType utilityType;

    public Utility(String name, UtilityType utilityType) {
        this.name = name;
        this.utilityType = utilityType;
    }

    @Override
    public String getLabel() {
        return name + " (" +  utilityType + ")";
    }

    @Override
    public Geometry getGeometryType() {
        return Geometry.LINE;
    }

    @Override
    public String getIcon() {
        return switch (utilityType) {
            case ELECTRICAL -> Color.RED + " " + LineMarker.DASHED;
            case FIBER_OPTIC -> Color.GREEN + " " + LineMarker.DOTTED;
            case GAS -> Color.ORANGE + " " + LineMarker.SOLID;
            case WATER -> Color.BLUE + " " + LineMarker.SOLID;
            default -> Color.BLACK + " "  + LineMarker.SOLID;
        };
    }
    public String toJSON() {
        return Mappable.super.toJSON() + """
                , "name": "%s", "utility": "%s" """.formatted(name, utilityType);
    }
}
