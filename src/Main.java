/**
 * Project: Lab3Hurtak
 * Purpose Details: Main program to test MySQL and MongoDB CRUD operations
 * Course: IST 242
 * Author: Alex Hurtak
 * Date Developed: 06/08/2026
 * Last Date Changed: 06/08/2026
 * Rev: 1.0
 */

public class Main {

    public static void main(String[] args) {

        MySQLCRUD mysql = new MySQLCRUD();
        MongoCRUD mongo = new MongoCRUD();

        Customer customer1 =
                new Customer(
                        1,
                        "John",
                        "Smith",
                        "john@email.com",
                        "555-1111"
                );

        Customer customer2 =
                new Customer(
                        2,
                        "Sarah",
                        "Jones",
                        "sarah@email.com",
                        "555-2222"
                );

        Customer customer3 =
                new Customer(
                        3,
                        "Mike",
                        "Brown",
                        "mike@email.com",
                        "555-3333"
                );

        System.out.println("===== CREATE =====");

        mysql.createCustomer(customer1);
        mysql.createCustomer(customer2);
        mysql.createCustomer(customer3);

        mongo.createCustomer(customer1);
        mongo.createCustomer(customer2);
        mongo.createCustomer(customer3);

        System.out.println("\n===== READ MYSQL =====");
        mysql.readCustomers();

        System.out.println("\n===== READ MONGODB =====");
        mongo.readCustomers();

        System.out.println("\n===== UPDATE =====");

        customer1.setLastName("Williams");
        customer1.setEmail("johnw@email.com");

        mysql.updateCustomer(customer1);
        mongo.updateCustomer(customer1);

        System.out.println("\n===== READ AFTER UPDATE =====");

        mysql.readCustomers();
        mongo.readCustomers();

        System.out.println("\n===== DELETE =====");

        mysql.deleteCustomer(3);
        mongo.deleteCustomer(3);

        System.out.println("\n===== FINAL READ =====");

        mysql.readCustomers();
        mongo.readCustomers();
    }
}