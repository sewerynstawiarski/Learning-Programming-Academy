package lpa;

import com.mysql.cj.jdbc.MysqlDataSource;
import jdk.jshell.StatementSnippet;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    private static String USE_SCHEMA = "USE storefront";

    private static int MYSQL_DB_NOT_FOUND = 1049;
    public static void main(String[] args) {

        var dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setUser(System.getenv("MYSQLUSER"));
        dataSource.setPassword(System.getenv("MYSQLPASS"));

        try (Connection connection =dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getSQLStateType());
            if (!checkSchema(connection)) {
                System.out.println("storefront schema does not exist");
                setUpSchema(connection);
            }
//            System.out.println("New order = " + addOrder(connection, new String[] {"shoes", "shirt", "socks"}));
            deleteOrder(connection, 7);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
private static boolean checkSchema(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(USE_SCHEMA);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());

            if (connection.getMetaData().getDatabaseProductName().equals("MySQL")
            && e.getErrorCode() == MYSQL_DB_NOT_FOUND) {
                return false;
            } else throw e;
        }
        return true;
    }
    private static void setUpSchema(Connection connection) throws SQLException {
        String createSchema = "CREATE SCHEMA storefront";

        String createOrder = """
               CREATE TABLE storefront.order (
               order_id int NOT NULL AUTO_INCREMENT,
               order_date DATETIME NOT NULL,
               PRIMARY KEY (order_id)
               )""";

        String createOrderDetails = """
                CREATE TABLE storefront.order_details (
                order_detail_id int NOT NULL AUTO_INCREMENT,
                item_description text,
                order_id int DEFAULT NULL,
                PRIMARY KEY (order_detail_id),
                KEY FK_ORDERID (order_id),
                CONSTRAINT FK_ORDERID FOREIGN KEY (order_id)
                REFERENCES storefront.order (order_id) ON DELETE CASCADE
                )""";

        try(Statement statement = connection.createStatement()) {

            System.out.println("Creating storefront Database");
            statement.execute(createSchema);
            if (checkSchema(connection)) {
                statement.execute(createOrder);
                System.out.println("successfully Created Order");
                statement.execute(createOrderDetails);
                System.out.println("Successfully Created Order Details");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static int addOrder(Connection connection, String[] items) throws SQLException {
        int orderId = -1;
        String insertOrder = "INSERT INTO storefront.order (order_date) VALUES ('%s')";
        String insertDetail = "INSERT INTO storefront.order_details (order_id, item_description) values(%d, %s)";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String orderDateTime = LocalDateTime.now().format(dateTimeFormatter);
        System.out.println(orderDateTime);
        String formattedString = insertOrder.formatted(orderDateTime);
        System.out.println(formattedString);
        //alternative for time
        String insertOrderAlternative = "INSERT INTO storefront.order (order_date) VALUES ('%1$tF %1$tT')";
        System.out.println(insertOrderAlternative.formatted(LocalDateTime.now()));

        try(Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            int inserts = statement.executeUpdate(formattedString, Statement.RETURN_GENERATED_KEYS);
            if (inserts == 1) {
                var rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    orderId = rs.getInt(1);
                }
            }
            int count = 0;
            for (var item : items) {
                formattedString = insertDetail.formatted(orderId, statement.enquoteLiteral(item));
                inserts = statement.executeUpdate(formattedString);
                count += inserts;
            }
            if (count != items.length) {
                orderId = -1;
                System.out.println("Number of records inserted doesn't equal items received");
                connection.rollback();
            } else {
                connection.commit();
            }

            connection.setAutoCommit(true);
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);
        }

        return  orderId;
    }
    private static void deleteOrder(Connection connection, int orderID) throws SQLException {
        String deleteOrder = "DELETE FROM %s WHERE order_id=%d";
        String parentQuery = deleteOrder.formatted("storefront.order", orderID);
        String childQuery = deleteOrder.formatted("storefront.order_details", orderID);

        try(Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);

            int deletedRecords = statement.executeUpdate(childQuery);
            System.out.printf("%d child records deleted%n", deletedRecords);
            deletedRecords = statement.executeUpdate(parentQuery);
            if (deletedRecords == 1) {
                connection.commit();
                System.out.printf("Order %d was successfully deleted%n", orderID);
            } else {
                connection.rollback();
            }
            connection.commit();

        } catch (SQLException e) {
            connection.rollback();
            throw  new RuntimeException(e);
        }
        finally {
            connection.setAutoCommit(true);
        }
    }
}
