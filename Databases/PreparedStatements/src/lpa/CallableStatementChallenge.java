package lpa;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class CallableStatementChallenge implements toJSON {
    @Override
    public String toJSON() {
        return new StringJoiner(", ", "{", "}")
                .toString();
    }
    public static class Item implements ItemToJson {
        String itemDescription;
        int qty;

        public Item(String itemDescription, int qty) {
            this.itemDescription = itemDescription;
            this.qty = qty;
        }

        @Override
        public String toJSON() {
            return new StringJoiner(", ", "{", "}")
                    .add("\"itemDescription\":\"" + itemDescription + "\"")
                    .add("\"qty\":" + qty)
                    .toString();
        }
    }

    public static void main(String[] args) {
        var dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("storefront");


        Map<String, List<Item>> listOfDetails = CallableStatementChallenge.createListOfDetails();


        try(Connection connection = dataSource.getConnection(System.getenv("MYSQL_USER"), System.getenv("MYSQL_PASS"))) {
            StringJoiner json =  new StringJoiner(",", "[", "]");
            listOfDetails.forEach((key, list) -> {
                list.forEach(item -> {
                    json.add(item.toJSON());
                });
            });
            System.out.println(json);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Map<String, List<Item>> createListOfDetails() {
        try {
            List<String> records = Files.readAllLines(Path.of("Orders.csv"));
            Map<String, List<Item>> listOfDetails = new HashMap<>();
            int indexStart = 0;
            int indexEND = 0;

            for (int i = 0; i < records.size(); i++) {
                if (records.get(i).contains("order")) {
                    indexEND = i;
                    if (indexEND != 0) {
                        var subList = records.subList(indexStart, indexEND);
                        String timeStamp = subList.get(0).split(",")[1];
                        List<Item> listOfItems = new ArrayList<>();
                        for (int j = 1; j < subList.size(); j++) {
                            String[] details = subList.get(j).split(",");
                            Item item = new Item(details[2], Integer.parseInt(details[1]));
                            listOfItems.add(item);
                        }
                        listOfDetails.put(timeStamp, listOfItems);
                    }
                    indexStart = i;
                }
                if (i == (records.size() - 1)) {
                    var subList = records.subList(indexStart, i + 1);
                    String timeStamp = subList.get(0).split(",")[1];
                    List<Item> listOfItems = new ArrayList<>();
                    for (int j = 1; j < subList.size(); j++) {
                        String[] details = subList.get(j).split(",");
                        Item item = new Item(details[2], Integer.parseInt(details[1]));
                        listOfItems.add(item);
                    }
                    listOfDetails.put(timeStamp, listOfItems);
                }
            }
//            listOfDetails.forEach((timeStamp, list) -> {
//                System.out.println(timeStamp + " = ");
//                list.forEach(item -> {
//                    System.out.print(item.toJSON());
//                });
//            });
            return listOfDetails;
//            records.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
