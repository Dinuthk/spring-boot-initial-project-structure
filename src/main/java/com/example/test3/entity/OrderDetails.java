package com.example.test3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_details")
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {
    @Id
    @Column(name = "order_details_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailsId;

    @Column(name = "item_name",length = 100,nullable = false)
    private String itemName;

    @Column(name = "qty",length = 100,nullable = false)
    private double qty;

    @Column(name = "amount",nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name="item_id", nullable=false)
    private Item items;
}
