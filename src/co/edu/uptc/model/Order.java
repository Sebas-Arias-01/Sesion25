package co.edu.uptc.model;

import java.util.Date;
import java.util.List;

public class Order {

    private String orderId;
    private Date creationDate;
    private String status; // Must be "Processing", "Shipped", or "Delivered"
    private String customerId;
    private List<String> productIds; // List of product identifiers

    // Empty constructor
    public Order() {}

    // Full constructor
    public Order(String orderId, Date creationDate, String status, String customerId, List<String> productIds) {
        this.orderId = orderId;
        this.creationDate = creationDate;
        setStatus(status); // Using setter to validate status
        this.customerId = customerId;
        this.productIds = productIds;
    }

    // Getters and Setters

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        // Validate that the status is one of the allowed values
        if (status.equals("En proceso") || status.equals("Enviado") || status.equals("Entregado")) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Estado no válido. Debe ser 'En proceso', 'Enviado' o 'Entregado'.");
        }
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }
}
