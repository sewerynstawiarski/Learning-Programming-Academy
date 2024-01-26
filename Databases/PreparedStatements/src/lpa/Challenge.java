package lpa;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Challenge {
    private static String ADDING_ORDER_QUERY = "INSERT INTO storefront.order (order_date) VALUES (?)"
    public static void main(String[] args) {
        var dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("storefront");

        try(Connection connection = dataSource.getConnection(System.getenv("MYSQL_USER"), System.getenv("MYSQL_PASS"))) {
//           addingNewColumn(connection, "quantity");

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
    private static int addingOrderAndDetailsFromCSV(Connection connection) {
        try(Statement statement = connection.createStatement()) {

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
