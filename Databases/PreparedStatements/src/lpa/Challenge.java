package lpa;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Challenge {
    private static String ADDING_ORDER_QUERY = "INSERT INTO storefront.order (order_date) VALUES (?)";
    private static String ADDING_ORDER_DETAILS = "INSERT INTO storefront.order_details (item_description, order_id, quantity) VALUES (?, ?, ? )";
    public static void main(String[] args) {
        var dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("storefront");

        try(Connection connection = dataSource.getConnection(System.getenv("MYSQL_USER"), System.getenv("MYSQL_PASS"))) {
//           addingNewColumn(connection, "quantity");
            System.out.println("Number of added orders: " + addingOrderAndDetailsFromCSV(connection));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private static void addingNewColumn (Connection connection, String newColumn) {
        try (Statement statement = connection.createStatement()) {
            String addingColumnQuery = "ALTER TABLE storefront.order_details ADD COLUMN " + newColumn + " INT";
            statement.execute(addingColumnQuery);
            System.out.println("Adding column = " + newColumn);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static int addingOrderAndDetailsFromCSV(Connection connection) throws SQLException {

        List<String> records = null;
        try {
            records = Files.readAllLines(Path.of("Orders.csv"));
            int indexStart = 0;
            int indexEND = 0;
            List<List<String>> listOfRecords = new ArrayList<>();
            for (int i = 0; i < records.size(); i++) {
                if (records.get(i).equals("order")) {
                    indexEND = i;
                    if (indexStart != 0 && indexEND != 0) {
                        listOfRecords.add(records.subList(indexStart, indexEND));
                    }
                    indexStart = i;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int orderID = 0;


        try(PreparedStatement preparedStatementOrder = connection.prepareStatement(ADDING_ORDER_QUERY, Statement.RETURN_GENERATED_KEYS);
        PreparedStatement preparedStatementDetails = connection.prepareStatement(ADDING_ORDER_DETAILS)) {


                connection.setAutoCommit(false);
                for (String record : records) {
                    String[] separatedRecord = record.split(",");
                    if (separatedRecord[0].equals("order")) {
                        preparedStatementOrder.setString(1, separatedRecord[1]);
                        preparedStatementOrder.execute();
                        var key = preparedStatementOrder.getGeneratedKeys();
                        orderID = (key != null && key.next() ? key.getInt(1) : -1);
                        System.out.println("Order = " + orderID + " added.  ");
                    }
                    if (separatedRecord[0].equals("item")) {
                        preparedStatementDetails.setString(1, separatedRecord[2]);
                        preparedStatementDetails.setInt(3, Integer.parseInt(separatedRecord[1]));
                        preparedStatementDetails.setInt(2, orderID);
                        preparedStatementDetails.addBatch();
                    }
                }

                int[] insertsDetails = preparedStatementDetails.executeBatch();
                System.out.println("Details added =  " + insertsDetails.length);
                connection.commit();
                connection.setAutoCommit(true);

                return preparedStatementOrder.getUpdateCount();
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);
        }
    }
}
