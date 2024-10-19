package com.example.test3.dto.request;

import com.example.test3.entity.enums.MeasuringUnitType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
//@ToString me 3ma wenuwta @data danwa eken e 3m krnw
@Data
public class ItemSaveRequestDTO {

    private String itemName;
    private MeasuringUnitType measuringUnitType;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
    
}
