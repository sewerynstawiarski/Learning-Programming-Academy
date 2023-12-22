import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Location> list =  new ArrayList<>(Location.getDefaultLocations());
        HashMap<String, Location> gameBoard = getBoardGame(list);
//        System.out.println(gameBoard);
            HashMap<Character, String> directionChurch = new HashMap<>();
            directionChurch.put('N', "hill");
            directionChurch.put('E', "valley");
        Location newLocation = new Location("church", "standing next to the church", directionChurch );

        HashMap<String, Location> newBoard = addLocation(gameBoard, newLocation, "hill", 'S');

        startGame(newBoard);

    }


    public static HashMap<String, Location> getBoardGame(Collection<Location> listOfLocations) {
        List<Location> locations = new ArrayList<>(listOfLocations);
        HashMap<String, Location> fields = new HashMap<>();
        locations.forEach(l -> fields.put(l.getKey(), l));
        return fields;
        }

        public static void startGame(HashMap<String,Location> gameBoard) {
        Scanner scanner = new Scanner(System.in);
        boolean gameIsOn = true;
        Location currentField = null;

        while (gameIsOn) {
            currentField =  currentField == null ? gameBoard.get("road") : currentField;
            System.out.printf("*** You're standing %s ***%n From here, you can see:%n".formatted(currentField.getDescription()));
            currentField.getNextPlaces().forEach((k,v) -> {
              String direction =  switch (k) {
                   case 'W' -> "West";
                   case 'N' -> "North";
                   case 'E' -> "East";
                   case 'S' -> "South";
                  default -> "Null";
               };
               System.out.println("\u2022A " + v + " to the " + direction + " " + "(" + k + ")");
           });
            System.out.println("Select Your Compass Direction (Q to quit)\n");
            char compass = scanner.next().toUpperCase().charAt(0);
            switch (compass) {
                case 'W' -> currentField = gameBoard.get(currentField.getNextPlaces().get('W'));
                case 'N' -> currentField = gameBoard.get(currentField.getNextPlaces().get('N'));
                case 'E' -> currentField = gameBoard.get(currentField.getNextPlaces().get('E'));
                case 'S' -> currentField = gameBoard.get(currentField.getNextPlaces().get('S'));
                case 'Q' -> gameIsOn = false;
            }
        }
        }

        public static HashMap<String, Location>  addLocation(HashMap<String, Location> gameBoard, Location newLocation, String from, char directionFrom) {
        HashMap<String, Location> newBoard = new HashMap<>(gameBoard);
        if (newBoard.get(from).getNextPlaces().get(directionFrom) != null) {
            System.out.printf("%c of %s already has assigned place, so new place wasn't added. You need to assign to other direction%n".formatted(directionFrom, from));
        } else {
         newBoard.put(newLocation.getKey(), newLocation);
         newBoard.get(from).getNextPlaces().put(directionFrom, newLocation.getKey());
            System.out.printf("New location (%s) added successfully%n".formatted(newLocation.getKey()));
        }
        return newBoard;
        }
    }
