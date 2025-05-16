package co.edu.uptc.controller;

import co.edu.uptc.model.Customer;
import co.edu.uptc.model.Persistence;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

public class CustomerController {
    public static final String FILE = "customers.txt";

    public void saveCustomer(Customer customer) {
        String line = customer.getId() + "," + customer.getAddress() + "," + customer.getPhone() + "," + customer.getEmail();
        try {
            Persistence.saveLine(FILE, line);
        } catch (IOException e) {
            System.out.println("Error al guardar el cliente: " + e.getMessage());
        }
    }

    public Customer findCustomerById(String customerId) throws IOException {
        List<String> lines = Persistence.readFile(FILE);
        for (String line : lines) {
            StringTokenizer st = new StringTokenizer(line, ",");
            String id = st.nextToken();
            String address = st.nextToken();
            String phone = st.nextToken();
            String email = st.nextToken();
            if (id.equals(customerId)) {
                return new Customer(customerId, address, phone, email);
            }
        }
        return null;
    }
}
