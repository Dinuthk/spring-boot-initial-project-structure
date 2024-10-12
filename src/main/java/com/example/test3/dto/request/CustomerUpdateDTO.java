package com.example.test3.dto.request;

public class CustomerUpdateDTO {

    private int customerId;
    private String customerName;
    private String customerAddress;

    private double customerSalery;

    public CustomerUpdateDTO() {
    }

    public CustomerUpdateDTO(int customerId, String customerName, String customerAddress, double customerSalery) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalery = customerSalery;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getCustomerSalery() {
        return customerSalery;
    }

    public void setCustomerSalery(double customerSalery) {
        this.customerSalery = customerSalery;
    }

    @Override
    public String toString() {
        return "CustomerUpdateDTO{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerSalery=" + customerSalery +
                '}';
    }
}
