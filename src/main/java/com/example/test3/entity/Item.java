package com.example.test3.entity;

import com.example.test3.entity.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
//@ToString me 3ma wenuwta @data danwa eken e 3m krnw
@Data
public class Item {
    @Id
    @Column(name = "item_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemID;

    @Column(name = "item_name",length = 100,nullable = false)
    private String itemName;

    @Column(name = "measure_type",length = 100,nullable = false)
    private MeasuringUnitType measuringUnitType;
    @Column(name = "balance_qty",length = 100,nullable = false)
    private double balanceQty;

    @Column(name = "supplier_price",length = 100,nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price",length = 100,nullable = false)
    private double sellingPrice;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean active;

    @OneToMany(mappedBy="items")
    private Set<OrderDetails> orderDetails;

}
