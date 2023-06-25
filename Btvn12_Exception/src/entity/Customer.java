package entity;

public class Customer {
    private double quantity;
    private static int AUTO_ID = 10000;
    private int customerId;
    private String code;
    private String fullName;
    private String address;
    private String phoneNumber;
    private String customerType;


    public Customer(int customerId, double quantity) {
        this.customerId = customerId;
        this.quantity = quantity;
    }


    public Customer(int customerId) {
        this.customerId = customerId;
    }

    public Customer(String code, String fullName, String address, String phoneNumber, String customerType) {
        this.code = "KH" + AUTO_ID;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.customerType = customerType;

        AUTO_ID++;

    }


    public String getCode() {
        return code;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCustomerType() {
        return customerType;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "code='" + code + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", customerType='" + customerType + '\'' +
                '}';
    }

    public String getName() {
        return null;
    }

    public int getCustomerId() {
        return customerId;
    }
}

