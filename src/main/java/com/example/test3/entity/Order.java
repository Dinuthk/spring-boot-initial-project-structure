package com.example.test3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @Column(name = "order_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToOne
    @JoinColumn(name="cusromer_id", nullable=false)
    private Customer cusromers;

    @Column(name = "order_date",columnDefinition = "DATETIME")
    private Date date;

    @Column(name = "total",nullable = false)
    private Double total;
}
