/**
 * Project: Lab3Hurtak
 * Purpose Details: MySQL CRUD operations for Customer records
 * Course: IST 242
 * Author: Alex Hurtak
 * Date Developed: 06/07/2026
 * Last Date Changed: 06/08/2026
 * Rev: 1.0
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLCRUD {

    /**
     * Inserts a customer into MySQL.
     *
     * @param customer customer to insert
     */
    public void createCustomer(Customer customer) {

        String sql = "INSERT INTO Customer VALUES (?, ?, ?, ?, ?)";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, customer.getCustomerId());
            statement.setString(2, customer.getFirstName());
            statement.setString(3, customer.getLastName());
            statement.setString(4, customer.getEmail());
            statement.setString(5, customer.getPhone());

            statement.executeUpdate();

            System.out.println("Customer inserted into MySQL.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays all customers.
     */
    public void readCustomers() {

        String sql = "SELECT * FROM Customer";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()
        ) {

            while (resultSet.next()) {

                System.out.println(
                        resultSet.getInt("customerId") + " " +
                                resultSet.getString("firstName") + " " +
                                resultSet.getString("lastName") + " " +
                                resultSet.getString("email") + " " +
                                resultSet.getString("phone")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates a customer.
     *
     * @param customer updated customer
     */
    public void updateCustomer(Customer customer) {

        String sql =
                "UPDATE Customer SET firstName=?, lastName=?, email=?, phone=? WHERE customerId=?";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhone());
            statement.setInt(5, customer.getCustomerId());

            statement.executeUpdate();

            System.out.println("Customer updated in MySQL.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a customer.
     *
     * @param customerId customer ID
     */
    public void deleteCustomer(int customerId) {

        String sql = "DELETE FROM Customer WHERE customerId=?";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, customerId);

            statement.executeUpdate();

            System.out.println("Customer deleted from MySQL.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}