package com.example.test3.dto;

import jakarta.persistence.Column;

public class CustomerDto {
    private int customerId;
    private String customerName;
    private String customerAddress;

    private double customerSalery;
//    private ArrayList contacNumber;
    private String nic;
    private boolean active;

    public CustomerDto() {
    }

    public CustomerDto(int customerId, String customerName, String customerAddress, double customerSalery, String nic, boolean active) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalery = customerSalery;
        this.nic = nic;
        this.active = active;
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerSalery=" + customerSalery +
                ", nic='" + nic + '\'' +
                ", active=" + active +
                '}';
    }
}
