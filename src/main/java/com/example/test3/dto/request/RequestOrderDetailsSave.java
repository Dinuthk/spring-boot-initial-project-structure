package com.example.test3.dto.request;

import com.example.test3.entity.Item;
import com.example.test3.entity.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestOrderDetailsSave {
    private String itemName;
    private double qty;
    private double amount;
    private int items;
}
