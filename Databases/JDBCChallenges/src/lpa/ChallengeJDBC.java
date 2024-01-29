package lpa;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;

public class ChallengeJDBC {
    public static void main(String[] args) {

        var dataSource = new MysqlDataSource();

        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("storefront");

        try(Connection connection = dataSource.getConnection(System.getenv("MYSQLUSER"), System.getenv("MYSQLPASS"));
        ) {

//        addingOrderWithDetails(connection, new String[] {"AKG k712 PRO", "Audio-technica ATH2020", "Austrian Audio HiX65"});
            deletingOrderWithDetails(connection, 45);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addingOrderWithDetails(Connection connection, String[] items) {
        String timeFormat = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(timeFormat);
        String dateTime = LocalDateTime.now().format(dateTimeFormatter);
//        System.out.println(dateTime);
        String query = "INSERT INTO storefront.order (order_date) VALUES ('" + dateTime + "')";
        try (Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
          int insert =  statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            int orderID = (rs != null && rs.next()) ? rs.getInt(1) : -1;
            for (String detail : items) {
                String queryWithDetail = "INSERT INTO storefront.order_details (item_description, order_id) VALUES ('%s', %d)".formatted(detail, orderID);
                statement.addBatch(queryWithDetail);
            }
            int[] results =  statement.executeBatch();
            if (results.length < items.length || insert < 1) {
                connection.rollback();
            } else {
                connection.commit();
            }
            connection.setAutoCommit(true);
            System.out.println( dateTime +  " Order added  with number of details = " + Arrays.toString(results));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deletingOrderWithDetails (Connection connection, int orderID) {
        String deletingDetails = "DELETE FROM storefront.order_details WHERE order_id='%d'".formatted(orderID);
        String deletingOrder = "DELETE FROM storefront.order WHERE order_id='%d'".formatted(orderID);
        try(Statement statement = connection.createStatement()) {
            statement.execute(deletingDetails);
            System.out.println("Details of order = " + orderID + " deleted");
            statement.execute(deletingOrder);
            System.out.println("Order " + orderID + " deleted.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
