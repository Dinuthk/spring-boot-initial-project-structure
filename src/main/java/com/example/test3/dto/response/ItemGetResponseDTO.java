package com.example.test3.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemGetResponseDTO {
    private int itemID;
    private String itemName;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
    private boolean active;
}

