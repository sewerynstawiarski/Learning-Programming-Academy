import java.util.*;

public class Location {
    private String key;
    private String description;
    private HashMap<Character, String> nextPlaces;

    public Location(String key, String description, HashMap<Character, String> nextPlaces) {
        this.key = key;
        this.description = description;
        this.nextPlaces = nextPlaces;
    }

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    public HashMap<Character, String> getNextPlaces() {
        return nextPlaces;
    }

    public static List<Location> getDefaultLocations() {
        String locations = """
                road,at the end of the road, W: hill, E:well house,S:valley,N:forest
                hill,on top of hill with a view in all directions,N:forest, E:road
                well house,inside a well house for a small spring,W:road,N:lake,S:stream
                valley,in a forest valley beside a tumbling stream,N:road,W:hill,E:stream
                forest,at the edge of a thick dark forest,S:road,E:lake
                lake,by an alpine lake surrounded by wildflowers,W:forest,S:well house
                stream,near a stream with a rocky bed,W:valley, N:well house
                """;
        Scanner scanner = new Scanner(locations);
        List<Location> locationsList =  new ArrayList<>();

        while (scanner.hasNext()) {
            String[] data =  scanner.nextLine().split(",");
//            System.out.println(Arrays.toString(data));
            HashMap<Character, String> nextPlaces = new HashMap<>();
            for (int i = 2; i < data.length; i++) {
                String[] smallString = data[i].split(":");
                Arrays.asList(smallString).replaceAll(String::trim);
                nextPlaces.put(smallString[0].charAt(0), smallString[1]);
            }
//            nextPlaces.forEach((k ,v) -> System.out.println("Key = " + k + " value = " + v));
            locationsList.add(new Location(data[0], data[1], nextPlaces));
        }


        return locationsList;
    }

    @Override
    public String toString() {
        return "%s & %s%n".formatted(description, nextPlaces.toString());
    }
}
