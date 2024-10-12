package com.example.test3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customer_Id",length = 45)
    private int customerId;

    @Column(name = "Customer_Name",length = 100,nullable = false)
    private String customerName;

    @Column(name = "Customer_address",length = 200)
    private String customerAddress;
    @Column(name = "customer_sallery")
    private double customerSalery;

//    @Column(name = "contact_number",columnDefinition = "json")
//    private ArrayList contacNumber;

    @Column(name = "customer_nic")
    private String nic;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean active;

    public Customer() {

    }

    public Customer(int customerId, String customerName, String customerAddress, double customerSalery, String nic, boolean active) {
        this.customerId=customerId;
        this.customerName=customerName;
        this.customerAddress=customerAddress;
        this.customerSalery=customerSalery;
        this.nic=nic;
        this.active=active;
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
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerSalery=" + customerSalery +
                ", nic='" + nic + '\'' +
                ", active=" + active +
                '}';
    }
}
