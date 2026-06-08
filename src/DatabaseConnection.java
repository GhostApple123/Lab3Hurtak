/**
 * Project: Lab3Hurtak
 * Purpose Details: Creates a connection to the MySQL database
 * Course: IST 242
 * Author: Alex Hurtak
 * Date Developed: 06/07/2026
 * Last Date Changed: 06/08/2026
 * Rev: 1.0
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    /**
     * Database URL.
     */
    private static final String URL =
            "jdbc:mysql://localhost:3306/RetailStore";

    /**
     * MySQL username.
     */
    private static final String USER = "root";

    /**
     * MySQL password.
     */
    private static final String PASSWORD = "IST888IST888";

    /**
     * Creates and returns a database connection.
     *
     * @return Connection object
     * @throws SQLException if connection fails
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}