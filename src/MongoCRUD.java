/**
 * Project: Lab3Hurtak
 * Purpose Details: MongoDB CRUD operations for Customer records
 * Course: IST 242
 * Author: Alex Hurtak
 * Date Developed: 06/08/2026
 * Last Date Changed: 06/08/2026
 * Rev: 1.0
 */

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class MongoCRUD {

    private MongoCollection<Document> collection;

    /**
     * Constructor connects to MongoDB.
     */
    public MongoCRUD() {

        MongoClient mongoClient =
                MongoClients.create("mongodb://localhost:27017");

        MongoDatabase database =
                mongoClient.getDatabase("RetailStoreMongo");

        collection =
                database.getCollection("customers");
    }

    /**
     * Inserts a customer.
     *
     * @param customer customer to insert
     */
    public void createCustomer(Customer customer) {

        Document document = new Document();

        document.append("customerId", customer.getCustomerId());
        document.append("firstName", customer.getFirstName());
        document.append("lastName", customer.getLastName());
        document.append("email", customer.getEmail());
        document.append("phone", customer.getPhone());

        collection.insertOne(document);

        System.out.println("Customer inserted into MongoDB.");
    }

    /**
     * Reads all customers.
     */
    public void readCustomers() {

        for (Document document : collection.find()) {
            System.out.println(document.toJson());
        }
    }

    /**
     * Updates a customer.
     *
     * @param customer updated customer
     */
    public void updateCustomer(Customer customer) {

        collection.updateOne(
                new Document("customerId",
                        customer.getCustomerId()),
                new Document("$set",
                        new Document("firstName",
                                customer.getFirstName())
                                .append("lastName",
                                        customer.getLastName())
                                .append("email",
                                        customer.getEmail())
                                .append("phone",
                                        customer.getPhone()))
        );

        System.out.println("Customer updated in MongoDB.");
    }

    /**
     * Deletes a customer.
     *
     * @param customerId customer ID
     */
    public void deleteCustomer(int customerId) {

        collection.deleteOne(
                new Document("customerId", customerId)
        );

        System.out.println("Customer deleted from MongoDB.");
    }
}