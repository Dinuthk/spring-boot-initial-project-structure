package com.example.test3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    @Id
    @Column(name = "order_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customers;

    @Column(name = "order_date",columnDefinition = "DATETIME")
    private Date date;

    @Column(name = "total",nullable = false)
    private Double total;

    @OneToMany(mappedBy="orders")
    private Set<OrderDetails> orderDetails;

    public Order(Customer customers, Date date, Double total) {
        this.customers = customers;
        this.date = date;
        this.total = total;
    }
}
