package com.example.test3.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestOrderSaveDTO {
    private int customers;
    private Date date;
    private Double total;
    private List<RequestOrderDetailsSave> orderDetails;
}
