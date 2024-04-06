package lpa;

import com.mysql.cj.jdbc.CallableStatement;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class CallableStatementChallenge implements toJSON {
    //official solution will be included in JDBCChallanges project
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


        Map<String, List<Item>> mapOfDetails = CallableStatementChallenge.createListOfDetails();


        try(Connection connection = dataSource.getConnection(System.getenv("MYSQL_USER"), System.getenv("MYSQL_PASS"))) {
            CallableStatement callableStatement = (CallableStatement) connection.prepareCall("CALL storefront.addOrder(?,?,?,?)");

            mapOfDetails.forEach((key, list) -> {
                StringJoiner json =  new StringJoiner(",", "[", "]");
                list.forEach(item -> {
                    json.add(item.toJSON());
                });
                String jsonReady = json.toString();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
                LocalDateTime localDateTime = LocalDateTime.parse(key, formatter);
                Timestamp timestamp = Timestamp.valueOf(localDateTime);

                try {
                    callableStatement.setTimestamp(1, timestamp);
                    callableStatement.setString(2, jsonReady);
                    callableStatement.registerOutParameter(3, Types.INTEGER);
                    callableStatement.registerOutParameter(4, Types.INTEGER);
                    callableStatement.execute();

                    System.out.printf("Order ID: %d -> number of details: %d %n",
                            callableStatement.getInt(3), callableStatement.getInt(4));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            });


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
