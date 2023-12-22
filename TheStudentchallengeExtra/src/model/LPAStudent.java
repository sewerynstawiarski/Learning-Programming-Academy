package model;

public class LPAStudent extends Student {
    private double percentComplete;

    public LPAStudent() {
        percentComplete = random.nextDouble(1, 100.001);
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    public double getPercentComplete() {
        return percentComplete;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String fName = fieldName.toUpperCase();
        return switch (fName) {
            case "NAME" -> super.getName().equalsIgnoreCase(value);
            case "COURSE" -> super.getCourse().equalsIgnoreCase(value);
            case "YEARSTARTED" -> super.getYearStarted() == (Integer.parseInt(value));
            case "ID" -> super.getId() == (Integer.parseInt(value));
            case "PERCENTCOMPLETE" -> {
                if (percentComplete <= Double.parseDouble(value)) {
                    yield true;
                } else yield false;
            }
            default -> false;
        };
    }
}
