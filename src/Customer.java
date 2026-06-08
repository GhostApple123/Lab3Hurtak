/**
 * Project: Lab3Hurtak
 * Purpose Details: Customer class for MySQL and MongoDB CRUD operations
 * Course: IST 242
 * Author: Alex Hurtak
 * Date Developed: 06/06/2026
 * Last Date Changed: 06/07/2026
 * Rev: 1.0
 */
public class Customer {

    /**
     * Unique customer ID.
     */
    private int customerId;

    /**
     * Customer first name.
     */
    private String firstName;

    /**
     * Customer last name.
     */
    private String lastName;

    /**
     * Customer email address.
     */
    private String email;

    /**
     * Customer phone number.
     */
    private String phone;

    /**
     * Default constructor.
     */
    public Customer() {
    }

    /**
     * Constructor with all customer fields.
     *
     * @param customerId Customer ID
     * @param firstName Customer first name
     * @param lastName Customer last name
     * @param email Customer email
     * @param phone Customer phone number
     */
    public Customer(int customerId, String firstName, String lastName,
                    String email, String phone) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    /**
     * Gets customer ID.
     *
     * @return customer ID
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Sets customer ID.
     *
     * @param customerId customer ID
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets first name.
     *
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets email.
     *
     * @return email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets phone number.
     *
     * @return phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone number.
     *
     * @param phone phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Returns customer information as a string.
     *
     * @return customer details
     */
    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}