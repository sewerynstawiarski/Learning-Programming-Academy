import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        City Warszawa = new City("Warszawa", "City", 52.22999408671773, 21.006949103579466);
        City Wrocław = new City("Wrocław", "City",51.10584137883199, 17.033742673636507);
        City Gdańsk = new City("Gdańsk", "City",54.35183533178196, 18.632325504687696);
        var cities = new City[] {
                new City("Warszawa", "City", 52.22999408671773, 21.006949103579466),
                new City("Wrocław", "City",51.10584137883199, 17.033742673636507),
                new City("Gdańsk", "City",54.35183533178196, 18.632325504687696)
        };

        Layer<City> citiesLayer = new Layer<>(cities);
        citiesLayer.addElements(new City("Lublin", "City", 51.24688680079249, 22.567888402447164));

        citiesLayer.renderLayer();


        double[][] setPointWisła =
                {{52.496295042786016, 20.131427012100882}, {53.35061961030796, 18.373534456073646}, {50.45414893887667, 21.4377385205035}};

        var rivers = new River[]{
                new River("Wisła", "River", setPointWisła)
        };
        Layer<River> riverLayer = new Layer<>(rivers);
riverLayer.renderLayer();



//        double[][] setPointWisła =
//                {{52.496295042786016, 20.131427012100882}, {53.35061961030796, 18.373534456073646}, {50.45414893887667, 21.4377385205035}};
//
//        Line wisła = new River("Wisła", "River", setPointWisła);
//       Layer<Mappable> rivers = new Layer<>(List.of(wisła));
//        rivers.renderLayer();
//
//        Point lublin = new City("Lublin", "City", 51.24688680079249, 22.567888402447164);



    }
}
