package co.edu.uptc.controller;

import co.edu.uptc.model.Order;
import co.edu.uptc.model.Persistence;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;


public class OrderController {
    private static final String FILE = "orders.txt";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public void saveOrder(Order order) throws IOException {
        String line = order.getOrderId() + "," + order.getCustomerId() + "," + order.getCreationDate() + "," + order.getStatus() +  "," + String.join(",", order.getProductIds());
        try {
            Persistence.saveLine(FILE, line);
        } catch (IOException e) {
            System.out.println("Error al guardar el pedido: " + e.getMessage());
        }
    }

    public Order findOrderById(String orderId) throws IOException, ParseException {
        List<String> lines = Persistence.readFile(FILE);
        for (String line : lines) {
            StringTokenizer st = new StringTokenizer(line, ",");
            String id = st.nextToken();
            String customerId = st.nextToken();
            Date creationDate = DATE_FORMAT.parse(st.nextToken());
            String status = st.nextToken();
            String [] products = st.nextToken().split(",");

            if (id.equals(orderId)) {
                return new Order(id, creationDate, status, customerId, List.of(products));
            }
        }
        return null;
    }

}
