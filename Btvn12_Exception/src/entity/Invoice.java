package entity;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private int serviceId;
    private double quantity;
    private Customer customer;
    private List<Service> services;

    public Invoice(Customer customer) {
        this.customer = customer;
        this.services = new ArrayList<>();
    }

    public Invoice(Customer customer, Service service, int quantity) {
        this.customer = customer;
        this.services = new ArrayList<>();
        this.services.add(service);
        this.quantity = quantity;
    }

    public Invoice(int serviceId, double quantity) {
        this.serviceId = serviceId;
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Service> getServices() {
        return services;
    }

    public void addService(Service service) {
        if (services.size() < 5 && !services.contains(service)) {
            services.add(service);
        }
    }

    public void removeService(Service service) {
        services.remove(service);
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Service service : services) {
            totalAmount += service.getPrice();
        }
        return totalAmount;
    }

    public int getServiceId() {
        return serviceId;
    }

    public double getQuantity() {
        return quantity;
    }

}
