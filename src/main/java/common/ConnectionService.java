package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Сервис подключения к БД.
 */
public class ConnectionService {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/task_management";

    public static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
//            DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error connecting to database");
        }
    }
}
